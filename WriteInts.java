/*****************************************************************************
 * 
 *  Matthew Wright
 *  Week # 3b
 *  06/25/2018
 * 
 ****************************************************************************/
import java.io.*;

public class WriteInts{
	// Constructor
	public WriteInts(String fileName, int myArray[]){
		try{
			// Interragate File
			long len;
			boolean b1,b2, b3;
			
			// 1.)creating an object "theFile" of type File
			// 2.)creating a file with the file name passed in by the argument "fileName"
			/* 1.) */File theFile;
			/* 2.) */theFile = new File(fileName);
			
			// does fileName already exist 
			b1 = theFile.exists();
			// checking the documents length
			len = theFile.length();
			// can this file be read
			b2 = theFile.canRead();
			// can this file be written to
			b3 = theFile.canWrite();
				if(len == 0){
					FileOutputStream fout = new FileOutputStream(theFile);
					//creating an object of type DataOutputStream
					DataOutputStream dout;
					// setting up the DataOutputStream for theFile as the object dout
					dout = new DataOutputStream(fout);
					// passing the array "myArray" through the dout object to be wrote to the file "fileName"
					for(int i = 0; i < myArray.length; i++)
					dout.writeInt(myArray[i]);
					dout.close();
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
		int myArray[] = {16,31,90,45,89};
		WriteInts wi;
		wi = new WriteInts("TSNCF.txt", myArray);
	}//end main
}// end class










