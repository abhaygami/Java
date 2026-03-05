package javaapplication1;

import java.util.*;

public class JavaApplication1 {

    static HashMap<Integer, User> users = new HashMap<>();
    static HashMap<Integer, Tenant> tenants = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws TenantInUseException {

        int choice = -1;
        while (choice != 0) {
            System.out.println("1. Tenant Input");
            System.out.println("2. User Input");
            System.out.println("3. Display user based on Tenant name");
            System.out.println("4. Delete Tenant");
            System.out.println("0. Exit\n");
            System.out.print("Enter your choice : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    tenantInput();
                    break;

                case 2:
                    userInput();
                    break;

                case 3:
                    displayUsers();
                    break;

                case 4:
                    deleteTenant();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }

    }

    public static void userInput() {
        System.out.print("Enter UserId: ");
        int userId = scanner.nextInt();
        System.out.print("Enter TenantId: ");
        int tenantId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter UserName: ");
        String userName = scanner.nextLine();

        if (users.containsKey(userId)) {
            System.out.println("UserId Already Exist\n");
        } else if (!tenants.containsKey(tenantId)) {
            System.out.println("Tenant doesn't Exist\n");
        } else {
            users.put(userId, new User(userId, tenantId, userName));
            System.out.println("User Added!\n");
        }
    }

    public static void tenantInput() {
        System.out.print("Enter TenantId: ");
        int tenantId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter TenantName: ");
        String tenantName = scanner.nextLine();

        if (tenants.containsKey(tenantId)) {
            System.out.println("TenantId Already Exist\n");
        } else {
//            users.put(userId, new User(userId, tenantId, userName));
            tenants.put(tenantId, new Tenant(tenantId, tenantName));
            System.out.println("Tenant Added!\n");
        }
    }

    public static void displayUsers() {
        System.out.print("Enter TenantName whose users you want to display: ");
        String tenantName = scanner.nextLine();
        int tenantId = -1;
        for (Tenant tenant : tenants.values()) {
            if (tenant.getTenantName().equalsIgnoreCase(tenantName)) {
                tenantId = tenant.getTenantId();
                break;
            }
        }
        if (tenantId == -1) {
            System.out.println("Tenant Doesn't exist\n");
        } else {
            for (User user : users.values()) {
                if (user.getTenantId() == tenantId) {
                    user.displayUser();
                }
            }
        }
    }

    public static void deleteTenant() throws TenantInUseException {
        System.out.print("Enter TenantID whom you want to delete: ");
        int tenantId = scanner.nextInt();
        scanner.nextLine();
//        boolean flag = true;

        for (User user : users.values()) {
            if (user.getTenantId() == tenantId) {
//                user.displayUser();
//                flag = false;
                throw new TenantInUseException("Tenant in used by " + user.getUserName());
            }
        }
        tenants.remove(tenantId);
        System.out.println("Tenant " + tenantId + " removed!\n");
    }

}
