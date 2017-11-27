package user;

public class Seller extends User{
    @Override
    public boolean update() {
        System.out.println("Seller updated!");
        return true;
    }
}
