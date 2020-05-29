package com.cfireworks.miaosha.domain;

import java.util.Date;

/**
 * @description: excellent
 * @author: cfireworks
 * @create: 2020-05-20 16:53
 **/
public class BoyFriend {
    private volatile static BoyFriend uniqueInstance;
    private BoyFriend(){}

    public static BoyFriend getInstance(){
        if(uniqueInstance == null){
            synchronized (BoyFriend.class){
                if(uniqueInstance == null){
                    uniqueInstance = new BoyFriend();
                }
            }
        }
        return uniqueInstance;
    }

    private Long id;
    private String name;
    private String hobbies;
    private String character;
    private String description;
    private String photoUrl;
    private Date bornDate;
    private Date meetDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Date getMeetDate() {
        return meetDate;
    }

    public void setMeetDate(Date meetDate) {
        this.meetDate = meetDate;
    }
}
