package com.example.doctorstaskmanagerapplication.gui;

/**
 * <code>Categories</code> class creates objects with <code>String</code> category fields
 * representing the categories of patients the doctor has
 */
public class Categories {
    private String categories;

    /**
     * Initializes the fields of the <code>Categories</code> objects
     * @param categories     the <code>String</code> values of the categories
     */
    public Categories(String categories){
        this.categories = categories;
    }

    /**
     * returns the <code>String</code> value of the category
     * @return     the <code>String</code> value of the chosen category
     */
    public String getCategories(){
        return this.categories;
    }

    /**
     * sets the <code>String</code> value of the categories
     * @param categories     the <code>String</code> value of the categories
     */
    public void setCategories(String categories){
        if(categories != null){
            this.categories = categories;
        }
    }
}
