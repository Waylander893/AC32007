package uk.ac.dundee.computing.joel.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ac.dundee.computing.joel.storage.loginBean;
import uk.ac.dundee.computing.joel.storage.userBean;


/**
 * Servlet implementation class login
 */
@WebServlet({ "/login", "/login/*","/Login"})
public class login extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
	public userBean curU = new userBean();
	
    public login() {
        super();
        // TODO Auto-generated constructor stub

}
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
			if(curU.getAuth() == true)
			{
				RequestDispatcher rD=request.getRequestDispatcher("/Redirect3.jsp");
				rD.forward(request,response);	
			}
			else
			{
				RequestDispatcher rD=request.getRequestDispatcher("/Login.jsp");
				rD.forward(request,response);	
				
			}

	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		System.out.println("This is the doPost method of login");
		
		
		
		String userN = request.getParameter("userName");        
	 	String passW = request.getParameter("userPass");
 	
	 		 	
	 		uk.ac.dundee.computing.joel.models.userCheckBean checkBean=new uk.ac.dundee.computing.joel.models.userCheckBean();
		List<loginBean> loginData = checkBean.getData();
		if (loginData==null)
		{
			System.out.println("no Data returned");
		}
	
		Iterator<loginBean> it = loginData.iterator();
	
		int iter = 0;
	
		while (it.hasNext())
		{
			loginBean item = new loginBean();
			item = (loginBean)it.next();
		
			String NAME = item.getUserN();
			String PASS = item.getPassW();
		
			System.out.println(" ");
		
			System.out.println("The current name: " + NAME + " is being checked against: " + userN);
		
			System.out.println(" ");
		
			if (NAME.equals(userN))
			{
			
				System.out.println("The matching name is: " + NAME);
			
				if(PASS.equals(passW))
				{
					System.out.println("The matching pass is: " + PASS);
				
		   	 		curU.setUserN(userN);
		   	 		curU.setPassW(passW);
		   	 		curU.setAuth(true);
					break;
				
				}
				else
				{
		   	 		curU.setAuth(false);
				}
			}
			else
			{
	   	 		curU.setAuth(false);	
			}	
		
			System.out.println("this loop has looped " + iter + " times");
			iter++;
			
		
		}
		
		
		
		if (curU.getAuth() == true)
		{
			session.setAttribute("UserData", curU);
			RequestDispatcher rD=request.getRequestDispatcher("/Redirect.jsp");
			rD.forward(request,response);
		}
		else
		{
			RequestDispatcher rD=request.getRequestDispatcher("/Failed.jsp");
			rD.forward(request,response);
			
		}
	}
	
}
