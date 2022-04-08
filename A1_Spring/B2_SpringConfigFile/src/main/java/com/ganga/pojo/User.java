package com.ganga.pojo;

public class User {

    private String username;
    private int age;
    private String adds;

    public User() {
    }

    public User(String username, int age, String adds) {
        this.username = username;
        this.age = age;
        this.adds = adds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdds() {
        return adds;
    }

    public void setAdds(String adds) {
        this.adds = adds;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", adds='" + adds + '\'' +
                '}';
    }
}
