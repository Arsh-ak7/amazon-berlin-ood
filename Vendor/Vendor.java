package Vendor;

/*  Given a list of customers, and a list of vendors, 
    A customer can ask only 1 question per week but a 
    vendor can answer atmost 5 questions per week. 
    Design an solution for this. */

class Customer {
    String customerId;
    Boolean hasAskedQuestion;
}

class Shop {
    String shopId;
    String shopName;
    Integer QuestionsAnswered;
}
