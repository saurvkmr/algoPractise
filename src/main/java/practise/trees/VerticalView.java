package practise.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class VerticalView {
    public static void main(String[] args) {
        IntBinaryTree tree = new IntBinaryTree(10, 7, 15, 4, 8, 9, 13, 17, 2, 6, 14, 16, 20, 1, 3, 5);
        computeNodeLocations(tree.root);
    }

    private static void computeNodeLocations(IntBinaryTree.TreeNode root) {
        Objects.requireNonNull(root, "Root node cannot be null");
        int x = 0, y = 0;
        List<NodeLocation> nodeLocations = new ArrayList<>();
        Deque<IntBinaryTree.TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Map<IntBinaryTree.TreeNode, NodeLocation> node = new HashMap<>();
        while (!queue.isEmpty()) {
            IntBinaryTree.TreeNode temp = queue.pop();
            NodeLocation location = node.get(temp);
            if (location == null) {
                location = new NodeLocation(x, y, root.val);
                node.put(temp, location);
            }
            nodeLocations.add(location);
            int parentX = location.x;
            int parentY = location.y;

            if (temp.left != null) {
                queue.add(temp.left);
                NodeLocation leftChild = new NodeLocation(parentX - 1, parentY - 1, temp.left.val);
                node.put(temp.left, leftChild);
            }
            if (temp.right != null) {
                queue.add(temp.right);
                NodeLocation rightChild = new NodeLocation(parentX + 1, parentY - 1, temp.right.val);
                node.put(temp.right, rightChild);
            }
        }

        groupByXCoordinate(nodeLocations);
    }

    private static void groupByXCoordinate(List<NodeLocation> nodeLocations) {
        Map<Integer, List<NodeLocation>> xCoordinateToNodeLoc = new TreeMap<>();
        nodeLocations.forEach(nodeLocation -> {
            List<NodeLocation> nodes = xCoordinateToNodeLoc.getOrDefault(nodeLocation.x, new ArrayList<>());
            nodes.add(nodeLocation);
            xCoordinateToNodeLoc.put(nodeLocation.x, nodes);
        });

        for (Integer i : xCoordinateToNodeLoc.keySet()) {
            xCoordinateToNodeLoc.get(i).forEach(nodeLocation -> System.out.print(nodeLocation.val + " "));
            System.out.println();
        }
    }
}
