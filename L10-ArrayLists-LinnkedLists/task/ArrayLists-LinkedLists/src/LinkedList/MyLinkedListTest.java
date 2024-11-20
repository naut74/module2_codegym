package LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        System.out.println("Danh sách sau khi thêm phần tử vào đầu:");
        printList(linkedList);

        linkedList.addLast(40);
        linkedList.addLast(50);
        System.out.println("Danh sách sau khi thêm phần tử vào cuối:");
        printList(linkedList);

        linkedList.add(2, 25);
        System.out.println("Danh sách sau khi thêm 25 vào vị trí 2:");
        printList(linkedList);

        System.out.println("Xóa phần tử tại vị trí 3: " + linkedList.remove(3));
        System.out.println("Danh sách sau khi xóa:");
        printList(linkedList);

        System.out.println("Xóa phần tử có giá trị 40: " + linkedList.remove((Integer) 40));
        System.out.println("Danh sách sau khi xóa phần tử có giá trị 40:");
        printList(linkedList);

        System.out.println("Chỉ số của phần tử 50: " + linkedList.indexOf(50));
        System.out.println("Chỉ số của phần tử 100 (không tồn tại): " + linkedList.indexOf(100));

        System.out.println("Phần tử tại vị trí 2: " + linkedList.get(2));

        System.out.println("Phần tử đầu tiên: " + linkedList.getFirst());
        System.out.println("Phần tử cuối cùng: " + linkedList.getLast());

        linkedList.clear();
        System.out.println("Danh sách sau khi xóa toàn bộ:");
        printList(linkedList);

    }

    static void printList(MyLinkedList<?> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
    }
}
