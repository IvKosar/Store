package user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellerTest {
    private Seller seller;

    @Before
    public void initialize(){
        seller = new Seller();
    }

    @Test
    public void update() throws Exception {
        assertTrue(seller.update());
    }

}