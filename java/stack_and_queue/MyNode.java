public class MyNode{
	int data;
	MyNode next;

	public MyNode(int data){
		this.data = data;
	}

	public void addAfter(int data){
		MyNode node = new MyNode(data);
		node.next=this.next;
		this.next=node;
	}
}