package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player {

	private Deck deck;
	private BlackJackHand hand;
	
	public Dealer() {
		super();
		deck = new Deck();
		deck.shuffle();
		hand = new BlackJackHand();
	}
	
	public Dealer (Hand hand) {
//		super(hand);
	}
	
	public Card dealCards () {
		System.out.println("Dealer deals ...");
		Card card = deck.dealCard();
		return card;
		}
	
	public void firstCardHidden () {
	List <Card> dealerCards = hand.getCards();
	System.out.print("\tDealer's hand: [1st Card hidden");
	for (int i=1; i < dealerCards.size(); i++) {
		System.out.print(", " + dealerCards.get(i));
	}
	System.out.println("]");
	
	}
	
	public int checkCurrentDeckSize() {
		return deck.checkDeckSize();
	}

	public void callNewDeck() {
		deck.newDeck();
	}

	@Override
	public void addCardPlayer(Card card) {
		hand.addCard(card);
	}


	public int askHandValue() {
		return hand.getHandValue();
	}


	public boolean isTwentyOne() {
		return hand.isTwentyOne();
	}

	public boolean isBust() {
		return hand.isBust();
	}

	
	public void clear() {
		hand.clear();
	}

	
	public boolean isBlackJack() {
		return hand.isBlackJack();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand: ").append(hand).append(" ");
		return builder.toString();
	}
	
	
	
	
}