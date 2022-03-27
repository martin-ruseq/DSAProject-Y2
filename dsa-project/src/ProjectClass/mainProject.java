package ProjectClass;

import java.util.Scanner;

//Name:					Julia Lodygowska & Marcin Rusiecki
//Student ID:			C00263203
//Date:					24.01.2022
//Purose:				Menu-based program that perform an series of operations on Sets.

public class mainProject 
{
	private static Scanner in;
	public static int add(int k, int [] S, int end)
	{
		int addPosition = 0;
		int index;
		if ( end != S.length-1 )
		{
			if (!contains(k, S, end))
			{
				for ( index = 0 ; index <= end ; index ++)
				{
					if(S[index] < k)
					{
						addPosition = index +1;
					}
				}
				end ++;
				for ( index = end ; index > addPosition ; index --)
				{
					S[index] = S[index-1];
				}
				S[addPosition] = k;
				System.out.println("");
				System.out.println(k + " has been added to the Set");
			}
			else
			{
				System.out.println("");
				System.out.println(k + " is already in the Set!");
			}
		}
		else
		{
			System.out.println("");
			System.out.println("The Set is full!");
		}
		return end;
	}
	
	public static boolean contains(int k, int [] S, int end)
	{
		boolean isMember = false;
		int index;
		for (index = 0; index <= end ; index ++)
		{
			if ( S[index] == k )
			{
				isMember = true;
			}
		}
		return isMember;
	}
	
	public static int removeAll(int [] remSet, int [] S, int endS, int endRemSet)
	{
		int index1 = 0, index2 = 0;
        while (index1 <= endS && index2 <= endRemSet) 
        {
            if (S[index1] < remSet[index2]) 
            {
                index1++;
            }
            else if (remSet[index2] < S[index1]) 
            {
                index2++;
            }
            else 
            {
            	System.out.println("");
            	System.out.println(S[index1] + " has been removed");
            	S[index1] = 0;
            	for (int index = index1 ; index <= endS ; index ++)
            	{
            		if (index == endS)
            		{
            			S[index] = 0;
            		}
            		else
            		{
            			S[index] = S[index +1];
            		}
            	}
            	endS --;
                index2++;
            }
        }
        return endS;
	}
	
	public static void print(int [] S, int end)
	{
		int index;
		System.out.println("");
		System.out.print("The Set contains: ");
		for (index = 0 ; index <= end ; index++)
		{
			System.out.print(S[index] + ", ");
		}
		System.out.println("");
	}
	
	public static void differenceOfSets(int [] S, int [] S2, int end, int end2)
	{
		int index1 = 0, index2 = 0;
    	System.out.println("");
        while (index1 <= end && index2 <= end2) 
        {

            if (S[index1] < S2[index2]) 
            {
                System.out.print(S[index1] + ", ");
                index1++;
            }
            else if (S2[index2] < S[index1]) 
            {
                System.out.print(S2[index2] + ", ");
                index2++;
            }
            else 
            {
                index1++;
                index2++;
            }
        }
        while (index1 <= end) 
        {
            System.out.print(S[index1] + ", ");
            index1++;
        }
        while (index2 <= end2) 
        {
            System.out.print(S2[index2] + ", ");
            index2++;
        }
		System.out.println("");
	}
	
	public static void similarities(int [] S, int [] S2, int end, int end2)
	{
		int index1 = 0, index2 = 0;
		System.out.println("");
        while (index1 <= end && index2 <= end2) 
        {
            if (S[index1] < S2[index2]) 
            {
                index1++;
            }
            else if (S2[index2] < S[index1]) 
            {
                index2++;
            }
            else 
            {
            	System.out.print(S[index1] + ", ");
                index1++;
                index2++;
            }
        }
		System.out.println("");
	}
	
	public static int menu()
	{
		int option;
		in = new Scanner(System.in);
		System.out.println("");
		System.out.println("Pick an option (1-7):");
		System.out.println("");
		System.out.println("1. Add");
		System.out.println("2. Contains");
		System.out.println("3. Remove all");
		System.out.println("4. Print");
		System.out.println("5. Difference");
		System.out.println("6. Similarities");
		System.out.println("7. Exit");
		System.out.println("");
		System.out.print("Enter an option: ");
		option = in.nextInt();
		return option;
	}
	public static void main(String []args)
	{
		int option;
		int element;
		boolean result = false;
		int suboption = 0;
		int [] S = new int [9];
		int end = -1;
		int [] S2 = new int [9];
		int end2 = -1;
		Scanner in = new Scanner(System.in);
		
		option = menu();
		while( option != 7 )
		{
			if ( option == 1 )
			{
				System.out.println("");
				System.out.println("1. Add an element into SET 1");
				System.out.println("2. Add an element into SET 2");
				System.out.println("3. Go back to main MENU");
				System.out.println("");
				System.out.print("Enter an option (1-3): ");
				suboption = in.nextInt();
				if ( suboption == 1 )
				{
					System.out.println("");
					System.out.println("What number would you like to add into SET 1?");
					System.out.print("Enter the number: ");
					element = in.nextInt();
					end = add(element, S , end);
				}
				else if ( suboption == 2 )
				{
					System.out.println("What number would you like to add into SET 2?");
					System.out.print("Enter the number: ");
					System.out.print("");
					element = in.nextInt();
					end2 = add(element, S2 , end2);
				}
				else if ( suboption > 3 || option < 1 )
				{
					System.out.println("");
					System.out.println("*** You have entered an invalid option, you are now back at the main menu ***");
				}
				option = menu();
			}
			else if ( option == 2 )
			{
				System.out.println("");
				System.out.println("1. Search for an element in Set 1");
				System.out.println("2. Search for an element in Set 2");
				System.out.println("3. Go back to main MENU");
				System.out.println("");
				System.out.print("Enter an option (1-3): ");
				suboption = in.nextInt();
				if ( suboption == 1 )
				{
					System.out.println("");
					System.out.println("Which number are you looking for?");
					System.out.print("Enter the number: ");
					System.out.print("");
					element = in.nextInt();
					result = contains(element, S, end);
					if (result)
					{
						System.out.println("");
						System.out.println("The element " + element + " is in Set 1");
					}
					else 
					{
						System.out.println("");
						System.out.println("The element " + element + " is NOT in Set 1");
					}
				}
				else if ( suboption == 2 )
				{
					System.out.println("");
					System.out.println("Which number are you looking for?");
					System.out.print("Enter the number: ");
					System.out.print("");
					element = in.nextInt();
					result = contains(element, S2, end2);
					if (result)
					{
						System.out.println("");
						System.out.println("The element " + element + " is in Set 2");
					}
					else 
					{
						System.out.println("");
						System.out.println("The element " + element + " is NOT in Set 2");
					}
				}
				else if (suboption > 3 || suboption < 1)
				{
					System.out.println("");
					System.out.println("*** You have entered an invalid option! ***");
				}
				option = menu();
				
			}
			
			else if ( option == 3 )
			{
				System.out.println("");
				System.out.println("1. Remove similar element(s) in Set 1, which both sets contain");
				System.out.println("2. Remove similar element(s) in Set 2, which both sets contain");
				System.out.println("3. Go back to main MENU");
				System.out.println("");
				System.out.print("Enter an option (1-3): ");
				suboption = in.nextInt();
				if ( suboption == 1 )
				{
					System.out.println("");
					System.out.print("Are you sure you want to remove element(s) from Set 1? [y/n]: ");
					char answer = in.next().charAt(0);
					if ( answer == 'y' || answer == 'Y')
					{
						end = removeAll(S2, S, end, end2);
					}
					else if ( answer == 'n' || answer == 'N')
					{
						
					}
					else 
					{
						System.out.println("");
						System.out.println("You have entered an invalid option!");
					}
				}
				else if ( suboption == 2 )
				{
					System.out.println("");
					System.out.print("Are you sure you want to remove element(s) from Set 2? [y/n]: ");
					char answer = in.next().charAt(0);
					if ( answer == 'y' || answer == 'Y')
					{
						end2 = removeAll(S, S2, end2, end);
					}
					else if ( answer == 'n' || answer == 'N')
					{
						
					}
					else 
					{
						System.out.println("");
						System.out.println("You have entered an invalid option!");
					}
					
				}
				else if ( suboption > 3 || option < 1 )
				{
					System.out.println("");
					System.out.println("You have entered an invalid option!");
				}
				option = menu();
			}
			
			else if ( option == 4 )
			{
				System.out.println("");
				System.out.println("1. Display all elements of Set 1");
				System.out.println("2. Display all elements of Set 2");
				System.out.println("3. Go back to main MENU");
				System.out.println("");
				System.out.print("Enter an option (1-3): ");
				suboption = in.nextInt();
				if ( suboption == 1 )
				{
					print(S, end);
				}
				else if ( suboption == 2 )
				{
					print(S2, end2);
				}
				else if ( suboption > 3 || option < 1 )
				{
					System.out.println("");
					System.out.println("You have entered an invalid option!");
				}
				option = menu();
			}
			else if ( option == 5 )
			{
				differenceOfSets(S, S2, end ,end2);
				option = menu();
			}
			
			else if ( option == 6 )
			{
				similarities(S, S2, end, end2);
				option = menu();
			}
			
			else if ( option > 7 || option < 1 )
			{
				System.out.println("");
				System.out.println("You have entered an invalid option, Please try again!");
				option = menu();
			}
			
		}
		in.close();
	}
}