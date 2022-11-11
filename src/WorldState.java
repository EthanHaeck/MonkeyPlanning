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

    public String getRoomMonkeyIn(){
        return this.roomMonkeyIn;
    }

    // check if the monkey is in the provided room
    public boolean isMonkeyAt(String room) {
        return this.roomMonkeyIn.equalsIgnoreCase(room);
    }

    // verify the height of the monkey
    public boolean checkMonkeyHeight(int height){
        if(monkeyHeight == height){
            return true;
        }

        return false;
    }

    public String getBananaRoom(){
        return roomBananasIn;
    }

}
