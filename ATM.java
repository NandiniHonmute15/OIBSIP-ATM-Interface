import java.util.Scanner;

class OperationATM
{
	Scanner s = new Scanner(System.in);
	int i = 0;
	int array[] = new int[10];
	int amount = 0;

	public void deposit()
	{
		System.out.println("\nEnter the amount to Deposit: ");
		int dept_amount = s.nextInt();
		amount = amount + dept_amount;
		System.out.println("Amount deposited successfully...");
		System.out.println("Your balance: "+amount);
		array[i] = amount;
		i++;		
	}
	
	public void withdraw()
	{
		System.out.println("\nEnter Withdraw Amount: ");
		int with_amount = s.nextInt();
		if(with_amount % 100 != 0)
		{
			System.out.println("\nENTER THE AMOUNT IN RANGE OF MULTIPIED BY 100...");
		}
		else if(with_amount > amount)
		{
			System.out.println("\nBalance is Insufficent");
		}
		else
		{
			amount = amount - with_amount;
			System.out.println("\nReceive your cash...");
			System.out.println("Your current balance is: "+amount);
			array[i] = amount;
			i++;
		}
	}

	public void transfer()
	{
		Scanner s1 = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name : ");
		String receipent = s1.nextLine();
		System.out.print("\nEnter amount which you want to transfer : ");
		int trans_amount = s1.nextInt();
		if ( amount >= trans_amount ) 
		{
			if ( trans_amount <= 50000 ) 
			{
				//array++;
				amount = amount - trans_amount;
				System.out.println("\nAmount is Successfully Transfered to " + receipent);
				array[i] = amount;
				i++;
			}
			else 
			{
				System.out.println("\nTransfer is Invalid, Cause ATM Limit is 50000 only");
			}
		}
		else 
		{
			System.out.println("\nBalance is Insufficient");
		}
	}
	
	public void history()
	{
		System.out.println("*****Transaction History*****\n");
		for(int j=0;j<i;j++)
		{
			System.out.println(array[j]);
		}
	}
}

class ATM
{
	public static void main(String args[]) 
	{

		int ch;	
		int pin = 6819;
		int id = 101;
		int i = 0;
		Scanner sc = new Scanner(System.in);
		OperationATM obj1 = new OperationATM();
		do
		{
		 	System.out.println("Enter ID:");
			id = sc.nextInt();
			System.out.println("Enter PIN : ");
			pin = sc.nextInt();
			if(id != 101 || pin != 6819)
			{
				System.out.println(" ! ENTER VALID CREDENTIALS...");
			}
		}while(id != 101 && pin != 6819);
		do
		{
			System.out.println("\n********** ATM INTERFACE **********\n");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Pay");
			System.out.println("4. History of Payments");
			System.out.println("5. Exit");
			System.out.println("\nEnter your Choice : ");
			ch = sc.nextInt();

			switch(ch)
			{
				case 1:
					obj1.deposit();
					break;
					
				case 2:
					obj1.withdraw();
					break;

				case 3:
					obj1.transfer();
					break;

				case 4:
					obj1.history();
					break;

				case 5:
					System.out.println("Thank you for using our service");
					break;

				default:
					System.out.println("Invalid choice");
			}
		}while(ch!=5);
	}
}
