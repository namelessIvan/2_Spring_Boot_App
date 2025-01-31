package learning.springcourse.web.controller;

import learning.springcourse.web.model.Order;
import learning.springcourse.web.model.RequestOrder;
import learning.springcourse.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;



@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    //Метод для создания заказа
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody RequestOrder requestOrder) {
        Order createOrder = orderService.createOrder(requestOrder);
        return ResponseEntity.ok(createOrder);
    }
    // Метод для обновления статуса заказа
    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestBody String status){
        Order updateOrder = orderService.updateOrderStatus(id, status);
        return ResponseEntity.ok(updateOrder);
    }
    // Метод для получения текущего состояния заказа
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){
        Order order = orderService.getOrder(id);
        return ResponseEntity.ok(order);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
