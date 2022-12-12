package put.io.testing.junit;
import jdk.jfr.StackTrace;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FailureOrErrorTest {
    @Test //Failure
    void test1(){ //Tu będzie error
        assertEquals(true,1==0);
    }
    @Test //Error
    void test2(){ //Tu będzie failure
        assertThrows(NumberFormatException.class,()-> {});
    }
    @Test
    void test3(){
        try{
            assertEquals(false,true);
        }catch(Throwable e){
            e.printStackTrace();
            System.out.println(e.getClass());
        } //4.2 class org.opentest4j.AssertionFailedError

    }

}
