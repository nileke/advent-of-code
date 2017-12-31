import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramTree {

    private ArrayList<CompositeNode> programList = new ArrayList<>();

    // Constructor for testing
    ProgramTree() { }

    ProgramTree(String filepath) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(filepath));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            readInput(line);
        }
    }


    void readInput(String line) {
        Scanner scLine = new Scanner(line);

        // Create parent node, find int for weight
        String programName = scLine.next();
        String programWeight = scLine.next();
        programWeight = programWeight.substring(1,programWeight.length()-1);
        CompositeNode parent = new CompositeNode(programName, Integer.parseInt(programWeight));

        // search for children
        if ((scLine.findInLine("->") != null)) {
            scan:
            while (scLine.hasNext()) {
                String childName = scLine.next();
                childName = childName.replace(",", "");
                for (CompositeNode node : this.programList) {
                    if (node.getProgram().equalsIgnoreCase(childName)) {
                        node.addParent(parent);
                        break scan;
                    }
                } 
                CompositeNode child = new CompositeNode(childName);
                child.addParent(parent);
                programList.add(child);
            }
        }
        programList.add(parent);
    }

    void parseNodes() {
        // iterate through children recursively to find parent
        // search for node w/o parent
    }

    public ArrayList<CompositeNode> getProgramList() {
        return programList;
    }

    public static void main(String[] args) {
        String filepath = "data/input.txt";
        try {
            new ProgramTree(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
