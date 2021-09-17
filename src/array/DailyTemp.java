package array;

import java.util.Stack;

/**
 * 일일 온도
 *
 * 기준 온도 보다 큰 온도를 만나게 되는 날짜는 몇일 후 인가?
 * 큰 온도 인덱스 - 기준 온도 인덱스
 * 한 값을 배열(기존 온도 있는 배열과 크기 같아야 함)에 다 저장해서 반환
 */
public class DailyTemp {

    public static void main(String[] args) {
        int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
        //int[] res = solve_1(nums);
		int[] res = solve_stack(nums);

        System.out.println("====result===");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    /**
     * 이중 for
     * @param tem
     * @return
     */
    public static int[] solve_1(int[] tem){
        //1. data structure
        int length = tem.length;
        int[] result = new int[length]; //8개
        int count = 0, j;

        //2. for-for
        for(int i = 0; i < length; i++){ //73 부터
            for(j = i + 1; j < length; j++){ //74 부터
                if(tem[i] < tem[j]){ //기준값 보다 큰 값을 찾았기 때문에 중단
                    count++;
                    break;
                } else{ //기준값보다 큰 값을 못찾으면 계속 카운트 증가
                    count++;
                }
            }
            if(j == tem.length){ //기준 보다 큰 값을 찾지 못하면 0을 넣어줌
                result[i] = 0;
            } else {
                result[i] = count;
            }
            count = 0; //기준값 가지고 카운트하기 때문에 기준값이 바뀌면 카운트도 초기화해서 다시 시작해야함
        }

        return result;
    }

    /**
     * stack 활용
     * @param tem
     * @return
     */
    public static int[] solve_stack(int[] tem){
        //1. data structure
        int length = tem.length;
        int[] result = new int[length]; //8개
        Stack<Integer> stack = new Stack<>();

        //2. for-for
        for(int i = 0; i < length; i++){
            while(!stack.isEmpty() && tem[stack.peek()] < tem[i]){ //73vs74
                int index = stack.pop();
                result[index] = i - index; //1-0
            }
            stack.push(i); //0-73
        }

        return result;
    }
}
