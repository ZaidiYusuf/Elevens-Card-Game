import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	private List<Card> cards;
	/*
	 * This arraylist is used to temporarily store discarded cards when dealing. 
	 * The 2 private fields are used for Algorithm 1 in Cards Deal method.
	 */
	//private List<Card> discardCards;
	//private int discardedCardsCounter=0;
	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		this.cards = new ArrayList<Card>();
		for(int i=0;i<ranks.length;i++){
			for(int j=0; j< suits.length; j++){
				Card tempCard = new Card(ranks[i],suits[j],values[i]);
				this.cards.add(tempCard);
			}
		}
		this.size=cards.size();
		shuffle();

	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		if(this.size==0)
			return true;
		else
			return false;
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() { //***************************
		Card temp;
		int random = 0;
		for (int index = cards.size() - 1; index > 0; index--) {
			random = (int) (Math.random() * this.cards.size());			
			temp = this.cards.get(index);
			this.cards.set(index, this.cards.get(random));
			this.cards.set(random, temp);
		}
		this.size = cards.size();
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
	//algorithm 2
		this.size -= 1;
		if(this.size > 0)
			return this.cards.get(this.size);
		else{
			return null;}
		
	//algorithm 1
	/*	this.discardCards.add(this.cards.get(this.size));
		this.cards.remove(this.size);
		discardedCardsCounter++;
		if(this.size > 0)
			return this.discardCards.get(discardedCardsCounter); 
		else
			return null;
	*/		
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
