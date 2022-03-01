import java.util.Scanner;
import java.util.ArrayList;

public class Planner {

	public Planner(){

	}

	//Sets up the scenario for our monkey
	public void Scenario(){

		System.out.println("=======================================================");

		boolean choosing = true;

		Scanner input = new Scanner(System.in);

		String roomM = "";
		String roomB = "";
		String roomN = "";

		while(choosing) { //Error Handling

			System.out.println("Select which room the monkey starts in:\n");
			printOptions();		
	
			String choice = " ";

			if(input.hasNext()){
			      choice = input.next();
			      
			      if(verifyChoice(choice) == true){
					
					roomM = choice;
					System.out.println();
			      }else{
				System.out.print("Not a valid room. Try again.\n");
				continue;
			     }			
			
			}else{
				System.out.println("Please choose a room!\n");
				continue;
			}

			System.out.println("Select which room the box starts in:\n");
			printOptions();			

			if(input.hasNext()){

				choice = input.next();				
				if(verifyChoice(choice) == true){
					roomB = choice;
					System.out.println();

				}else{
					System.out.println("Invalid choice.");
					continue;
				}

			}else{
				System.out.println("Pick a room please!");
				continue;	
			}
			

			System.out.println("Select which room the bananas start in:\n");
			printOptions();			

			if(input.hasNext()){

				choice = input.next();
				if(verifyChoice(choice) == true){
					roomN = choice;
					System.out.println();
				}else{
					System.out.println("Invalid choice\n");
					continue;
				}


					
			}else{
				System.out.println("Pick a room, or face your doom...\n");
				continue;
			}

			break;			
			


		} 


		Plan(roomM, roomB, roomN);


		System.out.println("=========================================================");


	}


	public void printOptions(){

		System.out.println("[1] Room A");
		System.out.println("[2] Room B");
		System.out.println("[3] Room C");
		System.out.print("==>");

	}


	public boolean verifyChoice(String choice){

		if(choice.equalsIgnoreCase("A") || choice.equalsIgnoreCase("B") || choice.equalsIgnoreCase("C")){
			return true;
		}else{
			return false;
		}

	}


	//Driver for the plan. Takes in the starting values, creates a worldstate.
	public void Plan(String monkeyLoc, String boxLoc, String bananaLoc){

		WorldState initialState = new WorldState(monkeyLoc, boxLoc, bananaLoc, WorldState.HEIGHT_LOW, false, "Start");

		decisionNode tree = new decisionNode(initialState);
		generateChildren(tree);

		tree.printChildren(tree);

	}


	public void validateMove(){


	}


	public int generateChildren(decisionNode n){

		//List<String> rooms = getRooms();
		String currentRoom = n.value.getRoomMonkeyIn();
		
		//Go through list of all possible moves?

		//Goal check:
		if(Grab.checkPreconditions(n.value) == true){
			decisionNode goalNode = new decisionNode(Grab.applyPostconditions(n.value));
			n.children.add(goalNode);
			return 1;
		}

		//Move Checks & Push Checks
		for (int i = 0; i < 2; i++) {
			
			String room = "" + WorldState.rooms.charAt(i);

			Move potential = new Move(currentRoom, room);
			Push potentialp = new Push(currentRoom, room);

			if(potential.checkPreconditions(n.value) == true){

				//create the move object
				n.children.add(new decisionNode(potential.applyPostconditions(n.value)));

			}

			if(potentialp.checkPreconditions(n.value) == true){

				n.children.add(new decisionNode(potentialp.applyPostconditions(n.value)));

			}

		}

		//climbs
		if(ClimbUp.checkPreconditions(n.value) == true){

				//create the move object
				n.children.add(new decisionNode(ClimbUp.applyPostconditions(n.value)));

		}

		if(ClimbDown.checkPreconditions(n.value) == true){

			//create the move object
			n.children.add(new decisionNode(ClimbDown.applyPostconditions(n.value)));

		}

		return 0;



	}


	//decision tree
	//move to any adjacent room
	//push a box
	//grab the bananas
	//climb (up or down)
	




}