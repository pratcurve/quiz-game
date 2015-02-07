import java.util.Scanner;


import java.util.*;


public class home {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				 Scanner input = new Scanner(System.in);
				 Scanner inputt = new Scanner(System.in);
				 String Name=null;
				 String opt;
				 int opt1;
				 int score=0;
				System.out.println("\t\t***WHO WANTS TO BE MILLIONAIRE!!***\t\t");
				System.out.println("\t\t1.Play\n\t\t2.Rules\n\t\t3.High Scores");
				//opt1 = input.nextInt();
				do{
					opt1 = input.nextInt();

				switch(opt1){
				case 1:
				System.out.println("\n\n\t\tAre you ready to play??\n\n\t\t\tY|N\n\n\t    Press Y to continue and N to exit");
				opt=inputt.nextLine();
				int size = opt.length();
				if (size>0){
				if(opt.charAt(0)=='Y'||opt.charAt(0)=='y'){
					Name=getdetails();
					score Object = new score(Name);
					play Object1 = new play();
					score=Object1.game();
					Object.keepScore(score);
					//input.close();
					//inputt.close();
					}
				}
			//	else if(opt.charAt(0)!='y'||opt.charAt(0)!='Y'||opt.charAt(0)!='n'||opt.charAt(0)!='N'){
			//		System.out.println("Enter valid option");
			//	}
				
				else
					System.exit(0);
				break;
				case 2:
					Rules();
					break;
				case 3:
					System.out.println("Soon it will be available");
					break;
				case 4:
					System.out.println("wrong choice!!.....enter valid option again");
					break;
				}		
				}
				while(opt1!=1||opt1!=2);
	}			
			public static String getdetails(){
				System.out.println("Enter your first name: ");
				String Name;
				//char a = 0;
				Scanner input = new Scanner(System.in);
				Name = input.nextLine();
				Name = Character.toUpperCase(Name.charAt(0))+Name.substring(1);
				//System.out.println(Name);
				//input.close();
				return Name;
			}
			
			public static void Rules(){
				System.out.println("Rules of \"WHO WANTS TO BE MILLIONAIRE\" are as follows:");
				System.out.println("1. There will be 12 questions in all, you will have to answer all the 12 questions to win the game.\n2.Each questions will have 4 options out which only one is Correct");
				System.out.println("3. You have there lifeline that you can use to answer a question if you dont know the answer.");
			}


	}



