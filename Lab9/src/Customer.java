import java.util.ArrayList;

public class Customer {
    //Excercise 2
//    private String firstName;
//    private String lastName;
//    private Account []acct;
//    private int numOfAccount;
//
//    public Customer(){
//        this("", "");
//    }
//    public Customer(String firstName, String lastName){
//        acct = new Account[5];
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public void setFirstName(String firstName){
//        this.firstName = firstName;
//    }
//    public String getFirstName(){
//        return firstName;
//    }
//    public void setLastName(String lastName){
//        this.lastName = lastName;
//    }
//    public String getLastName(){
//        return this.lastName;
//    }
//
//    public String toString(){
//        if(this.acct == null){
//            return getFirstName()+ " " + getLastName() + " doesn’t have account.";
//        }else{
//            return this.firstName + " " + this.lastName + " has " + this.numOfAccount + " accounts";
//        }
//    }
//    public boolean equals(Customer c){
//        if((this.firstName).equals(c.firstName) && (this.lastName).equals(c.lastName)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    public Account getAccount(int index){
//        return this.acct[index];
//    }
//    public void addAccount(Account acct){
//        this.acct[numOfAccount] = acct;
//        numOfAccount++;
//    }
//    public int getNumOfAccount(){
//        return this.numOfAccount;
//    }

    //Excercise 3
    private String firstName;
    private String lastName;
    private ArrayList acct;
    private int numOfAccount;

    public Customer(){
        this("", "");
    }
    public Customer(String firstName, String lastName){
        acct = new ArrayList();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public String toString(){
        if(this.acct == null){
            return getFirstName()+ " " + getLastName() + " doesn’t have account.";
        }else{
            return this.firstName + " " + this.lastName + " has " + this.numOfAccount + " accounts";
        }
    }
    public boolean equals(Customer c){
        if((this.firstName).equals(c.firstName) && (this.lastName).equals(c.lastName)){
            return true;
        }else{
            return false;
        }
    }
    public Account getAccount(int index){
        return (Account) this.acct.get(index);
    }
    public void addAccount(Account acct){
        this.acct.add(acct);
        numOfAccount++;
    }
    public int getNumOfAccount(){
        return this.acct.size();
    }
}
