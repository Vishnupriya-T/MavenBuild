import static org.junit.jupiter.api.Assertions.*;

class MavenBuildTest 
{
    @org.junit.jupiter.api.Test
    void getTest() 
    {
        MavenBuild mb = new MavenBuild();
        assertEquals(mb.get(),"Hi");
    }

    @org.junit.jupiter.api.Test
    void helloTest() 
    {
        MavenBuild mb = new MavenBuild();
        assertEquals(mb.hello(),"Hello");
    }
}
