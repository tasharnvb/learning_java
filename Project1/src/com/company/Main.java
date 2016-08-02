package com.company;

import transport.Car;

import java.time.DayOfWeek;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        int factorial = Maths.factorialFinder(6);
//        System.out.println("6! = " + factorial);
//
//        int probability = Maths.binomialProbability(10, 4);
//        System.out.println("10 cards, combination of 4 cards = " + probability);
//
//        int[] sequence = fibonacci(10);
//        System.out.print("Fibonacci: ");
//        for (int num:sequence) {
//            System.out.print(" " + num);
//        }
//        System.out.println();
//
//        Car[] cars = generateArray(10, 70, 6);
//        System.out.println("Cars: ");
//        for (Car car:cars) {
//            System.out.println("Car: " + car + ", Speed: " + car.getSpeed() + ", Gear: " + car.getGear());
//        }

        String from = "tbrown@spartaglobal.com", to = "foo@bar.com", message = "Hello World!";
        Email email = new Email(from, to, message);
        System.out.println("From: " + email.getFrom() + "\nTo: " + email.getTo() + "\nMessage: " + "\n" + email.getMessage() + "\nNumber of chars: " + email.charactersInMessage());
//        System.out.println("To: " + email.getTo());
//        System.out.println("Message: " + "\n" + email.getMessage());
//        System.out.println("Number of chars: " + email.charactersInMessage());
    }

    private static Car[] generateArray(int count, int maxSpeed, int maxGear) {
        Car[] cars = new Car[count];
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int speed = rand.nextInt(maxSpeed) + 1;
            int gear = rand.nextInt(maxGear + 1);
            Car car = new Car(speed, gear);
            cars[i] = car;
        }
        return cars;
    }

    private static int[] fibonacci(int num) {
        int[] sequence = new int[num];

        int x = 0;
        int y = 1;
        int z;
        for (int i = 0; i < num; i++) {
            sequence[i] = x;
            z = x + y;
            x = y;
            y = z;
        }
        return sequence;
    }
}
