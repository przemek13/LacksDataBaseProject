package LacksDataBaseProject;

public class App
{
    public static void main( String[] args )
    {
        User testUser = new User();
        Lack testLack = new Lack();
        testUser.createMissingLackData(testLack, testUser);
        System.out.println(testLack);
        testUser.setLackID(testLack, testUser);
        System.out.println(testLack);
    }
}
