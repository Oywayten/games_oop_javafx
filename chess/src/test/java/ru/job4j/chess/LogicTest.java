package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void whenMoveFigureNotFoundException()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        Figure[] figures = new Figure[5];
        figures[0] = new BishopBlack(Cell.A1);
        figures[1] = new BishopBlack(Cell.A2);
        figures[2] = new BishopBlack(Cell.A3);
        figures[3] = new BishopBlack(Cell.A4);
        figures[4] = new BishopBlack(Cell.A5);
        for (Figure figure : figures) {
            logic.add(figure);
        }
            logic.move(Cell.A6, Cell.A7);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveImpossibleMoveException()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        Figure[] figures = new Figure[5];
        figures[0] = new BishopBlack(Cell.A1);
        figures[1] = new BishopBlack(Cell.A2);
        figures[2] = new BishopBlack(Cell.A3);
        figures[3] = new BishopBlack(Cell.A4);
        figures[4] = new BishopBlack(Cell.A5);
        for (Figure figure : figures) {
            logic.add(figure);
        }
            logic.move(Cell.A1, Cell.B1);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveOccupiedCellException()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        Figure[] figures = new Figure[5];
        figures[0] = new BishopBlack(Cell.A1);
        figures[1] = new BishopBlack(Cell.A2);
        figures[2] = new BishopBlack(Cell.A3);
        figures[3] = new BishopBlack(Cell.A4);
        figures[4] = new BishopBlack(Cell.C3);
        for (Figure figure : figures) {
            logic.add(figure);
        }
            logic.move(Cell.A1, Cell.C3);
    }
}