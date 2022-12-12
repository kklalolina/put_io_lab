package put.io.testing.junit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator cal;


    @BeforeEach //Nie moze byc BeforeAll jeżeli setUp nie jest metodą statyczną i cal też musi być statyczne
    void setUp(){
        cal=new Calculator();
    }

    @Test
    void testadd(){
        assertEquals(3,cal.add(1, 2));
    }
    @Test
    void testmultiply(){
        assertEquals(6,cal.multiply(3, 2));
    }
    @Test
    void testaddpositive(){
        assertThrows(IllegalArgumentException.class,()->cal.addPositiveNumbers(-3, 2));
    }



}