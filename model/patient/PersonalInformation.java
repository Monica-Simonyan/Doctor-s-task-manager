package model.patient;

import model.exceptions.InvalidAgeException;
import model.exceptions.InvalidGenderException;
import model.exceptions.InvalidGmailException;
import model.exceptions.InvalidPhoneNumberException;

/**
 * Represents personal information for an individual in a patient management system.
 */
public class PersonalInformation implements Cloneable {
    // Fields
    private String name;
    private String lastName;
    private int age;
    private String gmail;
    private String address;
    private String phoneNumber;
    private Gender gender;

    // Enum to define gender types
    public enum Gender {
        MALE, FEMALE
    }

    public PersonalInformation() {
        this.name = "Michael";
        this.lastName = "Jackson";
        this.age = 30;
        this.phoneNumber = "5555555";
        this.gender = Gender.MALE;
    }

    /**
     * Constructor to create a new instance with full personal details.
     *
     * @param name        the first name of the individual
     * @param lastName    the last name of the individual
     * @param stringAge   the age of the individual
     * @param gmail       the Gmail address of the individual
     * @param address     the physical address of the individual
     * @param phoneNumber the phone number of the individual
     * @param gender      the gender of the individual
     */
    public PersonalInformation(String name, String lastName, String stringAge, String gmail,
                               String address, String phoneNumber, String gender) throws InvalidGenderException,
            InvalidGmailException, InvalidAgeException, InvalidPhoneNumberException {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        setAge(stringAge);
        setGender(gender);
        setPhoneNumber(phoneNumber); // Validates and sets phone number
        setGmail(gmail);             // Validates and sets Gmail
    }

    /**
     * Copy constructor for cloning an instance of PersonalInformation.
     *
     * @param that another PersonalInformation instance to copy data from.
     */
    public PersonalInformation(PersonalInformation that) {
        this.name = that.name;
        this.lastName = that.lastName;
        this.age = that.age;
        this.address = that.address;
        this.gender = that.gender;
        this.phoneNumber = that.phoneNumber;
        this.gmail = that.gmail;
    }



    /**
     * Retrieves the gender of the individual.
     *
     * @return the gender of the individual.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the gender of the individual.
     *
     * @param gender the gender to set.
     */
    public void setGender(String gender) throws InvalidGenderException {
        if (gender == null || !(Gender.valueOf(gender.toUpperCase()).equals(Gender.MALE) || Gender.valueOf(gender.toUpperCase()).equals(Gender.FEMALE)))
            throw new InvalidGenderException("Please enter a valid gender");
        else
            this.gender = Gender.valueOf(gender.toUpperCase());
    }

    /**
     * Retrieves the address of the individual.
     *
     * @return the physical address of the individual.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the physical address of the individual.
     *
     * @param address the address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the Gmail address of the individual.
     *
     * @return the Gmail address.
     */
    public String getGmail() {
        return gmail;
    }

    /**
     * Sets and validates the Gmail address of the individual. If the address is not valid,
     * prompts the user to enter a valid Gmail.
     *
     * @param gmail the Gmail address to set.
     */
    public void setGmail(String gmail) throws InvalidGmailException {
        String domain = "@gmail.com";
        if (!(gmail.endsWith(domain)))
            throw new InvalidGmailException();
        this.gmail = gmail;
    }

    /**
     * Retrieves the age of the individual.
     *
     * @return the age of the individual.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets and validates the age of the individual. If the age is not valid,
     * an exception message is printed and revalidation is prompted.
     *
     * @param stringAge the age to set.
     */
    public void setAge(String stringAge) throws InvalidAgeException {
        int intAge;
        try {
            intAge = Integer.parseInt(stringAge);
        } catch (Exception ex) {
            throw new InvalidAgeException();
        }
        if (intAge <= 0)
            throw new InvalidAgeException();
        else
            this.age = intAge;
    }

    /**
     * Retrieves the last name of the individual.
     *
     * @return the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the individual.
     *
     * @param lastName the last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the first name of the individual.
     *
     * @return the first name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the first name of the individual.
     *
     * @param name the first name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the phone number of the individual.
     *
     * @return the phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets and validates the phone number of the individual. If the phone number is not valid,
     * prompts the user to enter a valid phone number.
     *
     * @param phoneNumber the phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!((phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9') || phoneNumber.charAt(0) == '+'))
                throw new InvalidPhoneNumberException();
        }
        this.phoneNumber = phoneNumber;
    }

    /**
     * Creates a clone of this PersonalInformation object.
     *
     * @return a clone of this instance.
     */
    @Override
    public PersonalInformation clone() {
        try {
            return (PersonalInformation) super.clone();
        } catch (CloneNotSupportedException e) {
            return null; // This should never happen
        }
    }
    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        PersonalInformation other = (PersonalInformation) obj;
        return this.age == other.age && this.name.equals(other.name) && this.lastName.equals(other.lastName)
                && this.gmail.equals(other.gmail) && this.address.equals(other.address) && this.phoneNumber.equals(other.phoneNumber);
    }

    /**
     * Returns a string representation of the personal information.
     *
     * @return a formatted string with the individual's details.
     */
    @Override
    public String toString() {
        return name + " " + lastName + "\nAge: " + age + "\nAddress: " + address + "\nPhone number: "
                + phoneNumber + "\nGender: " + gender;
    }
}
