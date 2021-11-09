package EqualsExample.Transitivity;

public class Color {
    private String color;

    public Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Color && ((Color)o).color.equalsIgnoreCase(color);
    }
}
