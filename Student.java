/**************************************************************************

	Matthew Wright
	Ronald Enz
	Lab 5b
	7/9/2018
	
***************************************************************************/
import java.sql.*;

public class Student{
	// Declarations 
	private int id;
	private int zip;
	private double gpa;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String email;
	
	// Setter Methods
	public void setID(int i){
		id = i;
	}// end setID
	public void setZip(int z){
		zip = z;
	}// end setZip
	public void setGPA(double g){
		gpa = g;
	}// end setGPA
	public void setFirstName(String fn){
		firstName = fn;
	}// end setFirstName
	public void setLastName(String ln){
		lastName = ln;
	}// end setLastName
	public void setStreet(String str){
		street = str;
	}// end setStreet
	public void setCity(String c){
		city = c;
	}// end setCity
	public void setState(String st){
		state = st;
	}// end setState
	public void setEmail(String em){
		email = em;
	}// end setEmail
	
	// Getter Methods
	public int getID(){
		return id;
	}// end getID
	public int getZip(){
		return zip;
	}// end getZip
	public double getGPA(){
		return gpa;
	}// end getGPA
	public String getFirstName(){
		return firstName;
	}// end getFirstName
	public String getLastName(){
		return lastName;
	}// end getLastName
	public String getStreet(){
		return street;
	}// end getStreet
	public String getCity(){
		return city;
	}// end getCity
	public String getState(){
		return state;
	}// end getState
	public String getEmail(){
		return email;
	}// end getEmail
	
	// Constructors
	public Student(){
		setID(0);
		setZip(0);
		setGPA(0);
		setFirstName("");
		setLastName("");
		setStreet("");
		setCity("");
		setState("");
		setEmail("");
	}// end Constructor 1
	public Student(int i, int z, double g, String fn, String ln, String str, String c, String st, String em){
		setID(i);
		setZip(z);
		setGPA(g);
		setFirstName(fn);
		setLastName(ln);
		setStreet(str);
		setCity(c);
		setState(st);
		setEmail(em);
	}// end Construct 2
	
	public void selectDB(int id){
		setID(id);
		try{
			// step 1 and step 2: load the driver and get a connection
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Matthew/Desktop/Week_6_JarFiles/RegistrationDB.mdb");
			
			//step 3: create a memory for a Statement in which data from the database can be placed
				Statement stmt = con.createStatement();
				
			//step 4: start executing SQL Statements on the database through Java
			System.out.println();
			String sql;
			sql = "select * from Students where ID = " +id;
			System.out.println(sql);
			ResultSet rs;
			rs = stmt.executeQuery(sql);
			
			//step 5: Process Data received through String sql Statement from database
				    rs.next();
					setFirstName(rs.getString(2));
					setLastName(rs.getString(3));
					setStreet(rs.getString(4));
					setCity(rs.getString(5));
					setState(rs.getString(6));
					setZip(rs.getInt(7));
					setEmail(rs.getString(8));
					setGPA(rs.getDouble(9));
		} // end try
		catch(Exception e){
			System.out.println(e);
		}// end catch
	}// end selectDB
	
		public void insertDB(int id, String firstName, String lastName, String street,  String city,  String state, int zip, String email, double gpa){
			try{
				// step 1 and step 2: load the driver and get a connection
				Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Matthew/Desktop/Week_6_JarFiles/RegistrationDB.mdb");
				
				//step 3: create a memory for a Statement in which data from the database can be placed
					Statement stmt = con.createStatement();
					
				//step 4: start exacuting SQL Statements on the database through java
				System.out.println();
				String sql;
				sql = "insert into Students values( "+id+", '"+firstName+"','"+lastName+"', '"+street+"', '"+city+"', '"+state+"', "+zip+", '"+email+"', "+gpa+" )";
				System.out.println(sql);
				int n = stmt.executeUpdate(sql);
				if(n == 1){
					System.out.println(" 1 row of data was entered successfully.");
				}// end if
				else if(n != 1){
					System.out.println("Something went wrong...");
				}// end else if
				// You do not need (step 5: process the result set) because there is no result set
			} // end try
		catch(Exception e){
			System.out.println(e);
		}// end catch
	}// end insertDB
	
		public void updateDB(){
			try{
				// step 1 and step 2: load the driver and get a connection
				Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Matthew/Desktop/Week_6_JarFiles/RegistrationDB.mdb");
				
				//step 3: create a memory for a Statement in which data from the database can be placed
					Statement stmt = con.createStatement();
					
				//step 4: start exacuting SQL Statements on the database through java
				System.out.println();
				String sql;
				sql = "update Students set FirstName = '"+firstName+"', LastName = '"+lastName+"', Street = '"+street+"', City ='"+city+"', State = '"+state+"', Zip = "+zip+", Email = '"+email+"', GPA = "+gpa+" where ID = " +id;
				System.out.println(sql);
				int n = stmt.executeUpdate(sql);
				if(n == 1){
					System.out.println(" 1 row of data was updated successfully.");
				}// end if
				else if(n != 1){
					System.out.println("Something went wrong...");
				}// end else if
			} // end try
		catch(Exception e){
			System.out.println(e);
		}// end catch
	}// end updateDB
	
	public void deleteDB(){
			try{
				// step 1 and step 2: load the driver and get a connection
				Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Matthew/Desktop/Week_6_JarFiles/RegistrationDB.mdb");
				
				//step 3: create a memory for a Statement in which data from the database can be placed
					Statement stmt = con.createStatement();
					
				//step 4: start exacuting SQL Statements on the database through java
				System.out.println();
				String sql;
				sql = "delete from Students where ID = " +id;
				System.out.println(sql);
				int n = stmt.executeUpdate(sql);
				if(n == 1){
					System.out.println(" 1 row of data was deleted successfully.");
				}// end if
				else if(n != 1){
					System.out.println("Something went wrong...");
				}// end else if
			} // end try
		catch(Exception e){
			System.out.println(e);
		}// end catch
	}// end updateDB
	
	//Display
	public void Display(){
		System.out.println();
		System.out.println("=================================================================");
		System.out.println();
		System.out.println(" Student ID.. "+getID());
		System.out.println(" First Name.. "+getFirstName());
		System.out.println(" Last Name... "+getLastName());
		System.out.println(" Street...... "+getStreet());
		System.out.println(" City........ "+getCity());
		System.out.println(" State....... "+getState());
		System.out.println(" Zip......... "+getZip());
		System.out.println(" Email....... "+getEmail());
		System.out.println(" GPA......... "+getGPA());
		System.out.println();
		System.out.println("=================================================================");
		System.out.println();
	}// end Display
		
	public static void main(String[] args){

		// object 1: testing select
		Student s1 = new Student();
		s1.selectDB(3);
		s1.Display();
		
	    //object 2: testing insert
		Student s2 = new Student();
		s2.insertDB(17, "John", "Wright", "121 Pine Ridge rd. NW", "White", "GA", 30184, "John80@yahoo.com", 4.0);
		
		// object 3: testing update
		Student s3 = new Student();
		s3.selectDB(24);
		s3.setZip(30121);
		s3.updateDB();
		s3.Display();
		
		//object 4: testing delete
		Student s4 = new Student();
		s4.selectDB(6);
		s4.deleteDB();

	}// end main
}// end class