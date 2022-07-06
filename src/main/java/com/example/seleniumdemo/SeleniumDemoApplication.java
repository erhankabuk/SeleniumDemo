package com.example.seleniumdemo;

import com.example.seleniumdemo.Service.ServiceApplication;
import com.example.seleniumdemo.Utility.BusinessIntegrityException;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SeleniumDemoApplication {

    public static void main(String[] args) throws BusinessIntegrityException {

        try {
            ApplicationContext applicationContext = SpringApplication.run(SeleniumDemoApplication.class, args);
            ServiceApplication service = applicationContext.getBean(ServiceApplication.class);

            service.getDataFromBrowser();
            System.out.println(  service.checkDatabaseForUpdate().getUpdateTime());
            System.exit(0);
        } catch (BeansException e) {
            throw new BusinessIntegrityException(e.getMessage());
        }
    }

}
