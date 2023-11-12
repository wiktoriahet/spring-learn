package pl.hetman.wiktoria.spring.learn.app.shop;

public class ShopModel {

    private String item;
    private Integer price;

    public ShopModel(String item, Integer price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShopModel{" +
                "item='" + item + '\'' +
                ", price=" + price +
                '}';
    }
}
