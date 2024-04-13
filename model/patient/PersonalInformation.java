package model.patient;

import model.exceptions.InvalidGmailException;
import model.exceptions.InvalidPhoneNumberException;

public class PersonalInformation implements Cloneable{
    //Instance variables
    private String name;
    private String lastName;
    private int age;
    private String gmail;
    private String address;
    private String phoneNumber;
    private Gender gender;

    @Override
    public PersonalInformation clone() {
        try {
            return (PersonalInformation) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private enum Gender {
        MALE, FEMALE
    }
    public PersonalInformation(String name, String lastName, int age, String gmail,
                               String address, String phoneNumber, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.gender = gender;
        setPhoneNumber(phoneNumber);
        setGmail(gmail);
    }
    public PersonalInformation(PersonalInformation that) {
        this.name = that.name;
        this.lastName = that.lastName;
        this.age = that.age;
        this.address = that.address;
        this.gender = that.gender;
        setPhoneNumber(that.phoneNumber);
        setGmail(that.gmail);
    }
    public void verifyGmail(String gmail) throws InvalidGmailException {
        String domain = "@gmail.com";
        if (!(gmail.endsWith(domain)))
            throw new InvalidGmailException();
    }

    public void verifyPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!((phoneNumber.charAt(i) >= '1' && phoneNumber.charAt(i) <= '9') || phoneNumber.charAt(i) == '+'))
                throw new InvalidPhoneNumberException();
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        boolean validGmail = false;
        while (!validGmail) {
            try {
                verifyGmail(gmail);
                validGmail = true;
            } catch (InvalidGmailException e) {
                System.out.println("Please enter a valid gmail.");
            }
        }
        this.gmail = gmail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        boolean validPhoneNumber = false;
        while (!validPhoneNumber) {
            try {
                verifyPhoneNumber(phoneNumber);
                validPhoneNumber = true;
            } catch (InvalidPhoneNumberException e) {
                System.out.println("Please enter a valid phone number.");
            }
        }
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return name + " " + lastName + "\nAge: " + age + "\nAddress: " + address + "\nPhone number: "
                + phoneNumber + "\nGender: " + gender;
    }
}
