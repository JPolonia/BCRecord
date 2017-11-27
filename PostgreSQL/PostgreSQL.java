package database_conection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


	public class PostgreSQL
	{
		
		 String driver = "org.postgresql.Driver";
		 Properties props;
		 Connection con = null;
		 
		 
		 public PostgreSQL(String url, String username, String pass, String ssl_parameter) 
		 { 
			 
			 props = new Properties();
			 props.setProperty("user", username);
			 props.setProperty("password", pass);
			 props.setProperty("ssl", ssl_parameter);
			 
			 try
			    {
			        Class.forName(driver);
			        con =  DriverManager.getConnection(url, props);
			        System.out.println("Conexão realizada com sucesso.");
			        System.out.println(con);
			        
			    }
			    catch (ClassNotFoundException ex)
			    {
			    	
			        System.err.print(ex.getMessage());System.out.println("Conexão falhada 1.");
			    } 
			    
			    catch (SQLException e)
			    {
			    	
			        System.err.print(e.getMessage());System.out.println("Conexão falhada 2.");
			  
			    }

		 }  
		 
		 public void disconect()
		 {
			 try {
				 
		            con.close();
		            
		        } catch (SQLException ex) {
		            
		        	System.err.print(ex.getMessage());
		        	
		        }
		 }
	}
