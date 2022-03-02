package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test
    public void whenMoveFigureNotFoundException()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        Figure[] figures = new Figure[5];
        figures[0] = new BishopBlack(Cell.A1);
        figures[1] = new BishopBlack(Cell.A2);
        figures[2] = new BishopBlack(Cell.A3);
        figures[3] = new BishopBlack(Cell.A4);
        figures[4] = new BishopBlack(Cell.A5);
        for (int i = 0; i < figures.length; i++) {
            logic.add(figures[i]);
        }
        try {
            logic.move(Cell.A6, Cell.A7);
        } catch (FigureNotFoundException e) {
            Assert.assertEquals(
                    "ru.job4j.chess.FigureNotFoundException",
                    e.toString());
        }
    }

    @Test
    public void whenMoveImpossibleMoveException()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        Figure[] figures = new Figure[5];
        figures[0] = new BishopBlack(Cell.A1);
        figures[1] = new BishopBlack(Cell.A2);
        figures[2] = new BishopBlack(Cell.A3);
        figures[3] = new BishopBlack(Cell.A4);
        figures[4] = new BishopBlack(Cell.A5);
        for (int i = 0; i < figures.length; i++) {
            logic.add(figures[i]);
        }
        try {
            logic.move(Cell.A1, Cell.B1);
        } catch (ImpossibleMoveException e) {
            Assert.assertEquals(
                    "ru.job4j.chess.ImpossibleMoveException: "
                            + "Could not way by diagonal from A1 to B1",
                    e.toString());
        }
    }

    @Test
    public void whenMoveOccupiedCellException()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        Figure[] figures = new Figure[5];
        figures[0] = new BishopBlack(Cell.A1);
        figures[1] = new BishopBlack(Cell.A2);
        figures[2] = new BishopBlack(Cell.A3);
        figures[3] = new BishopBlack(Cell.A4);
        figures[4] = new BishopBlack(Cell.C3);
        for (int i = 0; i < figures.length; i++) {
            logic.add(figures[i]);
        }
        try {
            logic.move(Cell.A1, Cell.C3);
        } catch (OccupiedCellException e) {
            Assert.assertEquals(
                    "ru.job4j.chess.OccupiedCellException",
                    e.toString());
        }
    }
}