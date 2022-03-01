public class ClimbUp{
    public static String operatorName = "CLIMBUP";

    public static boolean checkPreconditions(WorldState worldState) {
        if(!worldState.isMonkeyAt(worldState.getRoomBoxIn())){
            return false;
        }

        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_LOW)){
            return false;
        }

        return true;
    }

    public static WorldState applyPostconditions(WorldState preOperation) {
        //create and return a new WorldState with all conditions constant except for the updated height='Heigh'
        WorldState postOperation = new WorldState(preOperation.getRoomMonkeyIn(),preOperation.getRoomBoxIn(), preOperation.getroomBananasIn(), WorldState.HEIGHT_HIGH, preOperation.getMonkeyHasBananas(), operatorName);
        return postOperation;
    }

    



    
}

