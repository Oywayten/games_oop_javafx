package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        int size = Math.abs(position.getX() - dest.getX());
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position.getX();
        int deltaY = dest.getY() - position.getY();
        for (int index = 0; index < size; index++) {
                int x = position.getX() + deltaX / Math.abs(deltaX) * (index + 1);
                int y = position.getY() + deltaY / Math.abs(deltaY) * (index + 1);
            steps[index] = Cell.findBy(x, y);
        }
            return steps;

    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = Math.abs(source.getX() - dest.getX());
        int deltaY = Math.abs(source.getY() - dest.getY());
        return deltaX == deltaY && deltaX != 0;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
