package com.codility.tasks.spring.healthcheck;

public class Status {
    private String currentTime;
    private String application;

    Status(String currentTime, String application) {
        this.currentTime = currentTime;
        this.application = application;
    }


    public String getCurrentTime() {
        return currentTime;
    }

    public String getApplication() {
        return application;
    }

}
