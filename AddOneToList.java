import java.util.Deque;
import java.util.LinkedList;

public class AddOneToList {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int i = size - 1;
        int carry = 1;
        Deque<Integer> dequeue = new LinkedList<Integer>();
        while (i >= 0) {
            int curr = digits[i] + carry;
            dequeue.addFirst(curr % 10);
            carry = curr / 10;
            i--;
        }
        if (carry > 0) {
            dequeue.addFirst(carry);
        }

        int j = 0;
        int[] result = new int[dequeue.size()];
        for (Integer it : dequeue) {
            result[j++] = it;
        }
        return result;
    }
}
