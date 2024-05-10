import java.awt.*;
import java.util.Random;

public class AI {
    private static char AIplayer;

    public void setAIPlayer(char a){
        AIplayer=a;
    }
    public char getAIPlayer(){
        return AIplayer;
    }
    public void aiMove(){
        random();
    }
    public void beginner() {
        function: if(GameRules.getCurrentPlayer()==AIplayer) {
            for(int i=0;i<Board.getBoardSize();i++) {
                for(int j=0;j<Board.getBoardSize();j++) {
                    String buttonText = GamePanel.getButtons()[i][j].getText();
                    if(buttonText.isEmpty()) {
                        GamePanel.getButtons()[i][j].setText(String.valueOf(AIplayer));
                        if (GameRules.getCurrentPlayer() == 'X') {
                            GamePanel.getButtons()[i][j].setForeground(Color.RED);
                        } else if (GameRules.getCurrentPlayer() == 'O') {
                            GamePanel.getButtons()[i][j].setForeground(Color.GREEN);
                        }
                        GameRules.changeCurrentPlayer();
                        break function;
                    }

                }

            }
        }

    }
    public void random(){
        if(GameRules.getCurrentPlayer()==AIplayer) {
            Random random = new Random();
            int randomRow = random.nextInt(Board.getBoardSize()-1 );
            int randomCol = random.nextInt(Board.getBoardSize()-1 );
            while (!GamePanel.getButtons()[randomRow][randomCol].getText().isEmpty()) {
                 randomRow = random.nextInt(Board.getBoardSize() );
                 randomCol = random.nextInt(Board.getBoardSize() );
            }
            GamePanel.getButtons()[randomRow][randomCol].setText(String.valueOf(AIplayer));
            GamePanel.getButtons()[randomRow][randomCol].setForeground((AIplayer == 'X') ? Color.RED : Color.GREEN);
            GameRules.changeCurrentPlayer();

        }
    }

}



