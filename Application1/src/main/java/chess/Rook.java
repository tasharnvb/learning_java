package chess;

import javafx.geometry.Point2D;

/**
 * Created by Academy07 on 03/08/2016.
 */
public class Rook extends ChessPiece {

    public Rook() {
    }

    public Rook(int x, int y) {
        super(x, y);
    }

    @Override
    public String getImage() {
        return "rook.png";
    }
}
