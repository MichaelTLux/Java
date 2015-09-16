package lab3;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4
{
  // TODO - add instance variables as needed
  int populationOfRabbits;
  
  int lastYearPopulation;
  
  int twoYearAgoPopulation;
	
	
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
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
	  populationOfRabbits=lastYearPopulation+twoYearAgoPopulation;
	  twoYearAgoPopulation=lastYearPopulation;
	  lastYearPopulation=populationOfRabbits; 
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  populationOfRabbits=1;
	  lastYearPopulation=1;
	  twoYearAgoPopulation=0;
  }
}
