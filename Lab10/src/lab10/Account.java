package lab10;

public class Account {
    protected double balance;
    protected String name;
    public Account(double balance, String name){
        this.balance = balance;
        this.name = name;
    }
    public void deposit(double a){
        if(a > 0){
            this.balance += a;
            System.out.println(a + " baht is deposited to " + this.name + ".");
        }else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    public  void withdraw(double amount) throws WithdrawException{
        if(amount > 0){
            if(this.balance-amount >= 0){                
                this.balance -= amount;
                System.out.println(amount + " baht is withdrawn from " + this.name +".");
            }else{
                throw new WithdrawException("Account " + this.name + " has not enough money.");
            }
        }else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public void showAccount(){
        System.out.println(this.name + " account has " + this.balance + " baht.");
    }
}
