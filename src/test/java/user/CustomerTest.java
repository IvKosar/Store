package user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer;

    @Before
    public void initialize(){
        customer = new Customer();
    }

    @Test
    public void update() throws Exception {
        assertTrue(customer.update());
    }

}