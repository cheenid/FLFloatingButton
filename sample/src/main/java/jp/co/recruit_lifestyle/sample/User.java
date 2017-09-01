package jp.co.recruit_lifestyle.sample;

/**
 * Created by 201502042 on 2017/9/1.
 */

public class User {


    public User(int uid, int age, String name) {
        this.uid = uid;
        this.age = age;
        this.name = name;
    }

    private int uid;
    private int age;
    private String name;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
