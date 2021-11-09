package EqualsExample.Symmetry;

import java.util.Objects;

/**
 * 对称性
 */
public final class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }
    //该方法覆盖了equals，想实现的是CaseInsensitiveString或者String类或者是他们的子类，只要内容相等就返回true
    //但是CaseInsensitiveString这边实现了equals,String的原生equals仍只能判断同为String类的对象内容
    //这就违反了重写equals的对称性原则。
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString)
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        if (o instanceof String)
//            return s.equalsIgnoreCase((String) o);
//        return false;
//    }
    //改成这样就是正确的了
    @Override
    public boolean equals(Object o){
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString)o).s.equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString string1 = new CaseInsensitiveString("fang");
        String string2 = "fang";
        //错误方法的test
        System.out.println(string1.equals(string2));
        System.out.println(string2.equals(string1));
    }
}
