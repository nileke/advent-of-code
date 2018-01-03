public class LeafNode extends AbstractNode {

    private CompositeNode parent;
    private String program;
    private int weight;

    LeafNode() {

    }

    LeafNode(String program, int weight) {
        super();
        this.program = program;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return program;
    }

    @Override
    public void addParent(CompositeNode parent) {
        this.parent = parent;
    }

    @Override
    public CompositeNode getParent() {
        return parent;
    }

    public String getProgram() {
        return program;
    }

    public int getWeight() {
        return weight;
    }
}