import java.util.*;

public class Planner {

    Scanner userInput = new Scanner(System.in);
    // Operators
    ClimbUp climbUp = new ClimbUp();
    ClimbDown climbDown = new ClimbDown();
    Grab grab = new Grab();

    // main driver function to create and display a plan
    public void createPlan(){
        String roomMonkeyIn;
        String roomBoxIn;
        String roomBananasIn;
        WorldState currentWorldState = new WorldState();

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
        currentWorldState.setWorldState(roomMonkeyIn, roomBoxIn, roomBananasIn);

        //develop plan
        developPlan(currentWorldState);

    }

    private void developPlan(WorldState currentWorldState){
        /*
        * Utilizing forward chaining
        * create small goals on the way to the ultimate goal
        * check world state after each operator
        * */

        //recursive case
        if(currentWorldState.checkWinCondition()){
            System.exit(0);
        }

        WorldState goalState;
        WorldState moveState;
        WorldState pushState;
        WorldState climbUpState;
        WorldState climbDownState;
        WorldState grabState;

        //create a new goal (step in the right direction)
        goalState = createNewGoal(currentWorldState);

        //check each operator's postconditions and see if they achieve next goal

        //MOVE
        Move move = new Move(currentWorldState.getMonkeyRoom(), goalState.getBoxRoom());
        if(move.checkPreconditions(currentWorldState)){ // move can be performed
            moveState = move.applyPostconditions(currentWorldState);
            if(moveState.equals(goalState)){
                //perform action and add to the plan
                System.out.printf("Move(%s,%s)\n", currentWorldState.getMonkeyRoom(), goalState.getBoxRoom());
                currentWorldState = move.applyPostconditions(currentWorldState);
                //repeat process
                developPlan(currentWorldState);
            }
        }

        //PUSH
        Push push = new Push(currentWorldState.getBoxRoom(), goalState.getBananaRoom());
        if(push.checkPreconditions(currentWorldState)){ // push can be performed
            pushState = push.applyPostconditions(currentWorldState);
            if(pushState.equals(goalState)){
                //perform action and add to the plan
                System.out.printf("Push(%s,%s)\n", currentWorldState.getBoxRoom(), goalState.getBananaRoom());
                currentWorldState = push.applyPostconditions(currentWorldState);
                //repeat process
                developPlan(currentWorldState);
            }

        }

        //ClimbUp
        if(climbUp.checkPreconditions(currentWorldState)){ // climbUp can be performed
            climbUpState = climbUp.applyPostconditions(currentWorldState);
            if(climbUpState.equals(goalState)){
                //perform action and add to the plan
                System.out.println("ClimbUp()");
                currentWorldState = climbUp.applyPostconditions(currentWorldState);
                //repeat process
                developPlan(currentWorldState);
            }
        }

        //ClimbDown
        if(climbDown.checkPreconditions(currentWorldState)){ // climbDown can be performed
            climbDownState = climbDown.applyPostconditions(currentWorldState);
            if(climbDownState.equals(goalState)){
                //perform action and add to the plan
                System.out.println("ClimbDown()");
                currentWorldState = climbDown.applyPostconditions(currentWorldState);
                //repeat process
                developPlan(currentWorldState);
            }
        }

        //Grab
        if(grab.checkPreconditions(currentWorldState)){ // grab can be performed
            grabState = grab.applyPostconditions(currentWorldState);
            if(grabState.equals(goalState)){
                //End Goal reached
                System.out.println("Grab()");
                System.exit(0);
            }
        }

    }

    public WorldState createNewGoal(WorldState currentWorldState){
        /*
         * Goals to achieve to grab the bananas
         * - Be in same room as box
         * - move box to banana room
         * - climb up box
         * - grab bananas
         * */
        WorldState goalState = currentWorldState.clone();

        // check if the monkey is not in the same room as the box, if not return a goal
        if(!currentWorldState.getMonkeyRoom().equalsIgnoreCase(currentWorldState.getBoxRoom())){
            //goal is to have monkey in box room
            goalState.changeMonkeyRoom(currentWorldState.getBoxRoom());
            return goalState;
        }

        // check if box is not in the banana room
        if(!currentWorldState.getBoxRoom().equalsIgnoreCase(currentWorldState.getBananaRoom())){
            //goal is to have box AND monkey in banana room
            goalState.changeBoxRoom(currentWorldState.getBananaRoom());
            goalState.changeMonkeyRoom(currentWorldState.getBananaRoom());
            return goalState;
        }

        // check if monkey is not on the box
        if(!currentWorldState.checkMonkeyHeight(WorldState.HEIGHT_HIGH)){
            goalState.setMonkeyHeight(WorldState.HEIGHT_HIGH);
            return goalState;
        }

        // all other goals have been reached, last is to grab bananas
        goalState.setWinCondition();
        return goalState;
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
