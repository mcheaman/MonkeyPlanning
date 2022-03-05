
public class Move {
    public static String operatorName = "MOVE";
    private String moveFrom;
    private String moveTo;



    public Move(String from, String to){
        this.moveFrom = from;
        this.moveTo = to;
    }

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.isMonkeyAt(moveFrom)){
            return false;
        }

        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_LOW)){
            return false;
        }

        if(moveTo.equalsIgnoreCase(moveFrom)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState preOperation) {
        //create and return a new WorldState with all conditions constant except for the updated roomMonkeyIn='moveTo'
        WorldState postOperation = new WorldState(moveTo,preOperation.getRoomBoxIn(), preOperation.getroomBananasIn(), preOperation.getMonkeyHeight(), preOperation.getMonkeyHasBananas(), operatorName + moveFrom + "->" + moveTo);
        return postOperation;
    }
}
    
