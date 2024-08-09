package lab10;

public class CheckingAccount extends Account{
    private double credit;
    public CheckingAccount(){
        super(0, "");
        this.credit = 0;
    }
    public CheckingAccount(double balance, String name, double credit){
        super(balance, name);
        this.credit = credit;
    }
    public void setCredit(double credit){
        if(credit > 0){
            this.credit = credit;
        }else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    public double getCredit(){
        return this.credit;
    }
    public void withdraw(double amount) throws WithdrawException{
        if(amount > 0){
            if(this.balance - amount >= 0){
                this.balance -= amount;
                System.out.print(amount + " baht is withdrawn from " + this.name);
                System.out.println(" and your credit balance is " + this.credit + ".");
            }else if(this.balance + this.credit - amount >= 0){
                System.out.print(amount + " baht is withdrawn from " + this.name);
                amount -= this.balance;
                this.balance = 0;
                this.credit -= amount;
                System.out.println(" and your credit balance is " + this.credit + ".");
            }else{
                throw new WithdrawException("Account " + this.name + " has not enough money.");
            }
        }
    }
    
    public void withdraw(String a) throws WithdrawException{
        withdraw(Double.parseDouble(a));
    }
    public String toString(){
        return "The " + getName() + " account has " + getBalance() + " baht and " + getCredit() + " credits.";
    }
}
