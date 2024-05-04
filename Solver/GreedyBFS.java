package Solver;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Dictionary.GameDictionary;
import WordNode.WordNode;

public class GreedyBFS extends BaseSolver {
    public GreedyBFS(String startNode, String targetNode) {
        super(startNode, targetNode);
        this.openQueue = new PriorityQueue<>(new GBFSComparator());
        this.openQueue.add(new WordNode(startNode, 0,this.targetNode.getDifference(startNode)));
    }

    public void solve(GameDictionary gameDictionary){
        ArrayList<String> possibleMove;
        WordNode currentNode = openQueue.peek();
        while(!this.openQueue.isEmpty() && !currentNode.getWord().equals(this.targetNode.getWord())){
            currentNode = this.openQueue.poll();
            possibleMove = currentNode.generatePossibleMove();
            for(String item : possibleMove){
                if(gameDictionary.getData().contains(item)){
                    openQueue.add(new WordNode(item,currentNode.getWeight()+1, targetNode.getDifference(item),currentNode));
                }
            }
            System.out.println("Expanded " + currentNode.getWord());
            if(this.visitedNode.contains(currentNode.getWord())){
                WordNode noSolution = new WordNode("No Solution", null, null);
                this.targetNode = noSolution;
                break;
            }
            else{
                this.visitedNode.add(currentNode.getWord());
            }
        }
        if(currentNode.getWord().equals(this.targetNode.getWord())){
            this.targetNode = currentNode;
        }
    }
}

class GBFSComparator implements Comparator<WordNode>{
    public int compare(WordNode n1, WordNode n2) {
       if(n1.getHeuristic()>n2.getHeuristic()){
           return 1;
       }
       else if(n1.getHeuristic()<n2.getHeuristic()){
           return -1;
       }
       return 0;
   }
}