package lab11;

public class MaxArrayValue 
{
	public static void main(String args[])
	{
		int[] array={1,2,32,4,10,3,6,2};
		System.out.println(findMax(array));
	}
	
	public static int findMax(int[] array)
	{
		return findMaxRec(array, 0, array.length-1);
	}
	private static int findMaxRec(int[] array,int start, int end)
	{
		if (start == end)
	    {
	      return array[start];
	    }
	    else
	    {
	      int mid = (start + end) / 2;
	      int leftMax = findMaxRec(array, start, mid);
	      int rightMax = findMaxRec(array, mid + 1, end);
	      return Math.max(leftMax, rightMax);
	    }
	}
	  
}
