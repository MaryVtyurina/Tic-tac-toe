/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maria
 */
public class TicTacToe {
    
    private final JabberServer player1;
    private final JabberServer player2;
    private JabberServer turn;

    JabberServer[][] players_field = new JabberServer[3][3];
    
    TicTacToe(JabberServer pl1, JabberServer pl2){
        player1 = pl1;
        player2 = pl2;
        turn = pl1;
    }
    
    public void startGame()
    {
        for (int i = 0; i < players_field.length; i++)
            for (int j = 0; j < players_field.length; j++)
                players_field[i][j] = null;
        player1.out.println("#GAME#START");
        player2.out.println("#GAME#START");
    }
    
    JabberServer gameResult()
    {
//        int[][] num_field = new int [3][3];
//        for (int i = 0; i < num_field.length; i++)
//        {
//            for (int j = 0; j < num_field.length; j++)
//            {
//                if (players_field[i][j] == player1) {num_field[i][j] = 1;}
//                else if (players_field[i][j] == player2) {num_field[i][j] = -1;}
//                else num_field[i][j] = 0;
//                
//                
//            }            
//        }
//        System.out.println(num_field);
//        int horizontal = 0;
//        int vertical = 0;
//        int diagonal1 = 0;
//        int diagonal2 = 0;
//        for (int i = 0; i < num_field.length; i++)
//        {
//            diagonal1 += num_field[i][i];
//            diagonal2 += num_field[num_field.length-i-1][i];
//            for (int j = 0; j < num_field.length; j++)
//            {
//                horizontal += num_field[i][j];
//                vertical += num_field[j][i];
//                if ((horizontal == num_field.length) || (vertical == num_field.length))
//                    return player1;
//                if ((horizontal == -num_field.length) || (vertical == -num_field.length))
//                    return player2;
//            }            
//        }
//        if ((diagonal1 == num_field.length) || (diagonal2 == num_field.length))
//            return player1;
//        if ((diagonal1 == -num_field.length) || (diagonal2 == -num_field.length))
//            return player2;
//        return null;
        if ( 
            (players_field[0][0]==player1 && players_field[0][1]==player1 && players_field[0][2]==player1) ||
            (players_field[1][0]==player1 && players_field[1][1]==player1 && players_field[1][2]==player1) ||
            (players_field[2][0]==player1 && players_field[2][1]==player1 && players_field[2][2]==player1) ||
            (players_field[0][0]==player1 && players_field[1][0]==player1 && players_field[2][0]==player1) ||
            (players_field[0][1]==player1 && players_field[1][1]==player1 && players_field[2][1]==player1) ||
            (players_field[0][2]==player1 && players_field[1][2]==player1 && players_field[2][2]==player1) ||
            (players_field[0][0]==player1 && players_field[1][1]==player1 && players_field[2][2]==player1) ||
            (players_field[0][2]==player1 && players_field[1][1]==player1 && players_field[2][0]==player1)
           ) return player1;
        if ( 
            (players_field[0][0]==player2 && players_field[0][1]==player2 && players_field[0][2]==player2) ||
            (players_field[1][0]==player2 && players_field[1][1]==player2 && players_field[1][2]==player2) ||
            (players_field[2][0]==player2 && players_field[2][1]==player2 && players_field[2][2]==player2) ||
            (players_field[0][0]==player2 && players_field[1][0]==player2 && players_field[2][0]==player2) ||
            (players_field[0][1]==player2 && players_field[1][1]==player2 && players_field[2][1]==player2) ||
            (players_field[0][2]==player2 && players_field[1][2]==player2 && players_field[2][2]==player2) ||
            (players_field[0][0]==player2 && players_field[1][1]==player2 && players_field[2][2]==player2) ||
            (players_field[0][2]==player2 && players_field[1][1]==player2 && players_field[2][0]==player2)
           ) return player2;
        return null;
    }
    
    public void parse(JabberServer player, String message) {
        String[] string = message.split("#");
        if (string[1].equals("MOVE") && player == turn) {
            int x = Integer.valueOf(string[2]) - 1;
            int y = Integer.valueOf(string[3]) - 1;
            if (players_field[x][y] == null) {
                players_field[x][y] = turn;
                if (turn == player1) {
                    player1.out.println("GAME#MOVE#X#"+string[2]+"#"+string[3]);
                    player2.out.println("GAME#MOVE#X#"+string[2]+"#"+string[3]);
                    turn = player2;
                }
                else {
                    player1.out.println("GAME#MOVE#O#"+string[2]+"#"+string[3]);
                    player2.out.println("GAME#MOVE#O#"+string[2]+"#"+string[3]);
                    turn = player1;
                }
                JabberServer victory = gameResult();
                if (victory == player1) {
                    player1.out.println("GAME#VICTORY#X");
                    player2.out.println("GAME#VICTORY#X");
//                    startGame();
                }
                if (victory == player2) {
                    player1.out.println("GAME#VICTORY#O");
                    player2.out.println("GAME#VICTORY#O");
//                    startGame();
                }
            }
        }
        if (string[1].equals("END")) {
            player1.out.println("GAME#END");
            player2.out.println("GAME#END");
        }
        if (string[1].equals("START")) {
            startGame();
        }
    }
    
}
//TODO
// сервер с thread
//создаем матрицу в player.java и на сервере. 
//По нажатию кнопки присваиваем соответствующей ячейке матрицы значение Кнопка нажата
//отправляем на сервер, сервер знает, от кого отправлено значение, заполняет у себя матрицу 
//и отправляет другому игроку, у которого матрица тоже заполняется + отрисовывается на игровом поле
//+ проверка игровой логики на сервере (кто выиграл)