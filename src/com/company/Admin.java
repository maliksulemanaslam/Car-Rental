package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Customer implements Serializable {
    static ArrayList<Admin> listAdmin = new ArrayList<>();
    public static int AdminID = listAdmin.size() + 1;
    public static int AdminRegCounter = listAdmin.size() + 1;
    public static int LoggedInAdminID = listAdmin.size() + 1;
    private static int ind = 1;
    public static boolean AdminloginSatus = false;
    public static int Chkindex = -99;

// End of variables declaration

    public Admin(int adminID, int adminRegCounter, int loggedInAdminID) {
        AdminID = adminID;
        AdminRegCounter = adminRegCounter;
        LoggedInAdminID = loggedInAdminID;
    }

    public Admin(String firstName, String lastName, String userName, String DOB, String IDCardNo, String email, int customerID, int reserved, String password, int adminID, int adminRegCounter, int loggedInAdminID, String loggedInUserType) {
        super(firstName, lastName, userName, DOB, IDCardNo, email, customerID, reserved, password, loggedInUserType);
        AdminID = adminID;
        AdminRegCounter = adminRegCounter;
        LoggedInAdminID = loggedInAdminID;
    }


    public Admin() {

    }
    //End of Constructors

    public static boolean isAdminloginSatus() {
        return AdminloginSatus;
    }

    public static void setAdminloginSatus(boolean adminloginSatus) {
        AdminloginSatus = adminloginSatus;
    }

//End of setters and getters



    public static void AdminReg(String FirstName, String LastName, String DOB, String email, String Password, String IDCardNo) {

        Admin admin = new Admin();
        admin.FirstName = FirstName;
        admin.LastName = LastName;
        admin.DOB = DOB;
        admin.Password = Password;
        admin.IDCardNo = IDCardNo;
        admin.email = email;
        admin.setUserName(FirstName + LastName);
        admin.LoggedInAdminID = listAdmin.size() + 1;

        LoggedInUserType = "admin";

        listAdmin.add(admin);
        System.out.println("\nRegistration Completed Successfully!");
        System.out.println(admin);
        setAdminloginSatus(true);
        viewAdmin();
    }

    public static void viewAdmin() {
        if (listAdmin.isEmpty()) {
            System.out.println("\nNo Admin account exists!\n");
        } else
            for (int i = 0; i < listAdmin.size(); i++) {
                System.out.println(listAdmin.get(i));
            }
    }

    public static void loginAdmin(String loginusernm, String PAss) {

        String loguserNM = loginusernm;
        String PASS = PAss;
        for (int i = 0; i < listAdmin.size(); i++) {
            if (listAdmin.get(i).email.equals(loguserNM) && listAdmin.get(i).Password.equals(PASS)) {
                setAdminloginSatus(true);
                break;
            }
        }

    }

    public static void logoutAdmin() {
        setAdminloginSatus(false);
}

        public static void SaveData () {
            try {

                FileOutputStream writeData = new FileOutputStream("AdminData.ser");
                ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
                writeStream.writeObject(listAdmin);
            System.out.println("file written");
            System.out.println("Total objects written are "+listAdmin.size());
                writeStream.flush();
                writeStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static void deleteAdmin (String usernm, String PAss, String RPS){

            for (int i = 0; i < listAdmin.size(); i++) {

                if (listAdmin.get(i).getEmail().equals(usernm) && listAdmin.get(i).getPassword().equals(PAss) && listAdmin.get(i).getPassword().equals(RPS)) {
                    Chkindex = i;
                }
            }
            listAdmin.remove(Chkindex);
            setAdminloginSatus(false);
        }
        public static void ReadData () {
            File recordFile = new File("AdminData.ser");
            if (recordFile.exists()) {
                try {
                    FileInputStream readData = new FileInputStream(recordFile);
                    ObjectInputStream readStream = new ObjectInputStream(readData);
                    listAdmin = (ArrayList<Admin>) readStream.readObject();
                    /*System.out.println("File has been read\n");*/
                    readStream.close();
                    /*System.out.println("the size of array list is  "+listAdmin.size() );*/
                /*for(int i=0; i<listAdmin.size(); i++) {
                    System.out.println(listAdmin.get(i));
                }*/
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString () {

            return "\n\nWelcome Admin " + FirstName + " " + LastName +
                    "\nFollowing is your Bio" +
                    "\nYourID: " + LoggedInAdminID +
                    "\nUserName: '" + UserName + '\'' +
                    "\nDate of Birth: '" + DOB + '\'' +
                    "\nIDCardNo: " + IDCardNo +
                    "\nEmail:'" + email + '\'' + "\n";
        }
//End of methods
}


