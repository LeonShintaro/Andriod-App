package com.zhaowei.shi.assignment.Bean;

public class food {
    private String name;
    private int ene;

    public food(String name, int ene){
        this.name=name;
        this.ene =ene;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEne() {
        return ene;
    }

    public void setEne(int ene) {
        this.ene = ene;
    }
}
