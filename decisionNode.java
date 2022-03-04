import java.util.ArrayList;

public class decisionNode {


    WorldState value;

    public ArrayList<decisionNode> children = new ArrayList<>();

    decisionNode(WorldState state){

        value = state;

    }

    //public ArrayList<WorldState> returnChildren(decisionNode n){

    //   return n.children;

    //}

    public void printChildren(decisionNode n){

        for (decisionNode Node : children) {
            System.out.println("\n" + Node.value.lastOp + ": Monke in " + Node.value.getRoomMonkeyIn());
        }


    }







}
