package ShoppingCart;

import java.util.*;

class Item {
    private String id;
    private String name;
    private Integer quantity;

    public Item(String id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return this.id;
    }

    public String getItemName() {
        return this.name;
    }

    public Integer getItemQuantity() {
        return this.quantity;
    }

    public void setItemQuantity(Integer count) {
        this.quantity = count;
    }
}

class Cart {
    private String id;
    private List<Item> items;

    public Cart(String id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    public List<Item> getCartItems() {
        return this.items;
    }

    public Item getParticularItemDetails(String id) {
        for (Item item : items) {
            if (item.getId().equals(id))
                return item;
        }

        return null;
    }

    public void editCartDetails(String productId, Integer newQuantity) {
        Item currProduct = this.getParticularItemDetails(productId);
        currProduct.setItemQuantity(newQuantity);
    }

    public void addItemsToCart(List<Item> items) {
        for (Item item : items) {
            this.items.add(item);
        }
    }
}

class Request {
    String reqType;
    String reqDetails;
}

public class ShoppingCart {
    private List<Item> items;
    private Cart cart;

    public Cart getCart() {
        return this.cart;
    }

    public void handleRequest(Request request) {
        Cart cart = getCart();
        if (request.reqType.equals("ADD")) {
            cart.addItemsToCart(items);
        } else if (request.reqType.equals("Edit")) {
            cart.editCartDetails("ID", 10);
        }
    }

    public void processRequests(List<Request> requests) {
        for (Request request : requests) {
            handleRequest(request);
        }
    }
}
