/******************************************************************************
 * 
 *  Matthew Wright
 *  Week # 3
 *  06/18/2018
 * 
 *****************************************************************************/
 // import classes
import java.io.*;

public class FileDetails {
	
	// creat Constructor
	public FileDetails(String s){
		// Declarations
		long len;
		boolean b1,b2, b3;
		// creating a variable of type File
        File f1;
		//setting a word document called "Always Be Sincer Connection.docx" to the value of f1
		f1 = new File(s);
		// checking the documents length
		len = f1.length();
		// does this document exist
		b1 = f1.exists();
		// can this file be read
		b2 = f1.canRead();
		// can this file be written to
		b3 = f1.canWrite();
		// print the the length and boolean values
		System.out.println("Length: "+len);
		System.out.println("File Exist: "+b1);
		System.out.println("Can Read: "+b2);
		System.out.println("Can Write: "+b3);
	}// end FileDetails
	
    public static void main(String[] args) {
		// call the constructor and set the name of the String variable inside its parameter list to the name of the word document 
		FileDetails fd = new FileDetails("Always be Sincer Connection.docx");
		System.out.println(fd);
    }// end main  
	
}// end class
