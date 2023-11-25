package org.example;
public class SavingsAccount extends Account
{

	public SavingsAccount(UserInformation u)
	{
		super(u);
//		setMinBalance(50);
//		setWithdrawalLimit(100,20000);
		setBalance(1200);
	}
	SavingsAccount(String an, String pin, double balance, UserInformation u)
	{
		this(u);
		super.setAccountNo(an);
		super.setPIN(pin);
		super.setBalance(balance);
	}

	public void setMinBalance(double a)
	{
		minBalance=a;
	}
	
	void setWithdrawalLimit(double l, double h)
	{
		minWithdrawal=l;
		maxWithdrawal=h;
	}

//	double getWithdrawalUpperLimit(){
//		return maxWithdrawal;
//	}
//
//	double getWithdrawalLowerLimit(){
//		return minWithdrawal;
//	}
	int getAccountType()
	{
		return Account.SAVINGS_ACCOUNT;
	}


}
