package lab8;
import java.util.Random;

import lab8.Card.Suit;

/**
 * Class representing a standard 52-card deck of playing
 * cards from which cards can be selected at random.
 */
public class Deck
{
  /**
   * The cards comprising this deck.
   */
  private Card[] cards;
  
  /**
   * The random number generator to use for selecting cards.
   */
  private Random rand;
  
  /**
   * Size of this deck
   */
  private final int DECK_ARRAY_SIZE=51;
  
  /**
   * Constructs a new deck with a default random number generator.
   */
  public Deck()
  {
    rand = new Random();
    init();
  }

  /**
   * Constructs a new deck with the given random number generator.
   */
  public Deck(Random givenGenerator)
  {
    rand = givenGenerator;
	init();
  }
  
  /**
   * Returns a new array containing k elements selected
   * at random from this deck.
   */
  public Card[] select(int k)
  {
    Card[] hand=new Card[k];
	for (int index=0; index<k && index<=DECK_ARRAY_SIZE;index=index+1)
	{
		int generated=rand.nextInt(DECK_ARRAY_SIZE+1-index);
		Card addedCard=cards[generated];
		Card tempcard=cards[DECK_ARRAY_SIZE-index];
		cards[DECK_ARRAY_SIZE-index]=addedCard;
		cards[generated]=tempcard;
		hand[index]=addedCard;		
	}
    return hand;
  }
  
  /**
   * Initializes a new deck of 52 cards.
   */
  private void init()
  {
    cards = new Card[52];
    int index = 0;
    for (int rank = 1; rank <= 13; ++rank)
    {
      cards[index] = new Card(rank, Suit.CLUBS);
      index += 1;
      cards[index] = new Card(rank, Suit.DIAMONDS);
      index += 1;
      cards[index] = new Card(rank, Suit.HEARTS);
      index += 1;
      cards[index] = new Card(rank, Suit.SPADES);
      index += 1;
    }

  }
}
