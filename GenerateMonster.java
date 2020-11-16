import java.util.ArrayList;
import java.util.Random;

public class GenerateMonster {

    static ArrayList<Monster> monster = new ArrayList<>();

    public static ArrayList<Monster> randomMonster() {
        Random rand = new Random();

        int loopTime = rand.nextInt(3) + 1;

        while (loopTime < 4) {
            int randNumber = rand.nextInt(99) + 1;

            if (randNumber < 20) {
                Monster giantSpider = new Giantspider(7, 1, 2, 3, 0.20);
                monster.add(giantSpider);
            } else if (randNumber < 35) {
                Monster skeleton = new Skeleton(4, 2, 3, 3, 0.15);
                monster.add(skeleton);
            } else if (randNumber < 45) {
                Monster orc = new Orc(6, 3, 4, 4, 0.10);
                monster.add(orc);
            } else if (randNumber < 50) {
                Monster troll = new Troll(2, 4, 7, 2, 0.05);
                monster.add(troll);
            }
            loopTime++;
        }
        return monster;
    }
}