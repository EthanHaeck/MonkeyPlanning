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
        if(!worldState.isMonkeyAt(moveFrom)){
            return false;
        }

        if(!worldState.checkMonkeyHeight(WorldState.HEIGHT_LOW)){
            return false;
        }

        return true;
    }

    public WorldState applyPostconditions(WorldState worldState) {
        //create and return a new WorldState
        //with the monkey’s updated location
        WorldState newWorldState = new WorldState();

        return newWorldState;
    }

}
