package cart.payment;

import org.junit.Test;

import static org.junit.Assert.*;

public class CashStrategyTest {
    private static PaymentStrategy cashStrategy = new CashStrategy();
    @Test
    public void testValidPay() throws Exception {
        double sum = 45.23;
        assertTrue(cashStrategy.pay(sum));
    }

    @Test(expected = InvalidPaymentSum.class)
    public void testInvalidPay(){
        double sum = -1.5;
        cashStrategy.pay(sum);
    }
}