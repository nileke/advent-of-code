import java.util.ArrayList;

public class CompositeNode {

    private String program;
    private int weight;
    private ArrayList<CompositeNode> children = new ArrayList<>();
    private CompositeNode parent;

    CompositeNode(String program, int weight) {
        this.program = program;
        this.weight = weight;
    }

    CompositeNode(String program) {
        this.program = program;
    }


    public void addChild(CompositeNode child) {
        children.add(child);
    }

    public String getProgram() {
        return program;
    }

    public int getWeight() {
        return weight;
    }

    public ArrayList<CompositeNode> getChildren() {
        return children;
    }

    public void addParent(CompositeNode parent)  {
        this.parent = parent;
    }

    public CompositeNode getParent() {
        return this.parent;
    }

}
