package nhs;

import java.util.Collection;

/**
 * Created by Academy07 on 08/08/2016.
 */
public interface IBloodManager {
    int addBloodTest(BloodTest bloodTest);

    int addPatient(Patient patient);

    Collection<Patient> selectAllPatients();

    Collection<String> search(int redBloodCellCount, int numberOfDays);

    Patient selectPatientByNhsNumber(String nhsNumber);
}
