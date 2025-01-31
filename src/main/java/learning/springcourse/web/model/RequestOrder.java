package learning.springcourse.web.model;



public class RequestOrder {

    private String foodName; // Поле для названия еды
    private String status;    // Поле для статуса заказа

    // Конструктор по умолчанию
    public RequestOrder() {}

    // Геттеры и сеттеры
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
