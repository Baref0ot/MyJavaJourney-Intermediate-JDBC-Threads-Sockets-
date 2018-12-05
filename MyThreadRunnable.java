/********************************************************************

	Matthew Lee Wright
	Java 2 / lab 4
	6/27/2018
	
*********************************************************************/
public class MyThreadRunnable implements Runnable{
		// Declarations
		private int count;
		
		// Constructors 
		public MyThreadRunnable(int x){
			count = x;
		}// end Constructor
		
		// create the run() method for thread
		public void run(){
			for(int i = count; count <= 301; i++){
				System.out.println("Thread Running..." + count);
			}// end for
		}// end run
		
	public static void main(String[] args){
		// object number 1
		MyThreadRunnable myr;
		myr = new MyThreadRunnable(250);
		Thread t1 = new Thread(myr);
		t1.start();
		// object number 2
		MyThreadRunnable myr2;
		myr2 = new MyThreadRunnable(300);
		Thread t2 = new Thread(myr2);
		t2.start();
	}// end main
}// end class