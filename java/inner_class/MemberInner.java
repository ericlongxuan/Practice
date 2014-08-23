public class MemberInner {
    private int x = 100;
 
    public void makeInner(){
        MemberInnerInner in = new MemberInnerInner();
        in.seeOuter();
    }
 
    class MemberInnerInner{
        public void seeOuter(){
            System.out.println("Outer x is " + x);
            System.out.println("Inner class reference is " + this);
            System.out.println("Outer class reference is " + MemberInner.this);
        }
    }
 
    public static void main(String [] args){
    	MemberInner o = new MemberInner();
        MemberInnerInner i = o.new MemberInnerInner();
        i.seeOuter();
    }
}