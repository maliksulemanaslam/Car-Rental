package com.company;
import java.io.Serializable;

public class Customer implements Serializable {
    protected String FirstName;
    protected String LastName;
    protected String UserName;
    protected String DOB;
    protected String IDCardNo;
    protected String email;
    protected int CustomerID;
    protected double reservedPltNo;
    protected String Password;
    public static String LoggedInUserType;


    //Non-Parameterized Constructor

    public Customer() {
    }

    //Parameterized Constructor


    public Customer(String firstName, String lastName, String userName, String DOB, String IDCardNo, String email, int customerID, double reserved, String password, String loggedInUserType) {
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
        this.DOB = DOB;
        this.IDCardNo = IDCardNo;
        this.email = email;
        CustomerID = customerID;
        reservedPltNo=reserved;
        Password = password;
        LoggedInUserType = loggedInUserType;
    }



    //Getters
    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUserName() {
        return UserName;
    }

    public String getDOB() {
        return DOB;
    }

    public String getIDCardNo() {
        return IDCardNo;
    }

    public String getEmail() {
        return email;
    }

    public double getCustomerID() {
        return CustomerID;
    }

    public String getPassword() {
        return Password;
    }


    public String getLoggedInUserType() {
        return LoggedInUserType;
    }

    //Setters
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public void setIDCardNo(String IDCardNo) {
        this.IDCardNo = IDCardNo;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getReservedPltNo() {
        return reservedPltNo;
    }

    public void setReservedPltNo(double reservedPltNo) {
        this.reservedPltNo = reservedPltNo;
    }

    public void setLoggedInUserType(String loggedInUserType) {
        LoggedInUserType = loggedInUserType;
    }
}
