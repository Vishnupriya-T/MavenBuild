class MavenBuild 
{
    public String get() 
    {
        return "Hi";
    }
    public String hello() 
    {
        return "Hello";
    }
    public static void main(String[] args)
    {
        MavenBuild mv = new MavenBuild();
        System.out.println(mv.get());
    }
}
