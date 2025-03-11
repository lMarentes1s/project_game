package Interface;
import java.util.List;
import Game.GameTable;
import Pieces.Pieces;


public interface SortingAlgorithm {
   void sort(List<Pieces> pieces, GameTable gameTable);
}
