import java.time.Duration;
import java.time.Instant;

import Dictionary.GameDictionary;
import Solver.GreedyBFS;
import WordNode.WordNode;

public class MainRunner {
    public static void main(String[] args) {
        GameDictionary gDictionary = new GameDictionary();
        gDictionary.read("words.txt");
        GreedyBFS gbfs = new GreedyBFS("love","kiss");
        Instant startTime = Instant.now();
        gbfs.solve(gDictionary);
        Instant endTime = Instant.now();

        WordNode currentNode = gbfs.getTargetNode();
        while (currentNode!=null) {
            System.out.println("Final:"+currentNode.getWord());
            // System.out.println(currentNode.getParent());
            currentNode = currentNode.getParent();
        }
        System.out.println("Runtime: "+ Duration.between(startTime, endTime));

    }
}
