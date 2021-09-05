package sorting_searching;

/**
 * move zero (searching)
 *
 * 0이 아닌 값은 상대적 순서 유지, 모든 0은 끝으로 이동
 * 단, 배열의 복사본을 만들지 않고 작업을 수행해야함
 *
 * 0이 아닌 값들을 먼저 한 쪽으로 몰아야 함(앞이든 뒤든)
 * 그 이후에 빈 공간에 0을 넣어야 함
 */
public class MoveZero {

    public static void main(String[] args) {
        // 1. data structure
        int[] nums = {0, 3, 2, 0, 8, 5};

        // 2-1. 3,2,8,5,0,0
        solve1(nums);

        // 2-2. 0,0,3,2,8,5
        //solve2(nums);

        for(int i : nums){
            System.out.println("i = " + i);
        }
    }

    /**
     * 앞에서 부터 숫자를 채움
     * @param nums
     */
    public static void solve1(int[] nums){
        //array 구하기, 0의 index 값
        int len = nums.length;
        int index = 0; //0이 아닌 값을 만났을때만 증가하면서 0이 아닌 값들을 앞으로 모으는 역할을 함
        //[3,2,8,5]
        for(int i = 0; i < len; i++){
            if(nums[i] != 0){ //0이면 패스함
                nums[index] = nums[i];
                index++;
            }
        }
        //index = 4인게 기억된 상태로 넘어옴
        //[3,2,8,5,0,0]
        while (index < len){ //4,5에 0을 넣어줌
            nums[index] = 0;
            index++;
        }
    }

    /**
     * 끝 방 부터 채워넣음
     * @param nums
     */
    public static void solve2(int[] nums){
        int len = nums.length;
        int index = len - 1; //5

        for(int i = index; i >= 0; i--){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index--;
            }
        }
        //[0,0,3,2,8,5]
        while(index >= 0){
            nums[index] = 0;
            index--;
        }
    }
}
