//Authors: Mason Heaman & Gemma Gendreau
//Date: 3/6/22
//Grab: Monkeys grab action

public class Grab{
    public static String operatorName = "Grab";

    public static boolean checkPreconditions(WorldState worldState) {
        if(!worldState.isMonkeyAt(worldState.getRoomBananasIn())){
            return false;
        }

        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_HIGH)){
            return false;
        }

        return true;
    }

    public static WorldState applyPostconditions(WorldState preOperation) {
        //create and return a new WorldState with all conditions constant except for the updated monkeyHasBananas=true
        WorldState postOperation = new WorldState(preOperation.getRoomMonkeyIn(),preOperation.getRoomBoxIn(), preOperation.getRoomBananasIn(), preOperation.getMonkeyHeight(), true, operatorName +"()");
        return postOperation;
    }

}
