package com.codility.tasks.spring.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class SingleStatus {


    private String status;

    SingleStatus(String status) {
        this.status = status;
    }

    @Required
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}