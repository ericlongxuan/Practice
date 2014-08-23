class MessageHandler {  
	void handleMessage(Message msg, Function getClientCode) {  
			Message msg1 = msg.setClientCode(getClientCode()); 
			System.out.println(msg1); 
	} 

	String getClientCodeOne() {  
	return "ABCD_123"; }  
 
	String getClientCodeTwo() {  
	return "123_ABCD"; }  
 
	public static void main(String[] args) throws Exception{
		MessageHandler handler = new MessageHandler(); 
		handler.handleMessage("qqq", getClientCodeOne);  
	}
}  
 
 
