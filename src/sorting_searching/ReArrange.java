package sorting_searching;

import java.util.Arrays;

/**
 * 로그 파일의 데이터 재정렬
 *
 * 첫번째 단어 = 식별자
 * 식별자 뒤의 단어들은 문자가 먼저 우선권을 갖음
 * 만약 식별자 뒤의 단어들이 다 같으면 식별자로 우선권을 줘야함
 *
 * compareTo()를 잘 알자
 */
public class ReArrange {

    public static void main(String[] args) {
        ReArrange ra = new ReArrange();
        String[] input = {
                "dig1 8 2 3 1",
                "let8 abc cat",
                "dig1 2 5",
                "let2 good dog book",
                "let3 abc cat"
        };
        String[] result = ra.solve(input);

        for(String s : result){
            System.out.println("s = " + s);
        }
    }

    public String[] solve(String[] logs){
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2); //[0]:letter-logs | [1]:digit-logs
            String[] split2 = s2.split(" ", 2); //[0]:letter-logs | [1]:digit-logs

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0)); //digit-logs의 첫 글짜가 digit인가
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                //모두 문자인 경우
                int comp = split1[1].compareTo(split2[1]); //오름차순
                if(comp == 0)
                    return split1[0].compareTo(split2[0]);
                else
                    return comp;
            } else if(isDigit1 && isDigit2){
                //모두 숫자인 경우
                return 0;
            } else if(isDigit1 && !isDigit2){
                //첫번째는 숫자, 두번째는 문자인 경우
                return 1;
            } else{
                //첫번째는 문자, 두번째는 숫자인 경우
                return -1;
           }
        });
        return logs;
    }
}
