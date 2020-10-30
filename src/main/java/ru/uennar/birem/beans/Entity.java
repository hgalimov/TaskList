package ru.uennar.birem.beans;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    private List<Integer> nums;
    private int num;
    private String user;

    public void setNums(ArrayList<Integer> nums) {
        this.nums = nums;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    private String user1;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Integer> getNums() {
        return nums;
    }
}
