package practice.oop.abstraction;

public class Square extends Shape{

    private int side;

    @Override
    public void calculateArea() {
        System.out.println("Square area is: " + side*side);
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}
