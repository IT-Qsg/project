package com.dfec.day7_2.EL.attribute.anno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 10:15
 * @describe
 **/
@Component("customerBean")
public class Customer {
    @Value("#{itemBean}")
    private Item item;
    @Value("#{itemBean.name}")
    private String itemName;

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

