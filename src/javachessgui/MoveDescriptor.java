package javachessgui;


public class MoveDescriptor {

    public int to_i;
    public int to_j;

    public Boolean end_piece;
    public Boolean castling;
    public Boolean promotion;
    public int next_vector;
    char prom_piece;

    public MoveDescriptor() {
        end_piece = false;
        castling = false;
        promotion = false;
        prom_piece = ' ';
    }
}
