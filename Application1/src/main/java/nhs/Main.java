package nhs;

import java.time.LocalDate;
import java.util.Random;

/**
 * Created by Tasharn on 06/08/2016.
 */
public class Main {
    public static void main(String[] args) {
        Patient[] patients = createPatientArray();
        BloodTest[] bloodTests = createBloodTestArray(patients);
        BloodManager bloodManager = new BloodManager(patients, bloodTests);
//        for (int i = 0; i < patients.length; i++) {
//            System.out.println("Patient " + (i + 1) +":");
//            System.out.println("Name: " + patients[i].getName());
//            System.out.println("NHS Number: " + patients[i].getNhsNumber());
//            System.out.println("Age: " + patients[i].getAge());
//            System.out.println("Address: " + patients[i].getAddress());
//            System.out.println();
//        }
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

    public static Patient[] createPatientArray() {
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
}
