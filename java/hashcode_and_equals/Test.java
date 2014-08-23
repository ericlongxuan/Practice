public class Test{
    private short ashort;
    private char achar;
    private byte abyte;
    private boolean abool;
    private long along;
    private float afloat;
    private double adouble;
    private Test aObject;
    private int[] ints;
    private Test[] units;
 
    public Test()
    public boolean equals(Object o) {
      if (!(o instanceof Test))
          return false;
      Test unit = (Test) o;
      return unit.ashort == ashort
        && unit.achar == achar
        && unit.abyte == abyte
        && unit.abool == abool
        && unit.along == along
        && Float.floatToIntBits(unit.afloat) == Float
              .floatToIntBits(afloat)
        && Double.doubleToLongBits(unit.adouble) == Double
              .doubleToLongBits(adouble)
        && unit.aObject.equals(aObject)
        && equalsInts(unit.ints)
        && equalsUnits(unit.units);
    }

    private boolean equalsInts(int[] ints){
      return Arrays.equals(this.ints, ints);
    }

    private boolean equalsUnits(int[] units){
      return Arrays.equals(this.units, units);
    }

    public static void main(String[] args){
      Test t1 = new Test(1,"1",1,1,1,1,1,new Test(),new int[5],new Test[5]);
      Test t2 = new Test(1,"1",1,1,1,1,1,new Test(),new int[5],new Test[5]);
      System.out.print(t1.equals(t2));
    }
 }