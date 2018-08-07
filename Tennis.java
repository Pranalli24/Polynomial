import java.lang.*;
public class Tennis {

    Player A = new Player();
    Player B= new Player();
    int index;
    String inp;

    Tennis(String inp) {
        this.inp = inp;
        index=0;
    }
    private void resetPoint(){
        A.score = 0;
        B.score = 0;
    }

    private void resetGame(){
        A.games = 0;
        B.games = 0;
    }
    public void gameWinner() {
        int difference = A.score - B.score;
        if(A.score >= 4 || B.score >= 4) {
            if(difference >= 2) {
                resetPoint();
                A.games++;
            }
            else if(difference <= -2) {
                resetPoint();
                B.games++;
            }
            setWinner();
        }
    }
    private void setWinner()
    {
        int difference = A.games - B.games;
        if(A.games >= 6 || B.games >= 6) {
            if(difference >= 2) {
                resetGame();
                A.sets++;
            }
            else if(difference <= -2) {
                resetGame();
                B.sets++;
            }
        }
    }
    public void printScore(){
        System.out.println("Player: A  B");
        System.out.println("sets:   "+ A.sets+" " + B.sets);
        System.out.println("games:  " + A.games +" "+ B.games);
        String marks[] = {"0","15","30","40","AD"};
        String a = marks[A.score];
        String b = marks[B.score];
        if(a.equals("AD"))
            b=" ";
        else if(b.equals("AD"))
            a=" ";
        System.out.println("points: " +a+" "+b );

    }
    private void rally() {
        while(index < inp.length()) {
            if(inp.charAt(index) == 'A'){
                if( A.score == 3 && B.score == 4)
                    B.score--;
                else
                    A.score++;
                index++;
            }
            else if(inp.charAt(index) == 'B')
            {
                if (B.score == 3 && A.score == 4)
                    A.score--;
                else
                    B.score++;
                index++;
            }
            gameWinner();
        }
        printScore();
    }

    public static void main(String args[])
    {
        Tennis T = new Tennis("AAAA");
        T.rally();
    }
}
