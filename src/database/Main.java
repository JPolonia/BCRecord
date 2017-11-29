package database;

public class Main {
    
	public static PostgreSQL main(String args[]) 
	{
		
		String user   = "sibd17g22";
		String pass = "1";
		String url = "jdbc:postgresql://dbm.fe.up.pt:5432/sibd17g22";    //?currentSchema=BCRecord
		String ssl_parameter = "false";
    
		PostgreSQL p = new PostgreSQL(url, user, pass, ssl_parameter);
		 
		//p.regist("Diogo", "Diogo", "Diogo");
		
		/*if(args[0] == "login")
		{
			if( p.login(args[0], args[1]) == 1)
			{
				
				System.out.println("Successful login");
				return 1;
				
			}else {
				
				System.out.println("Wrong login");
				p.disconect();
				return 0;
				 
			}
		}
		
		if(args[0] == "r")
		{
			
			if( p.regist( args[1], args[2], args[3]) == 1)
			{
				System.out.println("Successful regist");
				return 1;
				
			}else {
				
				System.out.println("Wrong regist");
				p.disconect();
				return 0;
				 
			}
		}*/
		
		return p;
				
				
	}
		
		 
		
				
}
  



