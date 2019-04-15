package week0;

public class CounterDemo {

	public static void main(String[] args) {

		Counter c = new Counter();
		c.increment();
		c.increment(3);
		System.out.println(c.getCount());

	}

}
