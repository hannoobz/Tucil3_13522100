import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar extends UniformCostSearch {
    public AStar(String startNode, String targetNode) {
        super(startNode, targetNode);
        this.openQueue = new PriorityQueue<>(new AStarComparator());
        this.openQueue.add(new WordNode(startNode, 0,this.targetNode.getDifference(startNode)));
    }
}

class AStarComparator implements Comparator<WordNode>{
    public int compare(WordNode n1, WordNode n2) {
       if(n1.getTotalCost()>n2.getTotalCost()){
           return 1;
       }
       else if(n1.getTotalCost()<n2.getTotalCost()){
           return -1;
       }
       return 0;
   }
}