package ChapterTwo.Two;

import ChapterTwo.One.Apple;

//仅仅选出绿苹果
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
