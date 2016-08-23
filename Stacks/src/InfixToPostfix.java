import java.util.*;

public class InfixToPostfix{
	
	public static int isp (String token){ // assign isp to the operators (precedence)
		int a = 0;
		if(token.equals("+")||token.equals("-")){
			a=2;	
		}else if(token.equals("*")||token.equals("/")){
			a=4;
		}else if(token.equals("^")){
			a=5;
		}
		
		return a;
	}
	public static int icp (String token){ // assign icp to the operators (precedence)
		int a = 0;
		if(token.equals("+")||token.equals("-")){
			a=1;	
		}else if(token.equals("*")||token.equals("/")){
			a=3;
		}else if(token.equals("^")){
			a=6;
		}
		return a;
	}
	
	public static void evaluateInfixExpression(String infixExpression){ // converting infix to postfix using stacks
		StringTokenizer tokens = new StringTokenizer(infixExpression);
		Stack infixValueStack = new LinkedStack();
		
		while(tokens.hasMoreTokens()){ //reads token from inputted strings
			String token = tokens.nextToken();
			
			if(token.equals("(")){ //left parenthesis would not be popped unless there is a closing parenthesis
				infixValueStack.push(token);
			}else if (token.equals(")")){
				
				try{
					while(infixValueStack.top().equals("(")==false)
					{
						System.out.print(" " + infixValueStack.pop());
					}
					
				}catch(StackEmptyException e){
					infixValueStack.pop(); //needed to remove trailing ) when the stack became empty
				}
					infixValueStack.pop(); // needed to remove trailing ) when the stack is not empty
				
			}else if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")||token.equals("^")){
				
					if(infixValueStack.isEmpty()==true){
					infixValueStack.push(token);
						}else if (icp(token)<isp((String)infixValueStack.top())){ //determines the precedence of the operators
							try{
								while(icp(token)<isp((String)infixValueStack.top())){ // if the precedence of the top of the stack is higher, pop the stack
									System.out.print(" " + infixValueStack.pop());
								}
							}catch(StackEmptyException e){
							
							}
							infixValueStack.push(token);
						
						}else{
						infixValueStack.push(token); //else, push the operator
					}	
				}else{
				System.out.print(" " + token); //outputs the string if it is an operand
			}
			
		}
		try{
			while(true){
				System.out.print (" " + infixValueStack.pop()); //pops the remaining operators on the stack
			}
		}catch(StackEmptyException e){
			
		}
		
	}
	
	
	
	public static void main(String[] args){
		System.out.println("Input the Infix expression: (Operands and operators must be separated by space)");
		Scanner input = new Scanner(System.in);
		String infixExpression = input.nextLine();
		System.out.println("The POSTFIX expression is: ");
		evaluateInfixExpression(infixExpression);
	}
}