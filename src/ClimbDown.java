public class ClimbDown {

    //ClimbDown operator

    public boolean checkPreconditions(WorldState worldState) {
        // preconditions to climb up
        // - monkey is at height LOW
        // - monkey and box are in same room
        if(!worldState.getMonkeyRoom().equalsIgnoreCase(worldState.getBoxRoom())){
            return false;
        }

        if(!worldState.checkMonkeyHeight(WorldState.HEIGHT_HIGH)){
            return false;
        }
        return true;
    }

    public WorldState applyPostconditions(WorldState worldState) {
        //postconditions
        // - monkey is at height LOW
        WorldState newWorldState = worldState.clone();

        newWorldState.setMonkeyHeight(WorldState.HEIGHT_LOW);

        return newWorldState;
    }
}
