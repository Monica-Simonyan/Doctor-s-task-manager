package com.example.doctorstaskmanagerapplication;

public class Categories {
    private String categories;

    public Categories(String categories){
        this.categories = categories;
    }

    public String getCategories(){
        return this.categories;
    }

    public void setCategories(String categories){
        if(categories != null){
            this.categories = categories;
        }
    }
}
