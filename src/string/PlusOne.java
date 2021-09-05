package string;

/**
 * 플러스 원 문제
 * 마지막 배열의 값에 1을 더함
 * 이때 carry 발생 가능 (이게 핵심)
 */
public class PlusOne {

    public static void main4(String[] args) {
        //int[] digits = {1,2,3};
        //int[] digits = {9,9,9};
        //int[] digits = {8,9,9};
        //int[] digits = {0,0,1};
        //int[] digits = {0,0};
        int[] digits = {9,9,9,9,9};
        //int[] digits = {9,9,0,9};

        int[] result = solve(digits);
        for(int i : result){
            System.out.println("i = " + i);
        }
    }

    public static int[] solve(int[] digits){
        int len = digits.length;
        for(int i = len-1; i >= 0; i--){
            //2 > 1 > 0
            digits[i]+=1;//마지막 배열 값에 1을 더해야 함
            if(digits[i] < 10){ //각 자리 값에 1을 더한 값이 10보다 작으면 각 자리 값을 그냥 반환해주면 됨
                return digits;
            }
            //마지막 배열 값에 1을 더한 값이 10이 되는 값이 나오면 (9,9,9)
            digits[i] = 0; //더한 값의 자리를 0으로 놓고
        }
        //최종 맨 앞의 숫자까지 carry 값이 발생하게 되는 경우
        //한 자리가 늘어난 배열을 만들어줘야 함
        int[] result = new int[len+1]; //(1,0,0,0)
        result[0] = 1; //맨 앞의 자리가 1이 되어야 함
        return result;
    }
}
