package game;

import game.ComputerGameParams;
import game.Genre;
import game.Platform;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ComputerGameParamsTest {
    private String name;
    private ArrayList<Genre> genres;
    private ArrayList<Platform> platforms;
    private String description;
    private int agePrest;
    private ComputerGameParams gtaParams;

    @Before
    public void initializationOfObject(){
        name = "GTA5";
        genres = new ArrayList<>(Arrays.asList(Genre.ACTION, Genre.SHOOTER, Genre.STRATEGY));
        platforms = new ArrayList<>(Arrays.asList(Platform.WINDOWS_7, Platform.WINDOWS_10));
        description = "Some desc";
        agePrest = 16;
        gtaParams = new ComputerGameParams(name, genres, platforms, description, agePrest);
    }
    @Test
    public void testGetName(){ assertEquals(name, gtaParams.getName()); }

    @Test
    public void testGetGenres(){ assertEquals(genres, gtaParams.getGenres()); }

    @Test
    public void testGetPlatforms(){ assertEquals(platforms, gtaParams.getPlatforms()); }

    @Test
    public void testGetDesc(){ assertEquals(description, gtaParams.getDescription()); }

    @Test
    public void testGetAgePrest(){ assertEquals(agePrest, gtaParams.getAgePrestriction()); }

    @Test
    public void testSetName(){
        name = "GTA6";
        gtaParams.setName(name);
        assertEquals(name, gtaParams.getName());
    }

    @Test
    public void testAddGenre(){
        genres.add(Genre.RACING);
        gtaParams.addGenre(Genre.RACING);
        assertEquals(genres, gtaParams.getGenres());
    }

    @Test
    public void testAddPlatform(){
        platforms.add(Platform.UBUNTU);
        gtaParams.addPlatform(Platform.UBUNTU);
        assertEquals(platforms, gtaParams.getPlatforms());
    }

    @Test
    public void testSetDesc(){
        description = "some other desc";
        gtaParams.setDescription(description);
        assertEquals(description, gtaParams.getDescription());
    }

    @Test
    public void testSetAgePrest(){
        agePrest = 18;
        gtaParams.setAgePrestriction(agePrest);
        assertEquals(agePrest, gtaParams.getAgePrestriction());
    }
}
