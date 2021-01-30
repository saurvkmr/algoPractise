package practise.trees;

import java.util.Objects;

public class NodeLocation implements Comparable<NodeLocation> {
    int x;
    int y;
    int val;

    public NodeLocation(int xValue, int yValue, int valValue) {
        x = xValue;
        y = yValue;
        val = valValue;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public int compareTo(NodeLocation nodeLocation) {
        Objects.requireNonNull(nodeLocation);
        int xAxisCompare = Integer.compare(this.x, nodeLocation.x);
        int yAxisCompare = Integer.compare(this.y, nodeLocation.y);
        int valAxisCompare = Integer.compare(this.val, nodeLocation.val);
        if (xAxisCompare == 0) {
            if (yAxisCompare == 0)
                return valAxisCompare;
            else
                return yAxisCompare;
        } else
            return xAxisCompare;
    }
}
