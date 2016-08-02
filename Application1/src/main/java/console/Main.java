package console;

import nhs.Patient;

/**
 * Created by Academy07 on 02/08/2016.
 * Console application
 */
public class Main {
    /**
     * Start point of the application
     * @param args command line arguments
     */
    public static void main(String[] args) {
//        System.out.println("Hello World!");

        Patient[] patients = createPatientArray();
        for (int i = 0; i < patients.length; i++) {
            System.out.println("Patient " + (i + 1) +":");
            System.out.println("Name: " + patients[i].getName());
            System.out.println("NHS Number: " + patients[i].getNhsNumber());
            System.out.println("Age: " + patients[i].getAge());
            System.out.println("Address: " + patients[i].getAddress());
            System.out.println();
        }
    }

    public static Patient[] createPatientArray() {
        Patient patient1 = new Patient("Hello World", "123456789", 50, "123 foobar road, foo, bar, FB1 2OA");
        Patient patient2 = new Patient("test testing", "987654321", 20, "213 hello road, world, hello, HW1 2EO");
        Patient patient3 = new Patient("Dani California", "0123456789", 10, "00 Graveyard lane, Mississippi, US, 1ID 2KX");
        Patient patient4 = new Patient();

        Patient[] patients = new Patient[4];
        patients[0] = patient1;
        patients[1] = patient2;
        patients[2] = patient3;
        patients[3] = patient4;

        return patients;
    }
}
