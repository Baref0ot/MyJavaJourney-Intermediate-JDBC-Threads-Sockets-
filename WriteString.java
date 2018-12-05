/*****************************************************************************
 * 
 *  Matthew Wright
 *  Week # 3b
 *  06/25/2018
 * 
 ****************************************************************************/
import java.io.*;

public class WriteString{
	// Constructor
	public WriteString(String fileName, String s1){
		try{
			// Interragate File
			long len;
			boolean b1,b2, b3;
			
			// creating an object "theFile" of type File
			File theFile;
			theFile = new File(fileName);
			
			// does fileName already exist 
			b1 = theFile.exists();
			// checking the documents length
			len = theFile.length();
			// can this file be read
			b2 = theFile.canRead();
			// can this file be written to
			b3 = theFile.canWrite();
			if(len == 0){
				FileOutputStream fout; 
				fout = new FileOutputStream(theFile);
				//creating an object of type DataOutputStream
				PrintStream ps;
				// setting up the DataOutputStream for theFile as the object dout
				ps = new PrintStream(fout);
				// passing the array "myArray" through the dout object to be wrote to the file "fileName"
				ps.println(s1);
				ps.close();
			}// end if
			else{
				System.out.println("This file already exist, right now you cannot override it.");
				System.out.println("Give the file another name, and Try again.");
			}// end else
		}// end try
		catch(IOException e){
			System.out.println("Something went wrong...");
			System.out.println(e);
		}// end catch
	}// end constructor
	
	public static void main(String[] args){
		WriteString ws = new WriteString("f1.txt","Hello World!");
	}//end main
}// end class










