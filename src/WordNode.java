import java.util.ArrayList;

public class WordNode{

    // Attribute
    private String word;
    private Integer weight;
    private Integer heuristic;
    private WordNode parent;

    // Constructor
    public WordNode(String word, Integer weight, Integer heuristic, WordNode parent){
        this.word = word;
        this.weight = weight;
        this.heuristic = heuristic;
        this.parent = parent;
    }

    public WordNode(String word, Integer weight, Integer heuristic){
        this(word, weight, heuristic, null);
    }

    // Setter
    public void setWord(String word) {
        this.word = word;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setHeuristic(Integer heuristic) {
        this.heuristic = heuristic;
    }
    
    public void setParent(WordNode parent) {
        this.parent = parent;
    }

    //Getter
    public String getWord() {
        return word;
    }
    
    public Integer getWeight() {
        return weight;
    }

    public Integer getHeuristic() {
        return heuristic;
    }

    public WordNode getParent() {
        return parent;
    }

    public Integer getTotalCost(){
        return weight+heuristic;
    }

    //Operations
    public Integer getDifference(String target){
        if(this.word.length()!=target.length()){
            return -1;
        }
        else{
            Integer diff = 0;
            for(int i=0;i<this.word.length();i++){
                if(this.word.charAt(i)!=target.charAt(i)){
                    diff++;
                }
            }
            return diff;
        }
    }

    public Integer getDifference(WordNode target){
        return this.getDifference(target.getWord());
    }

    public Integer getWordLength(){
        return this.word.length();
    }

    public ArrayList<String> generatePossibleMove(){
        StringBuilder editor;
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<this.getWordLength();i++){
            for(int j=97;j<123;j++){
                editor = new StringBuilder(this.getWord());
                editor.setCharAt(i, (char)j);
                if(!editor.toString().equals(this.word)){
                    result.add(editor.toString());
                }
            }
        }
        return result;

    }

    public void printNode(){
        System.out.println("Word: "+getWord());
        System.out.println("Weight: "+getWeight());
        System.out.println("Heuristic: "+getHeuristic());
        System.out.println("Cost: "+getTotalCost());
        System.out.println("Parent: "+getParent());
    }


    // public static void main(String[] args){
    //     WordNode a = new WordNode("kill", 0, 0);
    //     ArrayList<String> possible = a.generatePossibleMove(); 
    //     a.printNode();
    //     System.out.println(possible);

    // }
}