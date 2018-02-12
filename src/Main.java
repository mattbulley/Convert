import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	public static boolean playing = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Please enter a number between 1 and 99,999:");
		
		
		//for(int i = 0; i < 100000; i++)
		//	System.out.println(i + " " + digitsToWords(i));
		
		do {
			int input = Integer.parseInt(scanner.nextLine());
			
			
			if(input == 0) {
				playing = false;
				scanner.close();
				System.exit(0);
			}
			
			System.out.println(input + " " + digitsToWords(input));
			
		} while (playing);

		scanner.close();
	}
	
	public static String digitsToWords(int digit)
	{
		String temp = "";
		if(digit != 0) {
			
			
			// If number not teen and less than 100
			if(digit < 10 || digit > 19 && digit < 100) {
				int digit1 = digit/10;
				int digit2 = digit%10;
				temp = convertTens(digit1) + convertUnits(digit2);
			} else // if number teen
			{
				temp = convertTeens(digit);
			}
			
			
			if(digit > 99) // if 3 digits
				temp = threeDigits(digit);
				
			
			// if 4 digits
			if (digit > 999) {
				int digit0 = digit / 1000;
				int digit1 = (digit/100)%10;
				int digit2 = (digit/10)%10;
				int digit3 = digit%10;
				String and = "and ";
				if(digit2 == 0 && digit3 == 0)
					and = "";
				
				if(digit2 == 1) {
					int digitTeens = Integer.parseInt((Integer.toString(digit2) + Integer.toString(digit3)));
					temp = convertThousands(digit0) + convertHundreds(digit1) + and + convertTeens(digitTeens);
					
				} else {
					
					temp = convertThousands(digit0) + convertHundreds(digit1) + and + convertTens(digit2) + convertUnits(digit3);
				}
			}
			
			// if 5 digits
			if(digit > 9999) {
				int digitn = digit / 10000;
				int digit0 = (digit/1000)%10;
				int digit1 = (digit/100)%10;
				int digit2 = (digit/10)%10;
				int digit3 = digit%10;
				
				String and = "and ";
				if(digit2 == 0 && digit3 == 0)
					and = "";
				
				if(digitn == 1) {
					int digitTeens = Integer.parseInt((Integer.toString(digitn) + Integer.toString(digit0)));
					temp = convertTeens(digitTeens);
					
				} else {
					temp = convertTens(digitn) + convertUnits(digit0);
				}
				
				if(digit2 == 1) {
					int digitTeens = Integer.parseInt((Integer.toString(digit2) + Integer.toString(digit3)));
					temp += " Thousand " + convertHundreds(digit1) + and + convertTeens(digitTeens);
					
				}  
				
	
				else {
					
					temp += " Thousand " + convertHundreds(digit1) + and + convertTens(digit2) + convertUnits(digit3);
				
				}
			}
			
			
		} else {
			temp = "Zero";
			return temp;
		}
		
		return temp;
	}
	
	public static String threeDigits(int digit) {
		
		String temp = "";
		int digit1 = digit/100;
		int digit2 = (digit/10)%10;
		int digit3 = digit%10;
		String and = "and ";
		
		if(digit2 == 0 && digit3 == 0)
			and = "";
		
		if(digit2 == 1) {
			int digitTeens = Integer.parseInt((Integer.toString(digit2) + Integer.toString(digit3)));
			temp = convertHundreds(digit1) + and + convertTeens(digitTeens);	
		} else 
			temp = convertHundreds(digit1) + and + convertTens(digit2) + convertUnits(digit3);
		
		return temp;
	}
	
	public static String convertTens(int digit) {
		String word = "";
		switch(digit) {
			case 1:
				
				break;
			case 2:
				word = "Twenty ";
				break;
			case 3:
				word = "Thirty ";
				break;
			case 4:
				word = "Forty ";
				break;
			case 5:
				word = "Fifty ";
				break;
			case 6:
				word = "Sixty ";
				break;
			case 7:
				word = "Seventy ";
				break;
			case 8:
				word = "Eighty ";
				break;
			case 9:
				word = "Ninety ";
				break;
					
		}
		return word;
	}
	
	public static String convertUnits(int digit) {
		String word = "";
		switch(digit) {
			case 1:
				word = "One";
				break;
			case 2:
				word = "Two";
				break;
			case 3:
				word = "Three";
				break;
			case 4:
				word = "Four";
				break;
			case 5:
				word = "Five";
				break;
			case 6:
				word = "Six";
				break;
			case 7:
				word = "Seven";
				break;
			case 8:
				word = "Eight";
				break;
			case 9:
				word = "Nine";
				break;
					
		}
		return word;
	}
	
	public static String convertTeens(int digit) {
		String word = "";
		switch(digit) {
			case 10:
				word = "Ten";
				break;
			case 11:
				word = "Eleven";
				break;
			case 12:
				word = "Twelve";
				break;
			case 13:
				word = "Thirteen";
				break;
			case 14:
				word = "Fourteen";
				break;
			case 15:
				word = "Fifteen";
				break;
			case 16:
				word = "Sixteen";
				break;
			case 17:
				word = "Seventeen";
				break;
			case 18:
				word = "Eighteen";
				break;
			case 19:
				word = "Nineteen";
				break;
					
		}
		return word;
	}
	
	public static String convertHundreds(int digit) {
		String word = "";
		switch(digit) {
			case 1:
				word = "One Hundred ";
				break;
			case 2:
				word = "Two Hundred ";
				break;
			case 3:
				word = "Three Hundred ";
				break;
			case 4:
				word = "Four Hundred ";
				break;
			case 5:
				word = "Five Hundred ";
				break;
			case 6:
				word = "Six Hundred ";
				break;
			case 7:
				word = "Seven Hundred ";
				break;
			case 8:
				word = "Eight Hundred ";
				break;
			case 9:
				word = "Nine Hundred ";
				break;
					
		}
		return word;
	}
	
	public static String convertThousands(int digit) {
		String word = "";
		switch(digit) {
			case 1:
				word = "One Thousand ";
				break;
			case 2:
				word = "Two Thousand ";
				break;
			case 3:
				word = "Three Thousand ";
				break;
			case 4:
				word = "Four Thousand ";
				break;
			case 5:
				word = "Five Thousand ";
				break;
			case 6:
				word = "Six Thousand ";
				break;
			case 7:
				word = "Seven Thousand ";
				break;
			case 8:
				word = "Eight Thousand ";
				break;
			case 9:
				word = "Nine Thousand ";
				break;
					
		}
		return word;
	}
	
}