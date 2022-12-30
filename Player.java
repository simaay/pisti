package game;

import java.util.ArrayList;

public class Player {

    private String name;
    ArrayList<PlayingCard> cardsInHand=new ArrayList<>(); // Cards in the player's hand
    ArrayList<PlayingCard> gotCards=new ArrayList<>(); //cards won in the game
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int p){
        score+=p;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showCards(){  //shows player cards
        System.out.println("\n----My Hand---- ");

        for (int i=0;i<cardsInHand.size();i++) {

            System.out.println(i +" "+cardsInHand.get(i).toString());
        }
    }
    public void calculateScore(){  // calculate user score

        for (PlayingCard playingCard :gotCards){
            if ((playingCard.getSuit().equals("♦")))  {
                if (playingCard.getRank().equals("10")) {
                    addScore(3);
                }
            } else if ((playingCard.getSuit().equals("♣")))  {
                if (playingCard.getRank().equals("2")) {
                    addScore(2);
                }
            }else {
                addScore(1);
            }

        }
    }


}
