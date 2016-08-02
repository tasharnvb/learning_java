package transport;

/**
 * Created by Academy07 on 02/08/2016.
 */
public class Car {
    private int speed;
    private int gear;

    public Car() {

    }

    public Car(int speed, int gear) {
        this.speed = speed;
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }
}

