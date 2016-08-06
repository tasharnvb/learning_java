package entity;

import nhs.Patient;

import java.time.LocalDate;

/**
 * Created by Tasharn on 06/08/2016.
 */
public class BloodTest {
    private int redCellCount;
    private int whiteCellCount;
    private int plateletCount;
    private Patient patient;
    private LocalDate testDate;
    private int id;

    public BloodTest() {
        setRedCellCount(0);
        setWhiteCellCount(0);
        setPlateletCount(0);
        setPatient(new Patient());
        setTestDate(LocalDate.now());
        setId(0);
    }

    public BloodTest(int redCellCount, int whiteCellCount, int plateletCount, Patient patient, LocalDate testDate, int id) {
        this.redCellCount = redCellCount;
        this.whiteCellCount = whiteCellCount;
        this.plateletCount = plateletCount;
        this.patient = patient;
        this.testDate = testDate;
        this.id = id;
    }

    public int getRedCellCount() {
        return redCellCount;
    }

    public void setRedCellCount(int redCellCount) {
        this.redCellCount = redCellCount;
    }

    public int getWhiteCellCount() {
        return whiteCellCount;
    }

    public void setWhiteCellCount(int whiteCellCount) {
        this.whiteCellCount = whiteCellCount;
    }

    public int getPlateletCount() {
        return plateletCount;
    }

    public void setPlateletCount(int plateletCount) {
        this.plateletCount = plateletCount;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
