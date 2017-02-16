package com.matthewyao.effective;

/**
 * Created by matthewyao on 2017/2/16.
 */
public class ColorPoint extends Point{
    private final int color;

    public ColorPoint(int x, int y,int color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)){
            return false;
        }
        return super.equals(o) && ((ColorPoint)o).color == color;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color;
        return result;
    }

    public static void main(String[] args) {
        Point p = new Point(1,2);
        ColorPoint cp = new ColorPoint(1,2,3);
        System.out.println(p.equals(cp));
        System.out.println(cp.equals(p));
    }
}
