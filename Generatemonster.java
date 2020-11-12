import java.util.ArrayList;

public class Generatemonster {

    static ArrayList<Monster> monster = new ArrayList<>();
    static Monster giantSpider = new Giantspider (7, 1, 2, 3, 0.20);
    static Monster skeleton = new Skeleton (4, 2, 3, 3, 0.15);
    static Monster orc = new Orc (6, 3, 4, 4, 0.10);
    static Monster troll = new Troll (2, 4, 7, 2, 0.05);

    public static void randomMonster() {

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

