package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;

public class BlackJackHand extends Hand {
	private final int TWENTY_ONE = 21;

	public BlackJackHand() {
	}

	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ").append(cards).append(" ");
		return builder.toString();
	}

	public boolean isTwentyOne() {
		// TODO Auto-generated method stub
		return false;
	}

}
