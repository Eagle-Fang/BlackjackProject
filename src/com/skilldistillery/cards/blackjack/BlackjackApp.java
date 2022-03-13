package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApp {

	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private final int MIN_DECK_SIZE = 20;
	private final int DEALER_HIT_MIN = 17;
	

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Blackjack Game");

		app.run(scan);
	}

	private void run(Scanner scan) {

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

		checkForBlackJack(scan);

		hitOrStay(scan);
	}

	private void hitOrStay(Scanner scan) {

		System.out.println("Do you want to (h)it or (s)tay? ");
		String hos = scan.next().toLowerCase();

		switch (hos) {
	
		case "h":
			hit(scan);
			break;
		case "s":

			stand(scan);
			break;
		default:
			System.out.println("Error, please submit response again.");
			hitOrStay(scan);
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

	private void hit(Scanner scan) {
		player.addCardPlayer(dealer.dealCards());
		System.out.println("Player's " + player);
		printPlayerCurrentValue();

		checkValues(scan);
		playersTurn(scan);
	}

	private void stand(Scanner scan) {
		dealerPlayAfterStay(scan);
	}

	private void playersTurn(Scanner scan) {
		if (player.askHandValue() < 21) {
			hitOrStay(scan);
		} else {
			checkValues(scan);
			checkPush(scan);
		}
	}

	private void dealerPlayAfterStay(Scanner scan) {
		if (dealer.askHandValue() < DEALER_HIT_MIN) {
			dealer.addCardPlayer(dealer.dealCards());
			dealer.firstCardHidden();
		} else {
			checkValues(scan);
			checkPush(scan);
		}
		dealerPlayAfterStay(scan);
	}

	private void checkPush(Scanner scan) {
		if (player.askHandValue() == dealer.askHandValue()) {
			dealerShowsAllCards();
			System.out.println("It is a tie. ");
			playAgain(scan);
		}
		checkHighest(scan);
	}

	private void checkHighest(Scanner scan) {
		if (player.askHandValue() > dealer.askHandValue()) {
			dealerShowsAllCards();
			System.out.println("Player has a higher hand value.  Player wins.");
			playAgain(scan);
		} else {
			dealerShowsAllCards();
			System.out.println("Dealer has a higher hand value.  Dealer wins.");
			playAgain(scan);
		}
	}

	private void checkValues(Scanner scan) {
		if (player.isTwentyOne()) {
			dealerShowsAllCards();
			System.out.println("You win with Blackjack!");
			playAgain(scan);
		} else if (dealer.isBust()) {
			dealerShowsAllCards();
			System.out.println("Dealer busts, you win!");
			playAgain(scan);
		} else if (dealer.isTwentyOne()) {
			dealerShowsAllCards();
			System.out.println("You loose, the dealer wins had blackjack.");
			playAgain(scan);
		} else if (player.isBust()) {
			dealerShowsAllCards();
			System.out.println("Your hand is a bust. The dealer wins.");
			playAgain(scan);
		}
	}

	private void checkForBlackJack(Scanner scan) {
		if (player.isBlackJack() && dealer.isBlackJack()) {
			dealerShowsAllCards();
			System.out.println("It's a draw! You and the dealer both have BlackJack.");
			playAgain(scan);
		} else if (player.isBlackJack()) {
			dealerShowsAllCards();
			System.out.println("You win with BlackJack!");
			playAgain(scan);
		} else if (dealer.isBlackJack()) {
			dealerShowsAllCards();
			System.out.println("The dealer wins with BlackJack.");
			playAgain(scan);
		}
	}

	private void dealerShowsAllCards() {
		System.out.println("Dealer turns over hidden card...");
		System.out.println("\tDealer's " + dealer);
		printDealerCurrentValue();
	}

	private void playAgain(Scanner scan) {
		System.out.println();
		System.out.println("There are " + dealer.checkCurrentDeckSize()  
				+ " cards remaining in this deck.");
		System.out.println("Would you like to play another game of BlackJack (y or n)");

		String replay = scan.next().toLowerCase();
		switch (replay) {
		case "y":
			if (dealer.checkCurrentDeckSize() >= MIN_DECK_SIZE) {
				player.clear();
				dealer.clear();
				run(scan);
			} else {
				player.clear();
				dealer.clear();
				dealer.callNewDeck();
				System.out.println();
				System.out.println("******** Shuffling a new deck of cards. ********");
				run(scan);
			}
			break;
		case "n":
			System.out.println("Thank you for playing. Goodbye.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid response " + replay + "\nPlease submit response again.");
			playAgain(scan);
			break;
		}
	}
}