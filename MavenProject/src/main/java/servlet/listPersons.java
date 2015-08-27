package servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class listPersona
 */
@WebServlet("/listPersons")
public class listPersons extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public listPersons() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		PersonConnections p = new PersonConnections();
		ArrayList<Person> persons = new ArrayList<Person>();
		persons = p.getAll();
		if (persons != null){
			rd = sc.getRequestDispatcher("/listPersons.jsp");
			request.setAttribute("allPersons", persons);
		}
		else
			System.out.println("No persons available");
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
