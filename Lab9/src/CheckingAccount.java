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
    public void withdraw(double a){
        if(a > 0){
            if(this.balance - a >= 0){
                this.balance -= a;
                System.out.print(a + " baht is withdrawn from " + this.name);
                System.out.println(" and your credit balance is " + this.credit + ".");
            }else if(this.balance + this.credit - a >= 0){
                a -= this.balance;
                this.balance = 0;
                this.credit -= a;
                System.out.print(a + " baht is withdrawn from " + this.name);
                System.out.println(" and your credit balance is " + this.credit + ".");
            }else{
                System.out.println("Not enough money!");
            }
        }
    }
    public void withdraw(String a){
        withdraw((double)Double.parseDouble(a));
    }
    public String toString(){
        return "The " + getName() + " account has " + getBalance() + " baht and " + getCredit() + " credits.";
    }
}
