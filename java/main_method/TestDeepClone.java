import java.io.Serializable;

public class TestDeepClone implements Serializable
{
    private int a;
    private String b;
    private int[] c;
    public int getA()
    {
        return a;
    }
    public void setA(int a)
    {
        this.a = a;
    }
    public String getB()
    {
        return b;
    }
    public void setB(String b)
    {
        this.b = b;
    }
    public int[] getC()
    {
        return c;
    }
    public void setC(int[] c)
    {
        this.c = c;
    }

    public static void main(String[] args) throws CloneNotSupportedException
    {
        TestDeepClone t1 = new TestDeepClone();
        DeepClone dc = new DeepClone();
        // 对dc1赋值
        t1.setA(100);
        t1.setB("clone1");
        t1.setC(new int[] { 1000 });
        System.out.println("克隆前: t1.a=" + t1.getA());
        System.out.println("克隆前: t1.b=" + t1.getB());
        System.out.println("克隆前: t1.c[0]=" + t1.getC()[0]);
        System.out.println("-----------");

        TestDeepClone t2 = (TestDeepClone) dc.deepClone(t1);
        // 对c2进行修改
        t2.setA(50);
        t2.setB("clone2");
        int[] a = t2.getC();
        a[0] = 500;
        t2.setC(a);
        System.out.println("克隆前: t1.a=" + t1.getA());
        System.out.println("克隆前: t1.b=" + t1.getB());
        System.out.println("克隆前: t1.c[0]=" + t1.getC()[0]);
        System.out.println("-----------");
        System.out.println("克隆后: t2.a=" + t2.getA());
        System.out.println("克隆后: t2.b=" + t2.getB());
        System.out.println("克隆后: t2.c[0]=" + t2.getC()[0]);
    }
}