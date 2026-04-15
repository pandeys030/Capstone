// Priority Queue (Min heap)
// Arraylist
// Min heap (parent element is <= all other elements)

class ListNode402{
    int val;
    ListNode402 next;

    ListNode402(int val){
        this.val = val;
        this.next = null;
    }
}

public class SIT_402 {
    public static void main(String[] args) {
        ListNode402 head = new ListNode402(1);
        head.next = new ListNode402(2);
        head.next.next = new ListNode402(3);

        // Print the linked list
        ListNode402 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}