import java.util.Scanner;

public class HumanThinker
{
	private static final Scanner scanner = new Scanner(System.in);
	private String name;

	public HumanThinker()
	{
		name = null;
	}

	public void yourTurn()
	{
		//Clear the console
		for(int i = 0; i < 100; ++i)
		{
			System.out.println();
		}
		System.out.println(getName() + " it is now your turn.");
		System.out.println("Press ENTER when ready!");
		scanner.nextLine();
		//Clear the console
		for(int i = 0; i < 100; ++i)
		{
			System.out.println();
		}
	}

	public String getName()
	{
		if(name != null)
		{
			return name;
		}

		System.out.print("Thinker, please enter your name: ");
		name = scanner.nextLine();
		return name;
	}

	public void newGame(int min, int max, String opponent)
	{
		System.out.println("A new game is about to start. You are the thinker.");
		System.out.println("You are plaing against " + opponent + ".");
		System.out.println("The range is from " + min + " to " + max + ".");
		System.out.println("Please think of a number and press ENTER when ready.");
		scanner.nextLine();
	}

	public Answer evaluateGuess(int guess, String opponent)
	{
		System.out.println(opponent + " guessed: " + guess);
		System.out.println("  1 - Too low");
		System.out.println("  2 - Too high");
		System.out.println("  3 - Correct");

		while(true)
		{
			System.out.print("Enter your answer (1, 2 or 3): ");
			String answer = scanner.nextLine();
			if("1".equals(answer))
			{
				return Answer.TOO_LOW;
			}
			if("2".equals(answer))
			{
				return Answer.TOO_HIGH;
			}
			if("3".equals(answer))
			{
				return Answer.CORRECT;
			}
		}
	}

	public void endOfGame(int numberOfGuesses, String opponent)
	{
		System.out.println("Game over.");
		System.out.println(opponent + " used " + numberOfGuesses + " to guess your secret number.");
	}

}
