package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 보석과 돌 문제
 *
 * 보석은 대소문자를 다 가짐
 * 돌에는 대소문자가 막 섞여있음
 * 돌에 보석의 대소문자가 몇 개 있는지 체크함
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println("돌에 박힌 보석의 개수는 " + solve(jewels, stones));
    }

    /**
     * 돌을 하나씩 체크해 나가면서 보석의 값이 있으면 카운트 증가
     * @param jew
     * @param stones
     * @return
     */
    public static int solve(String jew, String stones){
        // 1. data structure
        Set<Character> set = new HashSet<>(); //대소문자 하나하나를 담아야 하기 때문에 Character
        // 2. for while
        //보석을 분리해서 따로 저장해둬야 돌에서 비교하기 쉬워짐
        char[] charArr = jew.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            set.add(charArr[i]); // a, A
        }

        //돌에 박힌 보석의 개수를 체크함
        int count = 0;
        char[] stoneArr = stones.toCharArray();
        for(int i = 0; i < stoneArr.length; i++){
            if(set.contains(stoneArr[i])){
                //보석 모음집(set) 안의 값이 돌을 분리한 값들(stoneArr)을 가지고 있다면
                count++;
            }
        }
        return count;
    }
}
