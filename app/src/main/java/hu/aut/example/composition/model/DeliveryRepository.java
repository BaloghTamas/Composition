package hu.aut.example.composition.model;


import java.util.ArrayList;
import java.util.List;

public class DeliveryRepository {


    private final Delivery delivery2;
    private final Delivery delivery1;
    private final Delivery delivery3;

    public DeliveryRepository() {
        delivery1 = new Delivery(1L, "Small box", "Box of stuff", "Transfer", "", "Me", "Bob", false, "Today", 0);
        delivery2 = new Delivery(2L, "Medium box", "Box of tools", "Pickup", "", "Alice", "Me", true, "Tomorrow", 120);
        delivery3 = new Delivery(3L, "Large box", "Box of gadgets", "Shipped", "", "Me", "Alice", false, "06/01/17", 10);
    }

    public List<Delivery> getAllDelivery() {
        List<Delivery> deliveryList = new ArrayList<>();
        deliveryList.add(delivery1);
        deliveryList.add(delivery2);
        deliveryList.add(delivery3);
        return deliveryList;
    }


    public List<Delivery> getSendDelivery() {
        List<Delivery> deliveryList = new ArrayList<>();
        deliveryList.add(delivery1);
        deliveryList.add(delivery3);
        return deliveryList;
    }


    public List<Delivery> getReceiveDelivery() {
        List<Delivery> deliveryList = new ArrayList<>();
        deliveryList.add(delivery2);
        return deliveryList;
    }
}
