package learning.springcourse.web.controller;

import learning.springcourse.web.model.Order;
import learning.springcourse.web.model.RequestOrder;
import learning.springcourse.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    //Метод для создания заказа
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody RequestOrder requestOrder) {
        Order order = new Order();
        order.setFoodName(requestOrder.getFoodName());
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
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


//    @GetMapping("/hello")
//    public void test(@RequestParam String data){
//        System.out.println(data);
//    }

}
