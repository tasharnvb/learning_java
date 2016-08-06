package entity;

import nhs.Patient;

import java.util.Collection;

/**
 * Created by Tasharn on 06/08/2016.
 */
public class BloodManager {
    private Collection<Patient> patients;
    private Collection<BloodTest> bloodTests;

    public int addBloodTest(BloodTest bloodTest) {
        return 0;
    }

    public int addPatient(Patient patient) {
        return 0;
    }

    public Collection<Patient> selectAllPatients() {
        return null;
    }

    public Collection<String> search(int redBloodCellCount, int numberOfDays) {
        return null;
    }

    public Patient selectPatientByNhsNumber(String nhsNumber) {
        return null;
    }
}
