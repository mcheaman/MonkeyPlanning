import java.util.ArrayList;

public class decisionNode {


    WorldState value;
    decisionNode parent;
    public ArrayList<decisionNode> children = new ArrayList<>();
    private int priority;

    decisionNode(WorldState state, decisionNode parent){

        value = state;
        this.parent = parent; 
    }

    //public ArrayList<WorldState> returnChildren(decisionNode n){

    //   return n.children;

    //}

    public void setPriority(int pri){
        this.priority = pri;
    }

    public int getPriority(){
        return this.priority;
    }

    public void printChildren(){
        System.out.println("************Printing Children of " + this.value.lastOp + " *************");
        for (decisionNode Node : children) {
            System.out.println("\n" + Node.value.lastOp + ": Monke in " + Node.value.getRoomMonkeyIn() + "priority: " + Node.priority);
            
        }
        System.out.println("*****************************************************");
    }

    public void printParents(){
        System.out.println("************Printing Parents*************");
        decisionNode temp = this;
        while(temp != null) {
            System.out.println("\n" + temp.value.lastOp + ": Monke in " + temp.value.getRoomMonkeyIn());
            temp = temp.parent;
        }
        System.out.println("*******************************************");
    }








}
