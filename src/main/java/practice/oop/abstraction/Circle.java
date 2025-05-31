package practice.oop.abstraction;

public class Circle extends Shape{

    private int r;

    @Override
    public void calculateArea() {
        System.out.println("Circle area is: " + Math.PI * Math.pow(r, 2));
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
