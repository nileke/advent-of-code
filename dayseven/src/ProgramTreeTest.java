import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProgramTreeTest extends TestCase {

    public void testReadInput() {
        ProgramTree testTree = new ProgramTree();

        testTree.readInput("dsstjf (100) -> cvchqoz, jirnr");
        testTree.readInput("sadasd (52) -> dsstjf");
        ArrayList<CompositeNode> programList = testTree.getProgramList();
        assertEquals(4, testTree.getProgramList().size());

        CompositeNode parent = testTree.getProgramList().get(2);
        CompositeNode childOne = programList.get(0);
        CompositeNode childTwo = programList.get(1);
        // ArrayList<CompositeNode> children = parent.getChildren();

        assertEquals("dsstjf", parent.getProgram());
        assertEquals(100, parent.getWeight());
        assertEquals("dsstjf", childOne.getParent().getProgram());
        assertEquals("dsstjf", childTwo.getParent().getProgram());
        assertEquals("sadasd", parent.getParent().getProgram());

        // assertEquals("cvchqoz", children.get(0).getProgram());
        // assertEquals("jirnr", children.get(1).getProgram());

    }
}