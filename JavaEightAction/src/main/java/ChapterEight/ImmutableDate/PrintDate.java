package ChapterEight.ImmutableDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * java.time.format用于格式化以及解析日期时间对象
 */
public class PrintDate {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);//20140318
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);//2014-03-18

        /**
         * 所有的DateTimeFormatter实例都是线程安全
         * 的。所以，你能够以单例模式创建格式器实例，就像DateTimeFormatter所定义的那些常量，并能在多个线程间共享这些实例。
         * DateTimeFormatter类还支持一个静态工厂方法，它可以按照某个特定的模式创建格式
         */

        //按照某个模式创建DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(formatter);//18/03/2014
        LocalDate date2 = LocalDate.parse(formattedDate, formatter);
        System.out.println(formattedDate);//2014-03-18
        System.out.println(date2);

        //创建一个本地化的DateTimeFormatter
        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date3 = LocalDate.of(2014, 3, 18);
        String formattedDate1 = date.format(italianFormatter); // 18. marzo 2014
        LocalDate date4 = LocalDate.parse(formattedDate, italianFormatter);

        /**
         * 如果你还需要更加细粒度的控制，DateTimeFormatterBuilder类还提供了更复杂
         * 的格式器，你可以选择恰当的方法，一步一步地构造自己的格式器。另外，它还提供了非常强大 的解析功能，
         * 比如区分大小写的解析、柔性解析（允许解析器使用启发式的机制去解析输入，不 精确地匹配指定的模式）、填充，以及在格式器中指定可选节。
         */

        DateTimeFormatter italianFormatter1 = new DateTimeFormatterBuilder() .appendText(ChronoField.DAY_OF_MONTH) .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR) .appendLiteral(" ")
                .appendText(ChronoField.YEAR) .parseCaseInsensitive() .toFormatter(Locale.ITALIAN);


    }
}
