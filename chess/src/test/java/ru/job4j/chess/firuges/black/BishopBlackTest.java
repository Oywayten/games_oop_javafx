package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {

    @Test
    public void whenPositionIsA8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        Assert.assertEquals(Cell.A8, bishopBlack.position());
    }

    @Test
    public void whenCopyIsA1() {
        Figure bishopBlack = new BishopBlack(Cell.A8);
        bishopBlack = bishopBlack.copy(Cell.A1);
        Assert.assertEquals(Cell.A1, bishopBlack.position());
    }

    @Test
    public void whenWayC1IsD2E3F4G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] ext = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] res = bishopBlack.way(Cell.G5);
        Assert.assertArrayEquals(ext, res);
    }
}