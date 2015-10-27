package lab8;

import java.util.Random;

public class DeckTest
{
  public static void main(String[] args)
  {
	 Random random=new Random();
	Deck deck = new Deck(random);
    Card[] hand = deck.select(100);
    System.out.println(Card.toString(hand));
  }
}