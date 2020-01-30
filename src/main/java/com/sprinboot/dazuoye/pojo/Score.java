package com.sprinboot.dazuoye.pojo;

public class Score {
    private Integer id;
    private String username;
    private String score;
    private String setedUser;
    private Integer essayID;

    public Score() {
        super();
    }

    public Score(Integer id, String username, String score, String setedUser, Integer essayID) {
        this.id = id;
        this.username = username;
        this.score = score;
        this.setedUser = setedUser;
        this.essayID = essayID;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSetedUser() {
        return setedUser;
    }

    public void setSetedUser(String setedUser) {
        this.setedUser = setedUser;
    }

    public Integer getEssayID() {
        return essayID;
    }

    public void setEssayID(Integer essayID) {
        this.essayID = essayID;
    }
}
