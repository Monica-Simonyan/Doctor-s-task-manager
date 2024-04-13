package com.example.doctorstaskmanagerapplication;

public class MyDate {
    private String day;
    private String month;
    private String year;

    public MyDate(String day, String month, String year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public String getDay(){
        return this.day;
    }

    public String getMonth(){
        return this.month;
    }

    public String getYear(){
        return this.year;
    }

    public String toString(){
        return this.day + " " + this.month;
    }

//    public String generateFromString(String date){
//        String[] dates = date.split("");
//        this.day = (dates[0]);
//        this.month = dates[1];
//        this.year = (dates[2]);
//       // return day + " " + month +
//    }
}
