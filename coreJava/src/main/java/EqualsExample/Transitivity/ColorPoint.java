package EqualsExample.Transitivity;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    //如何用父类Point调用equals方法，显然Point和ColorPoint是相同的，因为没有比较color的地方，但是子类ColorPoint
    //调用Point和父类比又是不同的，这违反了对称性
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color.equals(color);
    }


    public static void main(String[] args) {


        Color color = new Color("red");
        Point point = new Point(1, 2);
        ColorPoint colorPoint = new ColorPoint(1, 2, color);

        System.out.println(point.equals(colorPoint));
        System.out.println(colorPoint.equals(point));
    }
}
