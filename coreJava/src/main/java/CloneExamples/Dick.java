package CloneExamples;

public class Dick implements Cloneable{
    int size = 18;

    @Override
    protected Dick clone() throws CloneNotSupportedException {
        return (Dick) super.clone();
    }
}
