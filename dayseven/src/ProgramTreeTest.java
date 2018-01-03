import junit.framework.TestCase;

import java.util.ArrayList;

public class ProgramTreeTest extends TestCase {

    public void testReadInput() {

        ProgramTree testTree = new ProgramTree();
        testTree.createNodes("kjklfd (32) -> dsstjf, sadasd");
        testTree.createNodes("dsstjf (100) -> cvchqoz, jirnr");
        testTree.createNodes("sadasd (52) -> dsstjf, jfkdsl");
        testTree.createNodes("uidivc (12)");
        testTree.createNodes("jfkdsl (22)");
        testTree.createNodes("jirnr (120)");
        testTree.createNodes("cvchqoz (75)");
        ArrayList<AbstractNode> programList = testTree.getProgramList();
        assertEquals(7, programList.size());

        AbstractNode parent = programList.get(0);
        AbstractNode childOne = programList.get(1);
        AbstractNode childTwo = programList.get(2);
        // ArrayList<CompositeNode> children = parent.getChildren();

        testTree.buildTree("kjklfd (32) -> dsstjf, sadasd");
        testTree.buildTree("dsstjf (100) -> cvchqoz, jirnr");
        testTree.buildTree("sadasd (52) -> uidivc, jfkdsl");
        testTree.buildTree("uidivc (12)");
        testTree.buildTree("jfkdsl (22)");
        testTree.buildTree("jirnr (120)");
        testTree.buildTree("cvchqoz (75)");

        assertEquals("kjklfd", parent.getProgram());
        // assertEquals(100, parent.getWeight());
        assertEquals("kjklfd", childOne.getParent().getProgram());
        assertEquals("kjklfd", childTwo.getParent().getProgram());
        assertNull(parent.getParent());

    }
}