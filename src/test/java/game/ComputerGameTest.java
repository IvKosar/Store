package game;

import game.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ComputerGameTest {
    private float gta5Price;
    private float gta6Price;
    private ComputerGameParams gta5Params;
    private ComputerGameParams gta6Params;
    private ComputerGame gta5;
    private ComputerGame gta6;

    @Before
    public void initializationOfGame1(){
        gta5Price = 23.5f;
        String name = "GTA5";
        ArrayList<Genre> genres = new ArrayList<>(Arrays.asList(Genre.ACTION, Genre.SHOOTER, Genre.STRATEGY));
        ArrayList<Platform> platforms = new ArrayList<>(Arrays.asList(Platform.WINDOWS_7, Platform.WINDOWS_10));
        String description = "Some desc";
        int agePrest = 16;
        gta5Params = new ComputerGameParams(name, genres, platforms, description, agePrest);
        gta5 = new ComputerGame(gta5Price, gta5Params);
    }

    @Before
    public void initializationOfGame2(){
        gta6Price = 34.5f;
        String name = "GTA6";
        ArrayList<Genre> genres = new ArrayList<>(Arrays.asList(Genre.ACTION, Genre.SHOOTER, Genre.RACING));
        ArrayList<Platform> platforms = new ArrayList<>(Arrays.asList(Platform.WINDOWS_7, Platform.WINDOWS_8));
        String description = "Some OTHER desc";
        int agePrest = 18;
        gta6Params = new ComputerGameParams(name, genres, platforms, description, agePrest);
        gta6 = new ComputerGame(gta6Price, gta6Params);
    }

    @Test
    public void testGetPrice(){assertEquals(gta5Price, gta5.getPrice(), 4.5d);}

    @Test
    public void testGetParams(){assertEquals(gta5Params, gta5.getParams());}

    @Test
    public void testSetPrice(){
        gta5Price = 10.5f;
        gta5.setPrice(gta5Price);
        assertEquals(gta5Price, gta5.getPrice(), 4.5d);
    }

    @Test
    public void testSetParams(){
        String name = "GTA5.1";
        ArrayList<Genre> genres = new ArrayList<>(Arrays.asList(Genre.ACTION, Genre.SHOOTER));
        ArrayList<Platform> platforms = new ArrayList<>(Arrays.asList(Platform.WINDOWS_10));
        String description = "Some other desc";
        int agePrest = 14;
        gta5Params = new ComputerGameParams(name, genres, platforms, description, agePrest);
        gta5.setParams(gta5Params);
        assertEquals(gta5Params, gta5.getParams());
    }

    @Test
    public void testToString(){
        String gta5String = "Game 'GTA5'";
        assertEquals(gta5String, gta5.toString());
    }
}
