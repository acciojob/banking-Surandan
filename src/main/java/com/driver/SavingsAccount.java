package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate = rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        try{
            if(amount > maxWithdrawalLimit) throw new WithDrawLimit("Maximum Withdraw Limit Exceed");
            if(amount > this.getBalance()) throw new InsufficientBalance("Insufficient Balance");
        }
        catch (WithDrawLimit e){
            System.out.println(e.getMessage());
        }
        catch (InsufficientBalance e) {
            System.out.println(e.getMessage());
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
         return years*rate*this.getBalance();
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
         return this.getBalance()*Math.pow(1 + (rate/times),times*years);
    }

}
