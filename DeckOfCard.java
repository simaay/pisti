package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DeckOfCard {

    private static final String suits[] = {"♠", "♣", "♥", "♦"};
    private static final String ranks[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};


    ArrayList<PlayingCard> playingCards;


    public DeckOfCard() {  //creating cards in the deck
        playingCards = new ArrayList<>();
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                this.playingCards.add(new PlayingCard(suits[i], ranks[j]));
            }
        }
    }

    public void doShuffle() {  //card deck is shuffled
        Random rnd = new Random();
        int n = playingCards.size();
        for (int i = 0; i < n; i++) {
            int change = i + rnd.nextInt(n - i);
            swap(playingCards, i, change);
        }

    }

    private static <T> void swap(ArrayList<T> a, int i, int change) { //function used in mixing method
        T helper = a.get(i);
        a.set(i, a.get(change));
        a.set(change, helper);
    }

    public void cut() { //cards are cut from a random order
        Random rnd = new Random();
        int size = rnd.nextInt(1, 52);
        ArrayList<PlayingCard> top = new ArrayList<>();
        List<PlayingCard> bottom = new ArrayList<>();

        top.addAll(playingCards.subList(0,size));

        bottom.addAll(playingCards.subList(size,playingCards.size()));

        playingCards.clear();
        playingCards = merge(top, bottom);
    }

    private ArrayList<PlayingCard> merge(List<PlayingCard> top, List<PlayingCard> bottom) { //cut decks of cards are swapped
        ArrayList<PlayingCard> newList = new ArrayList<>();

        for (PlayingCard c : bottom) {
            newList.add(c);
        }
        for (PlayingCard c : top) {
            newList.add(c);
        }
        return newList;
    }

    public void dealOut(Player player, Player computer) { //Players are dealt cards
        int count = 0;
        while (count < 8) {
            player.cardsInHand.add(playingCards.get(count++));
            computer.cardsInHand.add(playingCards.get(count++));
        }
        playingCards.subList(0,7).clear();

    }


}

