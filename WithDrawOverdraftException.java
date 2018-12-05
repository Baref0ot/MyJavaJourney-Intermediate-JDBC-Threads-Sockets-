/************************************************************************

	Matthew Wright
	Week # 2
	06/18/2018

**************************************************************************/
public class WithDrawOverdraftException extends Exception{
	//Declarations
	public String message = "          Insufficient Funds:         ";
	
	//methods
	public String toString(){
		return message;
	}// end toString
	
	public static void main(String[] args){
	}// end main
}// end class