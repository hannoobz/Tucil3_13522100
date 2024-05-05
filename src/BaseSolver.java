import java.util.*;

public abstract class BaseSolver{
    protected PriorityQueue<WordNode> openQueue;
    protected WordNode targetNode;
    protected HashSet<String> visitedNode;
    protected ArrayList<String> pathSolution;
    protected long runtime;

    public BaseSolver(String startNode, String targetNode){
        this.targetNode = new WordNode(targetNode, null, null);
        this.visitedNode = new HashSet<>();
    }

    public WordNode getTargetNode() {
        return targetNode;
    }

    public ArrayList<String> getPathSolution(){
        return this.pathSolution;
    }
    abstract public void solve(GameDictionary gameDictionary);
    abstract public Integer getVisitCount();

    
}
