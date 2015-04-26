package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String getScore() {
        if (player1Score==player2Score) {
            return equalScores();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return overTime();
        } else {
            return unequalScores();
        }
    }

    private String unequalScores() {
        String score = pointsInStringForm(player1Score);
        score += "-";
        score += pointsInStringForm(player2Score);
        return score;
    }

    private String pointsInStringForm(int score) {
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String overTime() {      
        if (player1Score-player2Score == 1) {
            return "Advantage player1";
        }
        else if (player2Score-player1Score == 1) {
            return "Advantage player2";
        }
        else if (player1Score-player2Score >= 2) {
            return "Win for player1";
        }
        else {
            return "Win for player2";
        }
 
    }

    private String equalScores() {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";  
        }
    }
}