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
        position = new Point2D(x, y);
    }

    public abstract String getImage();
}
