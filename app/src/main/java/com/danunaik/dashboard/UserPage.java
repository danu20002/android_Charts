package com.danunaik.dashboard;

public class UserPage {
    private String page;
    private int users;

    public UserPage(String page, int users) {
        this.page = page;
        this.users = users;
    }

    public String getPage() {
        return page;
    }

    public int getUsers() {
        return users;
    }
}
