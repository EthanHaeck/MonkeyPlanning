import java.util.*;

public class Planner {

    Scanner userInput = new Scanner(System.in);
    WorldState worldState = new WorldState();

    // main driver function to create and display a plan
    public void createPlan(){
        String roomMonkeyIn;
        String roomBoxIn;
        String roomBananasIn;

        //ask for input
        System.out.println("Select which room the monkey starts in:");
        System.out.print("[1] Room A\n[2] Room B\n[3] Room C\n==>");
        roomMonkeyIn = validateInput(userInput.nextLine());

        System.out.println("Select which room the box starts in:");
        System.out.print("[1] Room A\n[2] Room B\n[3] Room C\n==>");
        roomBoxIn = validateInput(userInput.nextLine());

        System.out.println("Select which room the bananas start in:");
        System.out.print("[1] Room A\n[2] Room B\n[3] Room C\n==>");
        roomBananasIn = validateInput(userInput.nextLine());

        //set world state
        worldState.setWorldState(roomMonkeyIn, roomBoxIn, roomBananasIn);

        //develop plan
        developPlan(worldState);

    }

    private void developPlan(WorldState worldState){

    }

    private String validateInput(String input){
        //prompt user until input is either 'A', 'B', or 'C'
        while (!input.equalsIgnoreCase(WorldState.ROOM_A) && !input.equalsIgnoreCase(WorldState.ROOM_B)
                && !input.equalsIgnoreCase(WorldState.ROOM_C)){
            System.out.print("Enter a valid input: ");
            input = userInput.nextLine();
        }
        return input;
    }
}
