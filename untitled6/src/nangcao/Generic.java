package nangcao;

public class Generic {
    public static <E> void Print(E[] inputArray){
        for (E element : inputArray){
            System.out.printf("%s ",element);
        }
        System.out.println();
    }
    public static <T extends Comparable<T>> T maximum(T x,T y,T z){
        T max = x;
        if(y.compareTo(max)>0){
            max=y;
        }
        if(z.compareTo(max)>0){
            max=z;
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] integer = {1,2,3,4,5};
        Double[] doubles = {1.0,2.0,3.0,4.0,5.0};
        Character[] characters = {'N','G','H','I','A'};

        System.out.println("Integer: ");
        Print(integer);
        System.out.println("doubles: ");
        Print(doubles);
        System.out.println("characters: ");
        Print(characters);

        System.out.printf("Max của %d, %d, %d là %d",4,7,8,maximum(4,7,8));
        System.out.println();
        System.out.printf("Max của %f, %f, %f là %f",4.0,7.0,8.0,maximum(4.0,7.0,8.0));
        System.out.println();
        System.out.printf("Max của %s, %s, %s là %s","ios","android","window",maximum("ios","android","window"));
        System.out.println();
    }
}
class Box<T>{
    private T t;
    public void add(T t){
        this.t=t;
    }
    public T get(){
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.add(new Integer(20));
        stringBox.add(new String("hello world"));

        System.out.println("int: "+integerBox.get());
        System.out.println("string: "+stringBox.get());

    }
}

