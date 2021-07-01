public class SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {

        return arrayToBSTHelper(nums, 0, nums.length-1);

    }

    public TreeNode arrayToBSTHelper(int[] nums, int low, int high) {

        // base cases
        if (nums == null || low > high) return null;
        if (low == high) return new TreeNode(nums[low]);     // or high

        int mid = low + (high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.setLeft(arrayToBSTHelper(nums, low, mid-1));
        root.setRight(arrayToBSTHelper(nums, mid+1, high));

        return root;

    }

}
