import java.util.*;


public class GBFS{
    private PriorityQueue<WordNode> openQueue;
    private HashSet<WordNode> visitedQueue;
    private WordNode targetNode;

    public GBFS(String startNode, String targetNode){
        this.openQueue = new PriorityQueue<>(new GBFSComparator());
        this.visitedQueue = new HashSet<>();
        this.targetNode = new WordNode(targetNode, null, null);
        this.openQueue.add(new WordNode(startNode, 0,this.targetNode.getDifference(startNode)));
    }

    public WordNode getTargetNode() {
        return targetNode;
    }

    public void solve(GameDictionary gameDictionary){
        ArrayList<String> possibleMove;
        WordNode currentNode = openQueue.peek();
        while(!this.openQueue.isEmpty() && !currentNode.getWord().equals(this.targetNode.getWord())){
            currentNode = this.openQueue.poll();
            possibleMove = currentNode.generatePossibleMove();
            for(String item : possibleMove){
                if(gameDictionary.getData().contains(item)){
                    openQueue.add(new WordNode(item,0, targetNode.getDifference(item),currentNode));
                }
            }
            this.visitedQueue.add(currentNode);
        }
        if(currentNode.getWord().equals(this.targetNode.getWord())){
            this.targetNode = currentNode;
        }
    }
}

class GBFSComparator implements Comparator<WordNode>{
     public int compare(WordNode n1, WordNode n2) {
        if(n1.getHeuristic()<n2.getHeuristic()){
            return 1;
        }
        else if(n1.getHeuristic()>n2.getHeuristic()){
            return -1;
        }
        return 0;
    }
}

