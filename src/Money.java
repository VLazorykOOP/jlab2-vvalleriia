public class Money {
    
    private long hrn;
    private byte coin;
    public Money (long h,byte c){
        hrn = h;
        coin = c;
    }
    @Override
    public String toString() {
        return "Money [" + hrn + "," + coin + "]";
    }
    public Money sub (Money obj){
        long h;
        byte c; 
        h = hrn - obj.hrn;
        c = (byte)(coin - obj.coin );
        if (c < 0){
            h --;
            c =(byte) (100 + c);
        }
        Money obj1 = new Money(h, c);
        return obj1;
    }
    public Money add ( Money obj2 ) {
        long h;
        byte c;
        h = hrn + obj2.hrn;
        c = (byte)(coin + obj2.coin);
        if (c >= 100){
            h ++;
            c -= 100;
        }
        Money obj3 = new Money(h, c);
        return obj3;


    }
    public static void main(String[] args) {
        long x = 13, d = 9;
        byte z = 5, v = 4;

        Money obj = new Money(x, z);
        Money obj1 = new Money(d, v);
        Money obj2 = obj.sub(obj1);

        System.out.println(obj2.toString());
    }



}
