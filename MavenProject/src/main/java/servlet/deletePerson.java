package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataConnection.PersonConnections;

/**
 * Servlet implementation class addComic
 */
@WebServlet("/abms/deletePerson")
public class deletePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletePerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		PersonConnections personConnection = new PersonConnections();
		String error = personConnection.remove(request.getParameter("id"));
		
	
		if (error != null){
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors.jsp");
		}
		else
			sc.getRequestDispatcher("/listPersons");
		
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}		
		
		
}
