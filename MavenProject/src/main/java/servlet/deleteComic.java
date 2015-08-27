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

/**
 * Servlet implementation class addComic
 */
@WebServlet("/abms/deleteComic")
public class deleteComic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteComic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		ComicConnections comicConnection = new ComicConnections();
		String error = comicConnection.remove(request.getParameter("id"));
		if (error != null) {
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors");
		} else
			rd = sc.getRequestDispatcher("/listLoans");
		if (error != null){
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors");
		}
		else
			rd = sc.getRequestDispatcher("/listComics");
			
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}		
		
		
}
