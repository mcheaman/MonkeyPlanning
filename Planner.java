import java.util.Scanner;

public class Planner {

	public Planner(){

	}

	//Sets up the scenario for our monkey
	public void Scenario(){

		System.out.println("=======================================================");

		boolean choosing = true;

		Scanner input = new Scanner(System.in);

		while(choosing) { //Error Handling

			System.out.println("Select which room the monkey starts in:\n");
			printOptions();		
	
			String roomM;
			String roomB;
			String roomN; 
			String choice = " ";

			if(input.hasNext()){
			      choice = input.next();
			      
			      if(verifyChoice(choice) == true){
					
					roomM = choice;
			      }			
			
			}else{
				System.out.println("Please choose a room!");
			}

			System.out.println("Select which room the box starts in:");
			printOptions();			

			if(input.hasNext()){

				choice = input.next();				
				if(verifyChoice(choice) == true){
					roomB = choice;

				}

			}else{
				
			}
			

			System.out.println("Select which room the bananas start in:");
			printOptions();			

			if(input.hasNext()){

				choice = input.next();
				if(verifyChoice(choice) == true){
					roomN = choice;
				}


					
			}

			break;			
			


		} 


		System.out.println("=========================================================");


	}


	public void printOptions(){

		System.out.println("[1] Room A");
		System.out.println("[2] Room B");
		System.out.println("[3] Room C");
		System.out.print("==>");

	}


	public boolean verifyChoice(String choice){

		return true;

	}





}
