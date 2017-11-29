package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		        System.out.println("Conex�o realizada com sucesso.");
		        System.out.println(con);
		        
		    }
		    catch (ClassNotFoundException ex)
		    {
		    	
		        System.err.print(ex.getMessage());System.out.println("Conex�o falhada 1.");
		    } 
		    
		    catch (SQLException e)
		    {
		    	
		        System.err.print(e.getMessage());System.out.println("Conex�o falhada 2.");
		  
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

	 
	 public int regist(String name , String username, String password)
	 {
		 try {
                PreparedStatement pst = con.prepareStatement("INSERT INTO bcrecord.medico (nome, username,password)values(?,?,?)");
                // pst.setString(1, jPasswordField1.getText());
                //  pst.setString(2, jTextField6.getText());
                pst.setString(1,  name);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.executeUpdate();
                // jProgressBar1.setValue(100);
                //  JOptionPane.showMessageDialog(rootPane, "Cadastrado com sucesso!");
                return 1;
            
		 } catch (SQLException ex) {
         
			 	//JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar!\n Erro:"+ex);
            	System.err.print(ex.getMessage());
            	return 0;
            
		 }
	 }
	 
	 public int login(String username, String password)
	 {
		 
		 	String sql = "SELECT * from bcrecord.medico where username=? and password=? ";
            PreparedStatement stm;
			
            try {
				
					stm = con.prepareStatement(sql);
					stm.setString(1, username);
					stm.setString(2, password); 
					ResultSet rs = stm.executeQuery();  
					
					if (rs.next())
					{
						System.out.println("OK login");
						return 1;
						
					} else
					{
						System.out.println("Wrong login");
						return 0;
					}

				} catch (SQLException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return 0;
          
           

          
	 }
}