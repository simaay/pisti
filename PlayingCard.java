package game;

public class PlayingCard {
    private  String suit;
    private  String rank;


    public PlayingCard(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }
    public PlayingCard(){

    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return  suit +""+ rank ;
    }

}
