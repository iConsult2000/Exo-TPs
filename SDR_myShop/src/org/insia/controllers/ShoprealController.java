package org.insia.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.insia.beans.ProductContent;
import org.insia.models.Product;
import org.insia.utils.FakeDataHolder;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Servlet implementation class shopreal
 */
@WebServlet("/shopreal/*")
public class ShoprealController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoprealController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		FakeDataHolder database = FakeDataHolder.getInstance();
		
		if (session.getAttribute("login") != null) {
			System.out.println("Do the treatment");
			
			//Publish stored products
			ProductContent storedProducts = new ProductContent();
			
			// Retrieve information
//			System.out.println("Synchronizing myaccueil.jsp :");
//			Product dummy = new Product();
//			ListIterator<Product> e = storedProducts.;
//			while (e.hasNext()){
//				dummy = e.next();
//				session.setAttribute(dummy.getItem(), dummy);				
//			}
			
			//Si il y a deux users, ne pas stocker Cart dans la base
			
			//Retrieve the product using the bean id by Form submit
			Product resultparamBean = (Product) database.findOne("Products", "item", request.getParameter("item"));
			//add item to cart
			
//			System.out.println("What is in cart :");
//			Iterator<MyBeans> e = cart.iterator();
//			while (e.hasNext()) {
//				System.out.println(e.next());
//				if (e != null) {
//					
//				}
//			}
			
			
			
			//Return to shopping
			request.getRequestDispatcher("/WEB-INF/components/myaccueil.jsp").forward(request, response);
			
			
			
		}else {
			response.sendRedirect("./login.jsp");
			System.out.println("SendRedirect section");
		}
			
		
		

		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
