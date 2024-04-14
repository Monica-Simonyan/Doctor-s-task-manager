package com.example.doctorstaskmanagerapplication;

/**
 * <code>MyDate</code> class creates objects representing a date
 * with 3 <code>String</code> fields: day, month, and year
 */
public class MyDate {
    private String day;
    private String month;
    private String year;

    /**
     * Initializes the fields of the <code>MyDate</code> object
     * @param day      the <code>String</code> value of the day of the month
     * @param month    the <code>String</code> value of the month of the year
     * @param year     the <code>String</code> value of the year
     */
    public MyDate(String day, String month, String year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * returns the <code>String</code> day
     * @return     the <code>String</code> day
     */
    public String getDay(){
        return this.day;
    }

    /**
     * returns the <code>String</code> month
     * @return     the <code>String</code> month
     */

    public String getMonth(){
        return this.month;
    }


    /**
     * returns the <code>String</code> year
     * @return     the <code>String</code> year
     */
    public String getYear(){
        return this.year;
    }


    /**
     * returns the <code>String</code> day and month
     * @return
     */
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
