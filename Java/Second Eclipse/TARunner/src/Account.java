
public class Account {
	  double balance;
	    int pin;

	    public Account() {
	    }

	    ;
	    public Account(double balance, int pin) {
	        balance = this.balance;
	        pin = this.pin;

	    }

	    //return pin
	    public int getPin() {
	        return pin;
	    }

	    //void, take an int parameter, assign pin the parameter value
	    public void setPin(int tempPin) {
	        pin = tempPin;
	    }

	    //void, take a parameter, assign balance the parameter value
	    public void setBalance(double tempBal) {
	        balance = tempBal;
	    }

	    //return String, return a message for a balance statement
	    public String showBalance() {
	        String message = ("The current balance is\n$" + balance);
	        return message;

	    }

	    //void, take a parameter for the deposit value, updates the balance
	    public void deposit(double toDeposit) {
	        balance += toDeposit;
	    }

	    //return String, take a parameter for the ammount of withdrawal, update balance,
	    //returns a message of Figure 13 or 15 depending on the balance value relative
	    //to the requestd withdraw
	    public String withdraw(double wAmount) {
	        String withdrawMessage = "";

	        if (wAmount <= balance) {
	            balance -= wAmount;
	            withdrawMessage += "You withdrew "
	                    + wAmount + " dollars";

	        } else if (wAmount > balance) {
	            balance = 0.00;
	            withdrawMessage += "Required amount $"
	                    + wAmount + " exceeds balance\nYou receive: $"
	                    + wAmount;
	        }
	        return withdrawMessage;
	    }

}
