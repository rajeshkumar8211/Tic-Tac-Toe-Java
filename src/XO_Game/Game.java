package XO_Game;

import java.util.Scanner;

public class Game {
    final char user1,user2;
    Game(char user1,char user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
    static char [][] xo=new char[3][3];
    static Scanner sc=new Scanner(System.in);
    public static void start(){
        Game sg=new Game('X','O');
        System.out.println("User 1 is X");
        System.out.println("User 2 is O");
        System.out.println("Positon Of The Game");
        for(int i=1;i<=9;i++){
            System.out.print(" " +i);
            if (i%3==0){
                System.out.println();
            }
        }
        XO(sg.user1, sg.user2);
    }
    public static boolean setval(int val, char[][] xo, char c) {
        if (val < 1 || val > 9) {
            System.out.println("Invalid Position");
            return false;
        }
        int row = (val - 1) / 3;
        int col = (val - 1) % 3;
        if (xo[row][col] != '\0') {
            System.out.println("Position already occupied");
            return false;
        }
        xo[row][col] = c;
        return true;
    }
    public static boolean checkWinner(char player){
        for(int i=0;i<3;i++){
            if(xo[i][0]==player && xo[i][1]==player && xo[i][2]==player)
                return true;
            if(xo[0][i]==player && xo[1][i]==player && xo[2][i]==player)
                return true;
        }
        if(xo[0][0]==player && xo[1][1]==player && xo[2][2]==player)
            return true;
        if(xo[0][2]==player && xo[1][1]==player && xo[2][0]==player)
            return true;
        return false;
    }
    public static void XO(char u1, char u2){
        int move = 1;
        while(move <= 9){
            char currentPlayer = (move % 2 == 1) ? u1 : u2;
            System.out.println("User " + ((move % 2 == 1) ? 1 : 2)
                    + " Turn. Enter Position:");
            int pos = sc.nextInt();
            if(!setval(pos, xo, currentPlayer)){
                continue;
            }
            print();
            if(move >= 5){
                if(checkWinner(currentPlayer)){
                    System.out.println(currentPlayer + " Wins the Game");
                    return;
                }
            }
            move++;
        }
        System.out.println("Match Draw");
    }
    public static void print(){
        System.out.println();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char ch = xo[i][j];
                if(ch == '\0')
                    System.out.print("   ");
                else
                    System.out.print(" " + ch + " ");
                if(j<2)
                    System.out.print("|");
            }
            System.out.println();
            if(i<2)
                System.out.println("-----------");
        }
        System.out.println();
    }
    public static void main(String[] args){
        char st;
        System.out.println("You want to start the game");
        st=sc.next().toUpperCase().charAt(0);
        if(st=='Y'){
            Game.start();
        }
        else{
            System.exit(0);
        }
    }
}
