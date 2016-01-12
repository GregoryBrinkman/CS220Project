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
		try{
			Thread.sleep(100);
		}catch(InterruptedException e){}
		currentFloor.push(currentFloor.peek()+1);
	}

	public void goDown()
	{
		//wait one
		try{
			Thread.sleep(100);
		}catch(InterruptedException e){}
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
		System.out.println("\nThe elevator has arrived at " + getFloor());
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){}
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

		for(int x : goingTo) //determines how large the array should be
			if(x != floorFrom)
				counter++;

		if(counter != 0)
		{
			int [] tmp = new int[counter];
			int i = 0;
			for(int x : goingTo)
				if(x != floorFrom)
					tmp[i++] = x;
			
			tmp = sort(upOrDown, floorFrom, tmp);

			for(int ok : tmp)
				System.out.print(" | " + ok);
			System.out.println();
			floorCall(tmp);
		}
	}

	public int [] sort(boolean upOrDown, int pivot, int [] array)
	{
		int j = 0;
		int pivotIndex = 0;
		int x = 0;
		int temp = 0;

		//Sorts lowest to highest
		for(int i = 0; i < array.length-1; i++)
		{
			for(int q = i+1; q < array.length; q++)
			{
				if(array[i] > array[q])
				{
					temp = array[q];
					array[q] = array[i];
					array[i] = temp;
				}
			}
		}

		//determines which are less than the pivot(floorFrom)
		while(array[j] < pivot && j < array.length)
			j++;
		pivotIndex = j--;
		
		//swaps the lower floors highest to lowest
		while(j != x && x < j)
		{
			temp = array[x];
			array[x] = array[j];
			array[j] = temp;
			x++;
			j--;
		}
		
		//if up first, shifts all the lower amount to the end of the array
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
	
	public int floorAt(int i) //for the print elevators method
	{
		if(i != getFloor())
			i = 0;
		return i;
	}
}
