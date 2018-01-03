import java.util.ArrayList;

public abstract class AbstractNode {
    private String program;
    private int weight;

    public AbstractNode() {}

    public abstract String toString();

    public abstract void addParent(CompositeNode parent);

    public abstract CompositeNode getParent();
    public abstract String getProgram();

}