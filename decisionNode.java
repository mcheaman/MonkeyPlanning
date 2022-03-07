//Authors: Mason Heaman & Gemma Gendreau
//Date: 3/6/22
//decisionNode: represents a possible monkey move

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

    public void printPlan(){
        ArrayList<String> plan = new ArrayList<String>();
        decisionNode temp = this;
        while(temp != null) {
            plan.add(temp.value.lastOp);
            temp = temp.parent;
        }
        System.out.println("Plan:");
        for(int i = plan.size()-2; i>=0; i--){
            System.out.println(plan.get(i));
        }
    }









}
