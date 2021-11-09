package CloneExamples;

public class Human implements Cloneable{
    private Dick dick = new Dick();

    @Override
    protected Human clone() throws CloneNotSupportedException {
        Human clone = (Human)super.clone();
        clone.dick = dick.clone();
        return clone;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Human human = new Human();
        Human clone = human.clone();
        System.out.println(human.equals(clone));
        System.out.println(human.dick==clone.dick);
    }
}
