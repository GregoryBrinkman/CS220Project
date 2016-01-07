public class MainDriver
{
	public static void main(String [] args)
	{
		ElevatorSystem e = new ElevatorSystem(3);	
		e.floorCall(true, 4, 9);
		System.out.println("\n\n\n");
		e.floorCall(false, 1, 4);
		System.out.println("\n\n\n");
		e.floorCall(true, 1, 3, 6, 2, 8, 4);
	}
}
