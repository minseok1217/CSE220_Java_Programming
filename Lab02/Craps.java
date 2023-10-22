import java.util.Random;
import java.util.Scanner;

public class Craps {
   private Random randomNumbers =new Random();
   
   private enum Status {CONTINUE,WON,LOST};
   
   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;
   private static final int SEVEN = 7;
   private static final int YO_LEVEN = 11;
   private static final int BOX_CARS = 12;
   
//    public void run() {
//       int bankbalance=1000;
//       int wager;
//       Scanner input = new Scanner(System.in);
      
//       do
//       {
         
//       }while ((wager != -1) && (bankbalance > 0));
//    }
	public void run() {
		int bankBalance = 1000;
		int wager;
		Status gameStatus;
		Scanner input = new Scanner(System.in);

		do {
			// 입력: 베팅 금액을 입력받음
			System.out.printf("You have $%d. Enter your wager (-1 to quit): ", bankBalance);
			wager = input.nextInt();

			// 베팅이 유효한지 확인
			while (wager < -1 || wager > bankBalance) {
				System.out.println("Invalid wager. Please enter a valid wager.");
				wager = input.nextInt();
			}

			// -1을 입력하면 게임 종료
			if (wager == -1) {
				break;
			}

			// Craps 게임 실행
			gameStatus = play();

			// 게임 결과에 따라 은행 잔고 업데이트
			if (gameStatus == Status.WON) {
				bankBalance += wager;
			} else if (gameStatus == Status.LOST) {
				bankBalance -= wager;
			}

			// 은행 잔고 표시
			System.out.printf("New bank balance: $%d%n", bankBalance);

			// 게임 진행 메시지 표시
			System.out.println(chatter());

			// 게임 종료 여부 확인
		} while ((wager != -1) && (bankBalance > 0));

		// 게임 종료 메시지
		if (bankBalance <= 0) {
			System.out.println("Sorry. You busted!");
		}
	}

   public String chatter() {
      switch(randomNumbers.nextInt(5)) {
      case 0: return "Aw c'mon, take a chance!";
      case 1:return "Oh you're going for broke, huh?";
      case 2:return "";
      case 3:return "";
      default : return "";
      }
   }
   
   
   
   public Status play()
      {
         int myPoint = 0; // point if no win or loss on first roll
         Status gameStatus; // can contain CONTINUE, WON or LOST

         int sumOfDice = rollDice(); // first roll of the dice

         // determine game status and point based on first roll 
         switch (sumOfDice) 
         {
            case SEVEN: // win with 7 on first roll
            case YO_LEVEN: // win with 11 on first roll           
               gameStatus = Status.WON;
               break;
            case SNAKE_EYES: // lose with 2 on first roll
            case TREY: // lose with 3 on first roll
            case BOX_CARS: // lose with 12 on first roll
               gameStatus = Status.LOST;
               break;
            default: // did not win or lose, so remember point         
               gameStatus = Status.CONTINUE; // game is not over
               myPoint = sumOfDice; // remember the point
               System.out.printf("Point is %d%n", myPoint);
               break;
         } 

         // while game is not complete
         while (gameStatus == Status.CONTINUE) // not WON or LOST
         { 
            sumOfDice = rollDice(); // roll dice again

            // determine game status
            if (sumOfDice == myPoint) // win by making point
               gameStatus = Status.WON;
            else 
               if (sumOfDice == SEVEN) // lose by rolling 7 before point
                  gameStatus = Status.LOST;
         } 

         // display won or lost message
         if (gameStatus == Status.WON)
            System.out.println("Player wins");
         else
            System.out.println("Player loses");
			return gameStatus;
      }
   
    public int rollDice()
      {
         // pick random die values
         int die1 = 1 + randomNumbers.nextInt(6); // first die roll
         int die2 = 1 + randomNumbers.nextInt(6); // second die roll

         int sum = die1 + die2; // sum of die values

         // display results of this roll
         System.out.printf("Player rolled %d + %d = %d%n", 
            die1, die2, sum);

         return sum; 
      }
}