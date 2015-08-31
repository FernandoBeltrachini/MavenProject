package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataConnection.PersonConnections;
import element.Person;

/**
 * Servlet implementation class addComic
 */
@WebServlet("/abms/addPerson")
public class addPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");;
		HttpSession session = request.getSession();
		session.setAttribute("role", null);
		session.invalidate();
		rd.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");

		Person p = new Person(name, surname);
		PersonConnections persons = new PersonConnections();
		String error = persons.add(p);

		if (error != null) {
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors.jsp");
		} else
			rd = sc.getRequestDispatcher("/listPersons");

		rd.forward(request, response);

	}

}
