public class Grab{
    public String operatorName = "GRAB";

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.isMonkeyAt(worldState.getroomBananasIn())){
            return false;
        }

        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_HIGH)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState preOperation) {
        //create and return a new WorldState with all conditions constant except for the updated monkeyHasBananas=true
        WorldState postOperation = new WorldState(preOperation.getRoomMonkeyIn(),preOperation.getRoomBoxIn(), preOperation.getroomBananasIn(), preOperation.getMonkeyHeight(), true);
        return postOperation;
    }

}