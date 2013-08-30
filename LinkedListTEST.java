
/**
 * This class serves to test the similarly-named "LinkedList" class, to be
 * found in the default package, also. Tests cover edge cases and basic
 * operations and use the java provided object type: Integer, to do so.
 *
 */
public class LinkedListTEST<E> extends LinkedList<E>
  {
    private Object testCase;
    private int size;
    private LinkedList testlist;
    
    public LinkedListTEST() {
    	testlist= new LinkedList<Object>(); //object is used as <T>, here,
    	// to demonstrate LinkedList accepts any class type vs. only, ie: String<T>
    }
  
    public boolean isEmpty(){
    	return testlist.isEmpty(); // ==true only if empty list
    }
    
    public void add(E obj){
    	testlist.add(obj);
		return;
    }
    public void add(E obj, int index){
    	testlist.add(index,obj);
    	return;
    }
    public E remove(int index){
    	E obj = (E) testlist.remove(index); 
		return (E)obj;
    }
    public String toString(){
		return testlist.toString();
    }
    public E get(int index){
    	return (E)testlist.get(index);
    }
    public int size(){
    	return testlist.size();
    }
    public static void main(String[] args){
    	LinkedListTEST test = new LinkedListTEST();
    	String a = "apple";
        String b = "boy";
        String c = "cat";
    	
    	//System.out.println("test:size()="+test.size()); // >> ....-0 	
    	//System.out.println("test:isEmpty()="+test.isEmpty()); // >> .... true
    	
        
    	System.out.println("test:add("+a+")");
    	
    	test.add(a); // add "apple"
    	//test.remove(0);
    	//System.out.println("test:size()="+test.size()); // >> ....1 
    	System.out.println("test:get("+0+")="+test.get(0));
    	
//    	
    	System.out.println("test:get("+0+")="+test.get(0));
    	
//    	System.out.println("test:add("+b+")");
//    	test.add(b); // add "boy"
//    	System.out.println("test:size()="+test.size()); // >> ....2
//    	
//    	System.out.println("test:add("+c+")");
//    	test.add(c); // add "cat"
//    	System.out.println("test:size()="+test.size()); // >> ....3
//    	System.out.println("test:toString()="+test.toString()); // >>> apple boy cat
//    	
//    	System.out.println("test:get(lastElem@size()-1)="+test.get(test.size()-1)); // size()-1 because [index] is 1 less
//    	System.out.println("test:remove(0)="+test.remove(0)); // >> ....apple
//    	System.out.println("test:size()="+test.size()); // >> ....1
//    	System.out.println("test:toString()="+test.toString()); // >>> boy cat
//    	
//    	System.out.println("test:remove(0)="+test.remove(0)); // >> ....boy
//    	System.out.println("test:toString()="+test.toString()); // >>> cat
//    	
//    	System.out.println("test:size()="+test.size()); // >> ....1
//    	System.out.println("test:add(0,"+b+")");
//    	
//    	System.out.println("test:get(0)="+test.get(0)); // >> cat
//    	test.add(0,b);
//    	System.out.println("test:get(0)="+test.get(0)); // >> cat
//    	
//    	System.out.println("test:toString()="+test.toString()); // >>> boy
//    	
    //	System.out.println("test:remove(0)="+test.remove(0)); // >> ....cat
    	//System.out.println("test:toString()="+test.toString()); // >>> ""
    	
    }
   
  }
