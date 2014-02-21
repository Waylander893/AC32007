<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="uk.ac.dundee.computing.joel.storage.storeBean" %>
    <%@ page import="java.text.SimpleDateFormat;" %>
    

	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Results</title>
</head>
<body>

<a href="http://localhost:8080/FaultReportSystem/Logout.jsp">Log out</a>
	
	<% 
	if (request.getAttribute("dataBean") !=null){
		ArrayList<storeBean> storeB = (ArrayList<storeBean>)request.getAttribute("dataBean");
	
		Iterator it = storeB.iterator();
		
		%>
		<p><strong>ID	|	Error_Code	|	User	|	Date	|	Severity	|	Description</strong></p>
		<%
	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        while(it.hasNext())
	        {
	          
	        	storeBean item = (storeBean)it.next();
	            int value = item.getID();	
	            String value2 = item.getErrorC();
	       	 	String value3 = item.getSID();
	       	 	
	       	 	

	       		String value4=formatter.format(item.getDAT());
	    	 	
	    	 	//Date value4 = item.getDAT();
				String value5 = item.getSev();
	    	 	String value6 = item.getDesc();
				%>
			  <p><%=value%>	|	<%=value2%>	|	<%=value3%>	|	<%=value4%>	|	<%=value5%>	|	<%=value6%></p>
			  
			  <% 
			  
			  
			}
	        
	        %>
	        			 
                                        ><a href="Add.jsp">Add a new fault</a>
                            
	        <%
	}else{
		%>
		<p><strong>No Data</strong></p>
		<%
	}
			%>
		
</body>
</html>