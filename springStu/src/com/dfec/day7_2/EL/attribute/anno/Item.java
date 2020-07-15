package com.dfec.day7_2.EL.attribute.anno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("itemBean")
public class Item {
    @Value("item")
    private String name;
    @Value("12")
    private int qty;

    public String getName() {
            return name;
            }

    public void setName(String name) {
            this.name = name;
            }

    public int getQty() {
            return qty;
            }

    public void setQty(int qty) {
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