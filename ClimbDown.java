//Authors: Mason Heaman & Gemma Gendreau
//Date: 3/6/22
//Climbdown: climbdown action of the monkey

public class ClimbDown{
    public static String operatorName = "ClimbDown";


    public static boolean checkPreconditions(WorldState worldState) {

        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_HIGH)){
            return false;
        }

        return true;
    }

    public static WorldState applyPostconditions(WorldState preOperation) {
        //create and return a new WorldState with all conditions constant except for the updated height='Low'
        WorldState postOperation = new WorldState(preOperation.getRoomMonkeyIn(),preOperation.getRoomBoxIn(), preOperation.getRoomBananasIn(), WorldState.HEIGHT_LOW, preOperation.getMonkeyHasBananas(), operatorName +"()");
        return postOperation;
    }
}
