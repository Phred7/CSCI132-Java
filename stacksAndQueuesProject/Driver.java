package stacksAndQueuesProject;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		ArrayStack<String> stringsArray = new ArrayStack<>();
		ArrayStack<Double> doublesArray = new ArrayStack<>();
		DLLStack<String> strings = new DLLStack<>();
		DLLStack<Double> doubles = new DLLStack<>();
		DLLQueue<Integer> integers = new DLLQueue<>();

		// string ArrayStack
		System.out.println("ArrayStack - String");
		stringsArray.push("StringNumeroUno");
		stringsArray.push("StringNumberoDos?");
		System.out.println(stringsArray.toString());
		stringsArray.pop();
		System.out.println(stringsArray.toString() + "\n");

		// double ArrayStack
		System.out.println("Array Stack - Double");
		doublesArray.push(10.0);
		doublesArray.push(2987.3456);
		System.out.println(doublesArray.toString());
		doublesArray.pop();
		System.out.println(doublesArray.toString() + "\n");

		// string DLLStack
		System.out.println("DLL Stack - String");
		strings.push("StringNumeroUno");
		strings.push("StringNumberoDos?");
		System.out.println(strings.toString());
		strings.pop();
		System.out.println(strings.toString() + "\n");

		// double DLLStack
		System.out.println("DLL Stack - Double");
		doubles.push(10.0);
		doubles.push(2987.3456);
		System.out.println(doubles.toString());
		doubles.pop();
		System.out.println(doubles.toString() + "\n");

		// integer DLLQueue
		System.out.println("DLL Queue - Integer");
		integers.enqueue(1);
		integers.enqueue(2);
		System.out.println(integers.toString());
		integers.dequeue();
		System.out.println(integers.toString() + "\n");
		
		/*creation of the CallStackValidator
		 * All mehtods are called in the constructor to check validity. See 
		 */
		System.out.println("Call Stack Validator");
		CallStackValidator validator = new CallStackValidator();

	}

}
