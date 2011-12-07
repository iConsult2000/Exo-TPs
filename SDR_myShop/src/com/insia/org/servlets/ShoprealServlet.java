package com.insia.org.servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// Get the absolute path of the image
	    ServletContext sc = getServletContext();
	    String filename = sc.getRealPath("/img/iPhone4S.jpg");

	    // Get the MIME type of the image
	    String mimeType = sc.getMimeType(filename);
	    if (mimeType == null) {
	        sc.log("Could not get MIME type of "+filename);
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        return;
	    }

	    // Set content type
	    response.setContentType(mimeType);

	    // Set content size
	    File file = new File(filename);
	    response.setContentLength((int)file.length());

	    // Open the file and output streams
	    FileInputStream in = new FileInputStream(file);
	    OutputStream out = response.getOutputStream();

	    // Copy the contents of the file to the output stream
	    byte[] buf = new byte[1024];
	    int count = 0;
	    while ((count = in.read(buf)) >= 0) {
	        out.write(buf, 0, count);
	    }
	    in.close();
	    out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


	}

}
