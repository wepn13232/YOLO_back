package com.sprinboot.dazuoye.pojo;

public class Essay {
    private Integer id;
    private String title;
    private String username;
    private String name;
    private String url;
    private String date;
    private String essayType;
    private String content;
    private String OTitle; //附言

    public Essay() {
        super();
    }

    public Essay(Integer id, String title, String username, String name, String url, String date, String essayType, String content, String OTitle) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.name = name;
        this.url = url;
        this.date = date;
        this.essayType = essayType;
        this.content = content;
        this.OTitle = OTitle;
    }

    public String getOTitle() {
        return OTitle;
    }

    public void setOTitle(String OTitle) {
        this.OTitle = OTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEssayType() {
        return essayType;
    }

    public void setEssayType(String essayType) {
        this.essayType = essayType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
