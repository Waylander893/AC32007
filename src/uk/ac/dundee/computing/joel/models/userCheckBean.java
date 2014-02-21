package uk.ac.dundee.computing.joel.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.util.*;
import java.sql.*;

import uk.ac.dundee.computing.joel.storage.loginBean;



public class userCheckBean {
	
	private List<loginBean> storeList = new ArrayList<loginBean>();
	
	public void setData(String name, String pass)
	{
		
	}
	
public List<loginBean> getData() {
		
		try{
		     Class.forName("org.gjt.mm.mysql.Driver");
		}catch(Exception E){
		     System.out.println("First: " + E);
		}
		Connection MyConnection=null;
		try {
		
			 MyConnection= DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk:3306/12ac3d14","12ac3u14","a1c3b2");
		}catch(Exception E)
		{
		     System.out.println("Can't load driver: " + E);
		}	
		Statement st = null;
		ResultSet rs=null;
		try{	
			 st = MyConnection.createStatement(); 
			 rs = st.executeQuery("Select * from userLogin");
		}catch(Exception E){
		     System.out.println("Can't execute query: " + E);
		}
		try
		{
			System.out.println("Query ");
			if (rs==null)
			{
				System.out.println("result set is empty ");
				rs.close();
				MyConnection.close();
				return null;
			}
		 		
			while(rs.next())
			{
		 		loginBean myUsers = new loginBean();
				
		 		myUsers.setUserN(rs.getString("UserName")); 
					
		 		myUsers.setPassW(rs.getString("UserPass"));
										
				storeList.add(myUsers);
				System.out.println("model data "+myUsers.getUserN()+ " " + myUsers.getPassW());					
			}				
			rs.close();
			MyConnection.close();				
		}
		catch(Exception E)
		{
		     System.out.println("Can't iterate result set: " + E);
		}			 
		return storeList;
	}
}
