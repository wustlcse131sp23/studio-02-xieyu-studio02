package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the amount of money that you start with: ");
		double startAmount = in.nextDouble();
		System.out.println("Enter the win probability: ");
		double winChance = in.nextDouble();
		System.out.println("Enter the win limit: ");
		double winLimit = in.nextDouble();
		System.out.println("Enter the days you spend in casino: ");
		int totalSimulations = in.nextInt();
		int playNumber = 0;
		double b = startAmount;


		boolean each_success;
		String Lose = null;
		int totalLose = 0;
		double exp = 0.0;
		double c = 0.0;
		
		
		if (winChance == 0.5) {
			exp = 1.0 - (startAmount/winLimit);
		}
		else {
			c = (1.0 - winChance) / winChance;
			exp = (Math.pow(c, startAmount) - Math.pow(c, winLimit))/(1 - Math.pow(c, winLimit));
		}
		for(int i = 1 ; i <= totalSimulations; i++) {

			startAmount = b;
			playNumber = 0;
			while (startAmount > 0 && startAmount < winLimit ) {
				double a = Math.random();
				if (a < winChance && a > 0) {
					each_success = true;
					startAmount ++;
				}
				else {each_success = false;
				startAmount --;
				}
				playNumber ++;
			}
			
			if (startAmount == 0) {
				Lose = "Lose";
				totalLose ++;
			}
			else {
				Lose = "Win";
			}
			System.out.println("Simulation " + i + ": " + playNumber + " " + Lose);
		}
		double actRate = (totalLose * 1.0) / (totalSimulations * 1.0);
		System.out.println("Losses: " + totalLose + " Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simulation: " + actRate + " Expected Ruin Rate: " + exp);


	}

}
