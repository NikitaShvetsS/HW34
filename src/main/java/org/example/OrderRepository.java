package org.example;

import org.example.entities.Order;

import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private List<Order> orders;
    private int nextId = 1;

    public Optional<Order> getOrderById(int id){
        return orders.stream().filter(order -> order.getId() == id).findFirst();
    }

    public List<Order> getAllOrders(){
        return orders;
    }

    public void addOrder(Order order){
        order.setId(nextId++);
        orders.add(order);
    }

}
