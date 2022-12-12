package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    Customer cust ;
    Audiobook audio;
    AudiobookPriceCalculator audioprice;
    @BeforeEach
    void setUp(){
        audio = new Audiobook("Title",100);
        audioprice = new AudiobookPriceCalculator();
        AudiobookPriceCalculator audioprice = new AudiobookPriceCalculator();
    }
    @Test
    void testsubscriber(){
            Customer cust = new Customer("Name", Customer.LoyaltyLevel.SILVER,true);
            assertEquals(0.0,audioprice.calculate(cust, audio));
    }
    @Test
    void testSilver(){
        Customer cust = new Customer("Name", Customer.LoyaltyLevel.SILVER,false);

        assertEquals(90,audioprice.calculate(cust, audio));
    }
    @Test
    void testGold(){
        Customer cust = new Customer("Name", Customer.LoyaltyLevel.GOLD,false);

        assertEquals(80,audioprice.calculate(cust, audio));
    }
    @Test
    void testStandard(){
        Customer cust = new Customer("Name", Customer.LoyaltyLevel.STANDARD,false);

        assertEquals(100,audioprice.calculate(cust, audio));
    }

}