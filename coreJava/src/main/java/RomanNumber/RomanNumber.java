package RomanNumber;

import java.util.regex.Pattern;

//Pattern是用于表达正则表达式的一个类
public class RomanNumber {
    //    static boolean isRomanNumeral(String s){
//        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
//        + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
//    }
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s){
        return ROMAN.matcher(s).matches();
    }
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(isRomanNumeral("12345"));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }
}
