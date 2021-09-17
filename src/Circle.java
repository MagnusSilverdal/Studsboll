/**
 * This is a class
 * Created 2021-09-13
 *
 * @author Magnus Silverdal
 */
public class Circle {
    private double radius;
    private String color;

    public Circle() {
        radius = 1;
        color = "red";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle(double v) {
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {

        return 0;
    }
}
