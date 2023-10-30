import java.util.ArrayList;
import java.util.List;

class Point {
    int x;
    int y;

    Point() {
        x = -1;
        y = -1;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

class QuadTree {
    private Point point;
    private Point top_left;
    private Point bottom_right;
    private List<QuadTree> children;

    private static final int TL = 0;
    private static final int TR = 1;
    private static final int BR = 2;
    private static final int BL = 3;

    QuadTree() {
        point = new Point();
    }

    QuadTree(int x, int y) {
        point = new Point(x, y);
    }

    QuadTree(int x1, int y1, int x2, int y2) {
        if (x2 < x1 || y2 < y1) {
            return;
        }
        point = null;
        top_left = new Point(x1, y1);
        bottom_right = new Point(x2, y2);
        children = new ArrayList<>(4);
        for (int i = TL; i <= BL; i++) {
            children.add(null);
        }
    }

    void insert(int x, int y) {
        if (x < top_left.x || x > bottom_right.x || y < top_left.y || y > bottom_right.y) {
            return;
        }
        int midx = (top_left.x + bottom_right.x) >> 1;
        int midy = (top_left.y + bottom_right.y) >> 1;
        int pos = -1;
        if (x <= midx) {
            if (y <= midy)
                pos = TL;
            else
                pos = BL;
        } else {
            if (y <= midy)
                pos = TR;
            else
                pos = BR;
        }

        if (children.get(pos).point == null) {
            children.get(pos).insert(x, y);
            return;
        } else if (children.get(pos).point.x == -1) {
            children.set(pos, new QuadTree(x, y));
            return;
        } else {
            int x_ = children.get(pos).point.x;
            int y_ = children.get(pos).point.y;
            children.set(pos, null);
            if (pos == TL) {
                children.set(pos, new QuadTree(top_left.x, top_left.y, midx, midy));
            } else if (pos == TR) {
                children.set(pos, new QuadTree(midx + 1, top_left.y, bottom_right.x, midy));
            } else if (pos == BR) {
                children.set(pos, new QuadTree(midx + 1, midy + 1, bottom_right.x, bottom_right.y));
            } else {
                children.set(pos, new QuadTree(top_left.x, midy + 1, midx, bottom_right.y));
            }
            children.get(pos).insert(x_, y_);
            children.get(pos).insert(x, y);
        }
    }

    boolean find(int x, int y) {
        if (x < top_left.x || x > bottom_right.x || y < top_left.y || y > bottom_right.y) {
            return false;
        }
        int midx = (top_left.x + bottom_right.x) >> 1;
        int midy = (top_left.y + bottom_right.y) >> 1;
        int pos = -1;
        if (x <= midx) {
            if (y <= midy)
                pos = TL;
            else
                pos = BL;
        } else {
            if (y <= midy)
                pos = TR;
            else
                pos = BR;
        }
        if (children.get(pos).point == null) {
            return children.get(pos).find(x, y);
        } else if (children.get(pos).point.x == -1) {
            return false;
        } else {
            return x == children.get(pos).point.x && y == children.get(pos).point.y;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        QuadTree tree = new QuadTree(1, 1, 4, 4);
        System.out.println("Insert (3, 3)");
        tree.insert(3, 3);
        System.out.println("Insert (4, 4)");
        tree.insert(4, 4);
        System.out.println("Insert (1, 4)");
        tree.insert(1, 4);

        System.out.println("Find (3, 3):");
        System.out.println(tree.find(3, 3) ? "True" : "False");
        System.out.println("Find (3, 4):");
        System.out.println(tree.find(3, 4) ? "True" : "False");
    }
}
