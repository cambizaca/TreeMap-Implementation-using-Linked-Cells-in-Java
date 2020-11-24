package assignment2_f20;

import java.util.Arrays;

public class BST_Playground {
/*
 * you will test your own TreeMap implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create TreeMap objects,
 * put data into them, take data out, look for values stored
 * in it, checking size, and looking at the TMCells to see if they 
 * are all linked up correctly as a BST
 * 
*/
  
  public static void main(String[] args) {
    // you should test your TreeMap implementation in here
    // sample tests are shown

    // it is up to you to test it thoroughly and make sure
    // the methods behave as requested above in the interface
  
    // do not simple depend on the oracle test we will give
    // use the oracle tests as a way of checking AFTER you have done
    // your own testing

    // one thing you might find useful for debugging is a print tree method
    // feel free to use the one we have here ... basic and quick, or write one 
    // you like better, one that shows you the tree structure more clearly
    // the one we have here only shows keys, you may wish to add 
    // value fields to the printing

	  
//	  String h = "bannana";
//	  
//	
//	  System.out.println(h.compareTo("apple")); 
//	  
//	  
	  
	  
	  
    TreeMap tm = new TreeMap_imp();
    Value v1 = new Value_imp(1, 100.0, 20);
    Value v2 = new Value_imp(2, 100.0, 20);
    Value v3 = new Value_imp(3, 100.0, 20);
    Value v4 = new Value_imp(3, 100.0, 20);
    Value v5 = new Value_imp(3, 100.0, 20);
    Value v6 = new Value_imp(3, 100.0, 20);
    Value v7 = new Value_imp(3, 100.0, 20);

//    Value v4 = new Value_imp(45678, 55.70, 35);
//    tm.put("b", v1); 
    tm.put("e", v6);
    tm.put("f", v1);
    tm.put("d", v1);
    tm.put("c", v1);



//    tm.put("d", v1);
//    tm.put("b", v2);
//    tm.put("f", v3);
//    tm.put("a", v4);
//    tm.put("c", v5);
//    tm.put("g", v7);
//
//   
//
////    tm.put("c", v3);
////    tm.put("d", v4);
////    System.out.println(tm.minKey());
////    tm.remove("a");
////    tm.remove("a");
//    System.out.println(tm.size());
//    
//    tm.remove("a");
//    
//    System.out.println(tm.hasKey("a"));
//    tm.remove("b");
//
//    tm.remove("d");
    tm.remove("e");
    

    System.out.println(Arrays.toString(tm.getKeys()));
//
//    
//  tm.put("a", v1);
//  tm.remove("a");



//    System.out.println(tm.getRoot().getKey());
//    System.out.println(tm.getRoot().getLeft().getKey());
//    System.out.println(tm.getRoot().getRight().getKey());
//    System.out.println(tm.getRoot().getRight().getRight().getKey());
//    System.out.println("---");
//
//
//    tm.remove("b");
//    System.out.println(tm.getRoot().getKey());
//    System.out.println(tm.getRoot().getLeft().getKey());
//    System.out.println(tm.getRoot().getRight().getKey());
//
//    System.out.println("haha");
//
//    System.out.println(tm.maxKey());
//
//
//    System.out.println(tm.getRoot().getLeft() == null || tm.getRoot().getRight() == null);
//
//
//    tm.remove("alphah");
//
//    System.out.println(tm.size());
//    tm.remove("alpha");
//    System.out.println(tm.size());
  }

  public static void prTree (TMCell c, int off) {
    if (c==null) return;
        
    prTree(c.getRight(), off+2);
    
    for (int i=0; i<off; i++) System.out.print(" ");
    System.out.println(c.getKey());
    
    prTree(c.getLeft(), off+2);
  }

}
	  