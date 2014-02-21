package uk.ac.dundee.computing.joel.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ac.dundee.computing.joel.storage.storeBean;
import uk.ac.dundee.computing.joel.storage.userBean;

/**
 * Servlet implementation class fault
 */
@WebServlet({ "/fault", "/fault/*", "/faults" })
public class fault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	

    public fault() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//uk.ac.dundee.computing.joel.storage.storeBean storeBean=new uk.ac.dundee.computing.joel.storage.storeBean();
		//storeBean.setTest("Hello World");
		//request.setAttribute("storeBean", storeBean);
	    //RequestDispatcher rd=request.getRequestDispatcher("/View.jsp");
		//rd.forward(request,response);
		
			HttpSession session = request.getSession();
		
			userBean nameT = (userBean) session.getAttribute("UserData");
			
			if(nameT.getAuth() == true)
			{
				uk.ac.dundee.computing.joel.models.connectBean connectBean=new uk.ac.dundee.computing.joel.models.connectBean();
				List<storeBean> data = connectBean.getData();
				if (data==null)
				{
					System.out.println("no Data returned");
				}
				request.setAttribute("dataBean", data);
				RequestDispatcher rD=request.getRequestDispatcher("/View.jsp");
				rD.forward(request,response);
			}
			else
			{
				RequestDispatcher rD=request.getRequestDispatcher("/AccessDenied.jsp");
				rD.forward(request,response);
				
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		uk.ac.dundee.computing.joel.models.connectBean connectBean=new uk.ac.dundee.computing.joel.models.connectBean();
		
		uk.ac.dundee.computing.joel.storage.userBean userBean=new uk.ac.dundee.computing.joel.storage.userBean();
		
				
		HttpSession session = request.getSession();
				
		userBean nameT = (userBean) session.getAttribute("UserData");
		
		if(nameT.getAuth() == true)
		{
			String uName = nameT.getUserN();
	        
	   	 	String temp = request.getParameter("txtEC");
	   	 	int eCode = Integer.parseInt(temp);
	   	 	
			String severity = request.getParameter("txtSev");
		 	String description = request.getParameter("txtDesc"); 
		 	
		 	
		 	System.out.println("Its working so far (doPst in fault servlet)");
		 	connectBean.setData(uName, eCode, severity, description);
		 	
		 	
		 	RequestDispatcher rD=request.getRequestDispatcher("/Redirect2.jsp");
			rD.forward(request,response);
		}
		else
		{
			RequestDispatcher rD=request.getRequestDispatcher("/AccessDenied.jsp");
			rD.forward(request,response);			
		}
		

	}

}
