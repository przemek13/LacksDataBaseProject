package LacksDataBaseProject;

public class App {
    public static void main(String[] args) {

/*        User adminTestUser = new User(Role.ADMIN, new AddAndRemoveSupplier(), new AddAndRemoveUser());
        User forwarderTestUser = new User(Role.FORWARDER, new AddAndRemoveLack());
        User purchaserTestUser = new User(Role.PURCHASER, new SetLack());
        User purchaserTestUser2 = new User("Test Purchaser 2", "b", Role.PURCHASER);
        User purchaserTestUser3 = new User("Test Purchaser 3", "c", Role.PURCHASER);

        adminTestUser.addAndRemoveUser.addUser(adminTestUser, purchaserTestUser2);
        adminTestUser.listOfUsers.add(adminTestUser);
        adminTestUser.listOfUsers.add(purchaserTestUser2);
        adminTestUser.listOfUsers.add(forwarderTestUser);
        adminTestUser.listOfUsers.add(purchaserTestUser3);
        adminTestUser.listOfUsers.add(purchaserTestUser2);
        purchaserTestUser.listOfUsers.add(purchaserTestUser2);
        System.out.println(adminTestUser.listOfUsers);

        adminTestUser.addAndRemoveUser.removeUser(adminTestUser, purchaserTestUser2);
        System.out.println(adminTestUser.listOfUsers);
        System.out.println();

        Lack testLack = new Lack();
        Lack testLack2 = new Lack();
        forwarderTestUser.createMissingLackData(testLack, forwarderTestUser);
        forwarderTestUser.createMissingLackData(testLack2, forwarderTestUser);
        for (Lack lack : forwarderTestUser.getLacksList()) {
            System.out.println(lack);
        }

        forwarderTestUser.addAndRemoveLack.removeLack(testLack, forwarderTestUser);
        for (Lack lack : forwarderTestUser.getLacksList()) {
            System.out.println(lack);
        }

        forwarderTestUser.addAndRemoveLack.changeStatus(testLack2, forwarderTestUser);
        for (Lack lack : forwarderTestUser.getLacksList()) {
            System.out.println(lack);
        }

        Supplier testSupplier = new Supplier();
        Supplier testSupplier2 = new Supplier();

        adminTestUser.addAndRemoveSupplier.addSupplier(testSupplier, adminTestUser);
        System.out.println(testSupplier.listOfSuppliers);
        adminTestUser.addAndRemoveSupplier.addSupplier(testSupplier2, adminTestUser);
        System.out.println(testSupplier2.listOfSuppliers);
        adminTestUser.addAndRemoveSupplier.removeSupplier(testSupplier2, adminTestUser);
        System.out.println(testSupplier2.listOfSuppliers);

        forwarderTestUser.addAndRemoveLack.addlack(testLack, forwarderTestUser, testSupplier);
        System.out.println(forwarderTestUser.lacksList);

        purchaserTestUser.setLack.setOrderedAmount(testLack, purchaserTestUser);
        purchaserTestUser.setLack.setDate(testLack, purchaserTestUser);
        purchaserTestUser.setLack.setComment(testLack, purchaserTestUser);
        purchaserTestUser.setLack.changePurchaser(testLack, purchaserTestUser);
        System.out.println(forwarderTestUser.lacksList);*/
    }
}
