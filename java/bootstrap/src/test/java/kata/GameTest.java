package kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameTest {

    public static final char NO_WINNER = '_';
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void empty_board() {
        assertThat(game.toString()).isEqualTo("___\n___\n___\n");
        assertThat(game.winner()).isEqualTo(NO_WINNER);
        assertThat(game.turn()).isEqualTo('X');
    }

    @Test
    void place_token() {
        game.placeToken(1, 1);
        assertThat(game.toString()).isEqualTo("X__\n___\n___\n");
        assertThat(game.turn()).isEqualTo('O');
        game.placeToken(1, 2);
        assertThat(game.toString()).isEqualTo("XO_\n___\n___\n");
        assertThat(game.turn()).isEqualTo('X');
    }

    @Test
    void cannot_place_token_at_already_taken_cell() {
        game.placeToken(1, 1);
        game.placeToken(1, 1);
        assertThat(game.toString()).isEqualTo("X__\n___\n___\n");
        assertThat(game.turn()).isEqualTo('O');
    }

    @Test
    void wins_when_same_token_on_horizontal_line() {
        game.placeToken(1, 1);
        game.placeToken(2, 1);
        game.placeToken(1, 2);
        game.placeToken(2, 2);
        assertThat(game.winner()).isEqualTo(NO_WINNER);
        game.placeToken(1, 3);
        assertThat(game.toString()).isEqualTo("XXX\nOO_\n___\n");
        assertThat(game.winner()).isEqualTo('X');
    }

    @Test
    void wins_when_same_token_on_horizontal_line_O() {
        game.placeToken(2, 1);
        game.placeToken(1, 1);
        game.placeToken(2, 2);
        game.placeToken(1, 2);
        game.placeToken(3, 3);
        assertThat(game.winner()).isEqualTo(NO_WINNER);
        game.placeToken(1, 3);
        assertThat(game.toString()).isEqualTo("OOO\nXX_\n__X\n");
        assertThat(game.winner()).isEqualTo('O');
    }
}
