import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateMonster {

    static ArrayList<Monster> monster = new ArrayList<>();


    public static ArrayList<Monster> randomMonster() {
        Random rand = new Random();
        /*
        Monster giantSpider = new Giantspider (7, 1, 2, 3);
        Monster skeleton = new Skeleton (4, 2, 3, 3);
        Monster orc = new Orc (6, 3, 4, 4);
        Monster troll = new Troll (2, 4, 7, 2);
        Random rand = new Random();

         */

        // int loopTime = rand.nextInt(3) + 1;

        //while (loopTime < 4) {
        int randNumber = rand.nextInt(50) + 1;

        if (randNumber < 20) {
            Monster giantSpider = new Giantspider(7, 1, 2, 3);
            monster.add(giantSpider);
            System.out.println("Giantspider approaches");
        } else if (randNumber > 19 && randNumber < 35) {
            Monster skeleton = new Skeleton(4, 2, 3, 3);
            monster.add(skeleton);
            System.out.println("Skeleton approaches");
        } else if (randNumber > 34 && randNumber < 45) {
            Monster orc = new Orc(6, 3, 4, 4);
            monster.add(orc);
            System.out.println("Orc approaches");
        } else {
            Monster troll = new Troll(2, 4, 7, 2);
            monster.add(troll);
            System.out.println("Troll approaches");
        }
        // loopTime++;
        //  }
        return monster;
    }
}