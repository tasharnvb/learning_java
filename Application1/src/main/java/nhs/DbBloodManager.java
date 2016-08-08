package nhs;

import java.util.Collection;

/**
 * Created by Academy07 on 08/08/2016.
 */
public class DbBloodManager implements IBloodManager {
    @Override
    public int addBloodTest(BloodTest bloodTest) {
        return 0;
    }

    @Override
    public int addPatient(Patient patient) {
        return 0;
    }

    @Override
    public Collection<Patient> selectAllPatients() {
        return null;
    }

    @Override
    public Collection<String> search(int redBloodCellCount, int numberOfDays) {
        return null;
    }

    @Override
    public Patient selectPatientByNhsNumber(String nhsNumber) {
        return null;
    }
}
