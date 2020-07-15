package com.dfec.day7_2.scan;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/2 11:45
 * @describe
 **/
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public String toString() {
        return "CustomerService{" +
                "customerDao=" + customerDao +
                '}';
    }
}
