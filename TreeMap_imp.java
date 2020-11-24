package assignment2_f20;

//--------------------------------------------------------------

public class TreeMap_imp implements TreeMap { 
  TMCell root;
  int size;
  String[] keys;
  int i;

  // add fields as you need to in order to provide the required behavior
  // also you may add private methods to assist you as needed
  // in implementing
  
  //-------------------------------------------------------------

  TreeMap_imp () { 
	  System.out.println("-----");
    root = null;
    // for added fields you can add appropriate initialization code here
  }

  //-------------------------------------------------------------

  // dont change, we need this for grading
  @Override
  public TMCell getRoot() { return this.root; }
  //-------------------------------------------------------------
  // "height" is a complete implementation 
  // of the public interface method height
  // it is here to illustrate for you how the textbook sets up 
  // the method implementation as recursion
  // you may include this in your project directly

  public int height() { // public interface method signature
  // this method is the public interface method
  // it is not recursive, but it calls a recursive
  // private method and passes it access to the tree cells
    return height_r(this.getRoot());
  }
  private int height_r(TMCell c) { 
  // inner method with different signature
  // this helper method uses recursion to traverse
     if (c==null) return -1;
    int lht = height_r(c.getLeft());
    int rht = height_r(c.getRight());
    return Math.max(lht,rht) + 1;
  }
	
	@Override
	public Value put(String k, Value v) {
		System.out.println("String:" +k + " ; Value: " + v);
		if(root == null) {
			root = new TMCell_imp(k,v);
			size++;
			return null;
		}
		return put_r(root, k, v);
	}
	
	private Value put_r(TMCell ref, String k, Value v) {
		int compVal= k.compareTo(ref.getKey());
		if(compVal == 0) {
			Value tempVal = ref.getValue();
			ref.setValue(v);
			return tempVal;
		}
		else if(compVal > 0) {
			if(ref.getRight() == null) {
				TMCell newCell = new TMCell_imp(k,v);
				ref.setRight(newCell);
				size++;
				return null;
			}
			return put_r(ref.getRight(), k, v);
		} else if (compVal < 0) {
			if(ref.getLeft() == null) {
				TMCell newCell = new TMCell_imp(k,v);
				ref.setLeft(newCell);
				size++;
				return null;
			}
			return put_r(ref.getLeft(), k, v);
		}
		return null;
	}
		
	@Override
	public Value get(String k) {
		if(root == null) {
			return null;
		}
		return get_r(root, k);
	}
	
	private Value get_r(TMCell ref, String k) {
		int compVal= k.compareTo(ref.getKey());
		if(compVal == 0) {
			return ref.getValue();
		} else if(compVal > 0) {
			return get_r (ref.getRight(),k);
		} else if(compVal < 0) {
			return get_r (ref.getLeft(),k);
		}
		return null;
	}

	
	@Override
	public void remove(String k) {
		System.out.println("remove: "+k);
		if(root == null) {
			return;
		}
		if(root.getLeft() == null && root.getRight() == null) {
			root = null;
			size--;
			return;
		}
		
		int compVal= k.compareTo(root.getKey());
		if(compVal >0) {
			if(root.getRight() != null) {
				remove_r(root.getRight(), root, k, true); //goes right
			}
		}
		if (compVal < 0){
			if(root.getLeft() != null) { 
				remove_r(root.getLeft(), root, k, false); // goes left
			}
		} 
		if (compVal == 0) {
			root.getRight().setLeft(root.getLeft());
			root = root.getRight();
			size--;
			return;
		}
	}
	
	private void remove_r(TMCell ref, TMCell pCell, String k, Boolean wentRight) {
		int compVal= k.compareTo(ref.getKey());
		if (compVal == 0) {
			if(ref.getLeft() == null && ref.getRight() == null) {		//ref is leaf
				if(wentRight) {											//came from right
					pCell.setRight(null);
					size--;
					return;
				} else if (!wentRight) {								//came from left		
					pCell.setLeft(null);
					size--;
					return;
				}			
			}
			if(ref.getLeft() == null && ref.getRight() != null) {		//ref ONLY has a right child
				if(wentRight) {											//came from right
					pCell.setRight(ref.getRight());
					size--;

					return;
				} else if (!wentRight) {								//came from left		
					pCell.setLeft(ref.getRight());
					size--;

					return;
				}
			}
			if(ref.getLeft() != null && ref.getRight() == null) {		//ref ONLY has a left child
				if(wentRight) {											//came from right
					pCell.setRight(ref.getLeft());
					size--;

					return;
				} else if (!wentRight) {								//came from left		
					pCell.setLeft(ref.getLeft());
					size--;
					return;
				}
			}
			
			
			if(ref.getLeft() != null && ref.getRight() != null) {				//ref got two childs
				TMCell replaceDeletedNode = this.minkey_r1(ref.getRight());
				replaceDeletedNode.setLeft(ref.getLeft());
				replaceDeletedNode.setRight(ref.getRight());
				ref = replaceDeletedNode;
				remove_r(ref.getRight(), pCell, ref.getKey(), true);
			} 	
		}
		
		
		if(compVal > 0) {
			if(ref.getRight() != null || ref.getRight() != null) {
				remove_r(ref.getRight(), ref, k, true);
			} else if(ref.getRight() == null && ref.getRight() == null) {
				size--;
				return;
			}
		}  
		if (compVal < 0) {
			if(ref.getLeft() != null || ref.getLeft() != null) {
				remove_r(ref.getLeft(), ref, k, false);
			} else if(ref.getLeft() == null && ref.getLeft() == null) {
				size--;
				return;
			}
		}
	}
	
	@Override
	public boolean hasKey(String k) {
		if(root == null) {
			return false;
		}
		return hasKey_r(root, k);
	}
	
	public boolean hasKey_r(TMCell ref, String k) {
		int compVal= k.compareTo(ref.getKey());
		if(compVal == 0) {
			return true;
		} else if(compVal > 0) {
			if(ref.getRight() == null) return false;
			else return hasKey_r(ref.getRight(), k);
		} else if(compVal < 0) {
			if(ref.getLeft() == null) return false;
			else return hasKey_r(ref.getLeft(), k);
		}
		return false;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String maxKey() {
		return maxkey_r(root);
	}
	
	private String maxkey_r(TMCell mx) {
		if(mx == null) {
			return null;
		}
		if(mx.getRight() != null) {
			return maxkey_r(mx.getRight());
		} else {
			return mx.getKey();

		}
	}
	
	@Override
	public String minKey() {
		return minkey_r(root);
	}
	
	private String minkey_r(TMCell mn) {
		if(mn == null) {
			return null;
		}
		else if(mn.getLeft() == null) {
			return mn.getKey();
		}
		return minkey_r(mn.getLeft());
	}
	
	private TMCell minkey_r1(TMCell mn) {
		if(mn == null) {
			return null;
		}
		else if(mn.getLeft() == null) {
			return mn;
		}
		return minkey_r1(mn.getLeft());
	}
	
	
	@Override
	public String[] getKeys() {
		keys = new String[size];
		i = 0;
		if(root == null) {
			return keys;
		}
		return getKeys_r(root);
	}
	

	
	private String[] getKeys_r(TMCell in) {	
		if(in.getLeft() != null) {
			getKeys_r(in.getLeft());
		}
		keys[i] = in.getKey();
		i++;
		if(in.getRight() != null) {
			getKeys_r(in.getRight());
		}
		return keys;
	}

	  
	  //-------------------------------------------------------------
	  // here down... you fill in the implementations for
	  // the other interface methods
	  //-------------------------------------------------------------
	  //
	  // remember to implement the required recursion as noted
	  // in the interface definition
	  //
	  //-------------------------------------------------------------
	  
	}
