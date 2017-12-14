package designpattern;

public class TestDesignPatternClass {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.number=1;
		Singleton s1= Singleton.getInstance();
		s1.number=2;
		System.out.println(s1.number);
	}
}
