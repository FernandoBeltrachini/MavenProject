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

import dataConnection.ComicConnections;
import dataConnection.LoanConnections;
import dataConnection.PersonConnections;
import element.Comic;
import element.Loan;
import element.Person;

/**
 * Servlet implementation class addComic
 */
@WebServlet("/abms/addLoan")
public class addLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addLoan() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		PersonConnections p = new PersonConnections();
		ArrayList<Person> persons = new ArrayList<Person>();
		persons = p.getAll();
		ComicConnections c = new ComicConnections();
		ArrayList<Comic> comics = new ArrayList<Comic>();
		comics = c.getAll();
		
		if (persons != null && comics != null){
			rd = sc.getRequestDispatcher("/abms/addLoan.jsp");
			request.setAttribute("allPersons", persons);
			request.setAttribute("allComics", comics);
		}
		else
		{
			request.setAttribute("error", "Persons or comics are not available.");
			rd = sc.getRequestDispatcher("/errors.jsp");
		}
		rd.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		String person = request.getParameter("person");
		String comic = request.getParameter("comic");
//		request.setAttribute("error", name);
		LoanConnections l = new LoanConnections();
		Loan loan = new Loan(comic,person);
		String error = l.add(loan);
		if (error != null) {
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors.jsp");
		} else
			rd = sc.getRequestDispatcher("/listLoans");
		
		rd.forward(request, response);


	}

}
