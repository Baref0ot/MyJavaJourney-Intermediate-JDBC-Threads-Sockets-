/***************************************************************************

		Matthew Wright
		Ronald Enz
		Lab 5a
		7/9/2018
		
****************************************************************************/
import java.sql.*;

public class DBTester{
	public static void main(String[] args){
		try{
			System.out.println();
			System.out.println();
			System.out.println("Starting Database Tester...");
			
			// if you run the app from your app from your flashdrive don't forget to change the path
			// step 1 and step 2: load the driver and getting a connection
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://F:/{M.L.W} CTC Files/Courses/Summer 2018/Java 2/Week_6_JarFiles/RegistrationDB.mdb");
			
			//step 3: create a memory location for a Statement in which data from the database can be placed
			Statement stmt = con.createStatement();
			
			//step 4: start exacuting SQL Statements on the database through java
			String sql;
			System.out.println();
			sql = "select * from Instructors";
			System.out.println(sql);
			ResultSet rs;
			rs = stmt.executeQuery(sql);
			
			//step 5: Process Data recieved through String sql Statement from database
				System.out.println();
				System.out.println("=====================================================");
			while(rs.next()){
				System.out.println("ID: "+ rs.getInt(1));
				System.out.println("First Name: "+ rs.getString(2));
				System.out.println("Last Name: "+ rs.getString(3));
				System.out.println("Street: "+ rs.getString(4));
				System.out.println("City: "+ rs.getString(5));
				System.out.println("State: "+ rs.getString(6));
				System.out.println("Zip: "+ rs.getInt(7));
				System.out.println("Office: "+ rs.getString(8));
				System.out.println("Email: "+ rs.getString(9));
				System.out.println("=====================================================");
			}// end While
			
			//step 6: close the connection to the database
			con.close();
			
		}// end try
			
		catch(Exception e){
			System.out.println(e);
		}// end catch
	}// end main
}// end class