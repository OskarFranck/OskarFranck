import java.util.ArrayList;
import java.util.Random;

public class GenerateMonster {

    static ArrayList<Monster> monster = new ArrayList<>();
    static Monster giantSpider = new Giantspider (7, 1, 2, 3, 0.20);
    static Monster skeleton = new Skeleton (4, 2, 3, 3, 0.15);
    static Monster orc = new Orc (6, 3, 4, 4, 0.10);
    static Monster troll = new Troll (2, 4, 7, 2, 0.05);

    public static void randomMonster() {
        Random rand = new Random();

        int loopTime = rand.nextInt(3) +1;

        while (loopTime < 4) {
            int randNumber = rand.nextInt(99) +1;

            if (randNumber < 20) {
                generateGiantSpider();
            } else if (randNumber < 35) {
                generateSkeleton();
            } else if (randNumber < 45) {
                generateOrc();
            } else if (randNumber < 50) {
                generateTroll();
            }
            loopTime++;
        }
    }

    public static void generateTroll() {
        monster.add(troll);
    }

    public static void generateOrc() {
        monster.add(orc);
    }

    public static void generateGiantSpider() {
        monster.add(giantSpider);
    }

    public static void generateSkeleton() {
        monster.add(skeleton);
    }
}

