public class MyQueue{
	private MyNode top;

	public int peek(){
		return top.data;
	}

	public void offer(int data){
		MyNode node = new MyNode(data);

		if(top==null)
			top=node;
		else{
			MyNode tail = tail();
			tail.next=node;
		}
			
	}

	public int poll() throws Exception{
		if(top==null)
			throw new Exception("empty");

		MyNode node = top;
		top=top.next;
		return node.data;
	}

	private MyNode tail(){
		MyNode tail = top;
		while(tail.next!=null)
			tail=tail.next;
		return tail;
	}

	public static void main(String[] args){
		MyQueue s = new MyQueue();
		s.offer(1);
		s.offer(2);
		try{
			System.out.println(s.peek());
			System.out.println(s.poll());
			System.out.println(s.peek());
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
}