class Elevator
{
	private LinkedStack<Integer> currentFloor;
	public Elevator()
	{
		currentFloor = new LinkedStack<Integer>();
		currentFloor.push(1);
	}

	public void goUp()
	{
		//make the elevator wait
	
		currentFloor.push(currentFloor.peek()+1);
	}

	public void goDown()
	{
		//make the elevator wait

		currentFloor.pop();
	}

	public int getFloor()
	{
		return currentFloor.peek();
	}

	public void goToFloor(int f)
	{
		while(getFloor() != f)
		{
			if(getFloor() > f)
				goDown();
			else
				goUp();
		}
	}

	public int floorAt(int floor)
	{
		if (floor != getFloor())
			floor = 0;
		return floor;
	}
}
