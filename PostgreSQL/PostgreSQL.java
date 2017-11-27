package database_conection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
		 
		 public void regist(String name , String username, String password)
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
	            } catch (SQLException ex) {
	                //JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar!\n Erro:"+ex);
	            	System.err.print(ex.getMessage());
	            }
		 }
		 
		/* public void login(String username, String password)
		 {
			 
			 String sql = "select * from bcrecord.medico where username=? and password=? ";
	            PreparedStatement stm = con.prepareStatement(sql);
	            stm.setString(1, username);
	            stm.setString(1, password);

	            ResultSet rs = stm.executeQuery();

	            if (rs.next())
	            {
	                System.out.println(" Logado");
	            } else
	            {
	                System.out.println("login ou senha incorretos");
	            }
		 }*/
	}
