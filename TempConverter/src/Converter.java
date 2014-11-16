
/**
 * @author oscardasilva
 *
 */
public class Converter {	
	
	public double CtoF(double tempC){
		return (tempC * 1.8 + 32); 
	}
	
	public double FtoC(double tempF){
		return((tempF - 32) / 1.8);
	}
	
}
