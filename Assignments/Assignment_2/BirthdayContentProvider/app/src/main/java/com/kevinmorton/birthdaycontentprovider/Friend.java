package com.kevinmorton.birthdaycontentprovider;

public class Friend {
    private int _id;
    private String name;
    private String birthday;

    public Friend(int _id, String name, String birthday) {
        this._id = _id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
