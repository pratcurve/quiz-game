import java.sql.*;

public class score {
	private String Name;
	int score;
	public score(String consName){
		 Name = consName;
		 System.out.println("\nName of player is : "+Name);
		 return;
			
	}
	
	public void keepScore(int getScore){
		score = getScore;
		storeScore();
		return;
	}
	public void storeScore(){
		Connection conn = null;
		Statement stmnt = null;
		//driver
		try{
			Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException e){
				System.out.println("class not found");
				return ;
			}
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbc", "root", "3032");
			stmnt = conn.createStatement();
			System.out.println(Name);
			System.out.println(score);
			
			
			String sql = "INSERT INTO SCORES (Name,Score)" + "VALUES (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Name);
			pstmt.setInt(2,score);
			pstmt.execute();
			System.out.println("values inserted");
		}
		//catch(SQLException se){
		    //  Handle errors for JDBC
		  //    se.printStackTrace();
		 //  }
			catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmnt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		
	}

}
