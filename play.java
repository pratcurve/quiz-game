import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class play {
	public int game(){
		Scanner input = new Scanner(System.in);
		String ans_opt;
		int question_no=0;
		//Scanner ans = new Scanner(System.in);
		int score=0;
		Connection conn=null;
		Statement stmnt = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			System.out.println("class not found");
		}
		try{
			int n=0;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbc", "root", "3032");
		//System.out.println("connection is established");
		//STEP 4: Execute a query
	   //   System.out.println("Creating statement.../a");
	      stmnt = conn.createStatement();
	      String sql;
	      ResultSet rs; 
	    //  System.out.println("Query executed");
	     // System.out.println("Step 4");
	    	  stmnt=conn.createStatement();
	      sql = "SELECT * from Questions order by rand() limit 3";
	      rs = stmnt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	    	  question_no++;
	         //Retrieve by column name
	         int id  = rs.getInt("Qid");
	         String question = rs.getString("question");
	         String opt1 = rs.getString("opt1");
	         String opt2 = rs.getString("opt2");
	         String opt3 = rs.getString("opt3");
	         String opt4 = rs.getString("opt4");
	         String correct = rs.getString("correct_answer");
	         char correct_ans = correct.charAt(0);
	         //Display values
	         System.out.print(question_no);         
	         System.out.print(": " + question);
	         System.out.print("\nA. " + opt1);
	         System.out.print("\t\tB. " + opt2);
	         System.out.print("\nC. " + opt3);
	         System.out.print("\t\tD. " + opt4);
	         System.out.print("\nEnter your answer: ");
	         ans_opt=input.nextLine();
	         char answer1=ans_opt.charAt(0);
	         if((answer1-32)== correct_ans){
	      	 System.out.println("\n\n\tCorrect answer!!!");
	        	 
	         score++;
	         }
	         else{
	        	 return score;
	         }
	         
	      }
	     // rs.close();
	     // }
	   }catch(SQLException se){
	    //  Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
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
	   //System.out.println("Goodbye!");
		//input.close();
		return score;
	}

}
