package com.example.timmosquadros.treeview.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by TimmosQuadros on 12-01-2018.
 */

public class Node {

    //One biologically mother
    private Node father;
    //One biologically father
    private Node mother;
    //One or more children
    private ArrayList<Node> children;

    //General information
    private String firstName;
    private ArrayList<String> middleNames;
    private String lastName;
    private String birthPlace;
    private Date birthDate;
    private String imageUrl;

    //For the view
    private int level;

    public Node(Node father, Node mother, ArrayList<Node> children, String firstName, ArrayList<String> middleNames, String lastName, String birthPlace, Date birthDate, String imageUrl) {
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.imageUrl = imageUrl;
    }

    //Simple constructor
    public Node(Node father, Node mother, String firstName, String lastName) {
        this.father = father;
        this.mother = mother;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addChild(Node child){
        this.children.add(child);
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getMother() {
        return mother;
    }

    public void setMother(Node mother) {
        this.mother = mother;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ArrayList<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(ArrayList<String> middleNames) {
        this.middleNames = middleNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
