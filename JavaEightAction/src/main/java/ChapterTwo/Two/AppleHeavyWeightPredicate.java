package ChapterTwo.Two;

import ChapterTwo.One.Apple;

//仅仅选出重的苹果
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
