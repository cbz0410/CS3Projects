/* Goopert
 * 1A Malloy
 * 8/18/22
 * Program Description: In-class notes for chapter 18 */

public class Chapter18Notes {
    public static void main(String[] args) {
        Circle[] circles = new Circle[100];

        for(int i = 0; i < 100; i++) {
            circles[i] = new Circle(Math.random() * 51 + 50);
        }
    }
}

class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}