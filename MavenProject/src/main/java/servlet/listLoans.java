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

import dataConnection.LoanConnections;
import element.Loan;

/**
 * Servlet implementation class listPersona
 */
@WebServlet("/listLoans")
public class listLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public listLoans() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = null;
		
		LoanConnections l = new LoanConnections();
		ArrayList<Loan> loans = new ArrayList<Loan>();
		loans = l.getAllLoans();
		if (loans != null ){
			request.setAttribute("allLoans", loans);
			rd = sc.getRequestDispatcher("/listLoans.jsp");
			
		}
		else{
			String error = new String ("Loans are not availables.");
			request.setAttribute("error", error);
			rd = sc.getRequestDispatcher("/errors.jsp");
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
