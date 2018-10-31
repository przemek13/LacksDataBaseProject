package LacksDataBaseProject;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User user = new User();
        AddAndRemoveUser.addUser(user);
        System.out.println(User.listOfUsers);
        AddAndRemoveUser.removeUser();
        System.out.println(User.listOfUsers);

        Supplier supplier = new Supplier();
        AddAndRemoveSupplier.addSupplier(supplier);
        System.out.println(Supplier.listOfSuppliers);
        AddAndRemoveSupplier.removeSupplier();
        System.out.println(Supplier.listOfSuppliers);
    }

}
