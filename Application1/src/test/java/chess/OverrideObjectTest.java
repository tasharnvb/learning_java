package chess;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Academy07 on 03/08/2016.
 */
public class OverrideObjectTest {
    @Test
    public void referenceEquality() {
        //arrange
        Rook rook1 = new Rook(1, 2);
        Rook rook2 = rook1;

        //assert
        assertTrue(rook1.equals(rook2));
    }

    @Test
    public void valueEquality() {
        //arrange
        Rook rook1 = new Rook(1, 2);
        Rook rook2 = new Rook(1, 2);

        //assert
        assertTrue(rook1.equals(rook2));
    }

    @Test
    public void equalHashcodes() {
        //arrange
        Rook rook1 = new Rook(1, 2);
        Rook rook2 = new Rook(1, 2);

        //act
        int i = rook1.hashCode();
        int j = rook2.hashCode();

        //assert
        assertTrue(i==j);//only true if hashCode overridden
    }
}