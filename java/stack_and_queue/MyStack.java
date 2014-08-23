public class MyStack{
	private MyNode top;

	public int peek(){
		return top.data;
	}

	public void push(int data){
		MyNode node = new MyNode(data);

		if(top==null)
			top=node;
		else{
			node.next=top;
			top=node;
		}
			
	}

	public int pop() throws Exception{
		if(top==null)
			throw new Exception("empty");

		MyNode node = top;
		top=top.next;
		return node.data;
	}

	public static void main(String[] args){
		MyStack s = new MyStack();
		s.push(1);
		s.push(2);
		try{
			System.out.println(s.peek());
			System.out.println(s.pop());
			System.out.println(s.peek());
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
}