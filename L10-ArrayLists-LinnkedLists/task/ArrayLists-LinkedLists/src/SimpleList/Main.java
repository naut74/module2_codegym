package SimpleList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> listInterger = new MyList<Integer>();

        listInterger.add(1);
        listInterger.add(2);
        listInterger.add(3);
        listInterger.add(4);
        listInterger.add(5);

        System.out.println("element 4: " + listInterger.get(4));
        System.out.println("element 1: " + listInterger.get(1));
        System.out.println("element 2: " + listInterger.get(2));
    }
}
