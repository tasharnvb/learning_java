package chess;

import javafx.geometry.Point2D;

/**
 * Created by Academy07 on 03/08/2016.
 */
public abstract class ChessPiece {
    protected Point2D position;

    public ChessPiece() {
    }

    public ChessPiece(int x, int y) {
        if (x < 0 || y < 0 || x > 7 || y > 7) {
            throw new IndexOutOfBoundsException("This position is not on the board");
        }
        position = new Point2D(x, y);
    }

    public abstract String getImage();

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ChessPiece ? position.equals(((ChessPiece)obj).position) : false;
    }

    @Override
    public int hashCode() {
        // Two Point2D objects that have the same x and y values will have the same hash code
        return position.hashCode();
    }
}
