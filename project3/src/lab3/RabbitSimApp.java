package lab3;

import plotter.SimulationPlotter;

public class RabbitSimApp {
	public static void main(String args[])
	{
		//Construct a plotter
		SimulationPlotter plotter = new SimulationPlotter();
		
		//Use the plotter
		RabbitModel myModel = new RabbitModel();
		plotter.simulate(myModel);
	}

}
