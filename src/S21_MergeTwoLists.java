import utils.ListNode;

public class S21_MergeTwoLists {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * <p>
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.getListNode(new int[]{1, 2, 4});
        ListNode l2 = ListNode.getListNode(new int[]{1, 3, 4});
        ListNode listNode = solution.mergeTwoLists(null, null);
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            boolean isNull = isNull(l1, l2);
            ListNode listNode = isNull ? null : new ListNode();
            mergeTwoLists(l1, l2, listNode, isNull);
            return listNode;
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2, ListNode targetNode, boolean noNextNode) {
            if (noNextNode) {
                return targetNode;
            }
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 < val2) {
                targetNode.val = val1;
                noNextNode = isNull(l1.next, l2);
                return mergeTwoLists(l1.next, l2, noNextNode ? targetNode : (targetNode.next = new ListNode()), noNextNode);
            } else {
                targetNode.val = val2;
                ListNode temp = l2 == null ? null : l2.next;
                noNextNode = isNull(l1, temp);
                return mergeTwoLists(l1, temp, noNextNode ? targetNode : (targetNode.next = new ListNode()), noNextNode);
            }
        }

        private boolean isNull(ListNode l1, ListNode l2) {
            return null == l1 && null == l2;
        }
    }
}