package game;

import java.util.Random;

public class Game {

    public  void setGame(DeckOfCard deck, GameDesk t, Player p, Player c){ //method that starts the game

        deck.doShuffle();
        deck.cut();
        for (int i=0;i<4;i++){    //The first 4 cards are placed on the table.
            t.cardsOnDesk.add(deck.playingCards.get(i));
        }
        for (int i=0;i<4;i++){
            deck.playingCards.remove(i);
        }


        System.out.println("new cards are dealt!");
        deck.dealOut(p,c);



    }

    public void playUser (int cardNumber, Player p, Player c, GameDesk t) { //play method for player
        if (t.cardsOnDesk.size()!=0) {
            if (p.cardsInHand.get(cardNumber).getRank().compareTo(t.cardsOnDesk.get(t.cardsOnDesk.size() - 1).getRank()) == 0) {
                if (t.cardsOnDesk.size() == 1) {
                    System.out.println("PİŞTİ !!!");
                    p.addScore(10);
                    for (int i = 0; i < t.cardsOnDesk.size(); i++) {
                        p.gotCards.add(t.cardsOnDesk.get(i));

                    }
                    p.cardsInHand.remove(cardNumber);
                    t.cardsOnDesk.clear();

                } else {
                    System.out.println(p.getName()+" takes cards");
                    for (int i = 0; i < t.cardsOnDesk.size(); i++) {
                        p.gotCards.add(t.cardsOnDesk.get(i));

                    }
                    p.cardsInHand.remove(cardNumber);
                    t.cardsOnDesk.clear();

                }
            } else if(p.cardsInHand.get(cardNumber).getRank().compareTo("J")==0) {
                System.out.println(p.getName()+" takes cards with Joker");
                for (int i = 0; i < t.cardsOnDesk.size(); i++) {
                    p.gotCards.add(t.cardsOnDesk.get(i));

                }
                p.cardsInHand.remove(cardNumber);
                t.cardsOnDesk.clear();
            }
            else {
                t.cardsOnDesk.add(p.cardsInHand.get(cardNumber));
                p.cardsInHand.remove(cardNumber);
            }
        }else {
            t.cardsOnDesk.add(p.cardsInHand.get(cardNumber));
            p.cardsInHand.remove(cardNumber);
        }

        playComputer(p,c,t);


    }

    public  void playComputer(Player p, Player c, GameDesk t) {  // play method for computer

        Random rnd= new Random();
        int cardNumber=-1;


        for (int i=0;i<c.cardsInHand.size();i++){
            if(t.cardsOnDesk.size()>0) {
                if (c.cardsInHand.get(i).getRank().compareTo(t.cardsOnDesk.get(t.cardsOnDesk.size() - 1).getRank()) == 0) {
                    cardNumber = i;
                }
            }

        }
        if (cardNumber<0) {
            if (c.cardsInHand.size()>1) {
                cardNumber = rnd.nextInt(c.cardsInHand.size());
            } else {
                cardNumber=0;
            }
        }
        System.out.println("computer played "+c.cardsInHand.get(cardNumber).getRank());
        if (t.cardsOnDesk.size()!=0) {
            if (c.cardsInHand.get(cardNumber).getRank().compareTo(t.cardsOnDesk.get(t.cardsOnDesk.size() - 1).getRank()) == 0) {
                if (t.cardsOnDesk.size() == 1) {
                    System.out.println("PİŞTİ !!");
                    c.addScore(10);
                    for (int i = 0; i < t.cardsOnDesk.size(); i++) {
                        c.gotCards.add(t.cardsOnDesk.get(i));
                    }
                    c.cardsInHand.remove(cardNumber);
                    t.cardsOnDesk.clear();

                } else {
                    System.out.println("Computer takes cards");
                    for (int i = 0; i < t.cardsOnDesk.size(); i++) {
                        c.gotCards.add(t.cardsOnDesk.get(i));
                    }
                    c.cardsInHand.remove(cardNumber);
                    t.cardsOnDesk.clear();

                }
            }else if(c.cardsInHand.get(cardNumber).getRank().compareTo("J")==0) {
                System.out.println("Computer takes cards with Joker");
                for (int i = 0; i < t.cardsOnDesk.size(); i++) {
                    c.gotCards.add(t.cardsOnDesk.get(i));
                }
                c.cardsInHand.remove(cardNumber);
                t.cardsOnDesk.clear();
            }
            else {
                t.cardsOnDesk.add(c.cardsInHand.get(cardNumber));
                c.cardsInHand.remove(cardNumber);
            }
        }else {
            t.cardsOnDesk.add(c.cardsInHand.get(cardNumber));
            c.cardsInHand.remove(cardNumber);
        }

    }


}
