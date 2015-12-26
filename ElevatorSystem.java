class ElevatorSystem
{
	static final int DEFAULTFLOORS = 17;
	private Elevator[] elevators;
	private int numFloors;

	public ElevatorSystem(int e, int f)
	{
		elevators = new Elevator[e];
		for(int i = 0; i < e; i++)
			elevators[i] = new Elevator();
		numFloors = f;
	}
	
	public ElevatorSystem(int e)
	{
		this(e, DEFAULTFLOORS);
	}	

	public void floorCall(int from, int...to)
	{
		int index = 0;
		int min = numFloors;

		for(int i = 0; i < elevators.length; i++)
		{
			if(Math.abs(elevators[i].getFloor() - from) < min)
			{
				min = Math.abs(elevators[i].getFloor() - from);
				index = i;
			}
		}
	status();
	elevators[index].goToFloor(from);
	for (int floor : to)
	{	
		System.out.println("Elevator " + (1+index) + " is going to floor " + floor);
		elevators[index].goToFloor(floor);
	}
	}

	public void printElevators()
	{
		for(int i = numFloors; i > 0; i--)
			for(int numElevator = 0; numElevator < elevators.length; numElevator++)
			{
				if(numElevator == 0)	
					if (elevators[numElevator].floorAt(i) != 0)
						System.out.print("|\t" + elevators[numElevator].floorAt(i));
					else
						System.out.print("|\t");
				else if(numElevator == elevators.length-1)
					if (elevators[numElevator].floorAt(i) != 0)
						System.out.println("\t|\t" + elevators[numElevator].floorAt(i) + "\t|");
					else
						System.out.println("\t|\t\t|");
				else
					if (elevators[numElevator].floorAt(i) != 0)
						System.out.print("\t|\t" + elevators[numElevator].floorAt(i));
					else
						System.out.print("\t|\t");
			}
	}

	public void status()
	{
		for(int i = 1; i <= elevators.length; i++)
			System.out.println("Elevator " + i + " is on floor " + elevators[i-1].getFloor());
	}
}
