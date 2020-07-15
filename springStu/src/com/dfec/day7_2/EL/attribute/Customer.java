package com.dfec.day7_2.EL.attribute;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 10:15
 * @describe
 **/
public class Customer {
    private String itemName;
    private Item item;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "itemName='" + itemName + '\'' +
                ", item=" + item +
                '}';
    }
}
class Item {
    private String name;
    private String qty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}