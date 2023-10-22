import java.util.Random;
public class Roll36 {
    private Random randomNumbers = new Random();
    private int[] totals = new int[13];

    public void rollDice36(){
        for (int i = 0; i < totals.length; i++){
            totals[i] = 0;
            
        }
        for(int roll = 1; roll<360000000; roll++){
            totals[roll2()]++;
        }
        for(int k=2; k < totals.length; k++){
            System.out.printf("%3d, %3d",k,totals[k]);
        }
    }

    public int roll2(){
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;
        return sum;
    }
}
