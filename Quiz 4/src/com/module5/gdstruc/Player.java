package com.module5.gdstruc;

public class Player {
    private int id;
    private String userName;
    private int level;

    public Player(int id, String userName, int level) {
        this.id = id;
        this.userName = userName;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", level=" + level +
                '}';
    }
}