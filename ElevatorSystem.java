class ElevatorSystem
{
	static final int DEFAULTFLOORS = 17; //default number of floors for constructor
	private Elevator[] elevators;
	private int numFloors;

	public ElevatorSystem(int e, int f)
	{
		elevators = new Elevator[e]; //instantiates array of elevators
		for(int i = 0; i < e; i++)
			elevators[i] = new Elevator(); //instantiates elevators in array
		numFloors = f; //specifies total number of floors
	}//end constructor
	
	public ElevatorSystem(int e)
	{
		this(e, DEFAULTFLOORS); //calls constuctor with DEFAULTFLOORS for numFloor
	}//end constructor	

	public void floorCall(boolean upOrDown, int from, int...to)
	{
		int index = getClosestElevator(from);
		elevators[index].floorCall(upOrDown, from, to);
		printElevators();
	}

	private int getClosestElevator(int floor, int exclude)
	{
		int index = 0;
		if(index == exclude)
			index++;
		int min = numFloors;

		for(int i = index; i < elevators.length; i++)
		{
			if((Math.abs(elevators[i].getFloor() - floor) < min) && i != exclude)
			{
				min = Math.abs(elevators[i].getFloor() - floor);
				index = i;
			}//end if
		}//end for
		return index;
	}//end getClosestElevator
	
	private int getClosestElevator(int floor)
	{
		return getClosestElevator(floor, -1);
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
