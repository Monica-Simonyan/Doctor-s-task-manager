package com.example.doctorstaskmanagerapplication.patient;


import com.example.doctorstaskmanagerapplication.MyDate;

/**
 * <code>Patient</code> creates an object with 3 <code>String</code> fields:
 * name, age, history, one <code>MyDate</code> lastDate field, and one
 *<code>int</code> image
 */
public class Patient  {
    private String name;
    private String age;
    private MyDate lastDate;
    private String history;
    int image;

    /**
     * initializes the fields of a <code>Patient</code> class
     * @param name       the <code>String</code> name
     * @param age        the <code>String</code> age
     * @param lastDate   the <code>MyDate</code> lastDate
     * @param history    the <code>String</code> history
     * @param image      the <code>int</code> image
     */
    public Patient(String name, String age, String lastDate, String history, int image){
        this.name = name;
        this.age = age;
        this.lastDate = new MyDate(lastDate.split(" ")[0], lastDate.split(" ")[1], lastDate.split(" ")[2]);
        this.history = history;
        this.image = image;
    }


    /**
     * returns the <code>String</code> name
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * sets the <code>String</code> name
     * @param name <code>String</code> name
     */
    public void setName(String name){
        if(name != null){
            this.name = name;
        }
        else{
            System.out.println("Input a valid value");
        }
    }


    /**
     * returns the <code>String</code> age
     * @return     the <code>String</code> age
     */
    public String getAge(){
        return this.age;
    }


    /**
     * sets the <code>String</code> age
     * @param age     the <code>String</code> age
     */
    public void setAge(String age){
        if(age != null){
            this.age = age;
        }
        else{
            System.out.println("Input a valid value");
        }
    }

    /**
     * returns the <code>MyDate</code> lastDate
     * @return      the <code>MyDate</code> lastDate
     */
    public String getLastDate(){
        return lastDate.toString();
    }


    /**
     * sets the <code>MyDate</code> lastDate
     * @param lastDate     the <code>String</code> lastDate
     */
    public void setLastDate(MyDate lastDate){
        if(lastDate != null){
            this.lastDate = lastDate;
        }
    }


    /**
     * returns the <code>String</code> history
     * @return     the <code>String</code> history
     */
    public String getHistory(){
        return history;
    }


    /**
     * sets the <code>String</code> history
     */
    public void setHistory(String history){
        if(history != null){
            this.history = history;
        }
    }

    /**
     * returns the <code>int</code> image
     * @return
     */
    public int getImage(){
        return image;
    }

}



// we will change the class to this version





/*
}
public class Patient implements Cloneable {
    //instance variables
    PersonalInformation personalInfo;
    History history;
    Payments payments;

    public Patient(String patientName, String patientAge, String s, String s1, int patientImage) {
        personalInfo.setP
        personalInfo.setAge(Integer.parseInt(patientAge));
        personalInfo.setImage(patientImage);
    }

         */



//Accessors and mutators

/**
 * Returns payments of the patient
 *
 * @return payments of type Payments
 */
    /*
    public Payments getPayments() {
        return payments.clone();
    }

    /**
     * Sets the payments of the patient
     *
     * @param payments new payments of type Payments
     */

    /*
    public void setPayments(Payments payments) {
        this.payments = payments.clone();
    }

    public String getName(){
        return personalInfo.getName();
    }

    public String getAge(){
        return String.valueOf(personalInfo.getAge());
    }

    public String getLastDate(){
        return personalInfo.getLastDate();
    }

    public int getImage(){
        return personalInfo.getImage();
    }


    /**
     * Returns history of the patient
     *
     * @return history of type History
     */

    /*
    public String getHistory() {
        return history.toString();
    }

    /**
     * Sets the history of the patient
     *
     * @param history new history of type History
     */

    /*
    public void setHistory(History history) {
        history = new History(history);
    }

    /*
    public Patient clone() {
        try {
            Patient clone = (Patient) super.clone();
            clone.history = (History) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    */
