import java.util.Scanner;

public class Planner {

	public Planner(){

	}

	//Sets up the scenario for our monkey
	public void Scenario(){

		System.out.println("=======================================================");

		boolean choosing = true;

		Scanner input = new Scanner(System.in);

		String roomM;
		String roomB;
		String roomN;

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

		WorldState intitialState = new WorldState(monkeyLoc, boxLoc, bananaLoc, WorldState.HEIGHT_LOW, false);


	}





}
