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
import element.Comic;

/**
 * Servlet implementation class listPersona
 */
@WebServlet("/listComics")
public class listComics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listComics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		ComicConnections c = new ComicConnections();
		ArrayList<Comic> comics = new ArrayList<Comic>();
		comics = c.getAll();
		if (comics != null){
			rd = sc.getRequestDispatcher("/listComics.jsp");
			request.setAttribute("allComics", comics);
			
		}
		else{
			rd = sc.getRequestDispatcher("/errors.jsp");
			String error = "Something went wrong";
			request.setAttribute("error", error);
		}
			
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
