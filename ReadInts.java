/*****************************************************************************
 * 
 *  Matthew Wright
 *  Week # 3b
 *  06/25/2018
 * 
 ****************************************************************************/
import java.io.*;

public class ReadInts{
	// Constructor
	public ReadInts(String fileName){
		try{
			// Interragate File
			long len;
			boolean b1,b2, b3;
			
			// 1.)creating an object "theFile" of type File
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
				if(len != 0){
					FileInputStream fin = new FileInputStream(theFile);
					//creating an object of type DataInputStream called din
					DataInputStream din;
					// setting up the DataInputStream for theFile as the object din
					din = new DataInputStream(fin);
					int a;
					for(int x = 0; x < theFile.length()/4; x++){
						a = din.readInt();
						System.out.println(a);
					}// end for
					din.close();
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
		ReadInts ri = new ReadInts("TSNCF.txt");
	}//end main
}// end class