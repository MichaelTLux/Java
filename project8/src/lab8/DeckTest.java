package lab8;

import java.util.Random;

public class DeckTest
{
  public static void main(String[] args)
  {
	 Random random=new Random(7);
	Deck deck = new Deck(random);
    Card[] hand = deck.select(2);
    System.out.println(Card.toString(hand));
  }
}