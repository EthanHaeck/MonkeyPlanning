public class WorldState {

    //store information of the world
    private String roomMonkeyIn;
    private String roomBoxIn;
    private String roomBananasIn;
    private int monkeyHeight;
    private boolean monkeyHasBananas;

    public static final String ROOM_A = "A";
    public static final String ROOM_B = "B";
    public static final String ROOM_C = "C";
    public static final int HEIGHT_LOW = 0;
    public static final int HEIGHT_HIGH = 1;

    // set the initial world state
    public void setWorldState(String monkeyRoom, String boxRoom, String bananasRoom){
        this.roomMonkeyIn = monkeyRoom;
        this.roomBoxIn = boxRoom;
        this.roomBananasIn = bananasRoom;
        this.monkeyHeight = HEIGHT_LOW;
        this.monkeyHasBananas = false;
    }

    // check if the monkey is in the provided room
    public boolean isMonkeyAt(String room) {
        return this.roomMonkeyIn.equalsIgnoreCase(room);
    }

    // verify the height of the monkey
    public boolean checkMonkeyHeight(int height){
        return monkeyHeight == height;
    }

    public WorldState clone(){
        //return a copy of the current world state
        WorldState newWorldState = new WorldState();
        newWorldState.roomMonkeyIn = this.roomMonkeyIn;
        newWorldState.roomBoxIn = this.roomBoxIn;
        newWorldState.roomBananasIn = this.roomBananasIn;
        newWorldState.monkeyHeight = this.monkeyHeight;
        newWorldState.monkeyHasBananas = this.monkeyHasBananas;
        return newWorldState;
    }

    public boolean equals(WorldState providedState){
        if(!providedState.roomMonkeyIn.equalsIgnoreCase(this.roomMonkeyIn)){
            return false;
        }
        if(!providedState.roomBoxIn.equalsIgnoreCase(this.roomBoxIn)){
            return false;
        }
        if(!providedState.roomBananasIn.equalsIgnoreCase(this.roomBananasIn)){
            return false;
        }
        if(providedState.monkeyHeight != this.monkeyHeight){
            return false;
        }
        if(providedState.monkeyHasBananas != this.monkeyHasBananas){
            return false;
        }

        //all world variables are the same
        return true;
    }

    //getters and setters

    public String getBananaRoom(){
        return roomBananasIn;
    }

    public String getMonkeyRoom(){
        return roomMonkeyIn;
    }

    public String getBoxRoom(){
        return roomBoxIn;
    }

    public void setMonkeyHeight(int newHeight){
        this.monkeyHeight = newHeight;
    }

    public void changeMonkeyRoom(String newRoom){
        this.roomMonkeyIn = newRoom;
    }

    public void changeBoxRoom(String newRoom){
        this.roomBoxIn = newRoom;
    }

    public void setWinCondition(){
        this.monkeyHasBananas = true;
    }

    public boolean checkWinCondition(){
        return this.monkeyHasBananas;
    }

}
