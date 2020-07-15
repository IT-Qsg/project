package com.dfec.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/13 14:24
 * @describe
 **/
@Service
public class OrderService {
    @Autowired
    private ProductService productService;

    public String getProductName() {
        return productService.getProductName();
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
