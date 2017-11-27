package user;

public class Customer extends User{
    @Override
    public boolean update(){
        System.out.println("Customer updated!");
        return true;
    }
}
