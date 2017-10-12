package com.ex.clone;

/*
 * Must implement Cloneable
 * 		If not, CloneNotSupportedException will be thrown
 * 
 * Must override clone (defined in Object class)
 * 		If not, no one can call clone() outside of CloneClass because it is set to protected access
 */
public class CloneClass implements Cloneable {
	
	private int someInt;

	public int getSomeInt() {
		return someInt;
	}

	public void setSomeInt(int someInt) {
		this.someInt = someInt;
	}

	@Override
	public String toString() {
		return "CloneClass [someInt=" + someInt + "]";
	}
	
	
	/*
	 * Override clone() from Object class
	 * 
	 * NOTE: In Object, the clone method has access set to protected.
	 * NOTE: You may want to change the access to public.
	 * 
	 * NOTE: When overriding, you cannot have a more restricted access modifier
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		/*
		 * Call clone() from Object class
		 * 
		 * NOTE: By default, Object makes a "shallow copy"
		 * NOTE: If you want a "deep copy", you must implement it yourself
		 */
		return super.clone();
	}
}
