package console.model.patient;

import console.model.exceptions.InvalidAgeException;
import console.model.exceptions.InvalidGmailException;
import console.model.exceptions.InvalidPhoneNumberException;

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
    private enum Gender {
        MALE, FEMALE
    }

    /**
     * Constructor to create a new instance with full personal details.
     *
     * @param name        the first name of the individual
     * @param lastName    the last name of the individual
     * @param age         the age of the individual
     * @param gmail       the Gmail address of the individual
     * @param address     the physical address of the individual
     * @param phoneNumber the phone number of the individual
     * @param gender      the gender of the individual
     */
    public PersonalInformation(String name, String lastName, int age, String gmail,
                               String address, String phoneNumber, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.gender = gender;
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
        this.phoneNumber = that.phoneNumber; // Assume already validated
        this.gmail = that.gmail;             // Assume already validated
    }

    /**
     * Validates the provided Gmail address to ensure it ends with "@gmail.com".
     * Throws InvalidGmailException if validation fails.
     *
     * @param gmail the Gmail address to validate
     * @throws InvalidGmailException if the Gmail address does not end with "@gmail.com"
     */
    public void verifyGmail(String gmail) throws InvalidGmailException {
        String domain = "@gmail.com";
        if (!(gmail.endsWith(domain)))
            throw new InvalidGmailException();
    }

    /**
     * Validates the provided phone number to ensure it contains only digits or starts with '+'.
     * Throws InvalidPhoneNumberException if validation fails.
     *
     * @param phoneNumber the phone number to validate
     * @throws InvalidPhoneNumberException if the phone number contains invalid characters
     */
    public void verifyPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!((phoneNumber.charAt(i) >= '1' && phoneNumber.charAt(i) <= '9') || phoneNumber.charAt(i) == '+'))
                throw new InvalidPhoneNumberException();
        }
    }

    /**
     * Validates the provided age to ensure it is greater than zero.
     * Throws InvalidAgeException if validation fails.
     *
     * @param age the age to validate
     * @throws InvalidAgeException if the age is zero or negative
     */
    public void verifyAge(int age) throws InvalidAgeException {
        if (age <= 0)
            throw new InvalidAgeException();
    }


    // Getters and setters with documentation

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
    public void setGender(Gender gender) {
        this.gender = gender;
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
    public void setGmail(String gmail) {
        boolean validGmail = false;
        while (!validGmail) {
            try {
                verifyGmail(gmail);
                validGmail = true;
            } catch (InvalidGmailException e) {
                System.out.println("Please enter a valid Gmail.");
            }
        }
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
     * @param age the age to set.
     */
    public void setAge(int age) {
        boolean validAge = false;
        while (!validAge) {
            try {
                verifyAge(age);
                validAge = true;
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
        }
        this.age = age;
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
            throw new AssertionError(); // This should never happen
        }
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
