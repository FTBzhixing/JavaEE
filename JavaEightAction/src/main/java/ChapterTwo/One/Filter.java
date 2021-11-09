package ChapterTwo.One;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    /**
     * 筛选绿苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equalsIgnoreCase(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 颜色也作为参数
     *
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equalsIgnoreCase(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 重量作为参数
     * @param inventory
     * @param weight
     * @return
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 把所有用到的参数都放进去
     * @param inventory
     * @param color
     * @param weight
     * @param flag
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, Boolean flag) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((apple.getWeight() > weight)&&(color.equalsIgnoreCase(apple.getColor()))) {
                result.add(apple);
            }
        }
        return result;
    }
}
