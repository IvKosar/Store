package game;

import java.util.ArrayList;

public class ComputerGame {
    private float price;
    private static int idCounter = 0;
    private int id;
    private ComputerGameParams params;

    public ComputerGame(float price, ComputerGameParams gameParams) {
        this.params = gameParams;
        this.price = price;
        this.id = idCounter;
        idCounter += 1;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setParams(ComputerGameParams newParams){this.params = newParams;}

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public ComputerGameParams getParams(){return params;}

    @Override
    public String toString(){
        return String.format("Game '%s'", this.params.getName());
    }
}
