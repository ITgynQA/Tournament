import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    Player ivan = new Player(1, "Иван", 100);
    Player max = new Player(2, "Макс", 150);
    Player alex = new Player(2, "Алекс", 150);

    @Test
    public void testFirstPlayerStronger() {
        Game game = new Game();

        game.register(ivan);
        game.register(alex);

        int expected = 1;
        int actual = game.round("Алекс", "Иван");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSecondPlayerStronger() {
        Game game = new Game();

        game.register(ivan);
        game.register(alex);

        int expected = 2;
        int actual = game.round("Иван", "Алекс");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testEquallyStrong() {
        Game game = new Game();

        game.register(max);
        game.register(alex);

        int expected = 0;
        int actual = game.round("Алекс", "Макс");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayerNotExist() {
        Game game = new Game();

        game.register(ivan);
        game.register(alex);

        assertThrows(NotRegisteredException.class,
                () -> game.round("Федя", "Алекс")
        );
    }

    @Test
    public void testSecondPlayerNotExist() {
        Game game = new Game();

        game.register(max);
        game.register(alex);

        assertThrows(NotRegisteredException.class,
                () -> game.round("Макс", "Вася")
        );
    }

    @Test
    public void testBothPlayersNotExist() {
        Game game = new Game();

        game.register(ivan);
        game.register(alex);

        assertThrows(NotRegisteredException.class,
                () -> game.round("Федя", "Вася")
        );
    }
}
