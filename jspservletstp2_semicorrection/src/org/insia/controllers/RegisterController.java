package org.insia.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.insia.beans.Message;

import org.insia.models.*;
import org.insia.utils.FakeDataHolder;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pageName", "register.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FakeDataHolder database = FakeDataHolder.getInstance();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		boolean error = false;
		
		List<Message> errors = new ArrayList<Message>();
		
		// On vérifie que les champs ne sont pas vides
		if (login == null ||login.trim().equals("")) {
			errors.add(new Message("Veuillez spécifier un login"));
			error = true;
		}
		if (password == null || password.equals("")) {
			errors.add(new Message("Veuillez spécifier un mot de passe"));
			error = true;
		}

		// On verifie que l'utilisateur n'existe pas déjà
		List<User> users = (List<User>) database.get("user");
		if (users == null) {
			users = (List<User>) database.createTable("user");
		}
		User user = (User) database.findOne("user", "login", login);

		if (user != null) {
			// Un utilisateur portant le même login existe
			errors.add(new Message("Un utilisateur utilisant ce login existe déjà"));
			error = true;
		}

		// On vérifie que les deux mots de passe saisis correspondent
		if (!password.equals(confirmPassword)) {
			errors.add(new Message("Les deux mots de passe ne correspondent pas"));
			error = true;
		}
		if (error) {
			request.setAttribute("pageName", "register.jsp");
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			// S'il n'y a pas d'erreur, on "sauvegarde" l'utilisateur
			users.add(new User(login, password));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
