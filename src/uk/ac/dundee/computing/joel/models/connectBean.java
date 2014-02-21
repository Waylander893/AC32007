package uk.ac.dundee.computing.joel.models;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;
import java.sql.DriverManager;

import java.util.*;
import java.sql.*;

import uk.ac.dundee.computing.joel.storage.storeBean;


public class connectBean {
	
	private List<storeBean> storeList = new ArrayList<storeBean>();
	
	public void setData(String name, int ec, String sev, String des)
	{
		try{
		     Class.forName("org.gjt.mm.mysql.Driver");
		}catch(Exception E){
		     System.out.println("First: " + E);
		}
		Connection MyConnection=null;
		
		try {
			MyConnection= DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk:3306/12ac3d14","12ac3u14","a1c3b2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		java.util.Date date = new java.util.Date();
		
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		System.out.println("Still working!");
		
		PreparedStatement pmst=null;
		String query= "INSERT INTO faulttable(errorCode,submitID,dateAndTime,severity,description) VALUES (?,?,?,?,?)";
		try {
				pmst = MyConnection.prepareStatement(query);
				pmst.setInt(1,ec);
				pmst.setString(2,name);
				pmst.setDate(3, sqlDate);
				pmst.setString(4,sev);
				pmst.setString(5,des);

				
				pmst.executeUpdate();
		}catch(Exception ex){
			
			System.out.println("Not working");
			return; }

		
		try {
			MyConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<storeBean> getData() {
		
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
			 rs = st.executeQuery("Select * from faulttable");
		}catch(Exception E){
		     System.out.println("Can't execute query: " + E);
		}
		try{
		 System.out.println("Query ");
		 if (rs==null){
			 System.out.println("result set is empty ");
			 rs.close();
			MyConnection.close();
			return null;
		 }
		 		while(rs.next())
				{
		 			storeBean myBean = new storeBean();
					
		 			myBean.setID(rs.getInt("id")); 
					
					myBean.setErrorC(rs.getString("errorCode"));
					
					myBean.setSID(rs.getString("submitID"));
					
					myBean.setDAT(rs.getDate("dateAndTime"));
					
					myBean.setSev(rs.getString("severity"));
					
					myBean.setDesc(rs.getString("description")); 
					
					storeList.add(myBean);
					System.out.println("model data"+myBean.getID());
					
				}
				
				rs.close();
				MyConnection.close();
				
		}
		catch(Exception E){
		     System.out.println("Can't iterate result set: " + E);
		}			 
		return storeList;
	}
}
