/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card first = new Card("Ace","clubs",1);
		Card second = new Card("Ace","clubs",1);
		Card third = new Card("4","spades",4);
		
		System.out.println(first.rank());
		System.out.println(first.suit());
		System.out.println(first.pointValue());
		System.out.println(first);
		System.out.println(first.matches(second));
		System.out.println(first.matches(third));
	}
}
