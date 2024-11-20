package ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        myList.add(0, 10); // Thêm 10 vào vị trí 0
        myList.add(1, 20); // Thêm 20 vào vị trí 1
        myList.add(2, 30); // Thêm 30 vào vị trí 2
        System.out.println("Danh sách sau khi thêm: ");
        printList(myList);

        myList.add(40);
        System.out.println("Danh sách sau khi thêm 40: ");
        printList(myList);

        System.out.println("Danh sách có chứa 20 không? " + myList.contains(20));
        System.out.println("Danh sách có chứa 50 không? " + myList.contains(50));

        System.out.println("Phần tử tại vị trí 1: " + myList.get(1));

        System.out.println("Xóa phần tử tại vị trí 0: " + myList.remove(0));
        System.out.println("Danh sách sau khi xóa phần tử tại vị trí 0: ");
        printList(myList);

        System.out.println("Chỉ số của phần tử 30: " + myList.indexOf(30));
        System.out.println("Chỉ số của phần tử 50: " + myList.indexOf(50));

        MyList<Integer> clonedList = myList.clone();
        System.out.println("Danh sách đã clone: ");
        printList(clonedList);

        myList.clear();
        System.out.println("Danh sách sau khi xóa toàn bộ: ");
        printList(myList);
    }

    private static void printList(MyList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
