package uk.ac.dundee.computing.joel.storage;



public class userBean {

	private String UserN;
	private String PassW;
	private boolean auth;
	
	public String getUserN()
	{
		return UserN;	
	}
	
	public void setUserN(String u)
	{
		UserN = u;	
	}
	
	public String getPassW()
	{
		return PassW;	
	}
	
	public void setPassW(String p)
	{
		PassW = p;	
	}
	
	public boolean getAuth()
	{
		return auth;
	}
	
	public void setAuth(boolean a)
	{
		auth = a;
	}
	
	
}
