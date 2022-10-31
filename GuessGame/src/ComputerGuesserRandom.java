import java.util.Random;

public class ComputerGuesserRandom extends ComputerGuesser {
    private Random random;
    private int guess;

    public ComputerGuesserRandom() {
        random = new Random();
    }

    @Override
    public int makeGuess() {
        guess = random.nextInt(max-min+1) + min;
        return guess;
    }

    @Override
    public void guessFeedback(Answer answer) {
        switch(answer)
        {
            case TOO_LOW:
                //min = ((min + max) / 2) + 1;
                min = guess + 1;
                break;
            case TOO_HIGH:
                //max = ((min + max) / 2) -1;
                max = guess - 1;
                break;
            case CORRECT:
                break;
            default:
                throw new RuntimeException("This should never happen!");
        }
    }
}
