package Delivery;

import java.util.ArrayList;
import java.util.List;

/* 
You have to design Customer, Product. 
Customer contains Address...etc. It requires to be scalable such that zipcodes are not fixed/given
(you do not have like a list of zipcodes which is all products' shipping range), 
you have to write a function to check if customer's zipcode is vaild and within product shipping range. 
So if we want to update product's shipping range, we do not need to edit anything.
Basically it is like a Delivery app design.
*/

class Customer {
    private String Id;
    private String Address;
    private String Pincode;

    public Customer(String Id, String Address, String Pincode) {
        this.Id = Id;
        this.Address = Address;
        this.Pincode = Pincode;
    }

    public String getCustomerId(){
        return Id;
    }

    public String getCustomerAddress(){
        return Address;
    }

    public String getCustomerPincode(){
        return Pincode;
    }
}

class Product {
    private String Id;
    private List<String> pinCodes;

    public Product(String Id){
        this.Id = Id;
        this.pinCodes = new ArrayList<>();
    }    

    public String getProductId(){
        return Id;
    }

    public List<String> getProductDeliveryCodes(){
        return pinCodes;
    }

    public void addCodes(String code){
        pinCodes.add(code);
    }
}

class Order {
    String CustomerId;
    String ProductId;
}

public class Delivery {
    List<Customer> customers;
    List<Product> products;

    public Delivery(){ 
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void addDeliveryCode(String productId, String code){
        Product product = getProduct(productId);
        product.addCodes(code);
    }

    private Customer getCustomer(String id) {
        for(Customer customer : customers) {
            if(customer.getCustomerId() == id)
                return customer;
        }

        return null;
    }

    private Product getProduct(String id){
        for(Product product : products){
            if(product.getProductId() == id)
                return product;
        }

        return null;
    }

    Boolean checkOrderProcessable(Customer customer, Product product){
        String customerCode = customer.getCustomerPincode();
        for(String productCodes : product.getProductDeliveryCodes()){
            if(productCodes == customerCode)
                return  true;
        }

        return false;
    }

    public void processRequests(List<Order> orders) {
        for(Order order : orders){
            Customer customer = getCustomer(order.CustomerId);
            Product product = getProduct(order.ProductId);
            if(checkOrderProcessable(customer, product)){
                // YES
            } else {
                // NO
            }
        }
    }
}
