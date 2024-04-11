public class PersonalInformation {
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String address;
    private String phoneNumber;
    private Gender gender;

    private enum Gender {
        MALE, FEMALE
    }

    public PersonalInformation(String name, String lastName, int age, String email,
                               String address, String phoneNumber, Gender gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return name + " " + lastName + "\n" + "Age: " + age + "\nAddress: " + address +"\nPhone number: "
                +phoneNumber+"\nGender: "+gender;
    }
}
