package ChapterThree;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GuiYueTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Integer sum = numbers.stream().reduce(0, Integer::sum);
        //没有初始值就会返回一个Optional类型的值，因为不确定是否有返回值
        Optional<Integer> reduce = numbers.stream().reduce(Integer::sum);


        /**
         * 诸如map或filter等操作会从输入流中获取每一个元素，并在输出流中得到0或1个结果。 这些操作一般都是无状态的：它们没有内部状态
         * 但诸如reduce、sum、max等操作需要内部状态来累积结果。在上面的情况下，内部状态 很小。在我们的例子里就是一个int或double。不管流中有多少元素要处理，内部状态都是有界的。
         */

        
    }
}
