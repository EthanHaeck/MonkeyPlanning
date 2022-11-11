public class Grab {

    //Grab operator

    public boolean checkPreconditions(WorldState worldState) {
        // preconditions to grab bananas
        // - monkey is at height HIGH
        // - monkey is in the same room as bananas
        if(worldState.checkMonkeyHeight(WorldState.HEIGHT_HIGH) && worldState.isMonkeyAt(worldState.getBananaRoom())){
            return true;
        }
        return false;
    }
}
