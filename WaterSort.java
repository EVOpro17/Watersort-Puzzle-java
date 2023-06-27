//30415284 Fernandrique Jadon Ockhuys
import java.util.*;

public class WaterSort {
	
	static Character red= new Character('r'); 
	static Character green= new Character('g'); 
	static Character blue= new Character('b');
	
	public static void showAll( StackAsMyArrayList bottles[])
	{
		for (int i = 0; i<=4; i++)
		 {
			 int j=i+1;
			 System.out.println("Bottle "+ j + ": " + bottles[i]);
		 }
	}
public static boolean solved(StackAsMyArrayList bottles[]){
		
		boolean ans =false;
		int counter= 0 ;
		for(int i= 0; i < 5;i++){
			ans = bottles[i].checkStackUniform();
			counter++;
			if (ans == false){
				return false;
			}
			else{
				ans = true;
			}
			
		
		}
		return ans;
		
	}
		
	public static void main(String[] args) {
		
		
		boolean RepeatGame;
		
		
		while (RepeatGame = true){
			MyArrayList<Character> bottle1Array = new MyArrayList<>();
			StackAsMyArrayList bottles[] = new StackAsMyArrayList[5];
			
			bottles[0] = new StackAsMyArrayList<Character>();
			bottles[1] = new StackAsMyArrayList<Character>();
			bottles[2] = new StackAsMyArrayList<Character>();
			bottles[3] = new StackAsMyArrayList<Character>();
			bottles[4] = new StackAsMyArrayList<Character>();
			
			int temp, countR = 0, countG = 0, countB= 0;
			for (int i = 0; i<5; i++){
				for(int j = 0; j < 4;j++){
					temp = bottles[0].rand();
					switch(temp){
				
					  case 1:
							if(countR < 4){
							bottles[i].push(red);
							countR++;
							
							}
							
						  break;
					  case 2:
							if(countG < 4){
							bottles[i].push(green);
							countG++;
							}
							
							
						  break;
					  case 3:
							if(countB < 4){
							bottles[i].push(blue);
							countB++;
							}
							
						  break;
				 
				}
				}
				
				if(i == 4){
					if(countR < 4){
						bottles[i].push(red);
						countR++;
					}
					if(countG < 4){
						bottles[i].push(green);
						countG++;
					}
					if(countB < 4){
						bottles[i].push(blue);
						countB++;
					}
					
					
				}
			}
			
			while(!solved(bottles)){
				showAll(bottles);
				Scanner scan = new Scanner(System.in);
				
				System.out.println("Please select a bottle:");
				
				int SelectedVal = scan.nextInt();	 
					
				if(SelectedVal > 5 || SelectedVal < 0){
					System.out.println("The selected bottle does not exist, please choose another bottle:/n");
					
					System.out.println("Please Select a bottle :");
					
					SelectedVal = scan.nextInt();		
					
				}
				
				//-------
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Enter value for bottle to move to :");
				int MovedVal = scan1.nextInt();
				if(MovedVal > 5 || MovedVal < 0){
					System.out.println("The selected bottle does not exist, please choose another bottle:");
					
					System.out.println("Move to bottle :");
					
					MovedVal = scan1.nextInt();		
					
				}
				//---
				bottles[MovedVal -1].push(bottles[SelectedVal - 1].pop());
				if (bottles[SelectedVal-1].peek() != null){
					
					if(((Comparable)bottles[SelectedVal-1].peek()).compareTo(bottles[MovedVal-1].peek())==0){			//Comparision before push and pop of value
					
					bottles[MovedVal -1].push(bottles[SelectedVal - 1].pop());											//push and pop the value
					
				}
				}
				
				
				solved(bottles);
				
				
			}
			//---
			System.out.println("Well done! You Sorted all of the bottles");
			
			showAll(bottles);
			
			Scanner scan2 = new Scanner(System.in);
			
			System.out.println("Want to play the game again?(Enter a non-positive value for no or a positivevalue for Yes) : ");
			int Again = scan2.nextInt();
			
			if (Again < 0){
				RepeatGame = false;
			}
			if (Again > 0){
				RepeatGame = true;
			}
			
		}
		
	}
}