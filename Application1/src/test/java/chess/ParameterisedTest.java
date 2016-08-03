package chess;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Academy07 on 03/08/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class ParameterisedTest {
    @Test(expected=IndexOutOfBoundsException.class)
    @Parameters({"0, 8", "8, 0", "-1, 0", "0, -1"})
    public void chessPieceConstructorThrowsExceptionIfNotOnBoard(int x, int y) {
        new Rook(x, y);
    }
}
