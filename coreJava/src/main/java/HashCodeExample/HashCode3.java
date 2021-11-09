package HashCodeExample;

public class HashCode3 {

    private int hashCode;
    private int a;
    private int b;
    private int c;

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {

            result = Integer.hashCode(a);
            result = 31 * result + Integer.hashCode(b);
            result = 31 * result + Integer.hashCode(c);
            hashCode = result;
        }

        return hashCode;
    }

}
