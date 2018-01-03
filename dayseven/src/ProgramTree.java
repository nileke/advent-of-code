import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProgramTree {

    private ArrayList<AbstractNode> programList = new ArrayList<>();
    private ArrayList<CompositeNode> compositeList = new ArrayList<>();

    // Constructor for testing
    ProgramTree() { }

    ProgramTree(String filepath) throws FileNotFoundException{
        Scanner scanNodes = new Scanner(new File(filepath));
        while (scanNodes.hasNextLine()) {
            String line = scanNodes.nextLine();
            createNodes(line);
        }

        Scanner scanComposites = new Scanner(new File(filepath));
        while (scanComposites.hasNextLine()) {
            String line = scanComposites.nextLine();
            if (line.contains("->")) {
                buildTree(line);
            }
        }
    }

    void createNodes(String line) {
        Scanner sc = new Scanner(line);
        String programName = sc.next();
        String w = sc.next();
        w = w.substring(1,w.length()-1);
        int programWeight = Integer.parseInt(w);

        if (line.contains("->")) {
            CompositeNode node = new CompositeNode(programName, programWeight);
            compositeList.add(node);
            programList.add(node);
        } else {
            LeafNode node = new LeafNode(programName, programWeight);
            programList.add(node);
        }
    }

    void buildTree(String line) {
        Scanner sc = new Scanner(line);
        String programName = sc.next();
        String w = sc.next();
        // w = w.substring(1,w.length()-1);
        // int programWeight = Integer.parseInt(w);

        CompositeNode parent = null;
        for (CompositeNode node : compositeList) {
            if (node.getProgram().equals(programName)) {
                parent = node;
                break;
            }
        }

        sc.findInLine("-> ");
        sc.useDelimiter(",\\s*");
        scan:
        while (sc.hasNext()) {
            String childName = sc.next();
            for (AbstractNode node : this.programList) {
                if (node.getProgram().equals(childName)) {
                    node.addParent(parent);
                    continue scan;
                }
            }
        }
    }

    void findRoot() {
        for (AbstractNode node : programList) {
            if (node.getParent() == null) {
                System.out.println(node.getProgram());
                // break;
            }
        }
    }

    public ArrayList<AbstractNode> getProgramList() {
        return programList;
    }

    public static void main(String[] args) {
        String filepath = "data/input.txt";
        try {
            ProgramTree programTree = new ProgramTree(filepath);
            programTree.findRoot();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
