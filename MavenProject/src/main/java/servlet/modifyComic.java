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
@WebServlet("/abms/modifyComic")
public class modifyComic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyComic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/abms/modifyComic.jsp");
		
		ComicConnections comicConnection = new ComicConnections();
		Comic c = comicConnection.getComicById(request.getParameter("id"));
		if (c != null){
			request.setAttribute("comic", c);
			rd.forward(request,response);
		}
		else
			System.out.println("Something went wrong");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String copys = request.getParameter("copys");
		Comic update = new Comic(type,name,new Integer(copys));
		update.setId(new Integer(id));
		ComicConnections c = new ComicConnections();
		String error =c.modify(update); 
		if (error != null){
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors.jsp");
		}
		else
			rd = sc.getRequestDispatcher("/listComics");
			
		rd.forward(request,response);	
		
		
		
	
	
	
	}		
		
		
}
