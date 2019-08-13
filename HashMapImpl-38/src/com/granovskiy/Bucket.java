package com.granovskiy;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Node node;
    private int index;
    private int bucketSize = 16;
    private List<Node> nodeList = new ArrayList<Node>(16);

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "node=" + node +
                ", nodeList=" + nodeList +
                '}';
    }
}
