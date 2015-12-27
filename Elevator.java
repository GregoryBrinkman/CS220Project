class Elevator
{
	private LinkedStack<Integer> currentFloor; //allocate memory for LinkedStack, currentFloor

	public Elevator() //default constructor
	{
		currentFloor = new LinkedStack<Integer>(); //initialize currentFloor
		currentFloor.push(1); //initialize currentFloor to the first floor
	}//end constructor

	public void goUp()
	{
		currentFloor.push(currentFloor.peek()+1); //pushes currentFloor plus one
		waitOne(); //forces system to wait, making the elevator more realistic
	}//end goUp

	public void goDown()
	{
		currentFloor.pop(); //pops the last pushed floor number
		waitOne(); //forces system to wait, making the elevator more realistic
	}//end goDown

	public int getFloor()
	{
		return currentFloor.peek(); //currentFloor will be the first integer in the stack
	}//end getFloor

	public void goToFloor(int f)
	{
		while(getFloor() != f) //compares currentFloor to the desired floor
		{
			if(getFloor() > f) //if the currentfloor is greater 
				goDown();
			else
				goUp();
		}//end while
	}//end goToFloor

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

