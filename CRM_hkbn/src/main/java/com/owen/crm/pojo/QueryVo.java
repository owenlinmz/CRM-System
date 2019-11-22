package com.owen.crm.pojo;

import com.owen.page.Page;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryVo {
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    // 客户信息
    private Integer id;
    private String name;
    private String telephone;
    private String identity;
    private Integer roomId;


    // 客房信息
    private String roomNumber;
    private String floor;
    private String bed;
    private String type;
    private String status;
    private Integer price;

    // 入住信息
    private Date inTime;
    private Date outTime;
    private String breakfast;
    private Integer recordId;

    public Page<Record> recordList;

    public Page<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(Page<Record> recordList) {
        this.recordList = recordList;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
            if (timeString != null || !timeString.equals("")){
                timeString = timeString.replaceAll("T", " ");
            }
            this.inTime = dateFormat.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
            this.inTime = null;
        }
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(String timeString){
        try {
            if (timeString != null || !timeString.equals("")){
                timeString = timeString.replaceAll("T", " ");
            }
            this.outTime = dateFormat.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
            this.outTime = null;
        }
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // 当前页
    private Integer page;
    // 每页数
    private Integer size = 10;
    // 开始行
    private Integer startRow = 0;

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


}
