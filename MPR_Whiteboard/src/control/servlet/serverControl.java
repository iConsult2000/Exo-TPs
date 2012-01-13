package control.servlet;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serverControl
 */
@WebServlet("/serverControl")
public class serverControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serverControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> position = new ArrayList();
		
		//On récupère les valeurs de la position img
		String Arg_Top = request.getParameter("arg_top");
		String Arg_Left = request.getParameter("arg_left");
		
		position.add(0, Arg_Top);
		position.add(0, Arg_Left);
		
		for(int i=0;i<position.size();i++){
			System.out.println(position);
		}
		
		request.getRequestDispatcher("./index.jsp").forward(request, response);
	}

}
