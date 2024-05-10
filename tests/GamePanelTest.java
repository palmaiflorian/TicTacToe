

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class GamePanelTest {

    private GamePanel gamePanel;

    @Before
    void setUp() {
        // Initialize the GamePanel before each test
        gamePanel = new GamePanel(3); // Adjust the board size as needed
    }

    @Test
    void testGamePanelInitialization() {
        // Test that the GamePanel is initialized correctly
        Assert.assertNotNull(gamePanel.getButtons());
        Assert.assertEquals(3, gamePanel.getButtons().length);
        Assert.assertEquals(3, Board.getBoardSize());
    }





}
