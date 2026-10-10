import java.util.Arrays;

public class L5 {
    public int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;
        
        k = k % n;
        int[] newArray = new int[n];
        
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        
        return newArray;
    }

    public static void main(String[] args) {
        L5 solution = new L5();
        
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Sample 1 Output: " + Arrays.toString(solution.rotateArray(nums1, k1))); 
        
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("Sample 2 Output: " + Arrays.toString(solution.rotateArray(nums2, k2))); 
    }
}