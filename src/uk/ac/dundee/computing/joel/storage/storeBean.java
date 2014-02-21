package uk.ac.dundee.computing.joel.storage;

import java.util.*;

public class storeBean {
	
	private String test;
	private int ID;
	private String ErrorC;
	private String SID;
	private Date DAT;
	private String Sev;
	private String Desc;
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getErrorC() {
		return ErrorC;
	}

	public void setErrorC(String errorC) {
		ErrorC = errorC;
	}

	public String getSID() {
		return SID;
	}

	public void setSID(String sID) {
		SID = sID;
	}

	public Date getDAT() {
		return DAT;
	}

	public void setDAT(Date dAT) {
		DAT = dAT;
	}

	public String getSev() {
		return Sev;
	}

	public void setSev(String sev) {
		Sev = sev;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	} 

}
