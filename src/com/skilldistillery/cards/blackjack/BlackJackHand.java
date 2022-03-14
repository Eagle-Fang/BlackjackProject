package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;

public class BlackJackHand extends Hand {
	private final int TWENTY_ONE = 21;

	public BlackJackHand() {
	}

	public int getHandValue() {
		int aceCount = 0;
		int value = 0;
		boolean aceFlag = false;
		for (Card card : cards) {
			if (card.getValue() == 11) {
				aceFlag = true;
				aceCount ++;
			}
			value += card.getValue();
		}
		if (aceFlag && value > TWENTY_ONE) {
		for (int i=0; i < aceCount; i++) {
			value -= 10; // Change ace to 1 if hand is over 21 
		}
			System.out.println("Ace value adjusted");
		}
		return value;
	}
	
		

	public boolean isBlackJack() {
		if (getHandValue() == TWENTY_ONE) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > TWENTY_ONE) {
			return true;
		}
		return false;
	}

	public int checkHandSize() {
		return cards.size();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ").append(cards).append(" ");
		return builder.toString();
	}

	public boolean isTwentyOne() {
		return false;
	}

}
