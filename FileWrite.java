/*****************************************************************************
 * 
 *  Matthew Wright
 *  Week # 3
 *  06/18/2018
 * 
 ****************************************************************************/
 // import classes
import java.io.*;
public class FileWrite{
	
	// creat Constructor
	public FileWrite(String s, String s1){
		try{
		// Interragate File
		long len;
		boolean b1,b2, b3;
		// creating a variable of type File
        File f1;
		//setting a word document called "Always Be Sincer Connection.docx" to the value of f1
		f1 = new File(s);
		// does this document exist
		b1 = f1.exists();
		// checking the documents length
		len = f1.length();
		// can this file be read
		b2 = f1.canRead();
		// can this file be written to
		b3 = f1.canWrite();
			if(len == 0){
				FileOutputStream fops;
				// file your creating (ascii encoding)
				fops = new FileOutputStream(s);
				// text your entering (unicode encoding) into the file and storing in an array of bytes 
				byte arrOfBytes[] = new byte[s1.length()];
				// gets data byte data stored in the array (ascii encoding)
				arrOfBytes = s1.getBytes();
				// what and where on the physical document do you want the data to be displayed
				fops.write(arrOfBytes, 0 , 26);
				fops.close();
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
	}// end FileDetails
	
    public static void main(String[] args) {
		// call the constructor and set the name of the String variable inside its parameter list to the name of the word document 
		FileWrite fw = new FileWrite("RaeneeIsAwesome.txt", "Hello World...............");
		System.out.println(fw);
	}// end main
}// end class
