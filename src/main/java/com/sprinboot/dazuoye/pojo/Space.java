package com.sprinboot.dazuoye.pojo;

public class Space {
    private Integer id;
    private String username;
    private String name;
    private String content;
    private String date;

    public Space() {
        super();
    }

    public Space(Integer id, String username, String name, String content, String date) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.content = content;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
