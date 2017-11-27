package user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void initialize(){
        user = new User();
    }

    @Test
    public void testUpdate(){
        assertTrue(user.update());
    }

}