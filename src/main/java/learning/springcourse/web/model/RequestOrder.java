package learning.springcourse.web.model;



public class RequestOrder {

    private String foodName;

    public RequestOrder(String foodName) {

    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
