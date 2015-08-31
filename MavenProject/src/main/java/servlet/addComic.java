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

import dataConnection.ComicConnections;
import element.Comic;

/**
 * Servlet implementation class addComic
 */
@WebServlet("/abms/addComic")
public class addComic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addComic() {
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;

		String name = request.getParameter("name");
		String copys = request.getParameter("copys");
		String type = request.getParameter("type");

		Comic c = new Comic(type, name, new Integer(copys));
		ComicConnections comics = new ComicConnections();
		String error = comics.add(c);
		if (error != null) {
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors.jsp");
		} else
			rd = sc.getRequestDispatcher("/listComics");
		
		rd.forward(request, response);
	}

}
