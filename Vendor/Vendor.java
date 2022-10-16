package Vendor;

import java.util.Queue;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/*  Given a list of customers, and a list of vendors, 
    A customer can ask only 1 question per week but a 
    vendor can answer atmost 5 questions per week. 
    Design an solution for this. */

/* 
 * Assumption: 1 week refers to 7 consecutive days
 */

class Customer {
    private String customerId;
    private Date questionDate;

    public Customer(String id) {
        this.customerId = id;
        this.questionDate = null;
    }

    public String getId() {
        return customerId;
    }

    private Long getNumberOfDays(Date d1, Date d2) {
        Long time_ms = d1.getTime() - d2.getTime();

        return (time_ms) / (1000 * 3600 * 24);
    }

    public Date getLastQuestionDate() {
        return questionDate;
    }

    public Boolean setQuestionDate() {
        Date currDate = new Date();
        Long numberOfDays =  getNumberOfDays(currDate, getLastQuestionDate());

        if(numberOfDays < 7) {
            return false;
        } else {
            questionDate = currDate;
            return true;
        }
    }
}

class Shop {
    private String shopId;
    private Queue<Date> questionQueue;

    public Shop(String id){
        this.shopId = id;
        this.questionQueue = new LinkedList<Date>();
    }

    public String getId() {
        return shopId;
    }

    private Long getNumberOfDays(Date d1, Date d2) {
        Long time_ms = d1.getTime() - d2.getTime();

        return (time_ms) / (1000 * 3600 * 24);
    }

    public Boolean answerAQuery() {
        Date currDate = new Date();
        while(!questionQueue.isEmpty()  && getNumberOfDays(currDate, questionQueue.peek()) > 7){
            questionQueue.poll();
        }

        if(questionQueue.size() == 5) {
            /* handle error capacity full */
            return false;
        } else {
            questionQueue.add(currDate);
            return true;
        }
    }
}

class Request {
    String id;
    String customerId;
    String ShopId;
}

public class Vendor {
    List<Customer> customerList;
    List<Shop> shopList;

    public Vendor() {
        this.customerList = new ArrayList<>();
        this.shopList = new ArrayList<>();
    }

    public void initialiseCustomerList(Integer count) {
        for(int i = 1 ;i<=count;i+=1){
            customerList.add(new Customer(Integer.toString(i)));
        }
    }

    public void initialiseShopList(Integer count) {
        for(int i=1;i<=count;i+=1){
            shopList.add(new Shop(Integer.toString(i)));
        }
    }

    private Customer findCustomer(String id) {
        for(Customer customer : customerList) {
            if(customer.getId().equals(id)) {
                return customer;
            }
        }

        return null;
    }

    private Shop findShop(String id) {
        for(Shop shop : shopList) {
            if(shop.getId().equals(id)) {
                return shop;
            }
        }

        return null;
    }

    public void handleRequest(Request request) {
        Customer customer = findCustomer(request.customerId);
        Shop shop = findShop(request.ShopId);

        if(shop.answerAQuery()) {
            if(customer.setQuestionDate()) {
                // handle request processed successfully
            } else {
                // Handle customer limit reached
            }
        } else {
            // handle shop request limit exceeded
        }

    }

    public void processRequests(List<Request> requests) {
        for(Request request : requests) {
            handleRequest(request);
        }
    }
}
