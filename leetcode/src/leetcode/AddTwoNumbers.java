package leetcode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(-1);
		ListNode prev = dummyHead;
		int carry = 0;
		while(l1 != null || l2 != null){
			int val1 = l1 != null ? l1.val : 0;
			int val2 = l2 != null ? l2.val : 0;
			int sum = val1 + val2 + carry;
			carry = sum / 10;
			ListNode elem = new ListNode(sum % 10);
			prev.next = elem;
			prev = elem;
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
			
		}
		if (carry > 0){
			ListNode elem = new ListNode(carry);
			prev.next = elem;
		}
		return dummyHead.next;

	}
}
