package HashCodeExample;

import java.util.Objects;

public class HashCode2 {
    private int a;
    private int b;
    private int c;
//该方法可以传入任意数量的参数，返回一个散列码，但是效率不高，因为它会引起数组的创建。
    @Override
    public int hashCode() {
        return Objects.hash(a,b,c);
    }
}
