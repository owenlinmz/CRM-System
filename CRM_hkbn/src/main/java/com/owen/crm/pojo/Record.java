package com.owen.crm.pojo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Integer id;
    private Integer customerId;
    private Integer roomId;
    private Date inTime;
    private Date outTime;
    private String breakfast;
    private Integer recordId;
    private String roomNumber;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }


    public Date getInTime() {
        return inTime;
    }

    public void setInTime(String timeString) {
        try {
            this.inTime = dateFormat.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
            this.inTime = null;
        }
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(String timeString) {
        try {
            this.outTime = dateFormat.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
            this.outTime = null;
        }
    }

}
