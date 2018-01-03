import java.util.ArrayList;

public class CompositeNode extends AbstractNode {

    private String program;
    private int weight;
    private ArrayList<AbstractNode> children = new ArrayList<>();
    private CompositeNode parent;

    CompositeNode() {

    }

    CompositeNode(String program, int weight) {
        super();
        this.program = program;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.program;
    }

    @Override
    public void addParent(CompositeNode parent) {
        this.parent = parent;
    }

    public void addChild(AbstractNode child) {
        children.add(child);
    }

    public String getProgram() {
        return program;
    }

    public int getWeight() {
        return weight;
    }

    public ArrayList<AbstractNode> getChildren() {
        return children;
    }

    public CompositeNode getParent() {
        return this.parent;
    }

}