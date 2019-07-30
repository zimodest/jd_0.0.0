package com.modest.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author modest
 * @date 2019/07/18
 */
public class User implements Serializable {
    /**
     *  `uid` VARCHAR(32) NOT NULL,
     *   `username` VARCHAR(20) DEFAULT NULL,
     *   `password` VARCHAR(50) DEFAULT NULL,
     *   `name` VARCHAR(20) DEFAULT NULL,
     *   `email` VARCHAR(30) DEFAULT NULL,
     *   `telephone` VARCHAR(20) DEFAULT NULL,
     *   `birthday` DATE DEFAULT NULL,
     *   `sex` VARCHAR(10) DEFAULT NULL,
     *   `state` INT(11) DEFAULT NULL,
     *   `code` VARCHAR(64) DEFAULT NULL,
     */
    private String uid ;
    private String username ;
    private String password ;
    private String name ;
    private String email ;
    private String telephone ;
    private Date birthday ;
    private String sex ;

    /**
     * 当前用户的状态(0表示未激活,1表示激活状态)
     */
    private Integer state = 0 ;

    /**
     * Code激活码(要求唯一)
     */
    private String code ;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}
