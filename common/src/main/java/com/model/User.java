package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class User implements Serializable {
    private int id;
    private int userId;
    private Date createDate;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", userId=" + userId +
                ", createDate=" + createDate +
                ", name='" + name + '\'' +
                '}';
    }
}
