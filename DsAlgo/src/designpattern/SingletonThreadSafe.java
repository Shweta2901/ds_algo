package designpattern;

public class SingletonThreadSafe {
	private static volatile SingletonThreadSafe instance;
	private static Object mutex=new Object();
	private SingletonThreadSafe(){
	}
	
	public static SingletonThreadSafe getInstance() {
		SingletonThreadSafe result = instance;
		if(result ==  null) {
			synchronized(mutex) {
				if(result ==  null) {
					result = new SingletonThreadSafe();
				}
			}
		}
		return result;
	}
}
