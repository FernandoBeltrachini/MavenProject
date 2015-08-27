package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataConnection.LoanConnections;

/**
 * Servlet implementation class addComic
 */
@WebServlet("/abms/deleteLoan")
public class deleteLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteLoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		LoanConnections loansConnection = new LoanConnections();
		String error = loansConnection.remove(request.getParameter("id"));
		if (error == null)
			rd = sc.getRequestDispatcher("/listLoans");
		else{
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors");
		}
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}		
		
		
}
