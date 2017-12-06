package gameofcraps;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CrapsGameWinSequencesTest {

    @Parameters
    public static Collection<SequencedDice> data() {
        return Arrays.asList(
                new SequencedDice(4, 4),
                new SequencedDice(4, 5, 4),
                new SequencedDice(4, 5, 6, 4),
                new SequencedDice(10, 10),
                new SequencedDice(10, 9, 10),
                new SequencedDice(10, 9, 5, 10),
                new SequencedDice(10, 9, 5, 9, 10),
                new SequencedDice(4, 2, 4),
                new SequencedDice(4, 3, 4),
                new SequencedDice(4, 12, 4),
                new SequencedDice(4, 5, 6, 8, 9, 10, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8,
                        9, 5, 6, 8, 9, 5, 6, 8, 9, 5, 6, 8, 9, 4));
    }

    @Parameterized.Parameter
    public SequencedDice sequenceDice;

    @Test
    public void RunSequenceWinTests() {
        CrapsGame game = new CrapsGame(sequenceDice);
        game.play();
        assertTrue(game.getWin());
    }

}