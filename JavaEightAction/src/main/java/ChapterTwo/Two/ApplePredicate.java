package ChapterTwo.Two;

import ChapterTwo.One.Apple;

/**
 * 对选择标准建模，称为算法族，再根据算法族定义不同的策略。再根据不同的行为进行不同的实现
 * ApplePredicate作为参数类型，不同的接口实现都可以作为参数送入，这就是行为参数化
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
