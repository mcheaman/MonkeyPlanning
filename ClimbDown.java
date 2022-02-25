public class ClimbDown{
    private String operatorName = "ClimbDown";


    public boolean checkPreconditions(WorldState worldState) {

        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_HIGH)){
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