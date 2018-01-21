package socket;

import java.io.Serializable;
import java.util.ArrayList;

import logic.Patient;

public class SocketObject implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1313634636751502698L;
	
	private int number;
	private String IPaddress , user, cmd, msg, pass, role;
	private String newUser,newPassword, newRole;
	public  ArrayList<String> list;
	public Patient patient;

	private String PatientName;
	//public ArrayList<FieldSQL> valuesSQL = new ArrayList<FieldSQL>();
	
	public SocketObject(int num, String ip){
		this.setNumber(num);
		this.setIPaddress(ip);
	}
	
	public void flush() {
		//this.list.clear();
		//this.valuesSQL.clear();
		this.msg = null;
		this.cmd = null;
		this.number = 0;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int i) {
		this.number = i;
	}

	public String getIPaddress() {
		return IPaddress;
	}

	public void setIPaddress(String ip) {
		this.IPaddress = ip;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String name) {
		this.user = name;
	}
	
	public String getCommand() {
		return cmd;
	}

	public void setCommand(String cmd) {
		this.cmd = cmd;
	}
	
	public String getMessage() {
		return msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}
	
	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getNewUser() {
		return newUser;
	}

	public void setNewUser(String name) {
		this.newUser = name;
	}
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String name) {
		this.newPassword = name;
	}

	public void setPatientName(String name) {
		this.PatientName = name;
	}
	
	public String getPatientName() {
		return PatientName;
	}
}

