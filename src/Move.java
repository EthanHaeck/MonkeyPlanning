public class Move {

    //move operator
    private String operatorName = "MOVE";
    private String moveFrom;
    private String moveTo;

    public Move(String from, String to){
        this.moveFrom = from;
        this.moveTo = to;
    }

    public boolean checkPreconditions(WorldState worldState) {
        // preconditions to move
        // - monkey is at height LOW
        // - monkey is in room X
        if(!worldState.isMonkeyAt(moveFrom)){
            return false;
        }

        if(!worldState.checkMonkeyHeight(WorldState.HEIGHT_LOW)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState) {
        //postconditions
        // - monkey is in Room 'moveTo'
        // - monkey is no longer in room 'moveFrom'
        WorldState newWorldState = worldState.clone();

        newWorldState.changeMonkeyRoom(moveTo);

        return newWorldState;
    }

}
