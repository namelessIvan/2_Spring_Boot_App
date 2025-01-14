package learning.springcourse.web.Controller;

import learning.springcourse.web.Model.Order;
import learning.springcourse.web.Service.OrderService;
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
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
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
