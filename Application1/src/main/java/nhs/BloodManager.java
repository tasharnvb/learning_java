package nhs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Tasharn on 06/08/2016.
 */
public class BloodManager implements IBloodManager {
    private ArrayList<Patient> patients;
    private ArrayList<BloodTest> bloodTests;

    public BloodManager() {
        patients = new ArrayList<Patient>();
        bloodTests = new ArrayList<BloodTest>();
    }

    /**
     * @param patients   A list of patients
     * @param bloodTests A list of blood tests
     */
    public BloodManager(ArrayList<Patient> patients, ArrayList<BloodTest> bloodTests) {
        this.patients = patients;
        this.bloodTests = bloodTests;
    }

    @Override
    public int addBloodTest(BloodTest bloodTest) {
        // Returns 1 if the blood test was successfully added and 0 if not
        return bloodTests.add(bloodTest) ? 1 : 0;
    }

    @Override
    public void addPatient(Patient patient) {
        // Returns 1 if the patient was successfully added and 0 if not
        patients.add(patient);
    }

    @Override
    public Collection<Patient> selectAllPatients() {
        return patients;
    }

    @Override
    public Collection<String> search(int redBloodCellCount, int numberOfDays) {
        LocalDate givenDate = LocalDate.now().minusDays(numberOfDays);
        Collection<BloodTest> filteredBloodTests;
        // Returns a collection of blood tests where the red blood cell count was lower than the one given to this method
//        filteredBloodTests = bloodTests.stream().filter(bloodTest -> bloodTest.getRedCellCount() < redBloodCellCount).collect(Collectors.toList());
        // Returns a collection of blood tests where the date of the test was the same as or after the given date
//        filteredBloodTests = filteredBloodTests.stream().filter(bloodTest -> bloodTest.getTestDate().isEqual(givenDate) || bloodTest.getTestDate().isAfter(givenDate)).collect(Collectors.toList());
        // Combines both of the above into one
        filteredBloodTests = bloodTests.stream().filter(bloodTest -> (bloodTest.getRedCellCount() < redBloodCellCount) && (bloodTest.getTestDate().isEqual(givenDate) || bloodTest.getTestDate().isAfter(givenDate))).collect(Collectors.toList());
        ArrayList<String> filteredBloodTestsStrings = new ArrayList<String>();
        for (BloodTest bloodTest : filteredBloodTests) {
            filteredBloodTestsStrings.add("Test Id: " + Integer.toString(bloodTest.getId()) + ", Patient: " + bloodTest.getPatient().getName());
        }
        return filteredBloodTestsStrings;
    }

    @Override
    public Patient selectPatientByNhsNumber(String nhsNumber) {
        Optional<Patient> foundPatient = patients.stream().filter(patient -> patient.getNhsNumber().equals(nhsNumber)).findFirst();
        return foundPatient.isPresent() ? foundPatient.get() : null;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public Collection<BloodTest> getBloodTests() {
        return bloodTests;
    }

    public void setBloodTests(ArrayList<BloodTest> bloodTests) {
        this.bloodTests = bloodTests;
    }
}
