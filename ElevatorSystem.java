class ElevatorSystem
{
	static final int TOTALFLOORS = 17;
	private Elevator[] elevators;

	public ElevatorSystem(int e)
	{
		elevators = new Elevator[e];
		for(int i = 0; i < e; i++)
			elevators[i] = new Elevator();
	}

	public void floorCall(int from, int...to)
	{
		int index = 0;
		int min = TOTALFLOORS;

		for(int i = 0; i < elevators.length; i++)
		{
			if(Math.abs(elevators[i].getFloor() - f < min)
			{
				min = Math.abs(elevators[i].getFloor() - f);
				index = i;
			}
		}
	status();
	elevators[index].goToFloor(from);
	for (int floor : to)
	{	
		System.out.println("Elevator " + index + " is going to floor " + floor);
		elevators[index].goToFloor(floor);
	}
	}

	public void printElevators()
	{
		for(int i = TOTALFLOORS; i > 0; i++)
			for(int numElevator = 0; numElevator < elevators.length; numElevator++)
			{
				switch (numElevator) {
					case 0:
						if (elevators[numElevator].floorAt(i) != 0)
							System.out.print("|\t" + elevators[numElevator].floorAt(i));
						else
							System.out.print("|\t");
						break;
					case elevators.length-1:
						if (elevators[numElevator].floorAt(i) != 0)
							System.out.print("\t|\t" + elevators[numElevator].floorAt(i) + "\t|");
						else
							System.out.print("\t|\t\t|");
						break;
					default:
						if (elevators[numElevator].floorAt(i) != 0)
							System.out.print("\t|\t" + elevators[numElevator].floorAt(i));
						else
							System.out.print("\t|\t");
				}
			}
	}

	public void status()
	{
		for(int i = 1; i <= elevators.length; i++)
			System.out.println("Elevator " + i + " is on floor " + elevators[i-1].getFloor());
	}
}
