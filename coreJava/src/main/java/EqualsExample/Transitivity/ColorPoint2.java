package EqualsExample.Transitivity;

import java.util.Objects;

/**
 * 正确写法
 */
public class ColorPoint2 {
    private Point point;
    private Color color;

    public ColorPoint2(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ColorPoint2))
            return false;
        ColorPoint2 colorPoint2 = (ColorPoint2) o;
        return colorPoint2.point.equals(point) && colorPoint2.color.equals(color);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        Color color1 = new Color("red");
        Color color2 = new Color("blue");
        Point point = new Point(1, 2);
        ColorPoint colorPoint1 = new ColorPoint(1, 2, color1);
        ColorPoint colorPoint2 = new ColorPoint(1, 2, color2);

        System.out.println(point.equals(colorPoint1));

        System.out.println(colorPoint1.equals(point));
        System.out.println(point.equals(colorPoint2));
        System.out.println(colorPoint1.equals(colorPoint2));
    }
}
