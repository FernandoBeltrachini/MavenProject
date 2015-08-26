package servlet;

import java.io.IOException;

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

		String name  = request.getParameter("name");
		String copys = request.getParameter("copys");
		String type = request.getParameter("type");
		
		Comic c = new Comic(type,name,new Integer(copys));
		ComicConnections comics  = new ComicConnections();
		String error = comics.add(c);
		if (error != null)
			System.out.println(error);
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
