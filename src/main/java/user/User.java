package user;

public class User implements Observer{
    public boolean update(){
        System.out.println("User data updated!");
        return true;
    }
}
