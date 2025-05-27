package com.FoodWasteManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class FoodWasteManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodWasteManagementSystemApplication.class, args);
    }

}
