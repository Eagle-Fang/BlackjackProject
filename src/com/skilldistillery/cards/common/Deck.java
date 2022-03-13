package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;
	private final int NUM_OF_CARDS = 52;
	
	
	public Deck() {
		cards = createDeck();
	}

	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(NUM_OF_CARDS );
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		return cards.remove(0);

	}

	public void newDeck() {
		System.out.println("Creating new deck now.");
		cards = createDeck();
		shuffle();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Deck [cards=").append(cards).append("]");
		return builder.toString();
	}

}
