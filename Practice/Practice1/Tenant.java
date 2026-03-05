
package javaapplication1;

public class Tenant {
    private int tenantId;
    private String tenantName;
    
    public Tenant(int tenantId, String tenantName) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
    }
    
    public int getTenantId() {
        return tenantId;
    }
    
    public String getTenantName() {
        return tenantName;
    }
}
