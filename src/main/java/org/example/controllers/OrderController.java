package org.example.controllers;


import org.example.OrderRepository;
import org.example.entities.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable int id) {
        Optional<Order> order = orderRepository.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public ResponseEntity<Void> addOrder(@RequestBody Order order) {
        orderRepository.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
