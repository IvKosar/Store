import game.*;
import store.GameStore;

import java.util.*;
public class TestEnum {
    public static void main(String[] args){
        String s = Genre.ACTION.toString();
        System.out.println("abc".compareTo("abd"));
        List list = new ArrayList(Arrays.asList(Genre.ACTION, Genre.SHOOTER, Genre.STRATEGY));
        System.out.println(list.contains(Genre.SIMULATOR));

        ArrayList<Genre> genres = new ArrayList<>(Arrays.asList(Genre.SHOOTER, Genre.ACTION));
        ArrayList<Platform> platforms = new ArrayList<>(Arrays.asList(Platform.WINDOWS_7, Platform.UBUNTU));
        ComputerGameParams params = new ComputerGameParams("n", genres, platforms, "d", 14);
        ComputerGame desiredGame = new ComputerGame(23.5f, params);
        System.out.println(desiredGame.getId());

        GameStore store = new GameStore();
        System.out.println(store.search(desiredGame));
        store.add(desiredGame);
        System.out.println(store.search(desiredGame));
    }
}
