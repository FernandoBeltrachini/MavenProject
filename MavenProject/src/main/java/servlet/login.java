package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataConnection.ComicConnections;
import element.Comic;

/**
 * Servlet implementation class addComic
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username  = request.getParameter("username");
		String password = request.getParameter("password");
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		
//		if ("Sheldon".equals(username) && "Bazinga".equals(password))
//			rd = sc.getRequestDispatcher("/listComics.jsp");
//		else
//			rd = sc.getRequestDispatcher("/listComics.jsp");
		rd = sc.getRequestDispatcher("/menu/administratorMenu.jsp");
		rd.forward(request,response);
		
	}

}
