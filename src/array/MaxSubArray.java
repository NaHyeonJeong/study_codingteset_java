package array;

public class MaxSubArray {

    public static void main(String[] args) {
//		int[] nums = {  -30, -20,-10 };
//		int[] nums = { 10, 10, -3, 10, 10 };
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solve(nums));
    }

    public static int solve(int[] nums){
        //1.
        int curMax = nums[0]; //현재 max
        int allMax = nums[0]; //최종 max(return)

        //2.
        for(int i = 1; i < nums.length; i++){
            System.out.println("nums["+i+"] "+nums[i]+" nums["+i+"] "+"+ curMax: "+(nums[i]+curMax));

            curMax = Math.max(nums[i], nums[i] + curMax);
            allMax = Math.max(allMax, curMax); //최종 반환될 값

            System.out.println("curMax: "+curMax+" allMax: "+allMax);
            System.out.println("  ");
        }
        return allMax;
    }
}
