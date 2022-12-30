package game;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void picWinner(Player player, Player computer){ //determines the winner

        player.calculateScore();
        computer.calculateScore();

        if(player.gotCards.size()>computer.gotCards.size()) {
            player.addScore(3);
        } else if(player.gotCards.size()<computer.gotCards.size()){
            computer.addScore(3);
        }

        System.out.println(player.getName()+"'s score :"+player.getScore());
        System.out.println("Computer's score :"+computer.getScore());

        if (player.getScore()> computer.getScore()) {
            System.out.println(player.getName()+" Won !!! ");
            System.out.println("Congratulations!");
        } else if (player.getScore()< computer.getScore()) {
            System.out.println("Computer Won!");
        } else {
            System.out.println("All it even");
        }

    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        Game game = new Game();
        DeckOfCard deckOfCard = new DeckOfCard();

        System.out.println("Enter your name :");
        String name=sc.nextLine();
        Player player=new Player(name);

        Player computer = new Player("Computer"); //Creating a player based on the entered name

        GameDesk gameDesk = new GameDesk();

        game.setGame(deckOfCard, gameDesk,player,computer); //the game is starting
        System.out.println();
        gameDesk.showCards();
        System.out.println();
        player.showCards();
        int choose;

        do {   //the part that keeps the game going until the cards are gone

            System.out.print("Enter the number of the card you want to play :");
            choose=sc.nextInt();

                game.playUser(choose, player, computer, gameDesk);

            if (player.cardsInHand.size()==0){
                if (deckOfCard.playingCards.size()>=8) {
                    System.out.println("new cards are dealt");
                    deckOfCard.dealOut(player, computer);

                } else {
                    break;
                }
            }

            gameDesk.showCards();
            player.showCards();
        }while(deckOfCard.playingCards.size()>0);


        System.out.println("Game over!! \n");
        picWinner(player,computer);

    }
}
