public class Push {
    public static String operatorName = "PUSH";
    private String pushFrom;
    private String pushTo;

    public Push(String from, String to){
        this.pushFrom = from;
        this.pushTo = to;
    }

    public boolean checkPreconditions(WorldState worldState) {
        if(!worldState.isMonkeyAt(pushFrom)){
            return false;
        }
        if(!worldState.isBoxAt(pushFrom)){
            return false;
        }
        if(!worldState.isMonkeyHeight(WorldState.HEIGHT_LOW)){
            return false;
        }

        if(pushTo == pushFrom){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState preOperation) {
        //create and return a new WorldState with all conditions constant except for the updated roomMonkeyIn='pushTo' and roomBoxIn='pushTo'
        WorldState postOperation = new WorldState(pushTo,pushTo, preOperation.getroomBananasIn(), preOperation.getMonkeyHeight(), preOperation.getMonkeyHasBananas(), operatorName + pushTo);
        return postOperation;
    }




    
}
