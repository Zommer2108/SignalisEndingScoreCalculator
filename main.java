import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int ending = 0; // 0 = Memory, 1 = Leave, 2 = Promise
        int cirlce = 2;
        int leave = 0;
        int death = 0;
        int totalPurePlaytime, kills, damageTaken, deaths, regenTime, nearDeathSurvives, npcTalks, memoryTime = 0;
        Scanner userInput = new Scanner(System.in);

        // Data Gathering
        System.out.println("How long did you take for your playthrough?");
        // TODO researching if total playtime or total active playtime is important
        System.out.print("Active playtime:");
        totalPurePlaytime = Integer.parseInt(userInput.nextLine());

        System.out.println("How many enemies did you kill?");
        System.out.print("Enemies killed:");
        kills = userInput.nextInt();

        System.out.println("\nHow often did you die and took damage?");
        System.out.print("Damage taken:");
        damageTaken = userInput.nextInt();
        System.out.print("Deaths:");
        deaths = userInput.nextInt();

        System.out.println("\nHow often did you cheat death?");
        System.out.print("Neardeath:");
        nearDeathSurvives = userInput.nextInt();

        System.out.println(
                "\nHow often did you talk to NPCs? (if you spoke with everyone and exhausted the dialogue just enter a value greater than 35)");
        System.out.print("Amount of NPC interactions:");
        npcTalks = userInput.nextInt();

        System.out.println(
                "\nHow long were your regenTime? (The time regenating after experiencing near death state ~2 minutes)");
        System.out.print("regenTime (in minutes):");
        regenTime = userInput.nextInt();

        System.out.println(
                "\nHow much time did you spent in the Penrose Memory? (Waking up to return to the great red desert)");
        System.out.print("Penrose memory time (in minutes):");
        memoryTime = userInput.nextInt();
        userInput.close();

        // Calculating Ending Score
        for (int i = 2; i > 0 || regenTime >= 5; i--) {
            death++;
            regenTime -= 5;
        }

        if (totalPurePlaytime < 6) {
            cirlce += 2;
        } else if (totalPurePlaytime > 12) {
            death += 2;
        }

        if (kills > 120) {
            death += 2;
        } else if (kills > 90) {
            death++;
        }

        if (damageTaken > 1900 && deaths > 5) {
            death += 2;
        } else if (damageTaken > 1900 || deaths > 5) {
            death++;
        }

        if (nearDeathSurvives > 8) {
            death++;
        }

        if (npcTalks > 35 && memoryTime > 5) {
            leave += 2;
        } else if (npcTalks > 25 && memoryTime > 5) {
            leave += 2;
        } else if (memoryTime > 5) {
            leave++;
        }

        // Deciding Ending based on Score
        if (death > cirlce && death > leave) {
            ending = 2;
        } else if (leave > death && leave > cirlce) {
            ending = 1;
        }

        // Outputting Ending + Data
        switch (ending) {
            case 0:
                System.out.println(
                        "It seems you need to repeat the cycle to fulfill your promise...\n Ending received: Memory");
                break;

            case 1:
                System.out.println(
                        "You did not achieve it... You could not face Ariane and had to abandon her, running away and die alone...\n Ending received: Leave");
                break;

            case 2:
                System.out.println("You remembered the promise...\n Ending received: Promise");
                break;
            default:
                System.out.println("ACTHUNG! ACHTUNG! 39486 60170 24326 01064...");
                break;
        }
        System.out.println("Totalscore\nCirlce: " + cirlce + " Leave: " + leave + " Deeath: " + death);
    }
}