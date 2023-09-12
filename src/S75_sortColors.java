public class S75_sortColors {
    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     * 示例 1：
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * https://leetcode.cn/problems/sort-colors/
     */
    public static void main(String[] args) {
        Solution solution = new Solution4();
        solution.print(new int[]{2, 0, 2, 1, 1, 0});
        solution.print(new int[]{2, 0, 1});
    }

    //快速排序
    static class Solution4 extends Solution {

        @Override
        protected void sortColors(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }

        private int partition(int[] nums, int left, int right) {
            int temp = nums[left];
            int l = left;
            while (left < right) {
                while (left < right && nums[right] >= temp) {
                    right--;
                }
                while (left < right && nums[left] <= temp) {
                    left++;
                }
                swap(nums, left, right);
            }
            swap(nums, left, l);
            return left;
        }
    }

    //归并排序
    static class Solution3 extends Solution {

        @Override
        protected void sortColors(int[] nums) {
            sort(nums, 0, nums.length - 1);
        }

        private void sort(int[] nums, int left, int right) {
            // 判断是否只剩下最后一个元素
            if (left >= right) {
                return;
            }
            // 从中间将数组分成两个部分
            int mid = left + ((right - left) >> 1);

            // 分别递归地将左右两半排好序
            sort(nums, left, mid);
            sort(nums, mid + 1, right);

            // 将排好序的左右两半合并
            merger(nums, left, mid, right);
        }

        private void merger(int[] nums, int left, int mid, int right) {
            // 复制一份原来的数组
            int[] clone = nums.clone();
            // 定义一个 k 指针表示从什么位置开始修改原来的数组，i 指针表示左半边的起始位置，j 表示右半边的起始位置
            int i = left, k = left, j = mid + 1;
            while (k <= right) {
                if (i > mid) {
                    nums[k++] = clone[j++];
                } else if (j > right) {
                    nums[k++] = clone[i++];
                } else if (clone[i] > clone[j]) {
                    nums[k++] = clone[j++];
                } else {
                    nums[k++] = clone[i++];
                }
            }
        }
    }

    //插入排序
    static class Solution2 extends Solution {
        @Override
        protected void sortColors(int[] nums) {
            int length = nums.length;
            for (int i = 1; i < length; i++) {
                int current = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] > current) {
                    swap(nums, j, j + 1);
                    j--;
                }
                nums[j + 1] = current;
            }
        }
    }

    //冒泡排序
    static class Solution1 extends Solution {
        @Override
        protected void sortColors(int[] nums) {
            int length = nums.length;
            boolean hasChange = true;
            for (int i = 0; i < length - 1 && hasChange; i++) {
                hasChange = false;
                for (int j = 0; j < length - 1 - i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        swap(nums, j, j + 1);
                        hasChange = true;
                    }
                }
            }
        }
    }

    static abstract class Solution {
        void print(int[] nums) {
            sortColors(nums);
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        protected abstract void sortColors(int[] nums);

        void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
