package com.example.doctorstaskmanagerapplication.patient;


import com.example.doctorstaskmanagerapplication.MyDate;

public class Patient {
    private String name;
    private String age;
    private MyDate lastDate;
    private String history;
    int image;

    public Patient(String name, String age, String lastDate, String history, int image){
        this.name = name;
        this.age = age;
        this.lastDate = new MyDate(lastDate.split(" ")[0], lastDate.split(" ")[1], lastDate.split(" ")[2]);
        this.history = history;
        this.image = image;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        if(name != null){
            this.name = name;
        }
        else{
            System.out.println("Input a valid value");
        }
    }

    public String getAge(){
        return this.age;
    }

    public void setAge(String age){
        if(age != null){
            this.age = age;
        }
        else{
            System.out.println("Input a valid value");
        }
    }

    public String getLastDate(){
        return lastDate.toString();
    }

    public void setLastDate(MyDate lastDate){
        if(lastDate != null){
            this.lastDate = lastDate;
        }
    }

    public String getHistory(){
        return history;
    }

    public void setHistory(String history){
        if(history != null){
            this.history = history;
        }
    }

    public int getImage(){
        return image;
    }
}
