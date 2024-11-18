package com.codegym;

public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTEEN = 2;
    public static final int THIRTY = THIRTEEN;
    public static final int FOURTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return GetEqualScore(player1Score);
        } if (player1Score >= 4 || player2Score >= 4) {
            return getAdvantageOrWinScore(player1Score, player2Score);
        }
        return getNormalScore(player1Score, player2Score);
    }

    private static String getNormalScore(int player1Score, int player2Score) {
        return getScoreDescription(player1Score) + "-" + getScoreDescription(player2Score);
    }

    private static String getScoreDescription(int score) {
        return switch (score) {
            case LOVE -> "Love";
            case FIFTEEN -> "Fifteen";
            case THIRTY -> "Thirty";
            case FOURTY -> "Forty";
            default ->  throw new IllegalArgumentException("Invalid score: " + score);
        };
    }

    private static String getAdvantageOrWinScore(int player1Score, int player2Score) {
        int scoreDifference = player1Score - player2Score;

        if (scoreDifference == 1) {
            return "Advantage player1";
        } else if (scoreDifference == -1) {
            return "Advantage player2";
        } else if (scoreDifference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private static String GetEqualScore(int score) {
        return switch (score) {
            case LOVE -> "Love-All";
            case FIFTEEN -> "Fifteen-All";
            case THIRTY -> "Thirty-All";
            case FOURTY -> "Forty-All";
            default -> "Deuce";
        };
    }
}