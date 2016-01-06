public class Elevator
{
	private LinkedStack<Integer> currentFloor;

	public Elevator()
	{
	currentFloor = new LinkedStack<Integer>();
	currentFloor.push(1);
	}

	public void goUp()
	{
		//wait one
		currentFloor.push(currentFloor.peek()+1);
	}

	public void goDown()
	{
		//wait one
		currentFloor.pop();
	}

	public int getFloor(){return currentFloor.peek();}

	public void goToFloor(int f)
	{
		while(getFloor() != f)
		{
			if(getFloor() > f)
				goDown();
			else
				goUp();
		}
		//wait five
	}

	public void floorCall(int [] floorsCalled)
	{
		for(int i = 0; i < floorsCalled.length; i++)
			goToFloor(floorsCalled[i]);	
	}

	public void floorCall(boolean upOrDown, int floorFrom, int...goingTo)
	{
		goToFloor(floorFrom);
		int counter = 0;

		for(int x : goingTo)
			if(x != floorFrom)
				counter++;

		if(counter != 0)
		{
			int [] tmp = new int[counter];
			int i = 0;
			for(int x : goingTo)
				tmp[i++] = x;
			floorCall(sort(upOrDown, floorFrom, tmp));
		}
	}

	public int [] sort(boolean upOrDown, int pivot, int [] array)
	{
		int temp = 0;
		int x = 0;
		int pivotIndex = 0;
		int j = 0;

		for(int i = 0; i < array.length-1; i++)
		{
			for(int q = i+1; q < array.length; q++)
				if(array[i] > array[q])
				{
					temp = array[q];
					array[q] = array[i];
					array[i] = temp;
				}
		}

		while(array[j] < pivot)
			j++;
		pivotIndex = j;

		while(j != x && x < j)
		{
			temp = array[x];
			array[x] = array[j];
			array[j] = temp;
			x++;
			j--;
		}

		if(upOrDown)
		{
			x = 0;
			while(x < pivotIndex)
			{
				//shift everything 
				//use modulo
				temp = array[0];

				for(int e = 0; e < array.length-1; e++)
					array[e] = array[e+1];

				array[array.length-1] = temp;

				x++;
			}
		}
	return array;
	}
}
