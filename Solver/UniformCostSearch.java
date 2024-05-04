package Solver;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Dictionary.GameDictionary;
import WordNode.WordNode;

public class UniformCostSearch extends BaseSolver {


    public UniformCostSearch(String startNode, String targetNode) {
        super(startNode, targetNode);
        this.openQueue = new PriorityQueue<>(new UCSComparator());
        this.openQueue.add(new WordNode(startNode, 0,this.targetNode.getDifference(startNode)));
    }

    public void solve(GameDictionary gameDictionary){
        ArrayList<String> possibleMove;
        WordNode currentNode = openQueue.peek();
        while(!this.openQueue.isEmpty() && !currentNode.getWord().equals(this.targetNode.getWord())){
            currentNode = this.openQueue.poll();
            possibleMove = currentNode.generatePossibleMove();
            for(String item : possibleMove){
                WordNode inserter = new WordNode(item,currentNode.getWeight()+1, targetNode.getDifference(item),currentNode);
                if(gameDictionary.getData().contains(item) && !visitedNode.contains(inserter.getWord())){
                    openQueue.add(inserter);
                }
            }
            System.out.println("Expanded "+currentNode.getWord());
            this.visitedNode.add(currentNode.getWord());
        }
        if(currentNode.getWord().equals(this.targetNode.getWord())){
            this.targetNode = currentNode;
        }
    }
}

class UCSComparator implements Comparator<WordNode>{
    public int compare(WordNode n1, WordNode n2) {
       if(n1.getWeight()>n2.getWeight()){
           return 1;
       }
       else if(n1.getWeight()<n2.getWeight()){
           return -1;
       }
       return 0;
   }
}
