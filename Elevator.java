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
		currentFloor.push(currentFloor.peek()+1);
		waitOne();
	}

	public void goDown()
	{
		currentFloor.pop();
		waitOne();
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

	private void waitOne()
	{
		long t1, t2;
		t1 = System.currentTimeMillis();
		do{t2=System.currentTimeMillis();} while (t2-t1 < 1000);
	}

}

