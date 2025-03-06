package creationalpatterns.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Admin implements Cloneable{
    private String id;
    protected String type;

    public abstract void doWork();

    public String getType(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }
        catch (CloneNotSupportedException e){
            System.out.println("Error: " + e.getMessage());
        }
        return clone;
    }

    public String getId() {
        return id;
    }
}


// Finance Admin
class FinanceAdmin extends Admin{
    public FinanceAdmin(){
        type = "FinanceAdmin";
    }
    @Override
    public void doWork() {
        System.out.println("Finance admin working!");
    }
}

// HR Admin
class HRAdmin extends Admin{
    public HRAdmin(){
        type = "HRAdmin";
    }

    @Override
    public void doWork() {
        System.out.println("HR admin working!");
    }
}

class ITAdmin extends Admin{
    public ITAdmin(){
        type = "ITAdmin";
    }

    @Override
    public void doWork() {
        System.out.println("IT admin working!");
    }
}

// Admin Caching
class AdminCache{
    private static HashMap<String, Admin> adminMap = new HashMap<>();

    public static Admin getAdmin(String adminId){
        Admin cachedAdmin= adminMap.get(adminId);
        return (Admin) cachedAdmin.clone();
    }

    public static void loadAdminCache(){
        FinanceAdmin finance = new FinanceAdmin();
        finance.setId("finance");
        adminMap.put(finance.getId(), finance);

        HRAdmin hr = new HRAdmin();
        hr.setId("hr");
        adminMap.put(hr.getId(), hr);

        ITAdmin itAdmin = new ITAdmin();
        itAdmin.setId("it");
        adminMap.put(itAdmin.getId(), itAdmin);
    }
}

public class AdminCachePrototypeMain {
    public static void main(String[] args) {
        AdminCache.loadAdminCache();

        Admin financeAdmin = (Admin) AdminCache.getAdmin("finance");
        financeAdmin.doWork();;

    }

}
