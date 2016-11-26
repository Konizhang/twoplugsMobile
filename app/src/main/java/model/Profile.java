package model;


import java.sql.Timestamp;

/**
 * Created by koni.zhang on 2016/8/9.
 */

public  class Profile {
    private int id;

    private User user;

    private String firstName;
    private String lastName;
    private Byte sex;
    private String addres1;
    private String addres2;
    private int country;
    private int province;
    private int city;

    //private City network;

    private String postalcode;

    private int companyId;
    private Integer showAddress;
    private Integer balance;
    private String img;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private byte showEmail;
    private String town;
    private String tagline;
    private String profilePics;
    private Integer servicebought;
    private byte verified;
    private String idimageName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }


    public String getAddres1() {
        return addres1;
    }

    public void setAddres1(String addres1) {
        this.addres1 = addres1;
    }

    public String getAddres2() {
        return addres2;
    }

    public void setAddres2(String addres2) {
        this.addres2 = addres2;
    }


    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }


    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }


    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }



}
