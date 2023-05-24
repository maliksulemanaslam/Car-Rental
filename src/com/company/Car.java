package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Car implements Serializable {
    static ArrayList<Car> listCar = new ArrayList<>();
    static Scanner key = new Scanner(System.in);
    static  Scanner in= new Scanner(System.in);
    public String carName;
    private  String carMake;
    private String carType;
    private String carColour;
    private String carLocation;
    private int carModel;
    private int carPlateNo;
    private int carPricePerDay;
    public static boolean ReserveStatus;
    private int CarCounter=listCar.size();
    public static int updatedIndex=0;
    public static double rentedPltNo=0;


    public static String searchnm,searchmk,searchtp,searchcl,searchlcn;
    public static int searchmd,searchpltn,searchprpd,searchIndex=-99;
    public static boolean status;

    public static String rentednm, rentedmk, rentedtp, rentedcl, rentedlcn;
    public static int rentedmd, rentedpltn, rentedprpd, rentedIndex;
    public static double memberReservedPLT=-999;

//End of variables declaration

    public Car() {
    }



    public Car(String carName, String carMake, String carType, String carColour, String carLocation, int carModel, int carPlateNo, int carPricePerDay, boolean reserveStatus, int carCounter) {
        this.carName = carName;
        this.carMake = carMake;
        this.carType = carType;
        this.carColour = carColour;
        this.carLocation =carLocation;
        this.carModel = carModel;
        this.carPlateNo =  carPlateNo;
        this.carPricePerDay =  carPricePerDay;
        ReserveStatus = reserveStatus;
        CarCounter = carCounter;
    }

    //End of constructors

    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public String getCarMake() {
        return carMake;
    }
    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getCarColour() {
        return carColour;
    }
    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }
    public String getCarLocation() {
        return carLocation;
    }
    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }
    public double getCarModel() {
        return carModel;
    }
    public void setCarModel(double carModel) {
        this.carModel = (int) carModel;
    }
    public double getCarPlateNo() {
        return carPlateNo;
    }
    public void setCarPlateNo(double carPlateNo) {
        this.carPlateNo = (int) carPlateNo;
    }
    public double getCarPricePerDay() {
        return carPricePerDay;
    }
    public void setCarPricePerDay(double carPricePerDay) {
        this.carPricePerDay = (int) carPricePerDay;
    }
    public boolean isReserveStatus() {
        return ReserveStatus;
    }
    public void setReserveStatus(boolean reserveStatus) {
        ReserveStatus = reserveStatus;
    }
    public int getCarCounter() {
        return CarCounter;
    }
    public void setCarCounter(int carCounter) {
        CarCounter = carCounter;
    }

    //End of setters and getters

    public static void addCar(String carnm, String carbrnd, String cartype, String carclr,String carlctn, int carmdl, int carpltno, int carppp)  {
        Car car=new Car();
        car.CarCounter++;
        car.carName=carnm;

        car.carMake=carbrnd;

        car.carType=cartype;

        car.carColour=carclr;

        car.carLocation=carlctn;

        car.carModel=carmdl;

        car.carPlateNo=carpltno;

        car.carPricePerDay=carppp;
        car.ReserveStatus=false;



        listCar.add(car);
    }

    public static void viewCar(){

            for (int i = 0; i <listCar.size(); i++) {
                System.out.println(listCar.get(i));
            }
    }

    public static void deleteCar(int plateno){
        int carIndex=0;
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarPlateNo()==plateno){
                carIndex=i;
            }
        }
            listCar.remove(carIndex);

    }

    public static void updateCarModel(int plt, int newmdl) {
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarPlateNo() == plt) {
                listCar.get(i).setCarModel(newmdl);
                updatedIndex=i;
            }
        }
    }
    public static void updateCarRent(int plt, int newrnt) {
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarPlateNo() == plt) {
                listCar.get(i).setCarPricePerDay(newrnt);
                updatedIndex=i;
            }
        }
    }
    public static void updateCarPlate(int plt, int newplt) {
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarPlateNo() == plt) {
                listCar.get(i).setCarPlateNo(newplt);
                updatedIndex=i;
            }
        }
    }
    public static void updateCarLocation(int plt, String newlcn) {
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarPlateNo() == plt) {
                listCar.get(i).setCarLocation(newlcn);
                updatedIndex=i;
            }
        }
    }

    public static void searchCarbyName(String searchNM){
            for (int i = 0; i < listCar.size(); i++) {
                if (listCar.get(i).getCarName().equals(searchNM)) {
                    searchnm=listCar.get(i).carName;
                    searchmk=listCar.get(i).carMake;
                    searchtp=listCar.get(i).carType;
                    searchcl=listCar.get(i).carColour;
                    searchmd=listCar.get(i).carModel;
                    searchpltn=listCar.get(i).carPlateNo;
                    searchprpd=listCar.get(i).carPricePerDay;
                    searchlcn=listCar.get(i).carLocation;
                    status=listCar.get(i).isReserveStatus();
                    searchIndex=i;

                }
                else{
                    searchIndex=-99;
                }
                viewCar();
            }
    }
    public static void searchCarbyColour(String searchCL){
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarColour().equals(searchCL)) {
                searchnm=listCar.get(i).carName;
                searchmk=listCar.get(i).carMake;
                searchtp=listCar.get(i).carType;
                searchcl=listCar.get(i).carColour;
                searchmd=listCar.get(i).carModel;
                searchpltn=listCar.get(i).carPlateNo;
                searchprpd=listCar.get(i).carPricePerDay;
                searchlcn=listCar.get(i).carLocation;
                status=listCar.get(i).isReserveStatus();
                searchIndex=i;

            }
            else{
                searchIndex=-99;
            }
        }
    }
    public static void searchCarbyType(String searchTP){
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarType().equals(searchTP)) {
                searchnm=listCar.get(i).carName;
                searchmk=listCar.get(i).carMake;
                searchtp=listCar.get(i).carType;
                searchcl=listCar.get(i).carColour;
                searchmd=listCar.get(i).carModel;
                searchpltn=listCar.get(i).carPlateNo;
                searchprpd=listCar.get(i).carPricePerDay;
                searchlcn=listCar.get(i).carLocation;
                status=listCar.get(i).isReserveStatus();
                searchIndex=i;
            }
            else{
                searchIndex=-99;
            }
        }
    }
    public static void searchCarbyMake(String searchMK){
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarMake().equals(searchMK)) {
                searchnm=listCar.get(i).carName;
                searchmk=listCar.get(i).carMake;
                searchtp=listCar.get(i).carType;
                searchcl=listCar.get(i).carColour;
                searchmd=listCar.get(i).carModel;
                searchpltn=listCar.get(i).carPlateNo;
                searchprpd=listCar.get(i).carPricePerDay;
                searchlcn=listCar.get(i).carLocation;
                status=listCar.get(i).isReserveStatus();
                searchIndex=i;
            }
            else{
                searchIndex=-99;
            }
        }
    }
    public static void searchCarbyNoPlate(int searchNP){
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarPlateNo()==searchNP) {
                searchnm=listCar.get(i).carName;
                searchmk=listCar.get(i).carMake;
                searchtp=listCar.get(i).carType;
                searchcl=listCar.get(i).carColour;
                searchmd=listCar.get(i).carModel;
                searchpltn=listCar.get(i).carPlateNo;
                searchprpd=listCar.get(i).carPricePerDay;
                searchlcn=listCar.get(i).carLocation;
                status=listCar.get(i).isReserveStatus();
                searchIndex=i;
            }
            else{
                searchIndex=-99;
            }
        }
    }
    public static void searchCarbyPrice(int searchPR){
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getCarPricePerDay()== searchPR) {
                searchnm=listCar.get(i).carName;
                searchmk=listCar.get(i).carMake;
                searchtp=listCar.get(i).carType;
                searchcl=listCar.get(i).carColour;
                searchmd=listCar.get(i).carModel;
                searchpltn=listCar.get(i).carPlateNo;
                searchprpd=listCar.get(i).carPricePerDay;
                searchlcn=listCar.get(i).carLocation;
                status=listCar.get(i).isReserveStatus();
                searchIndex=i;
            }
            else{
                searchIndex=-99;
            }
        }
    }
    public static void RentCar(int index) {
        for (int i = 0; i < listCar.size(); i++) {
            if (i == index) {
                if (listCar.get(index).isReserveStatus()) {
                    System.out.println("Already Rented!");
                }
                else {
                    listCar.get(i).setReserveStatus(true);
                    System.out.println(listCar.get(i));
                    rentedPltNo=listCar.get(i).getCarPlateNo();
                    System.out.println(listCar.get(i));
                }
            }
        }
        Member.listMember.get(Member.loggedInIndex).setReservedPltNo(rentedPltNo);
    }
    public static void ViewMyRentedVehicle(){
        memberReservedPLT=Member.listMember.get(Member.loggedInIndex).getReservedPltNo();
        for(int i=0; i<listCar.size(); i++){
            if(listCar.get(i).getCarPlateNo()==memberReservedPLT){
                rentednm=listCar.get(i).carName;
                rentedmk=listCar.get(i).carMake;
                rentedtp=listCar.get(i).carType;
                rentedcl=listCar.get(i).carColour;
                rentedmd=listCar.get(i).carModel;
                rentedpltn=listCar.get(i).carPlateNo;
                rentedprpd=listCar.get(i).carPricePerDay;
                rentedlcn=listCar.get(i).carLocation;

            }
        }

    }
    public static void Cancel(double plate){
        for (int i = 0; i < listCar.size(); i++) {
            if(listCar.get(i).getCarPlateNo()==plate){
                listCar.get(i).setReserveStatus(false);
            }
        }
    }
    public static void addCarToFile(){
        try{
            FileOutputStream writeCarData = new FileOutputStream("CarData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeCarData);
            writeStream.writeObject(listCar);
           /* System.out.println("file written");
            System.out.println("Total objects written are "+listCar.size());*/
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readCar(){
    File CarRecordFile= new File("CarData.ser");
    if(CarRecordFile.exists())
    {
        try{
            FileInputStream readCarData = new FileInputStream(CarRecordFile);
            ObjectInputStream readStream = new ObjectInputStream(readCarData);
            listCar = (ArrayList<Car>) readStream.readObject();
            /*System.out.println("File has been read\n");*/
            readStream.close();
            System.out.println("the size of array list is  "+listCar.size() );
            for(int i=0; i<listCar.size(); i++) {
                System.out.println(listCar.get(i));
            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

    @Override
    public String toString() {
        return  "\n Car Name: " + carName +
                "\n Car Make: " + carMake +
                "\n Car Model: " + carModel +
                "\n Car Colour: " + carColour +
                "\n Car Location: " + carLocation +
                "\n Car Type: " + carType +
                "\n Car PlateNo: " + carPlateNo +
                "\n Car Price Per Day: " + carPricePerDay+
                "\n Car reserve status: "+ ReserveStatus;
    }
    //End of methods
}
