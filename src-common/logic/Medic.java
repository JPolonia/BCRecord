package logic;

public final class Medic {
	
	private static String username;
	private static String passHash;
	
	private static String fullName;
	private static String phoneNumber;

	private Medic() {
		// TODO Auto-generated constructor stub
	}
	
	protected static String getUser() {
		return username;
	}

	protected static void setUser(String str) {
		Medic.username = str;
	}
	
	protected static String getPassHash() {
		return passHash;
	}

	protected static void setPassHash(String str) {
		Medic.passHash = str;
	}
	
	

}
