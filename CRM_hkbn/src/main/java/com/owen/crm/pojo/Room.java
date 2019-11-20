package com.owen.crm.pojo;

import java.util.Date;

public class Room {

    private int id;
    private String roomNumber;
    private int floor;
    private int bed;
    private String status;
    private int price;
    private String type;

    enum Status {
        normal("正常"), repairing("维修");
        private String desc;

        Status(String s) {
            desc = s;
        }

        String getDesc() {
            return desc;
        }
    }

    enum BedNum {
        one(1), two(2), three(3);

        private int num;

        BedNum(int n) {
            num = n;
        }

        public int getNum() {
            return num;
        }
    }

    enum Type {
        standard("标准间"), VIP("豪华间"), president("总统套间");
        private String desc;

        Type(String s) {
            desc = s;
        }

        String getDesc() {
            return desc;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
