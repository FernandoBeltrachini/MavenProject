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
import element.Person;

/**
 * Servlet implementation class addComic
 */
@WebServlet("/abms/modifyPerson")
public class modifyPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyPerson() {
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
		Person p = personConnection.getPersonById(request.getParameter("id"));
		if (p != null){
			rd = sc.getRequestDispatcher("/abms/modifyPerson.jsp");
			request.setAttribute("person", p);
			
		}
		else{
			rd = sc.getRequestDispatcher("/errors.jsp");
			request.setAttribute("error", "Couldnt modify person.");
		}
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		Person update = new Person(name,surname);
		update.setId(new Integer(id));
		PersonConnections p = new PersonConnections();
		String error =p.modify(update); 
		if (error != null){
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors.jsp");
		}
		else
			rd = sc.getRequestDispatcher("/listPersons");
		rd.forward(request,response);
	
	}		
		
		
}
