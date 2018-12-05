/********************************************************************

	Matthew Lee Wright
	Java 2 / lab 4
	6/27/2018
	
*********************************************************************/

public class MyThread extends Thread{
	// Declarations
	private int count;
	
	// Constructor 
	public MyThread(int x){
		count = x;
	}// end Constuctor
	
	// create run method for thread
	public void run(){
		for(int i = 0; i <= count; i++){
			System.out.println(" Thread Running... " + i);
		}// end for
	}//end run
	
	public static void main(String[] args){
		// Thread number 1
		MyThread mt;
		mt = new MyThread(250);
		mt.start();
		// Thread number 2
		MyThread mt2;
		mt2 = new MyThread(300);
		mt2.start();
	}// end main
}// end class