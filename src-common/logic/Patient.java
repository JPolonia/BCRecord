package logic;

import java.io.Serializable;

public final class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2022330374397641326L;

	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
	private String username;
	private String passHash;
	
	public String fullName;
	public String phoneNumber;
	public int dataNascimento;
	public int dataPrimeiraConsulta;
	public int numberProcess;
	public int sns;
	public String id;
	public String address;
	public String estadoCivil;
	public boolean rastreio;
	
	protected String getUser() {
		return username;
	}

	protected  void setUser(String str) {
		username = str;
	}
	
	protected String getPassHash() {
		return passHash;
	}

	protected void setPassHash(String str) {
		passHash = str;
	}

	public void setData(String fullName, String phoneNumber, int dataNascimento, int dataPrimeiraConsulta, int numberProcess, String address, int sns) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.numberProcess = numberProcess;
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
		this.dataNascimento = dataNascimento;
		this.address = address;
		this.sns = sns;
	}
	
	public Object getData(String attribute) {
		switch(attribute) {
			case "fullName":
				return fullName;
			case "phoneNumber":
				return phoneNumber;
			case "numberProcess":
				return numberProcess;
			case "dataPrimeiraConsula":
				return dataPrimeiraConsulta;
			case "dataNascimento":
				return dataNascimento;
			case "address":
				return address;
			case "sns":
				return sns;
			default:
				return null;
		}
	}
	

}
