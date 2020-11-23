package ohtu;

public class TennisGame {

    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;
    private String firstPlayerName;
    private String secondPlayerName;

    public TennisGame(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            firstPlayerScore += 1;
        } else {
            secondPlayerScore += 1;
        }
    }

    public String getScore() {
        boolean isTie = (firstPlayerScore == secondPlayerScore);
        int maxScore = Math.max(firstPlayerScore, secondPlayerScore);
        if (isTie) {
            return this.handleTie(firstPlayerScore);
        } else if (maxScore < 4) {
            return this.nameForPoint(firstPlayerScore) + "-" + this.nameForPoint(secondPlayerScore);
        } else {
            return this.handleScoreOverFour();
        }
    }

    public String handleTie(int score) {
        if (score < 4) {
            return this.nameForPoint(score) + "-All";
        } else {
            return this.nameForPoint(score);
        }
    }

    public String handleAdvantage() {
        if (firstPlayerScore > secondPlayerScore) {
            return "Advantage player1";
        } else {
            return "Advantage player2";
        }
    }

    public String handleVictory() {
        if (firstPlayerScore > secondPlayerScore) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public String handleScoreOverFour() {
        int scoreDifference = firstPlayerScore - secondPlayerScore;
        boolean isAdvantage = (Math.abs(scoreDifference) == 1);
        if (isAdvantage) {
            return this.handleAdvantage();
        } else {
            return this.handleVictory();
        }
    }

    public String nameForPoint(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }

}
