package com.hannoobz.wordladdersolver.Solver;
import java.util.*;

import com.hannoobz.wordladdersolver.Dictionary.GameDictionary;
import com.hannoobz.wordladdersolver.WordNode.WordNode;


public abstract class BaseSolver{
    protected PriorityQueue<WordNode> openQueue;
    protected WordNode targetNode;
    protected HashSet<String> visitedNode;

    public BaseSolver(String startNode, String targetNode){
        this.targetNode = new WordNode(targetNode, null, null);
        this.visitedNode = new HashSet<>();
    }

    public WordNode getTargetNode() {
        return targetNode;
    }

    abstract public void solve(GameDictionary gameDictionary);
    abstract public Integer getVisitCount();

    
}
