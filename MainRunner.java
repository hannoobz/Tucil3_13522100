public class MainRunner {
    public static void main(String[] args) {
        GameDictionary gDictionary = new GameDictionary();
        gDictionary.read("words.txt");
        GBFS gbfs = new GBFS("kill","feel");
        gbfs.solve(gDictionary);

        WordNode currentNode = gbfs.getTargetNode();
        while (currentNode!=null) {
            currentNode.printNode();
            currentNode = currentNode.getParent();
        }

    }
}
