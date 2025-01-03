package MyList;

public class Main {
    public static void main(String[] args) {
        // Create a list
        MyList list = new MyArrayList<>();

        // Add elements to the list
        list.add("America");
        System.out.println("(1) " + list);

        list.add(0, "Canada");
        System.out.println("(2) " + list);

        list.add("Russia");
        System.out.println("(3) " + list);

        list.add("France");
        System.out.println("(4) " + list);

        list.add(2, "Germany");
        System.out.println("(5) " + list);

        list.add(5, "Norway");
        System.out.println("(6) " + list);

        // Remove elements from the list
        list.remove("Canada");
        System.out.println("(7) " + list);

        list.remove(2);
        System.out.println("(8) " + list);

        list.remove(list.size() - 1);
        System.out.print("(9) " + list + "\n(10) ");

        for (Object s : list)
            System.out.print(s.toString() + " ");
    }
}
