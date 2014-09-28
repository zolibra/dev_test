package test.com.mytest; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import com.mytest.SingleList;

/** 
* LinkedList Tester. 
* 
* @author <Authors name> 
* @since <pre>Jul 2, 2014</pre> 
* @version 1.0 
*/ 
public class SingleListTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getNode(int index) 
* 
*/ 
@Test
public void testGetNode() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getFirst() 
* 
*/ 
@Test
public void testGetFirst() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insert(T value, int index) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: add(T t) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(int index) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteDuplicates(LinkedList head) 
* 
*/ 
@Test
public void testDeleteDuplicates() throws Exception { 
//TODO: Test goes here...
    SingleList<Integer> list = new SingleList<Integer>();
    list.add(1);
    list.add(2);
    list.add(2);
    list.add(3);
    list.add(3);
    list.print();
    list.deleteDuplicates();
    list.print();
} 

/** 
* 
* Method: print() 
* 
*/ 
@Test
public void testPrint() throws Exception { 
//TODO: Test goes here... 
} 


} 
