
package javaapplication1;

public class User {
    private int userId;
    private int tenantId;
    private String userName;
    
    public User(int userId, int tenantId, String userName) {
        this.tenantId = tenantId;
        this.userId = userId;
        this.userName = userName;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public int getTenantId() {
        return tenantId;
    }
    
    public void displayUser() {
        System.out.println("UserId : " + userId);
        System.out.println("TenantId : " + tenantId);
        System.out.println("UserName : " + userName + "\n");
    }
}
