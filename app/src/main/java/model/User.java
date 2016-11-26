package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by koni.zhang on 2016/8/6.
 */

public  class User {


    /**
     * id : 5
     * username : Dave1111
     * email : Test_Canada_dba@hotmail.com
     * code : 123123123
     * active : 1
     * status : 1
     * role : 0
     * createdAt : 2015-09-11T14:32:44.000+0000
     * updatedAt : 2016-08-05T22:50:03.000+0000
     * _links : {"self":{"href":"http://localhost:3721/apk/v1/users/5"},"user":{"href":"http://localhost:3721/apk/v1/users/5{?projection}","templated":true},"profile":{"href":"http://localhost:3721/apk/v1/users/5/profile"}}
     */

    @SerializedName("Id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;
    @SerializedName("code")
    private String code;
    @SerializedName("active")
    private int active;
    @SerializedName("status")
    private int status;
    @SerializedName("role")
    private int role;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("updatedAt")
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
