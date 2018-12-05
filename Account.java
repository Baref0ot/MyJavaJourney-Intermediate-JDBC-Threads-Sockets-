/************************************************************************

	Matthew Wright
	Week # 2
	06/18/2018

**************************************************************************/
public class Account{
	// Declarations
	private int acctNo;
	private String owner;
	private double balance; 
	private double deposited;
	private double withdrawed;
	
	// Constructors
	public Account(){
		setAcctNo(0);
		setOwner("");
		setBalance(0.0);
	}// end Empty Constructor
	public Account(int an, String o, double b){
		setAcctNo(an);
		setOwner(o);
		setBalance(b);
	}// end Full Constructor
	
	// Methods
		public void setAcctNo(int an){
			acctNo = an;
		}//end setAcctNo
		public int getAcctNo(){
			return acctNo;
		}// end getAcctNo
		
		public void setOwner(String o){
			owner = o;
		}// end setOwner
		public String getOwner(){
			return owner;
		}// end getOwner
		
		public void setBalance(double b){
			balance = b;
		}// end setBalance
		public double getBalance(){
			return balance;
		}// end getBalance
		
	    public void setDeposite( double d){
			 double deposit = d;
			deposited = deposit;
		}// end Amount
		public void Deposit(){
			 double newBalance = balance + deposited;
			 balance = newBalance;
		}// end Deposit
		
		public void setWithdraw(double w){
			double withdraw = w;
			withdrawed = withdraw;
		}// end setWithdraw
		public void Withdraw() throws WithDrawOverdraftException{
			if(withdrawed > balance){
				throw new WithDrawOverdraftException();
			}// end if
			else{
			 double newBalance = balance - withdrawed;
			 balance = newBalance;
			}// end else
		}// end Withdraw
		
		public void Display(){
			System.out.println(" Account Number: "+getAcctNo());
			System.out.println(" Owner: " +getOwner());
			System.out.println(" Deposit: " +deposited);
			System.out.println(" Withdraw: " +withdrawed);
			System.out.println(" Balance: " +getBalance()); 
		}// end Display.
		
	public static void main(String[] args) throws WithDrawOverdraftException{
		// create Account Object
		Account a1 = new Account();
		a1.setAcctNo(34095);
		a1.setOwner("Matthew");
		a1.setBalance(400.00);
		a1.setDeposite(100.00);
		a1.Deposit();
		a1.setWithdraw(1600.00);
		try{
			a1.Withdraw();
		}// end try
		catch(WithDrawOverdraftException e){
			System.out.println(e);
			System.out.println(" ** NO FUNDS WERE WITHDRAWN FROM YOUR ACCOUNT **");
			System.out.println(" You attempted to withdraw more from account than was available in your account Balance.");
		}// end catch
		a1.Display();
	}// end main
}// end class