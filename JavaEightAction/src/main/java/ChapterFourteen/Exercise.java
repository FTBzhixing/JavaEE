package ChapterFourteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 什么是函数式编程
 * 被称为“函数式”的函数或方法都只能修改本地变量。除此之外，它引用的 对象都应该是不可修改的对象。通过这种规定，我们期望所有的字段都为final类型，所有的引
 * 用类型字段都指向不可变对象。要被称为函数式，函数或者方法不应该抛出任何异常那么，如果不使用异常，你该如何对除法这样的函数进行建模呢？答案是请使用
 * Optional<T>类型：你应该避免让sqrt使用double sqrt(double)这样的函数签名，因为这 种方式可能抛出异常；与之相反我们推荐你使用Optional<Double> sqrt(double)
 *
 */


/**
 * 给定一个列表List<value>，比如{1, 4,
 * 9}，构造一个List<List<Integer>>，它的成员都是类表{1, 4, 9}的子集——我们暂时不考虑 元素的顺序。{1, 4, 9}的子集是{1, 4, 9}、{1, 4}、{1, 9}、{4, 9}、{1}、{4}、{9}以及{}。
 */

/**
 * 在这里需要注意的是，在插入list时，一定要插入传入参数的副本，为每个元素创建一个副本，可以防止修改源数据，这样的编程方式才满足函数式编程
 */
public class Exercise {

    public static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            ArrayList<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    public static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        ArrayList<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }

    public static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            ArrayList<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 9);
//        System.out.println(list.get(0));
        subsets(list).stream().forEach(System.out::println);
    }
}
