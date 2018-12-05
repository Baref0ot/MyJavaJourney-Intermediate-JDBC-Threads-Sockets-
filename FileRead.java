/*****************************************************************************
 * 
 *  Matthew Wright
 *  Week # 3
 *  06/18/2018
 * 
 ****************************************************************************/
 // import classes
import java.io.*;
public class FileRead{
	
	// creat Constructor
	public FileRead(String docName){
		try{
		// Interragate File
		long len;
		boolean b1,b2, b3;
		// creating a variable of type File
        File f1;
		//setting a word document called "Always Be Sincer Connection.docx" to the value of f1
		f1 = new File(docName);
		// does this document exist
		b1 = f1.exists();
		// checking the documents length
		len = f1.length();
		// can this file be read
		b2 = f1.canRead();
		// can this file be written to
		b3 = f1.canWrite();
			if(len == 0){
				FileInputStream gops;
				// file your creating (ascii encoding)
				gops = new FileInputStream(docName);
				// text your entering (unicode encoding) into the file and storing in an array of bytes 
				byte arrOfBytes[] = new byte[(int)docName.length()];
				arrOfBytes = gops.read());
				//Coverts your byte data into readable string data
				String s2 = newString(arrOfBytes);
				System.out.println(s2);
				gops.close();
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
		FileRead fr = new FileRead("Always be Sincer Connection.txt");
		System.out.println(fr);
	}// end main
}// end class