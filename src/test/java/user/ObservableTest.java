package user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ObservableTest {
    private Observable observable;

    @Before
    public void initialize(){
        observable = new Observable();
    }

    @Test
    public void getObserversTest() throws Exception {
        assertEquals(new ArrayList<>(), observable.getObservers());
    }

    @Test
    public void addObserverTest() throws Exception {
        User user = new User();
        List<Observer> observerList = new ArrayList<Observer>(Arrays.asList(user));
        observable.addObserver(user);
        assertEquals(observerList, observable.getObservers());
    }

    @Test
    public void removeObserverTest() throws Exception {
        User user = new User();
        List<Observer> observerList = new ArrayList<Observer>(Arrays.asList(user));
        observable.addObserver(user);
        observable.removeObserver(user);
        assertEquals(new ArrayList<Observer>(), observable.getObservers());
    }

    @Test
    public void notifyObserversTest() throws Exception {
        User user1 = new User();
        User user2 = new User();
        observable.addObserver(user1);
        observable.addObserver(user2);
        assertTrue(observable.notifyObservers());
    }

}