import java.util.*;

public class MainDriver
{
	public static void main(String [] args)
	{
		ElevatorSystem sys = new ElevatorSystem(5, 10);
		sys.printElevators();
		sys.floorCall(2, 4, 7, 2, 10);
		sys.floorCall(4, 4, 7, 2, 7);
		sys.printElevators();	
	}
}				
