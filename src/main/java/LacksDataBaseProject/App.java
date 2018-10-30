package LacksDataBaseProject;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User user = new User("Oskar", "oski83", "oski", "oski82", Role.ADMIN);
        AddAndRemoveUser.addUser(user);
        System.out.println(User.listOfUsers);
        AddAndRemoveUser.removeUser();
        System.out.println(User.listOfUsers);
    }
}
