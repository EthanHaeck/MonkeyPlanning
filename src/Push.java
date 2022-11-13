public class Push {

    //push operator
    private String operatorName = "PUSH";
    private String pushFrom;
    private String pushTo;

    public Push(String from, String to){
        this.pushFrom = from;
        this.pushTo = to;
    }

    public boolean checkPreconditions(WorldState worldState) {
        // preconditions to push
        // - monkey is at height LOW
        // - monkey and box are both in room X
        if(!worldState.isMonkeyAt(pushFrom)){
            return false;
        }

        if(!worldState.getBoxRoom().equalsIgnoreCase(pushFrom)){
            return false;
        }

        if(!worldState.checkMonkeyHeight(WorldState.HEIGHT_LOW)){
            return false;
        }
        return true;
    }

    public WorldState applyPostconditions(WorldState worldState) {
        //postconditions
        // - monkey and box are in Room 'pushTo'
        // - monkey and box are not in room 'pushFrom'
        WorldState newWorldState = worldState.clone();

        newWorldState.changeMonkeyRoom(pushTo);
        newWorldState.changeBoxRoom(pushTo);

        return newWorldState;
    }
}
