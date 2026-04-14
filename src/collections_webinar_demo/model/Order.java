package collections_webinar_demo.model;
/*
 Класс для демонстрации Map
*/

public class Order {

    private int id;
    private String product;

    public Order(int id, String product) {

        this.id = id;
        this.product = product;

    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public String toString() {

        return "Order{id=" + id + ", product='" + product + "'}";

    }

}