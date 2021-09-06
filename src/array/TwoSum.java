package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 배열안의 값들 중 두 값을 더하여 target과 같아지는 값들의 인덱스 + 1
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum a = new TwoSum();
        int[] nums = { 2, 8, 11, 14 };
        int target = 16;
		//int[] result = a.solve1(nums, target);
        int[] result = a.solve2(nums, target);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * 이중 for문 >>> O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] solve1(int[] nums, int target){
        int len = nums.length;

        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if(target == nums[i] + nums[j]){
                        return new int[] {i+1, j+1};
                }
            }
        }
        return new int[] {0,0};
    }

    /**
     * for문 >>> O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] solve2(int[] nums, int target){

        //1. data structure
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(); //key = 배열안의 값 | val = 방번호

        //2. for + Map<>
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int val = map.get(nums[i]);
                result[0] = val + 1;
                result[1] = i + 1;
            } else{
                map.put(target - nums[i], i);
            }
        }

        return result;
    }
}
