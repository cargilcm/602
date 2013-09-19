
/**
 * This class implements a List ADT by means of a linked data structure.
 * A List (also known as a <i>sequence</i>) is an ordered collection.
 * Elements in the list can be accessed by their integer index.  The
 * index of the first element in the list is zero.
 *
 *  @author Chris Cargile
 *  @since  08/28/2013
 *  This class implements typical Linked List behaviours and is accompanied 
 *  by a class file for testing it.
 */
public class LinkedList<E>
  {
    private Node<E> head; // position in the list is indexed via "head"
    private int size=0; // the volume (qty) of objects in this list


    /**
     * HEY!  THIS IS A SHORT, INNER CLASS FOR THE NODE OBJECT
     * A list node contains the data value and a link to the next
     * node in the linked list.
     */
    private static class Node<E>
      {
        private E data;
        private Node<E> next;


        /**
         * Construct a node with the specified data value and link.
         */
        public Node(E dataIn, Node<E> nextIn)
          {
            data=dataIn;
            next=nextIn;
          }


        /**
         * Construct a node with the given data value
         */
        public Node(E data)
          {
            this(data, null);
          }
      } 
	  
	  
	  // THIS IS THE END OF THE NODE INNER CLASS

    /**
     * Helper method:  Find the node at a specified index.
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    private Node<E> getNode(int index)
      {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index="+Integer.toString(index)+",size="+size);

        Node<E> node = head;
        for (int i = 0;  i < index;  ++i){
        		node = node.next;
        	}
        if(node==null){
        	node=head;
        	//node.next=new Node<E>(null);
        }
    	return node;
      }


    /**
     * Constructs an empty list.
     */
    public LinkedList()
      {
        
      }


    /**
     * Appends the specified element to the end of the list.
     */
    public void add(E element)
      {
        if (isEmpty())
            head = new Node<E>(element);
        else
          {
            Node<E> lastNode = getNode(size-1);
            lastNode.next = new Node<E>(element);
          }
        ++size;
      }


    /**
     * Inserts the specified element at the specified position in the list.
     * In other words, grows the list by inserting the passed-in value into the position 
     * specified.  Also, changes previous and next elements so new element/node can
     * fit in.
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
    public void add(int index, E element)
      {
    	if(size==0){
    		head = new Node<E>(element);
    		System.out.println("size==0 in this case");
    		size++;
    		return;
    	}
    	if(size>=0 && index==0){
    		System.out.println("before:head = "+head.data);
	    	E prevHead= get(index);
    		head = new Node<E>(element);
    		System.out.println("before:head = "+head.data);
	    	head.next=new Node<E>(prevHead);
    	}
    	else{
	    	Node<E> node = getNode(index);
	    	//System.out.println("before:head = "+node.data);
	    	
	    	Node<E> added=new Node<E>(element);
	    	if(index==0){
	    		//System.out.println("head = "+size);
	        	added.next=new Node<E>(node.data);
	    		head=added;
	    		System.out.println("after:head = "+head.data);
	    		System.out.println("after:head.next = "+head.next.data);
	    		System.out.println("after:get(0) = "+get(0));
	        	
	    	}
			else{
	    	  	Node<E> beforeAdded = getNode(index);
	        	added.next=beforeAdded;
	    	}
	    	
	    	size++;
    	}
    	return;
        
      }


    /**
     * Removes all of the elements from this list.
     */
    public void clear()
      {
        while (head != null)
          {
             Node<E> temp = head;
             head = head.next;

             temp.data = null;
             temp.next = null;
          }

        size = 0;
      }


    /**
     * Returns the element at the specified position in this list.
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E get(int index)
      {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(Integer.toString(index));

        Node<E> node = getNode(index);
        return node.data;
      }


    /**
     * Replaces the element at the specified position in this list
     * with the specified element.
     *
     * @returns The data value previously at index
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E set(int index, E newValue)
      {
    	Node<E> el=getNode(index);
    	E data=el.data;
    	el=new Node<E>(newValue);
    	return data;
      }
    

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
    public int indexOf(Object obj)
      {
        int index = 0;

        if (obj == null)
          {
            for (Node<E> node = head;  node != null;  node = node.next)
              {
                if (node.data == null)
                    return index;
                else
                    index++;
              }
          }
        else
          {
            for (Node<E> node = head;  node != null;  node = node.next)
              {
                if (obj.equals(node.data))
                    return index;
                else
                    index++;
              }
          }

        return -1;
    }


    /**
     * Returns <tt>true</tt> if this list contains no elements.
     */
    public boolean isEmpty()
      {
        return head==null;
      }


    /**
     * Removes the element at the specified position in this list.  Shifts
     * any subsequent elements to the left.
     *
     * @returns the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public E remove(int index)
      {
    	// TODO: *************confirm the below's correctness***************
        if( index<0 || index>=size() )
    		throw new IndexOutOfBoundsException();
        // case 1: remove and return 1st node element if index==0
        else if(index==0){
        	Node<E> temp=head;
        	//if(size>=1)
        		head=head.next;
        	size--;
        	return temp.data;
        }
        // case 2: if(index>0), return the node's data where we are 1 less than
        // "index" positions from the head node since an index of [0] vs [1] corresponds to the
        // "head" element(/location)
        else{	
	    	int i=-1;
	    	Node<E> previous=head;
	    	while(i<index){
	    		previous=previous.next;
	    		i++;
	    	}
	    	previous.next=previous.next.next;
	    	size--;
	    }
	    return null;
      }


    /**
     * Returns the number of elements in this list.
     */
    public int size()
      {
    	return size;
      }


    /**
     * Returns a string representation of this list.  Formatting chosen is: "data1 data2 (..dataN)"
     */
    @Override
    public String toString()
      {
    	String answer="";
    	if(isEmpty())
    		return answer;
    	else{
    		answer="";
	    	int i=0;
	    	Node<E> temp=head;
	    	while(i<size()){
	    		answer+=temp.data.toString()+" ";
	    		temp=temp.next;
	    		i++;
	    	}
	    }
        return answer;
      }


    /*
     * Compares the specified object with this list for equality. Returns true
     * if and only if both lists contain the same elements in the same order.
     */
    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(Object obj)
      {
        if (obj == this)
            return true;

        if (!(obj instanceof LinkedList))
            return false;

        // cast obj to a linked list
        LinkedList listObj = (LinkedList) obj;

        // compare elements in order
        Node<E> node1 = head;
        Node    node2 = listObj.head;

        while (node1 != null && node2 != null)
          {
            // check to see if data values are equal
            if (node1.data == null)
              {
                if (node2.data != null)
                    return false;
              }
            else
              {
                if (!node1.data.equals(node2.data))
                    return false;
              }

            node1 = node1.next;
            node2 = node2.next;
          }

        return node1 == null && node2 == null;
      }


    /**
     * Returns the hash code value for this list.
     */
    @Override
    public int hashCode()
      {
        int hashCode = 1;
        Node<E> node = head;

        while (node != null)
          {
            E obj = node.data;
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
            node = node.next;
          }

        return hashCode;
      }
  }
