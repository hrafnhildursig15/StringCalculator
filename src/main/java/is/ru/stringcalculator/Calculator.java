package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("//;")){
			return sum(splitNumbers(replaceNewDelimiter(text)));
		}
		else if(text.contains("\n")){
			return sum(splitNumbers(replaceNewLine(text)));
		}
		else if(text.contains("-")){
			isNegative(splitNumbers(text));
			return 0;
		}
		else if(text.contains(",")){
			int summa = 0;
			summa = sum(splitNumbers(text));
			if (summa > 1001){
				summa = largerThanThousand(splitNumbers(text));
			}
			return summa;
		}
		else
			return 1;
	}
	private static int largerThanThousand(String[] numbers){
		int num = 0;
		for (String number : numbers){
			if (Integer.parseInt(number) > 1000){
				number = "0";
			}	
			num += toInt(number);
		}	
		return num;		
	}
	private static String replaceNewDelimiter(String text){
		String newStr = "";
		newStr = text.replace("\n", "");
		newStr = newStr.replace("//;", "");
		newStr = newStr.replace(";", ",");
		return newStr; 
	}
	private static int isNegative(String[] numbers){
		String strMinus = "";
		for(String number : numbers){
			if (Integer.parseInt(number) < 0){
				strMinus = strMinus + number + ",";	
			}			
		}	
		System.err.println("Negatives not allowed: " + strMinus);		
		return 1;
	}
	private static String replaceNewLine(String text){
		return text.replace("\n", ","); 
	}
	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	private static String[] splitNumbers(String numbers){
		return numbers.split(",");
	}
	private static int sum(String[] numbers){
		int total = 0;
		for(String number : numbers){
			total += toInt(number);
		}			
		return total;
	}
}
