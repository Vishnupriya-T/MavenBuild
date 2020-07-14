import static org.junit.jupiter.api.Assertions.*;

class AnotherTryTest 
{
    @org.junit.jupiter.api.Test
    void getOneTest() 
    {
        AnotherTry mb = new AnotherTry();
        assertEquals(mb.getOne(),1);  
    }

    @org.junit.jupiter.api.Test
    void getTwoTest() 
    {
        AnotherTry mb = new AnotherTry();
        int expectedValue = mb.getTwo();
        assertEquals(expectedValue,2);
    }
}
