/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author rohit
 */
//import java.util.ArrayList;
//
//
//
import java.util.ArrayList;

public class WarGame extends Game {
    private GroupOfCards deck;

    public WarGame() {
        super("War Game");
        getPlayers().add(new Player("Rohitpal"));
        getPlayers().add(new Player("Arsdheep"));
        getPlayers().add(new Player("Kamaldeep"));
        getPlayers().add(new Player("Gajanpreet"));
        deck = new GroupOfCards(52);
        initializeDeck();
    }

    private void initializeDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new PlayingCard(rank, suit));
            }
        }

        getDeck().setCards(cards);
        getDeck().shuffle();
    }

    @Override
    public void play() {
        // Deal the cards to each player
        dealCards();
        
        // Play the game (each player draws one card, highest card wins the round)
        for (int i = 0; i < 13; i++) { // 52 cards, 4 players, so 13 rounds
            ArrayList<Card> roundCards = new ArrayList<>();
            for (Player player : getPlayers()) {
                Card card = player.drawCard();
                roundCards.add(card);
                System.out.println(player.getName() + " drew " + card);
            }
            
            // Determine the winner of the round
            Player roundWinner = determineRoundWinner(roundCards);
            roundWinner.incrementScore();
            System.out.println(roundWinner.getName() + " wins the round!\n");
        }
    }

    private void dealCards() {
        ArrayList<Card> cards = getDeck().getCards();
        int playerIndex = 0;
        for (Card card : cards) {
            getPlayers().get(playerIndex).addCard(card);
            playerIndex = (playerIndex + 1) % getPlayers().size();
        }
    }

    private Player determineRoundWinner(ArrayList<Card> roundCards) {
        Card highestCard = roundCards.get(0);
        Player roundWinner = getPlayers().get(0);
        for (int i = 1; i < roundCards.size(); i++) {
            if (roundCards.get(i).compareTo(highestCard) > 0) {
                highestCard = roundCards.get(i);
                roundWinner = getPlayers().get(i);
            }
        }
        return roundWinner;
    }

    @Override
    public void declareWinner() {
        // Empty method to satisfy the abstract class requirement
    }

    /**
     * @return the deck
     */
    public GroupOfCards getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(GroupOfCards deck) {
        this.deck = deck;
    }
}


//import java.util.ArrayList;
//
//public class WarGame extends Game {
//    private GroupOfCards deck;
//
//    public WarGame() {
//        super("War Game");
//        for (int i = 1; i <= 4; i++) {
//            getPlayers().add(new Player("Player " + i));
//        }
//        deck = new GroupOfCards(52);
//        initializeDeck();
//    }
//
//    private void initializeDeck() {
//        ArrayList<Card> cards = new ArrayList<>();
//        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
//        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
//
//        for (String suit : suits) {
//            for (String rank : ranks) {
//                cards.add(new PlayingCard(rank, suit));
//            }
//        }
//
//        getDeck().setCards(cards);
//        getDeck().shuffle();
//    }
//
//    @Override
//    public void play() {
//        // Deal the cards to each player
//        dealCards();
//        
//        // Play the game (each player draws one card, highest card wins the round)
//        for (int i = 0; i < 13; i++) { // 52 cards, 4 players, so 13 rounds
//            ArrayList<Card> roundCards = new ArrayList<>();
//            for (Player player : getPlayers()) {
//                Card card = player.drawCard();
//                roundCards.add(card);
//                System.out.println(player.getName() + " drew " + card);
//            }
//            
//            // Determine the winner of the round
//            Player roundWinner = determineRoundWinner(roundCards);
//            roundWinner.incrementScore();
//            System.out.println(roundWinner.getName() + " wins the round!\n");
//        }
//    }
//
//    private void dealCards() {
//        ArrayList<Card> cards = getDeck().getCards();
//        int playerIndex = 0;
//        for (Card card : cards) {
//            getPlayers().get(playerIndex).addCard(card);
//            playerIndex = (playerIndex + 1) % getPlayers().size();
//        }
//    }
//
//    private Player determineRoundWinner(ArrayList<Card> roundCards) {
//        Card highestCard = roundCards.get(0);
//        Player roundWinner = getPlayers().get(0);
//        for (int i = 1; i < roundCards.size(); i++) {
//            if (roundCards.get(i).compareTo(highestCard) > 0) {
//                highestCard = roundCards.get(i);
//                roundWinner = getPlayers().get(i);
//            }
//        }
//        return roundWinner;
//    }
//
//    @Override
//    public void declareWinner() {
//        // Empty method to satisfy the abstract class requirement
//    }
//
//    /**
//     * @return the deck
//     */
//    public GroupOfCards getDeck() {
//        return deck;
//    }
//
//    /**
//     * @param deck the deck to set
//     */
//    public void setDeck(GroupOfCards deck) {
//        this.deck = deck;
//    }
//}
