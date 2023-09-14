package com.quiz.Data;

import java.util.Comparator;

public class Node implements Comparable<Node> {
    private String name;
    private int score;
    public Node(String name,int score){
        this.name=name;
        this.score=score;
    }
    public Node(){}
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }


    @Override
    public int compareTo(Node o) {
        return o.score-this.score;
    }
}
