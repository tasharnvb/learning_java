package nhs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

/**
 * Created by Tasharn on 06/08/2016.
 */
public class Main {
    public static void main(String[] args) {
        Patient[] patientsArr = createPatientArray();
//        printPatientArray(patientsArr);
        BloodTest[] bloodTestsArr = createBloodTestArray(patientsArr);
//        printBloodTestArray(bloodTestsArr);
        ArrayList<Patient> patientsArrList = new ArrayList<>(Arrays.asList(patientsArr));
        ArrayList<BloodTest> bloodTestArrList = new ArrayList<>(Arrays.asList(bloodTestsArr));
        BloodManager bloodManager = new BloodManager(patientsArrList, bloodTestArrList);

        bloodManager.addBloodTest(new BloodTest());
        bloodManager.addPatient(new Patient());

        Collection<Patient> patientsCol = bloodManager.selectAllPatients();
        printPatientArray(patientsCol.toArray(new Patient[patientsCol.size()])); // http://stackoverflow.com/a/3293970

        Collection<String> patientsSearchCol = bloodManager.search(100, 40);
        for (String patient : patientsSearchCol) {
            System.out.println(patient);
        }

        Patient foundPatient = bloodManager.selectPatientByNhsNumber("0123456789");
        System.out.println(foundPatient.getName());
        System.out.println(foundPatient.getNhsNumber());
    }

    private static Patient[] createPatientArray() {
        Random r = new Random();
        LocalDate today = LocalDate.now();
        // The date for the patient is today's date minus a random number of days between 0 and 100
        Patient patient1 = new Patient("Hello World", "123456789", 50, "123 foobar road, foo, bar, FB1 2OA", today.minusDays(r.nextInt(101)), BloodType.A);
        Patient patient2 = new Patient("test testing", "987654321", 20, "213 hello road, world, hello, HW1 2EO", today.minusDays(r.nextInt(101)), BloodType.B);
        Patient patient3 = new Patient("Dani California", "0123456789", 10, "00 Graveyard lane, Mississippi, US, 1ID 2KX", today.minusDays(r.nextInt(101)), BloodType.O);
        Patient patient4 = new Patient();

        Patient[] patients = new Patient[4];
        patients[0] = patient1;
        patients[1] = patient2;
        patients[2] = patient3;
        patients[3] = patient4;

        return patients;
    }

    private static BloodTest[] createBloodTestArray(Patient[] patients) {
        BloodTest[] bloodTestArray = new BloodTest[patients.length];
        Random r = new Random();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < patients.length; i++) {
            BloodTest bloodTest = new BloodTest(r.nextInt(101), r.nextInt(101), r.nextInt(101), patients[i], today.minusDays(r.nextInt(101)), i + 1);
            bloodTestArray[i] = bloodTest;
        }
        return bloodTestArray;
    }

    private static void printPatientArray(Patient[] patients) {
        for (int i = 0; i < patients.length; i++) {
            System.out.println("Patient " + (i + 1) + ":");
            System.out.println("Name: " + patients[i].getName());
            System.out.println("NHS Number: " + patients[i].getNhsNumber());
            System.out.println("Age: " + patients[i].getAge());
            System.out.println("Address: " + patients[i].getAddress());
            System.out.println("DOB: " + patients[i].getDateOfBirth());
            System.out.println("Blood Type: " + patients[i].getBloodType());
            System.out.println();
        }
    }

    private static void printBloodTestArray(BloodTest[] bloodTests) {
        for (int i = 0; i < bloodTests.length; i++) {
            System.out.println("Blood Test " + bloodTests[i].getId() + ":");
            System.out.println("Patient: " + bloodTests[i].getPatient().getName());
            System.out.println("Test Date: " + bloodTests[i].getTestDate());
            System.out.println("Red Blood Cells: " + bloodTests[i].getRedCellCount());
            System.out.println("White Blood Cells: " + bloodTests[i].getWhiteCellCount());
            System.out.println("Platelet: " + bloodTests[i].getPlateletCount());
            System.out.println();
        }
    }
}
