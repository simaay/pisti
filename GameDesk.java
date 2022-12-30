package game;

import java.util.ArrayList;

public class GameDesk {
    ArrayList<PlayingCard> cardsOnDesk=new ArrayList<>(); //cards on the game table

    public void showCards(){

        String cardsOn="";
        System.out.println("\n----Board---- ");

        if(cardsOnDesk.size()>0) {
            System.out.println((cardsOnDesk.get(cardsOnDesk.size() - 1).toString() ));


            for (int i =  cardsOnDesk.size()-2 ;i>=0 ; i--) {
                System.out.print(cardsOnDesk.get(i).toString() + " ");
            }
        }

    }

}
