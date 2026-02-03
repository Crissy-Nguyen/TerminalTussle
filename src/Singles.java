import java.util.Random;
import java.util.Scanner;

public class Singles {
    private int playerHP;
    private int enemyHP;
    private int playerMP;
    private int turnCount;
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    public Singles() {
        playerHP = 20;
        playerMP = 3;
        enemyHP = 20;
        turnCount = 0;
    }

    public void battle () {
        while (enemyHP > 0 && playerHP > 0) {
            System.out.println("\n\n\n(Turn #" + turnCount + ")");
            if (enemyHP > 15) { System.out.print("Face the giant rock! [▮▮▮▮]\n"); }
            else if (enemyHP > 10) { System.out.print("Face the giant rock! [▮▮▮▯]\n"); }
            else if (enemyHP > 5) { System.out.print("Face the giant rock! [▮▮▯▯]\n"); }
            else { System.out.print("Face the giant rock! [▮▯▯▯]\n"); }

            System.out.println("      ------ MOVES ------");
            System.out.println("[1] Tackle\t[2] Drop Kick");
            System.out.println("[3] Snack\t[4] Flee\n");
            int c = scan.nextInt();

            int dmg;
            switch (c) {
                case 1:
                    dmg = 2 + rand.nextInt(4);
                    System.out.println("You tackled the rock! " + dmg + " DMG!");
                    enemyHP -= dmg;
                    break;
                case 2:
                    dmg = 2 + rand.nextInt(4);
                    int r = rand.nextInt(2);
                    if (r==0) {
                        System.out.println("You missed your kick and fell... 1 DMG to self.");
                        playerHP--;
                    }
                    else {
                        System.out.println("Big kick!! " + dmg + " DMG!");
                        enemyHP -= dmg;
                    }
                    break;
                case 3:
                    dmg = 1 + rand.nextInt(3);
                    break;
                case 4:
                    System.out.println("You fled...");
                    playerHP = 0;
                    break;
                default:
                    System.out.println("Wrong command.");
                    continue;
            }
            if (enemyHP <= 0) break;

            dmg = 3 + rand.nextInt(6);
            System.out.println("The giant rock has rocked you! " + dmg + " DMG!");
            playerHP -= dmg;
        }

        if(enemyHP <= 0) {
            System.out.println(("You've shattered the rock! WIN!!!"));
        }
        else if (playerHP <= 0) {
            System.out.println("You've been thoroughly rocked. Lose...");
        }
    }
}