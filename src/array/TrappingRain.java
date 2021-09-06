package array;

/**
 * 빗물 담기 문제
 *
 * 왼쪽과 오른쪽의 높이 비교
 * 총 담기는 빗물의 양 출력
 */
public class TrappingRain {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; //height
        System.out.println(trap(nums));
    }

    public static int trap(int[] height){
        int result = 0;
        if(height == null || height.length <= 2){
            return result;
        }

        int len = height.length; //12
        int[] left = new int[len];
        int[] right = new int[len];

        //1. left max
        int max = height[0];
        left[0] = height[0];

        for(int i = 1; i < len; i++){
            if(height[i] < max){
                left[i] = max;
            } else{
                left[i] = height[i];
                max = height[i];
            }
        }

        //2. right max
        max = height[len-1];
        right[len-1] = height[len-1];

        for(int i = len-2; i > 0; i--){
            if(height[i] < max){
                right[i] = max;
            } else{
                right[i] = height[i];
                max = height[i];
            }
        }

        //3. min() - height
        for(int i = 0; i < len; i++){
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}
