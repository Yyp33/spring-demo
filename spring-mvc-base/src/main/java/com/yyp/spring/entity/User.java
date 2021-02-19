package com.yyp.spring.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class User {

    private Integer id;
    private String name;
    private String[] alias;
    private List<String> hobbies;
    private Map<String, String> relative;
    private Role role;
    private List<User> friends;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAlias() {
        return alias;
    }

    public void setAlias(String[] alias) {
        this.alias = alias;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getRelative() {
        return relative;
    }

    public void setRelative(Map<String, String> relative) {
        this.relative = relative;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias=" + Arrays.toString(alias) +
                ", hobbies=" + hobbies +
                ", relative=" + relative +
                ", role=" + role +
                ", friends=" + friends +
                ", date=" + date +
                '}';
    }
}
