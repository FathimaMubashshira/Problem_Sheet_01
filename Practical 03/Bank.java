class BankAccount{
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	public BankAccount(int accountNumber, String accountHolder, double balance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public void setAccountNumber(int accountnumber){
		this.accountNumber=accountNumber;
	}
	
	public String getAccountHolder(){
		return accountHolder;
	}
	
	public void setAccountHolder(String accountHolder){
		this.accountHolder=accountHolder;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void setBalance(double balance){
		this.balance=balance ;
	}
	
	public double withdraw(double amount)throws Exception{
		
			if(balance>=amount){
				balance -= amount;
			}
			else{
			
			throw new Exception("Insufficient balance.");
			}
			return balance;
		}
}

class Bank{
	private BankAccount[] accountObjects;
	private int totalAccounts;
	
	public Bank(){
		accountObjects=new BankAccount[5];
		totalAccounts=0;
	}
	
	public void addAccount(BankAccount bankaccount){
		if(totalAccounts<accountObjects.length){
			accountObjects[totalAccounts++]=bankaccount;
		}
		else{
			System.out.println("Sorry!We unabble to create a new account currently.");
		}
	}
	
	public void withdrawMoney(int accountnumber,double amount){
		for(int i=0;i<totalAccounts;i++){
			if(accountObjects[i].getAccountNumber()== accountnumber){
				try{
					accountObjects[i].withdraw(amount);
					System.out.println("The withdrawal is successfull from the account "+accountnumber+".");
				}
				catch(Exception e){
					System.out.println("Cannot withdraw money from your account "+accountnumber+".");
					System.out.println(e.getMessage());
				}
				return;
			}
		}
			System.out.println("The entered account number "+accountnumber+" is wrong.Please try again.");
		
	}
	
	public void displayAccountDetails(){
		for(int i=0;i<totalAccounts;i++){
			System.out.println("The account number is "+accountObjects[i].getAccountNumber()+" and the account holder is "+accountObjects[i].getAccountHolder()+
			" The current balance in your account is "+accountObjects[i].getBalance());
		}
	}
}

class Main{
	public static void main(String[] args){
	
	Bank bAccount=new Bank();
	
	bAccount.addAccount(new BankAccount(1001,"Alice",5000.0));
	bAccount.addAccount(new BankAccount(1002,"Bob",3000.0));
	
	bAccount.withdrawMoney(1001,6000.0);
	bAccount.withdrawMoney(1002,3000.0);
	
	bAccount.displayAccountDetails();
	}
}
