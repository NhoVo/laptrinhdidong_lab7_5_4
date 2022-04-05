package com.example.laptrinhdidong_lab7_4_5;

public class item {
    int id;
    String putname;

    public item(int id, String putname) {
        this.id = id;
        this.putname = putname;
    }

    public item() {
    }

    public item(String putname) {
        this.putname = putname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPutname() {
        return putname;
    }

    public void setPutname(String putname) {
        this.putname = putname;
    }
}
