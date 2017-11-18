package cart.delivery;

import game.ComputerGame;

import java.util.List;

public class DeliveryNovaPoshta implements DeliveryStrategy {
    public boolean deliver(List<ComputerGame> games){
        if (games.isEmpty()){
            throw new EmptyDelivery();
        }
        else{
            System.out.println("Package is successfully delivered by NOVA POSHTA!");
            return true;
        }
    }
}
