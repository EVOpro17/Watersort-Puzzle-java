//30415284 Fernandrique Jadon Ockhuys

public class StackAsMyArrayList<E> 
{   
	MyArrayList<E> theStack;
	MyArrayList bottle[];
    public StackAsMyArrayList()
    {  theStack = new MyArrayList<E>();  
		bottle = new MyArrayList[5];     
    }
	
    public void push(E newElement) //insert at end of array!
    {  
		   if (!theStack.checkSpace())
		   throw new IndexOutOfBoundsException
                    ("Stack out of bounds");
		   theStack.add(theStack.getSize(),newElement);
    }
	
	public E pop() //remove end of array
    {  
		E temp = null;
		
		boolean isDone = false;
		if (theStack.getSize() > 0)
			temp=theStack.remove(theStack.getSize()-1);
		return temp; // temp will be null in special case of empty list
    }
    public E peek() //remove end of array
    {  
		E temp = null;
		if (theStack.getSize() > 0)
			temp=theStack.get(theStack.getSize()-1);
		return temp; // temp will be null in special case of empty list
    }
	
	public String toString()
	{
		return theStack.toString();
	}
	
	public int getStackSize() {
       return theStack.getSize();
    }
	
	public int rand() {
       return theStack.filter();
    }
	
    public boolean checkStackUniform() {
       return theStack.checkUniform();
    }
   
   
}//end class
