public class S2_AddTwoNumbers {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = getListNode(new int[]{2, 4, 3});
        ListNode l2 = getListNode(new int[]{5, 6, 4});

        ListNode temp = solution.addTwoNumbers2(l1, l2);
        while (temp.next != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode getListNode(int[] arr) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        for (int i = 0; i < arr.length; i++) {
            temp.val = arr[i];
            temp.next = new ListNode();
            temp = temp.next;
        }
        return listNode;
    }

    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode();
            ListNode lastNode = listNode;
            int base = 0;
            while (hasNext(l1, l2, base)) {
                int l1Varl = l1 != null ? l1.val : 0;
                int l2Varl = l2 != null ? l2.val : 0;
                int tempSum = l1Varl + l2Varl + base;
                lastNode.val = tempSum % 10;
                base = tempSum / 10;

                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;

                if (hasNext(l1, l2, base)) {
                    lastNode.next = new ListNode();
                    lastNode = lastNode.next;
                }
            }
            return listNode;
        }

        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode();
            ListNode lastNode = listNode;
            int base = 0;
            while (hasNext(l1, l2, base)) {
                if (null != l1) {
                    base += l1.val;
                    l1 = l1.next;
                }
                if (null != l2) {
                    base += l2.val;
                    l2 = l2.next;
                }

                lastNode.next = new ListNode(base % 10);
                lastNode = lastNode.next;
                base /= 10;
            }
            return listNode.next;
        }

        private boolean hasNext(ListNode l1, ListNode l2, int base) {
            return null != l1 || null != l2 || 0 != base;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
