package nhs;

import java.time.LocalDate;

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
    private LocalDate dateOfBirth;
    private BloodType bloodType;


    /**
     * Patient constructor with no args
     * This sets default values if none are passed in
     */
    public Patient() {
        setName("Foo Bar");
        setNhsNumber("000000000");
        setAge(0);
        setAddress("00 Somewhere Road, Someplace, Somewhere, AB1 2CD");
        setDateOfBirth(LocalDate.now());
        setBloodType(BloodType.A);
    }

    /**
     * Patient constructor with 4 args
     * @param name Name of the patient
     * @param nhsNumber Patient's NHS number
     * @param age Age of the patient
     * @param address Address of the patient
     * @param dateOfBirth Patient's date of birth
     * @param bloodType Patient's blood type
     */
    public Patient(String name, String nhsNumber, int age, String address, LocalDate dateOfBirth, BloodType bloodType) {
        this.name = name;
        this.nhsNumber = nhsNumber;
        this.age = age;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.bloodType = bloodType;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Patient ? nhsNumber.equals(((Patient)obj).nhsNumber) : false;
    }

    @Override
    public int hashCode() {
        return nhsNumber.hashCode();
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
}
