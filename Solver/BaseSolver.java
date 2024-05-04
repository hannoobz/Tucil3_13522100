package Solver;
import java.util.*;

import Dictionary.GameDictionary;
import WordNode.WordNode;


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

    abstract void solve(GameDictionary gameDictionary);

    
}
