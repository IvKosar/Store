package user;

import java.util.ArrayList;
import java.util.List;

public class Observable{
    private List<Observer> observers;

    public Observable(){
        observers = new ArrayList<>();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        try{
        this.getObservers().remove(observer);
        }catch (IndexOutOfBoundsException e){
            System.out.println("No such observer");
        }
    }

    public boolean notifyObservers(){
        for(Observer observer: this.getObservers()){
            observer.update();
        }
        return true;
    }
}
