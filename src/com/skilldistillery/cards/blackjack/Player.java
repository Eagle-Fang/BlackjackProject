package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;


public class Player {

	private BlackJackHand hand;
	
	public Player() {
	hand= new BlackJackHand();
	
	}
	
	public Player(BlackJackHand hand) {
		super();
		this.hand = hand;
	}


	public void addCardPlayer (Card card) {
		hand.addCard(card);
	}

	public int askHandValue () {
		return hand.getHandValue();
	}
	
	public boolean isTwentyOne()  {
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
