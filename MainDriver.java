public class MainDriver
{
	public static void main(String [] args)
	{
		Elevator e = new Elevator();
	
		e.floorCall(true, 4, 1, 2, 7, 9, 8, 3);
		System.out.println("\n\n\n");
		e.floorCall(false, 6, 1, 3, 6, 2, 8, 4);
		System.out.println("\n\n\n");
		e.floorCall(true, 6, 1, 3, 6, 2, 8, 4);
	}
}
