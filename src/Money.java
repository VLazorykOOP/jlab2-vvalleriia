public class Money {

    private long hrn;
    private byte coin;

    public Money(long h, byte c) {
        hrn = h;
        coin = c;
    }

    @Override
    public String toString() {
        return "Money [" + hrn + "," + coin + "]";
    }

    public Money sub(Money obj) {
        long h;
        byte c;
        h = hrn - obj.hrn;
        c = (byte) (coin - obj.coin);
        if (c < 0) {
            h--;
            c = (byte) (100 + c);
        }
        Money obj1 = new Money(h, c);
        return obj1;
    }

    public Money add(Money obj2) {
        long h;
        byte c;
        h = hrn + obj2.hrn;
        c = (byte) (coin + obj2.coin);
        if (c >= 100) {
            h++;
            c -= 100;
        }
        Money obj3 = new Money(h, c);
        return obj3;

    }

    public double toCoin() {
        return (double) (hrn * 100.0 + coin);

    }

    public double div(Money obj) {
        return (double) (this.toCoin() / obj.toCoin());

    }

    public double divn (int g) {
        return (double)(this.toCoin() / g);
    }
    public void comp (Money obj ) {
        if (this.toCoin()>obj.toCoin()){
            System.out.println(this.toString()+" > "+obj.toString());
        }
         else if (this.toCoin()<obj.toCoin()){
            System.out.println(this.toString()+" < "+obj.toString());
        }
    } 

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Money other = (Money) obj;
        if (hrn != other.hrn)
            return false;
        if (coin != other.coin)
            return false;
        return true;
    }

    public static void main(String[] args) {
        long x = 13, d = 3;
        byte z = 5, v = 50;

        Money obj = new Money(x, z);
        Money obj1 = new Money(d, v);
        Money obj2 = obj;
        
        System.out.println(obj.toString() + " " + obj1.toString());
        
        System.out.println("Додавання грошей:");
        System.out.println(obj.add(obj1));
        
        System.out.println("Віднімання грошей:");
        System.out.println(obj.sub(obj1));
        
        System.out.println("Ділення грошей:");
        System.out.println(obj.div(obj1));
        
        System.out.println("Ділення на число:");
        System.out.println(obj.divn(13));
        
        obj.comp(obj1);
        obj1.comp(obj);
        
        System.out.println(obj.equals(obj2));

    }

}