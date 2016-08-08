package nhs;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Academy07 on 08/08/2016.
 */
public class BloodManagerTest {

    //arrange
    BloodManager bloodManager = new BloodManager();

    Patient patient1 = new Patient("Hello World", "N100", 50, "123 foobar road, foo, bar, FB1 2OA", LocalDate.of(1954, 1, 16), BloodType.A);
    Patient patient2 = new Patient("Foo Bar", "N101", 50, "123 foobar road, foo, bar, FB1 2OA", LocalDate.of(1954, 1, 16), BloodType.A);

    BloodTest bloodTest1 = new BloodTest(100, 50, 10, patient1, LocalDate.of(2016, 1, 25), 1);
    BloodTest bloodTest2 = new BloodTest(200, 50, 10, patient2, LocalDate.of(2016, 4, 25), 2);
    BloodTest bloodTest3 = new BloodTest(300, 50, 10, patient1, LocalDate.of(2016, 6, 25), 3);
    BloodTest bloodTest4 = new BloodTest(400, 50, 10, patient2, LocalDate.of(2016, 7, 25), 4);

    @org.junit.Before
    public void initialize() {
        bloodManager.addBloodTest(bloodTest1);
        bloodManager.addBloodTest(bloodTest2);
        bloodManager.addBloodTest(bloodTest3);
        bloodManager.addBloodTest(bloodTest4);
    }

    @Test
    public void searchShouldReturnMatchingPatientName() {
        //act
        Collection<String> patientNames = bloodManager.search(500, 30);

        //assert
        assertTrue(patientNames.stream().findFirst().get().equals("Test Id: 4, Patient: Foo Bar"));
        assertEquals(1, patientNames.size());
    }

    @Test
    public void searchShouldReturnMatchingPatientNames() {
        //act
        Collection<String> patientNames = bloodManager.search(500, 50);

        //assert
        assertTrue(patientNames.stream().findAny().get().equals("Test Id: 3, Patient: Hello World"));
        assertEquals(2, patientNames.size());
    }
}
