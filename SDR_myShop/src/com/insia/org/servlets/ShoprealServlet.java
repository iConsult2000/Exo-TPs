package com.insia.org.servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

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

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Servlet implementation class shopreal
 */
@WebServlet("/shopreal/*")
public class ShoprealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoprealServlet() {
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
		
		if (session.getAttribute("login") != null) {
			System.out.println("Do the treatment");
			
			FakeDataHolder database = FakeDataHolder.getInstance();
			
			if (database.createTable("Products") != null) {
				//Completer la base de données Products
				List<MyBeans> StoreProducts = (List<MyBeans>) database.get("Products");
//				StoreProducts.add(new MyBeans("id005", 75, "wave3 desire"));
//				StoreProducts.add(new MyBeans("id004", 5, "nokia 800"));
//				StoreProducts.add(new MyBeans("id003", 15, "Galaxy note"));
//				StoreProducts.add(new MyBeans("id002", 745, "Black Berry Curve"));
//				StoreProducts.add(new MyBeans("id001", 250, "iPhone 4S"));
				
				
				MyBeans id001 = new MyBeans("id001", 250, "iPhone 4S");
				System.out.println(id001.getDescription());
				MyBeans id002 = new MyBeans("id002", 745, "Black Berry Curve");
				MyBeans id003 = new MyBeans("id003", 15, "Galaxy note");
				MyBeans id004 = new MyBeans("id004", 5, "nokia 800");
				MyBeans id005 = new MyBeans("id005", 75, "wave3 desire");
				
				//Add in datrabase
				StoreProducts.add(id001);
				StoreProducts.add(id002);
				StoreProducts.add(id003);
				StoreProducts.add(id004);
				StoreProducts.add(id005);
//				
				//Publish them in session
				session.setAttribute("id001", id001);
				session.setAttribute("id002", id002);
				session.setAttribute("id003", id003);
				session.setAttribute("id004", id004);
				session.setAttribute("id005", id005);
				
//				RequestDispatcher dispatch = request.getRequestDispatcher("./accueil.jsp");
//				dispatch.forward(request, response);
				
				//Create the cart
				database.createTable("Cart");
				
			}
				
			List<MyBeans> cart = (List<MyBeans>) database.get("Cart");
			
			//Retrieve the product using the bean id by Form submit
			MyBeans resultparamBean = (MyBeans) database.findOne("Products", "item", request.getParameter("item"));
			//add item to cart
			cart.add(resultparamBean);
			
				
			
			System.out.println("What is in cart :");
			Iterator<MyBeans> e = cart.iterator();
			while (e.hasNext()) {
				System.out.println(e.next());
			}
			
			
			
			//Return to shopping
			request.getRequestDispatcher("/myaccueil.jsp").forward(request, response);
			
			
			
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
