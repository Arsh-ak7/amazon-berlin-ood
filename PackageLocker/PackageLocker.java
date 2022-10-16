package PackageLocker;

import java.util.*;

/*
 * To monitor the process of how to put the package into a right locker. 
 * and one locker for one package. your package and locker have different size, 
 * you need to make sure the locker size > package.
 */

class Package {
    private String id;
    private String name;
    private Integer size;

    public Package(String id, String name, Integer size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public Integer getPackageSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public String getPackageId() {
        return this.id;
    }
}

class Locker {
    private String id;
    private Integer size;
    private Boolean isEmpty;
    private Package packageDetails;

    public Locker(String id, Integer size) {
        this.id = id;
        this.size = size;
        this.isEmpty = true;
        this.packageDetails = null;
    }

    public String getId() {
        return this.id;
    }

    public Integer getSize() {
        return this.size;
    }

    public Boolean checkEmpty() {
        return this.isEmpty;
    }

    public Package getPackage() {
        return this.packageDetails;
    }

    public void setPackage(Package packageDetail) {
        this.packageDetails = packageDetail;
    }

}

class Request {
    String type;
    Package val;
}

class PackageLocker {
    List<Package> packages;
    List<Locker> lockers;

    public PackageLocker() {
        this.packages = new ArrayList<>();
        this.lockers = new ArrayList<>();
    }

    public Boolean checkValidLocker(Package packageDetails, Locker currLocker) {
        Integer currLockerSize = currLocker.getSize();
        if (currLockerSize > packageDetails.getPackageSize() && currLocker.checkEmpty()) {
            currLocker.setPackage(packageDetails);
            return true;
        }
        return false;
    }

    public void handleRequest(Request request) {
        // according to qs
    }

    public void processRequests(List<Request> requests) {
        for (Request request : requests) {
            handleRequest(request);
        }
    }
}
