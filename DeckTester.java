/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks1 = {"ace","2","3"};
		String[] suits1 = {"clubs","diamonds","hearts"};
		int[] points1 = {1,2,3};
		Deck deck1 = new Deck(ranks1, suits1, points1);  //test constructor
		System.out.println(deck1.size()); //test size method
		System.out.println(deck1.deal()); //test deal method
		System.out.println(deck1.isEmpty()); //test isEmpty method
		deck1.shuffle();
		System.out.println(deck1);//after shuffling
	}
	
}
