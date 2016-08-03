package chess;

/**
 * Created by Academy07 on 03/08/2016.
 */
public class Knight extends ChessPiece {
    public Knight(int x, int y) {
        super(x, y);
    }

    @Override
    public String getImage() {
        return "knight.png";
    }
}
