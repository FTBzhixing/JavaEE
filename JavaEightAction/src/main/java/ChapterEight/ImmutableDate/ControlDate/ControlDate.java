package ChapterEight.ImmutableDate.ControlDate;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * 如果你已经有一个LocalDate对象，想要创建它的一个修改版，最直接也最简单的方法是使
 * 用withAttribute方法。withAttribute方法会创建对象的一个副本，并按照需要修改它的属 性。
 * 注意，下面的这段代码中所有的方法都返回一个修改了属性的对象。它们都不会修改原来的 对象
 */
public class ControlDate {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
    }
}
