public class ClimbUp{
    private String operatorName = "ClimbUp";

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.isMonkeyAt(worldState.getRoomBoxIn())){
            return false;
        }

        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_LOW)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState) {
        //create and return a new WorldState
        //with the monkey’s updated location
        WorldState out = new WorldState(/*Add Post Conditions*/);
        return out;
    }

    



    
}
