//Authors: Mason Heaman & Gemma Gendreau
//Date: 3/6/22
//Planner: Driver class of MonkeyPlanning. 

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Planner {

	private Queue<decisionNode> stateQueue;
	Scanner input;

	public Planner(){

	}

	public int maxPriority;

	//Sets up the scenario for our monkey
	public void Scenario(){

		System.out.println("=======================================================");

		boolean choosing = true;

		input = new Scanner(System.in);

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


		Plan(roomM.toUpperCase(), roomB.toUpperCase(), roomN.toUpperCase());


        System.out.println("=================================================");


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
		while(true){ //While goal is not reached

			currentNode = stateQueue.remove();
			if(goalReached(currentNode)){
				decisionNode goalNode = new decisionNode(Grab.applyPostconditions(currentNode.value), currentNode);
				goalNode.printPlan();
				input.close();
				return;
			}else{
				generateChildren(currentNode);
				// currentNode.printChildren();
			}
		}
	}


	//Set the priority of a decisionNode to denote how "productive" its WorldState is
	public void calcPriority(decisionNode n){

		int priority = 0;

		//If not in room with box and moving towards room with box
		//priority set to 1
		if(n.value.lastOp.substring(0,4).equalsIgnoreCase("Move") && n.value.getRoomMonkeyIn().equalsIgnoreCase(n.value.getRoomBoxIn())){
			priority += 1;
		}
		
		//If box not in room with bananas and moving box to room with bananas
		//priority set to 2
		if(n.value.lastOp.substring(0,4).equalsIgnoreCase("Push") && n.value.getRoomMonkeyIn().equalsIgnoreCase(n.value.getRoomBananasIn())){
			priority += 2;
		}

		//If height is low and in room with bananas, and trying to set height to high
		//priority set to 3
		if(n.value.getMonkeyHeight().equalsIgnoreCase("High") && n.value.getRoomMonkeyIn().equalsIgnoreCase(n.value.getRoomBananasIn())){
			priority +=3;
		}

		if(priority > maxPriority){
			maxPriority = priority;
		}


		n.setPriority(priority);

	}
	public boolean goalReached(decisionNode n){
		return Grab.checkPreconditions(n.value) == true;
	}

	public int generateChildren(decisionNode n){

		String currentRoom = n.value.getRoomMonkeyIn();
		
		maxPriority = 0;

		ArrayList<decisionNode> possibleMoves = new ArrayList<decisionNode>();
	
		//Move Checks & Push Checks
		for (int i = 0; i < 3; i++) {
			
			String room = "" + WorldState.rooms.charAt(i);
			

			Move potential = new Move(currentRoom, room);
			Push potentialp = new Push(currentRoom, room);

			if(potential.checkPreconditions(n.value) == true){
				//create the move object
				decisionNode moveNode = new decisionNode(potential.applyPostconditions(n.value), n);
				//set the node's priority
				calcPriority(moveNode);
				possibleMoves.add(moveNode);
			}
			
			if(potentialp.checkPreconditions(n.value) == true){
				decisionNode pushNode = new decisionNode(potentialp.applyPostconditions(n.value), n);
				//set the node's priority		
				calcPriority(pushNode);
				possibleMoves.add(pushNode);
			}

		}

		//climbs
		if(ClimbUp.checkPreconditions(n.value) == true){
				//create the ClimbUp object
				decisionNode upNode = new decisionNode(ClimbUp.applyPostconditions(n.value), n);
				//set the node's priority	
				calcPriority(upNode);
				possibleMoves.add(upNode);
		}

		if(ClimbDown.checkPreconditions(n.value) == true){
			//create the ClimbDown object
			decisionNode downNode = new decisionNode(ClimbDown.applyPostconditions(n.value), n);
			//set the node's priority
			calcPriority(downNode);
			possibleMoves.add(downNode);
		}

		//Go through list of possible children and add the ones with high priority, skipping the ones with low priority
		for(decisionNode e : possibleMoves){

			//from max priority: Add only the nodes with maxPriority
			if(e.getPriority() == maxPriority){
				n.children.add(e);
				stateQueue.add(e);
			}

		}

		return 0;



	}



}