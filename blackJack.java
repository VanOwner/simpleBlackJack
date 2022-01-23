import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class blackJack {
    public static void main(String[] args) {
        Scanner KB3 = new Scanner(System.in);

        System.out.println("||-------------------------||");
        System.out.println("||  Welcome to blackjack!  ||");
        System.out.println("||  1) Play                ||");
        System.out.println("||  2) Quit                ||");
        System.out.println("||-------------------------||");

        int x = KB3.nextInt();

        if (x == 1) {
            BlackJack();
        }

        else {
            try {
                Thread.sleep(1000);
            }

            catch (InterruptedException e) {
                System.out.println("got interrupted!");
            }

        }
        KB3.close();
    }

    static void BlackJack() {
        ArrayList<Integer> count = new ArrayList<Integer>();
        ArrayList<Integer> count2 = new ArrayList<Integer>();
        Scanner KB = new Scanner(System.in);
        Scanner KB2 = new Scanner(System.in);
        String stay = "yes";
        String again = "yes";
        int sum = 0;
        int sum2 = 0;

        System.out.println("Welcome!");

        while (again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y")) {

            while (stay.equalsIgnoreCase("yes") || stay.equalsIgnoreCase("Y")) {

                int rng = ThreadLocalRandom.current().nextInt(0, 22);
                int rng2 = ThreadLocalRandom.current().nextInt(0, 22);

                if (count.size() < 6 || count2.size() < 6) {

                    System.out.println("Your card is " + rng);
                    System.out.println("The dealer's card is " + rng2);

                    count.add(rng);
                    count2.add(rng2);

                    System.out.println("Would you like to hit?");
                    stay = KB.nextLine();
                } else {
                    stay.equalsIgnoreCase("yes");
                }
                for (int i : count) {
                    sum += i;
                    sum2 += i;
                }

                if (sum > sum2 && sum < 22) {
                    System.out.println(
                            "You've won with: " + sum + " as your final count! the dealer's count is: " + sum2);
                }
                if (sum < sum2 && sum < 22) {
                    System.out.println("You and the dealer have tied nothing has happened.");
                }

                else {
                    System.out.println(
                            "You've lost with: " + sum + " as your final count. the dealer's count is: " + sum2);
                }

                System.out.println("Would you like to play again?");
                again = KB2.nextLine();

            }
            while (again.equalsIgnoreCase("yes") || again.equalsIgnoreCase("y"));
                

            KB.close();
            KB2.close();
        }

    }
}