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
        ListNode l1 = ListNode.getListNode(new int[]{1, 2, 4, 5});
        ListNode l2 = ListNode.getListNode(new int[]{1, 3, 4});
        ListNode listNode = solution.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode();
            mergeTwoLists(l1, l2, listNode);
            return listNode.next;
        }

        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            // 类似归并排序中的合并过程
            ListNode dummyHead = new ListNode(0);
            ListNode cur = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
            // 任一为空，直接连接另一条链表
            if (l1 == null) {
                cur.next = l2;
            } else {
                cur.next = l1;
            }
            return dummyHead.next;
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2, ListNode targetNode) {
            if (null == l1) {
                targetNode.next = l2;
                return targetNode;
            }
            if (null == l2) {
                targetNode.next = l1;
                return targetNode;
            }
            if (l1.val < l2.val) {
                targetNode.next = l1;
                return mergeTwoLists(l1.next, l2, targetNode.next);
            } else {
                targetNode.next = l2;
                return mergeTwoLists(l1, l2.next, targetNode.next);
            }
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