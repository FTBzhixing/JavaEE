package HashCodeExample;

public class HashCode1 {

    private int a;
    private int b;
    private int c;

//把类中成员变量的类型都是基础类型的变量都拿来放进hashcode中进行这样的计算
    @Override
    public int hashCode() {

        int result = Integer.hashCode(a);
        result = 31 * result + Integer.hashCode(b);
        result = 31 * result + Integer.hashCode(c);
        return result;

    }
}
