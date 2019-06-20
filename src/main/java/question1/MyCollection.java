package question1;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	int sentinal=0; //To mark the number of elements in array (it points where to add element)
	private int[] numArray;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
	}

	public int search(int searchingNum) {
		// TODO Auto-generated method stub
		for(int i=0; i<numArray.length; i++)
		{
			if(numArray[i] == searchingNum)
				return i;	//if search pass
		}
		return -1;	//if search fails
	}

	public boolean add(int numberToAdd) {
		// TODO Auto-generated method stub
		if(search(numberToAdd) != -1)	//Element is already present in array
			return false;

		if(sentinal == numArray.length)	//Array is full
		{
			doubleCapacity();
		}

		//Adding element
		numArray[sentinal] = numberToAdd;
		sentinal++;

		return true;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		int doubleCap[] = new int[numArray.length * 2];

		//Copying previous array
		for(int i=0; i<numArray.length; i++)
		{
			doubleCap[i] = numArray[i];
		}

		//Assigning memory block to numArray
		numArray = doubleCap;
		
	}

	public boolean remove(int numberToRemove) {
		// TODO Auto-generated method stub
		int numIndex = search(numberToRemove);
		if(numIndex == -1)
			return false;

		for(int i=numIndex; i<sentinal; i++)
		{
			numArray[i] = numArray[i+1];
		}
		numArray[sentinal-1] = 0;
		sentinal-- ; // Decrementing count

		return true;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return sentinal;
	}

	public int[] rotate(int n) {
		// TODO Auto-generated method stub
		/*  We will try to improve the time-complexity by using binary approach */

		int tempArr[] = new int[n];		// Array to pluck the elements before pivot point(n-1)
		for(int i=0; i<n; i++)
		{
			tempArr[i] = numArray[i];
		}

		for(int i=0; i<n; i++)	//Removing elements before pivot point
		{
			remove(tempArr[i]);
		}


		for(int i=0; i<n; i++)	//Adding elements
		{
			add(tempArr[i]);
		}

		return numArray;
	}

	public String toString( )
	{
		String str= new String("");
		str += "{";
		for(int i=0; i<sentinal; i++)
		{
			if(i == sentinal-1)
				str += (numArray[i] + "");
			else
				str += (numArray[i] + ",");
		}
		str += "}";

		return str;
	}
}
