package com.skilldistillery.cards.blackjack;

import java.util.Scanner;


public class BlackjackApp {
	private Scanner scan = new Scanner(System.in);
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private final int MIN_DECK_SIZE = 20;


	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		System.out.println("Welcome to the Blackjack Game");

		app.run();
	}



	private void run() {

		System.out.println();
		player.addCardPlayer(dealer.dealCards());
		System.out.println("\tPlayer's " + player);

		dealer.addCardPlayer(dealer.dealCards());
		dealer.firstCardHidden();

		player.addCardPlayer(dealer.dealCards());
		System.out.println("\tPlayer's " + player);

		dealer.addCardPlayer(dealer.dealCards());
		dealer.firstCardHidden();

		printPlayerCurrentValue();

		checkForBlackJack();

		hitOrStay();
	}

	private void hitOrStay() {

		System.out.println("Do you want to (h)it or (s)tay? ");
		String hos = scan.next().toLowerCase();

		switch (hos) {

		case "h":
			hit();
			break;
		case "s":

			stand();
			break;
		default:
			System.out.println("Error, please submit response again.");
			hitOrStay();
			break;
		}
	}

	private void printPlayerCurrentValue() {
		System.out.println("Player's Hand: " + player.askHandValue());
		System.out.println();

	}

	private void printDealerCurrentValue() {
		System.out.println("Dealer's Hand Value: " + dealer.askHandValue());
		System.out.println();

	}

	private void hit() {
		player.addCardPlayer(dealer.dealCards());
		System.out.println("Player's " + player);
		printPlayerCurrentValue();

		checkValues();
		playersTurn();
	}

	private void stand() {
		dealerPlayAfterStay();
	}

	private void playersTurn() {
		if (player.askHandValue() < 21) {
			hitOrStay();
		} else {
			checkValues();
			checkPush();
		}
	}

	private void dealerPlayAfterStay() {
		if (dealer.askHandValue() < 17) {
			dealer.addCardPlayer(dealer.dealCards());
			dealer.firstCardHidden();
		} else {
			checkValues();
			checkPush();
		}
		dealerPlayAfterStay();
	}

	private void checkPush() {
		if (player.askHandValue() == dealer.askHandValue()) {
			dealerShowsAllCards();
			System.out.println("It is a tie. ");
			playAgain();
		}
		checkHighest();
	}

	private void checkHighest() {
		if (player.askHandValue() > dealer.askHandValue()) {
			dealerShowsAllCards();
			System.out.println("Player has a higher hand value.  Player wins.");
			playAgain();
		} else {
			dealerShowsAllCards();
			System.out.println("Dealer has a higher hand value.  Dealer wins.");
			playAgain();
		}
	}

	private void checkValues() {
		if (player.isTwentyOne()) {
			dealerShowsAllCards();
			System.out.println("You win with Blackjack!");
			playAgain();
		} else if (dealer.isBust()) {
			dealerShowsAllCards();
			System.out.println("Dealer busts, you win!");
			playAgain();
		} else if (dealer.isTwentyOne()) {
			dealerShowsAllCards();
			System.out.println("You loose, the dealer wins had blackjack.");
			playAgain();
		} else if (player.isBust()) {
			dealerShowsAllCards();
			System.out.println("Your hand is a bust. The dealer wins.");
			playAgain();
		}
	}

	private void checkForBlackJack() {
		if (player.isBlackJack() && dealer.isBlackJack()) {
			dealerShowsAllCards();
			System.out.println("It's a draw! You and the dealer both have BlackJack.");
			playAgain();
		} else if (player.isBlackJack()) {
			dealerShowsAllCards();
			System.out.println("You win with BlackJack!");
			playAgain();
		} else if (dealer.isBlackJack()) {
			dealerShowsAllCards();
			System.out.println("The dealer wins with BlackJack.");
			playAgain();
		}
	}

	private void dealerShowsAllCards() {
		System.out.println("Dealer turns over hidden card...");
		System.out.println("\tDealer's " + dealer);
		printDealerCurrentValue();
	}

	private void playAgain() {
		System.out.println();
		System.out.println("There are " + dealer.checkCurrentDeckSize() + " cards remaining in this deck.");
		System.out.println("Would you like to play another game of BlackJack (y or n)?");

		String replay = scan.next().toLowerCase();
		switch (replay) {
		case "y":
			if (dealer.checkCurrentDeckSize() >= MIN_DECK_SIZE) {
				player.clear();
				dealer.clear();
				run();
			} else {
				player.clear();
				dealer.clear();
				dealer.callNewDeck();
				System.out.println();
				System.out.println("******** Switching to a new deck of cards. ********");
				run();
			}
			break;
		case "n":
			System.out.println("Thank you for playing. Goodbye.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid response " + replay + "\nPlease submit response again.");
			playAgain();
			break;
		}
	}
}