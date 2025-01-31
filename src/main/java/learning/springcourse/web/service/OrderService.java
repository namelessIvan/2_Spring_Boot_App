package learning.springcourse.web.service;


import learning.springcourse.web.model.RequestOrder;
import org.springframework.beans.factory.annotation.Autowired;
import learning.springcourse.web.model.Order;
import learning.springcourse.web.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
//•	Создание заказа
    public Order createOrder (RequestOrder requestOrder){
        Order order = new Order();
        order.setFoodName(requestOrder.getFoodName());
        order.setStatus(requestOrder.getStatus());
        order.setCreateAt(LocalDateTime.now());
        order.setUpdateAt(LocalDateTime.now());
        return orderRepository.save(order);
    }
//•	Обновление статуса заказа
    public Order updateOrderStatus (Long id, String status){
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Заказ с id не найден" + id));
        order.setStatus(status);
        order.setUpdateAt(LocalDateTime.now());
        return orderRepository.save(order);
    }
//•	Получение текущего состояния заказа
    public Order getOrder(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Заказ с id не найден" + id));
    }
//•	Удаление заказа
    public void deleteOrder(Long id){
        if (!orderRepository.existsById(id)) throw new RuntimeException("Заказ с id не найден" + id);
        orderRepository.deleteById(id);
    }
}
