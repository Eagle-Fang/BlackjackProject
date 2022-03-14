# BlackjackProject


### Description

This project simulates Blackjack play. First, the player is dealt 2 cards and then dealer is dealt 2 cards with one face-up and one face-down. Cards are equal to their value with face cards being 10 and an Ace being either 1 or 11. The players cards are added up for their total. The Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.  Dealer is supposed to “Hit” until their total equals or exceeds 17. The goal is to have a higher card total than the dealer without going over 21. If the player total equals the dealer total, it is a “Push” and neither the player nor the dealer wins that hand;


### Technologies Used

Java v. 1.9; Eclipse; GitHub;

### Java Topics covered
This assignment allowed us to apply many of the Java fundamentals covered during the first 4 weeks at Skills Distillery.  Some of the more difficult topics included abstract class implementation, encapsulation, and polymorphism.  Additionally, the assignment was good practice on inheritance, and for-each loops.

### User Stories

**User Story #1
User Story #1
Create a class structure that mimics a deck of cards. R Feel free to create the structure in any way you see fit.

User Story #2
Add methods and fields to your classes that mimic the functionality of shuffling and dealing a deck of cards. Remember that when a card is dealt you have to remove it from the current deck.

User Story #3
Deal two hands of cards - one to a Dealer and another to a Player. Allow the players to Hit (add cards to their hand) or Stay (not add cards to their hand) in accordance to the rules of blackjack shown in the wiki.

User Story #4
The Dealer's decisions are based on game logic in the program.
The Dealer must decide to Hit or Stay based on the rules of Blackjack: if the Dealer's hand total is below 17, the Dealer must Hit; if the hand total is 17 or above, the Dealer must Stay.

User Story #5
Determine the winner of each round by implementing the remaining rules of Blackjack (such as going over 21) and comparing hand values.

###Lessons Learned
Like most complicated problems, it is best to begin by documenting the coding strategy before actually coding.  A use case diagram works will to accomplish this task.  I was able to practice encapsulation and polymorphism via subclasses.  While the access modifiers helped with data hiding, the use of abstract classes forced me to adapt the design. I personally had compiler issues early in development resulting from missing instanciations.


###Potential Improvements
If given additional time, I would have liked to incorporate some of the stretch goals such as adding additional decks and / or addtional players.  
