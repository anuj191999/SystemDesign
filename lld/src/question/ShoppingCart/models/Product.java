package question.ShoppingCart.models;

import java.math.BigDecimal;

public class Product {

    private String id;
    private String name;
    private BigDecimal cost;
    private String desc;

    public Product(String id, String name, BigDecimal cost, String desc) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", desc='" + desc + '\'' +
                '}';
    }
}
