import java.util.Scanner;

public class CalculateTempDewHum {

	public static void main(String[] args) {
		
/*******************************************************************/
		
		// inputs for dew point 
		Scanner input = new Scanner(System.in);
		System.out.println("Lets calculte the dewpoint!");
		System.out.print("Please enter the actual temperature (F): ");
		double actualTempFahr = input.nextDouble();
		System.out.print("Please enter the relative humidity: ");
		double humidityPercent = input.nextDouble();
		double actualTempCent = 5.0 / 9.0 * (actualTempFahr - 32.0);
		
		
		// calculation for dew point 
		double dewPoint = 243.04*(Math.log(humidityPercent/100)+((17.625*actualTempCent)/(243.04+actualTempCent)))
				/(17.625-Math.log(humidityPercent/100)-((17.625*actualTempCent)/(243.04+actualTempCent)));
		
		double dewPointFahr = 9.0 / 5.0 * dewPoint + 32.0;
		
		
		// output of dew point 
		System.out.printf("The dewpoint in fahrenheit is: %.2f \n\n\n", dewPointFahr); 
		
		
/*******************************************************************/
		
		// inputs for temperature 
		System.out.println("Excellent! Now lets calculate the temperature!!!");
		System.out.print("Please enter the dewpoint (F): ");
		double dewPointTemp = input.nextDouble();
		System.out.print("Please enter the relative humidity: ");
		double humidityTemp = input.nextDouble();
		double temperatureCent = 5.0 / 9.0 * (dewPointTemp - 32.0);
		
		
		// calculation for temperature 
		double temperature = 243.04*(((17.625*temperatureCent)/(243.04+temperatureCent))-Math.log(humidityTemp/100))/
				(17.625+Math.log(humidityTemp/100)-((17.625*temperatureCent)/(243.04+temperatureCent)));
		
		double temperatureFahr = 9.0 / 5.0 * temperature + 32.0;
		
		
		// output of temperature 
		System.out.printf("The temperature in fahrenheit is: %.2f  Great Work! \n\n\n", temperatureFahr);
		
		
/**************************************************************************/
		
		// inputs for humidity 
		System.out.println("Lastly, lets calculate the relative humidity!! ");
		System.out.print("Please enter the dewpoint (F): ");
		double dewpointForHumidity = input.nextDouble();
		System.out.print("Please enter the temperature (F): ");
		double tempForHumidity = input.nextDouble();
		double dewCent = 5.0 / 9.0 * (dewpointForHumidity - 32.0);
		double tempCent = 5.0 / 9.0 * (tempForHumidity - 32.0);
		input.close();

		
		// calculation for humidity 
		double humidity = 100*(Math.exp((17.625*dewCent)/(243.04+dewCent))/
				Math.exp((17.625*tempCent)/(243.04+tempCent)));
		
	
		// output for humidity
		System.out.printf("The relative humidity is %.2f !!! All done! Woot Woot!!  \n", humidity);
	}

}
