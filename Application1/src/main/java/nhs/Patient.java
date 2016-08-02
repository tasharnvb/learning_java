package nhs;

/**
 * Created by Academy07 on 02/08/2016.
 *
 * Patient Class
 */
public class Patient {
    private String name;
    private String nhsNumber;
    private int age;
    private String address;

    /**
     * Patient constructor with no args
     * This sets default values if none are passed in
     */
    public Patient() {
        setName("Foo Bar");
        setNhsNumber("000000000");
        setAge(0);
        setAddress("00 Somewhere Road, Someplace, Somewhere, AB1 2CD");
    }

    /**
     * Patient constructor with 4 args
     * @param name Name of the patient
     * @param nhsNumber Patient's NHS number
     * @param age Age of the patient
     * @param address Address of the patient
     */
    public Patient(String name, String nhsNumber, int age, String address) {
        this.name = name;
        this.nhsNumber = nhsNumber;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
