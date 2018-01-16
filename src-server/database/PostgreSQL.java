package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import javax.swing.JTextField;


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
			        System.out.println("Conex„o realizada com sucesso.");
			        //System.out.println(con);
			        
			    }
			    catch (ClassNotFoundException ex)
			    {
			    	
			        System.err.print(ex.getMessage());System.out.println("Conex„o falhada 1.");
			    } 
			    
			    catch (SQLException e)
			    {
			    	
			        System.err.print(e.getMessage());System.out.println("Conex„o falhada 2.");
			  
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
	
		 
		 public int registMedic(String name , String username, String password)
		 {
			 /*Verificar existencia do username a registar */
			 /*tabela medico*/
			 
			 String sql = "SELECT * from bcrecord.medico where username=?";
			 PreparedStatement stm;
				
			 try {
					
				 	stm = con.prepareStatement(sql);
					stm.setString(1, username); 
					ResultSet rs = stm.executeQuery();  
						
					if (rs.next())
					{
						System.out.println("USername already in use, try another");
						return 0;
							
					} else
					{
						System.out.println("Username ok");
						
					}

					} catch (SQLException e) {
						
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 	            
	         /*Visto que n√£o username igual, procede para o registo*/
			
			 try {
	                PreparedStatement pst = con.prepareStatement("INSERT INTO bcrecord.medico (nome, username,password)values(?,?,?)");
	              
	                pst.setString(1,  name);
	                pst.setString(2, username);
	                pst.setString(3, password);
	                pst.executeUpdate();
	                
	                pst = con.prepareStatement("INSERT INTO bcrecord.users (username,password,role)values(?,?,?)");
	                pst.setString(1, username);
	                pst.setString(2, password);
	                pst.setString(3, "medic");
	                pst.executeUpdate();
	                
	                return 1;
	            
			 } catch (SQLException ex) {
	         
				 
	            	System.err.print(ex.getMessage());
	            	return 0;
	            
			 }
		 }
		 
		 public String login(String username, String password)
		 {
			 
			 	String sql = "SELECT * from bcrecord.users where username=? and password=? ";
	            PreparedStatement stm;
				
	            try {
					
						stm = con.prepareStatement(sql);
						stm.setString(1, username);
						stm.setString(2, password); 
						ResultSet rs = stm.executeQuery();  
						
						if (rs.next())
						{
							//System.out.println("OK login");
							return rs.getString("role");
							
						} else
						{
							//System.out.println("Wrong login");
							return null;
						}

					} catch (SQLException e) {
						
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				return null;
	          
	           

	          
		 }
		 
		 public int registPatient(String name , String username, String password, String birth_date, int sns, String date_1c, String adress, String civil_state )
		 {
			 /*Verificar existencia do username a registar */
			 /*tabela medico*/
			 
			 String sql = "SELECT * from bcrecord.paciente where username=? or sns=?";
			 PreparedStatement stm;
				
			 try {
					
				 	stm = con.prepareStatement(sql);
					stm.setString(1, username); 
					stm.setLong(2, sns);
					ResultSet rs = stm.executeQuery();  
						
					if (rs.next())
					{
						System.out.println("USername or sns already in use, try another");
						return 0;
							
					} else
					{
						System.out.println("Username ok");
						
					}

					} catch (SQLException e) {
						
						// TODO Auto-generated catch block
						e.printStackTrace();
						return 0;
					}
			 
			 /*paciente*/
			 
			 sql = "SELECT * from bcrecord.medico where username=?";
				
			 try {
					
				 	stm = con.prepareStatement(sql);
					stm.setString(1, username); 
					ResultSet rs = stm.executeQuery();  
						
					if (rs.next())
					{
						System.out.println("USername already in use, try another");
						return 0;
							
					} else
					{
						System.out.println("Username ok");
						
					}

					} catch (SQLException e) {
						
						// TODO Auto-generated catch block
						e.printStackTrace();
						return 0;
					}
	            
	         /*Visto que n√£o username igual, procede para o registo*/
			
			 try {
	                /*PreparedStatement pst = con.prepareStatement("INSERT INTO bcrecord.paciente (nome, username,password, data_nasc, sns, data_1c, morada, estado_civil)values(?,?,?,?,?,?,?,?)");
	              
	                pst.setString(1,  name);
	                pst.setString(2, username);
	                pst.setString(3, password);
	                pst.setString(4, birth_date);
	                pst.setInt(5, sns);
	                pst.setString(6, date_1c);
	                pst.setString(7, adress);
	                pst.setString(8, civil_state);
	                pst.executeUpdate();*/
				 
				 	PreparedStatement pst = con.prepareStatement("INSERT INTO bcrecord.users (username,password,role)values(?,?,?)");
	                pst.setString(1, username);
	                pst.setString(2, password);
	                pst.setString(3, "paciente");
	                pst.executeUpdate();
	                
	                return 1;
	            
			 } catch (SQLException ex) {
	         
				 
	            	System.err.print(ex.getMessage());
	            	return 0;
	            
			 }
		 }
		 
		 public int search(String paciente, JTextField data, JTextField sns, JTextField data1c, JTextField morada, JTextField estado_civil ) {
			 
			 String sql = "SELECT * from bcrecord.paciente where nome=?";
			 PreparedStatement pst;
			 ResultSet rs;
			 
	         try {
	        	 	
	        	 	pst=con.prepareStatement(sql);
					pst.setString(1, paciente);
					
					rs=pst.executeQuery();
					
					if(rs.next()) {
						String add1=rs.getString("data_nasc");
						data.setText(add1);
						String add2=rs.getString("sns");
						sns.setText(add2);
						String add3=rs.getString("data_1c");
						data1c.setText(add3);
						String add4=rs.getString("morada");
						morada.setText(add4);
						String add5=rs.getString("estado_civil");
						estado_civil.setText(add5);
						
						System.out.println("Procura bem sucedida");
						return 1;
						
					} else{
						
						System.out.println("Procura Mal Sucedida");
						return 0;
					}

				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			return 0;

		 }
	}
