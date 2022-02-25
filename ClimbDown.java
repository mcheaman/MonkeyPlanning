public class ClimbDown{
    public String operatorName = "CLIMBUP";


    public boolean checkPreconditions(WorldState worldState) {

        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_HIGH)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState preOperation) {
        //create and return a new WorldState with all conditions constant except for the updated height='Low'
        WorldState postOperation = new WorldState(preOperation.getRoomMonkeyIn(),preOperation.getRoomBoxIn(), preOperation.getroomBananasIn(), WorldState.HEIGHT_LOW, preOperation.getMonkeyHasBananas());
        return postOperation;
    }
}