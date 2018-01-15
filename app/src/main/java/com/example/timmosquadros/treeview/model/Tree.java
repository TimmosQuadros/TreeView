package com.example.timmosquadros.treeview.model;

/**
 * Created by TimmosQuadros on 12-01-2018.
 */

public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
