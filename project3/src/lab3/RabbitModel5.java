package lab3;

import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel5
{
  // TODO - add instance variables as needed
  private int populationOfRabbits;
  
  private Random rand= new Random(7);
	
	
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel5()
  {
    this.reset();
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    return populationOfRabbits;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  populationOfRabbits=populationOfRabbits+rand.nextInt(11);
}
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  populationOfRabbits=0;
  }
}
