import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;


public class GreedyBFS extends BaseSolver {
    private HashSet<String> multipleVisit;

    public Integer getVisitCount(){
        return this.visitedNode.size()+this.multipleVisit.size();
    }

    public GreedyBFS(String startNode, String targetNode) {
        super(startNode, targetNode);
        this.openQueue = new PriorityQueue<>(new GBFSComparator());
        this.openQueue.add(new WordNode(startNode, 0,this.targetNode.getDifference(startNode)));
        this.multipleVisit =  new HashSet<>();
    }

    public void solve(GameDictionary gameDictionary){
        long startTime = System.currentTimeMillis();
        ArrayList<String> possibleMove;
        WordNode currentNode = openQueue.peek();
        if(this.getTargetNode().getWord().length()==currentNode.getWord().length() && gameDictionary.getData().contains(currentNode.getWord()) && gameDictionary.getData().contains(this.getTargetNode().getWord())){
                while(!this.openQueue.isEmpty() && !currentNode.getWord().equals(this.targetNode.getWord())){
                    currentNode = this.openQueue.poll();
                    possibleMove = currentNode.generatePossibleMove();
                    for(String item : possibleMove){
                        if(gameDictionary.getData().contains(item)){
                            openQueue.add(new WordNode(item,currentNode.getWeight()+1, targetNode.getDifference(item),currentNode));
                        }
                    }
                    System.out.println("Expanded " + currentNode.getWord());
                    if(this.multipleVisit.contains(currentNode.getWord())){
                        WordNode noSolution = new WordNode("No Solution", null, null);
                        this.targetNode = noSolution;
                        pathSolution = new ArrayList<>();
                        pathSolution.add(0, noSolution.getWord());
                        break;
                    }
                    if(this.visitedNode.contains(currentNode.getWord())){
                        multipleVisit.add(currentNode.getWord());
                    }
                    else{
                        this.visitedNode.add(currentNode.getWord());
                    }
                }
                if(currentNode.getWord().equals(this.targetNode.getWord())){
                    this.targetNode = currentNode;
                    pathSolution = new ArrayList<>();
                    while (currentNode!=null) {
                        pathSolution.add(0,currentNode.getWord());
                        currentNode = currentNode.getParent();
                    }
                } 
                else{
                    WordNode noSolution = new WordNode("No Solution", null, null);
                    this.targetNode = noSolution;
                    pathSolution = new ArrayList<>();
                    pathSolution.add(0, noSolution.getWord());
                }
            }
            else{
                WordNode noSolution = new WordNode("No Solution", null, null);
                this.targetNode = noSolution;
                pathSolution = new ArrayList<>();
                pathSolution.add(0, noSolution.getWord());
            }
            long endTime = System.currentTimeMillis();
            this.runtime = endTime-startTime;
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