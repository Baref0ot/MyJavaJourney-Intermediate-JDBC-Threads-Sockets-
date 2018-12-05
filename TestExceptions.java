/************************************************************************

	Matthew Wright
	Week # 2
	06/18/2018

**************************************************************************/
public class TestExceptions{
	public static void main(String[] args){
		int[] myArr = new int[10];
		int x,y,z;
			x = 1;
			y = 10;	
			z = 0;
		try{
	        z = y/x;
			myArr[9]=0;
		}// end try
			 
		catch(ArithmeticException de){
			System.out.println(" Please enter a value greater than 0 and try again.");
			System.out.println(de);
		}// end first catch
		
		catch(ArrayIndexOutOfBoundsException oe){
			System.out.println(" You tried to enter a value that was outside the bounds of the array, enter a value between 0 and 9.");
			System.out.println(oe);
		}// end second catch
		catch(Exception e){
			System.out.println(e);
			System.out.println(" Something went wrong. ");
		}// end third catch
		System.out.println(y+" divided by "+x+" = "+z);
	}// end main
}// end class