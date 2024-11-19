package ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        // Tạo một danh sách kiểu Integer
        MyList<Integer> myList = new MyList<>();

        // Thêm các phần tử
        myList.add(0, 10); // Thêm 10 vào vị trí 0
        myList.add(1, 20); // Thêm 20 vào vị trí 1
        myList.add(2, 30); // Thêm 30 vào vị trí 2
        System.out.println("Danh sách sau khi thêm: ");
        printList(myList);

        // Thêm vào cuối danh sách
        myList.add(40);
        System.out.println("Danh sách sau khi thêm 40: ");
        printList(myList);

        // Kiểm tra phần tử có tồn tại không
        System.out.println("Danh sách có chứa 20 không? " + myList.contains(20));
        System.out.println("Danh sách có chứa 50 không? " + myList.contains(50));

        // Lấy phần tử tại vị trí 1
        System.out.println("Phần tử tại vị trí 1: " + myList.get(1));

        // Xóa phần tử tại vị trí 0
        System.out.println("Xóa phần tử tại vị trí 0: " + myList.remove(0));
        System.out.println("Danh sách sau khi xóa phần tử tại vị trí 0: ");
        printList(myList);

        // Lấy chỉ số của phần tử
        System.out.println("Chỉ số của phần tử 30: " + myList.indexOf(30));
        System.out.println("Chỉ số của phần tử 50: " + myList.indexOf(50));

        // Clone danh sách
        MyList<Integer> clonedList = myList.clone();
        System.out.println("Danh sách đã clone: ");
        printList(clonedList);

        // Xóa toàn bộ danh sách
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
