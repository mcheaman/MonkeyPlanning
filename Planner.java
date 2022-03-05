import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Planner {

	private Queue<decisionNode> stateQueue;

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

		stateQueue = new LinkedList<>(); //Initialize queue for breadth first tree search 
		decisionNode head = new decisionNode(initialState, null);
		stateQueue.add(head);


		decisionNode currentNode;
		// int x = 0;
		while(true){ //While goal is not reached
			//Implement breadth first search with inspo from https://www.baeldung.com/java-breadth-first-search#algorithm-trees

			//1. Pop first node from the queue
			//2. If node is a goal state
				//3. end search
			//4. else
				//5. add node's children to the queue and goto 1
					//To do this, make the Queue a global variable and add to it in generateChildren
			currentNode = stateQueue.remove();
			if(goalReached(currentNode)){
				System.out.println("Goal reached");
				decisionNode goalNode = new decisionNode(Grab.applyPostconditions(currentNode.value), currentNode);
				goalNode.printParents();
				//some end procedure
				break;
			}else{
				generateChildren(currentNode);
				currentNode.printChildren();
			}
			// x++;
		}
	}

	// public void validateMove(){
	// }

	public boolean goalReached(decisionNode n){
		return Grab.checkPreconditions(n.value) == true;
	}

	public int generateChildren(decisionNode n){

		//List<String> rooms = getRooms();
		String currentRoom = n.value.getRoomMonkeyIn();
		
		//Go through list of all possible moves?

		// //Goal check:
		// if(Grab.checkPreconditions(n.value) == true){
		// 	decisionNode goalNode = new decisionNode(Grab.applyPostconditions(n.value));
		// 	n.children.add(goalNode);
		// 	return 1;
		// }

		//Move Checks & Push Checks
		for (int i = 0; i < 3; i++) {
			
			String room = "" + WorldState.rooms.charAt(i);

			Move potential = new Move(currentRoom, room);
			Push potentialp = new Push(currentRoom, room);
			if(potential.checkPreconditions(n.value) == true){
				//create the move object
				decisionNode moveNode = new decisionNode(potential.applyPostconditions(n.value), n);
				n.children.add(moveNode);
				stateQueue.add(moveNode);
			}else{
				// System.out.println("\tinvalid");
			}
			if(potentialp.checkPreconditions(n.value) == true){
				decisionNode pushNode = new decisionNode(potentialp.applyPostconditions(n.value), n);				
				n.children.add(pushNode);
				stateQueue.add(pushNode);
			}else{
				// System.out.println("\tinvalid");
			}

		}

		//climbs
		if(ClimbUp.checkPreconditions(n.value) == true){
				//create the ClimbUp object
				decisionNode upNode = new decisionNode(ClimbUp.applyPostconditions(n.value), n);	
				n.children.add(upNode);
				stateQueue.add(upNode);
		}

		if(ClimbDown.checkPreconditions(n.value) == true){
			//create the ClimbDown object
			decisionNode downNode = new decisionNode(ClimbDown.applyPostconditions(n.value), n);
			n.children.add(downNode);
			stateQueue.add(downNode);
		}

		return 0;



	}



}