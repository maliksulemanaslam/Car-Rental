package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Member extends Customer {
   static ArrayList<Member> listMember = new ArrayList<Member>();
   public static int MemberID=listMember.size()+1;
   public static int MemberRegCounter=listMember.size()+1;
   public static int LoggedInMemberId=listMember.size()+1;
   public static boolean MemberLoginStatus= false;
   public static int loggedInIndex=-99;
   public static int Delindex = -99;
public static String tempmail, tempPass, Fname,Lname, Dob, EmaiL,iD;
public static int loginID;

   //End of variables declarations

    public Member(int memberID, int memberRegCounter, int loggedInMemberId) {
        MemberID = memberID;
        MemberRegCounter = memberRegCounter;
        LoggedInMemberId = loggedInMemberId;
    }



    public Member() {

    }


    public Member(String firstName, String lastName, String userName, String dob, String idCardNo, String email, int customerID, int b, String password, String loggedInUserType, int memberID, int memberRegCounter, int loggedInMemberId) {
        super(firstName, lastName, userName, dob, idCardNo, email, customerID, b, password, loggedInUserType);
        MemberID = memberID;
        MemberRegCounter = memberRegCounter;
        LoggedInMemberId = loggedInMemberId;
    }

    //End of constructors

    public static boolean isMemberLoginStatus() {
        return MemberLoginStatus;
    }

    public static void setMemberLoginStatus(boolean memberLoginStatus) {
        MemberLoginStatus = memberLoginStatus;
    }

//End of setters and getters

    public static void MemberReg(String FirstName, String LastName, String DOB, String email, String Password, String IDCardNo){
        Member memb  = new Member();
        memb.FirstName=FirstName;
        memb.LastName=LastName;
        memb.DOB=DOB;
        memb.Password=Password;
        memb.IDCardNo=IDCardNo;
        memb.email=email;
        memb.setUserName(FirstName+LastName);
        memb.LoggedInMemberId=listMember.size()+1;
        memb.setLoggedInUserType("member");
        memb.setMemberLoginStatus(true);
        memb.reservedPltNo=-99;
        tempmail=email;
        tempPass=Password;
        listMember.add(memb);

    }
public static void viewmyprofile(){
        for(int i=0; i<listMember.size(); i++){
            if(listMember.get(i).getEmail().equals(tempmail) && listMember.get(i).getPassword().equals(tempPass)){
                Fname=listMember.get(i).FirstName;
                Lname=listMember.get(i).LastName;
                Dob=listMember.get(i).DOB;
                EmaiL=listMember.get(i).email;
                loginID=LoggedInMemberId;
                iD=listMember.get(i).IDCardNo;
            }
        }
}
    public static void viewMember(){
        for(int i=0;i<listMember.size(); i++) {
            System.out.println(listMember.get(i).toString());
        }
    }

 public static void deleteMember (String usernm, String PAss, String RPS){


     for (int i = 0; i < listMember.size(); i++) {

         if (listMember.get(i).getEmail().equals(usernm) && listMember.get(i).getPassword().equals(PAss) && listMember.get(i).getPassword().equals(RPS)) {
             Delindex = i;
         }
     }
     listMember.remove(Delindex);
     setMemberLoginStatus(false);
 }
public static void CancelReservation(){
     double plt=0;
     if(listMember.get(loggedInIndex).reservedPltNo!=0){
         plt=listMember.get(loggedInIndex).reservedPltNo;
         listMember.get(loggedInIndex).setReservedPltNo(-99);
         Car.Cancel(plt);
         System.out.println("Your Reservation has been canceled!");
     }
}
    public static void loginMember(String usernm, String PAss){
        tempmail=usernm;
        tempPass=PAss;
        for (int i = 0; i < listMember.size(); i++) {
            if (listMember.get(i).getEmail().equals(usernm) && listMember.get(i).getPassword().equals(PAss)) {
                loggedInIndex=i;
                setMemberLoginStatus(true);
                break;
            }
            else{
                System.out.println("Wrong email or password has been entered!");
            }
        }
    }
    public static void logoutMember(){
        setMemberLoginStatus(false);
        loggedInIndex=-99;
    }

    public static void SaveMemData(){
        try{
            FileOutputStream writeData = new FileOutputStream("MemberData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(listMember);
      /*      System.out.println("file written");
            System.out.println("Total objects written are "+listMember.size());*/
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadMemData(){
        File recordFile= new File("MemberData.ser");
        if(recordFile.exists())
        {
            try{
                FileInputStream readData = new FileInputStream(recordFile);
                ObjectInputStream readStream = new ObjectInputStream(readData);
                listMember = (ArrayList<Member>) readStream.readObject();
                System.out.println("File has been read\n");
                readStream.close();
               System.out.println("the size of array list is  "+listMember.size() );
                for(int i=0; i<listMember.size(); i++) {
                    System.out.println(listMember.get(i).toString());
                }
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public String toString() {
        return "\n\nWelcome Customer " + FirstName + " " + LastName +
                "\nFollowing is your Bio" +
                "\nYourID: " + LoggedInMemberId +
                "\nUserName: '" + UserName + '\'' +
                "\nDate of Birth: '" + DOB + '\'' +
                "\nIDCardNo: " + IDCardNo +
                "\nEmail:'" + email + '\'' +
                "\nRented PLate No: "+ reservedPltNo+
                "\n";
    }

    //End of methods
}
