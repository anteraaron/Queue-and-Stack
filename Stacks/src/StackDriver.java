
public class StackDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack s = new LinkedStack();
				
		for(int i = 0; i < 50; i++) {
			s.push(new Integer(i));
		}
		
		for(int i = 0; i < 25; i++) {
			System.out.println(s.pop());
		}
		
		for(int i = 0 ; i < 20; i++) {
			s.push(new Integer(100 * i));
		}
		
		for(int i = 0; i < 25; i++) {
			System.out.println(s.pop());
		}
		
		//s.push("Hello World");
		//s.push("H");

	}

}
