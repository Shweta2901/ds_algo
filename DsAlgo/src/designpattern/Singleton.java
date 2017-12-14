package designpattern;

public class Singleton {
	private static Singleton instance=new Singleton();
	public int number;
	private Singleton() {
	}
	public static Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}  
	    return instance;
	}
}
