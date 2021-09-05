package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 고유한 이메일 문제
 *
 * 로컬네임 @ 도메인네임
 * 로컬네임에는 .은 없애야 하고 + 뒤의 내용은 필요가 없음
 * 도메인네임에는 .이 몇 개 있던 상관 없음
 */
public class UniqueEmailAddress {

    public static void main1(String[] args){
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"
        };

        System.out.println("use charAt() + subString() = " + a.solve1(emails));
        System.out.println("use split() + replace() = " + a.solve2(emails));
    }

    /**
     * split()을 활용한 문제 풀이
     * '@'를 기준으로 분리할거임
     * @param emails
     * @return
     */
    public int solve2(String[] emails){
        // 1. data structure
        Set<String> set = new HashSet<>();
        // 2. for while
        for(String email : emails){
            //2-1 @로 분리
            String[] parts = email.split("@"); //@ 이전은 0번방 이후는 1번방에 나눠서 들어감
            //2-2 +로 분리
            String[] localName = parts[0].split("[+]");//+ 를 split 할 때는 [+] 해주거나 \\+ 해주거나
            //2-3 .은 ""로 바꿔주기
            set.add(localName[0].replace(".", "") + "@" + parts[1]);
        }
        return set.size();
    }

    /**
     * charAt()과 subString()을 활용한 문제 풀이
     * @param emails
     * @return
     */
    public int solve1(String[] emails){
        // 1. data structure
        Set<String> set = new HashSet<>(); //중복 불가, 수정된 email 모음
        // 2. for while charAt()
        for(String email : emails){
            String localName = makeLocalName(email);
            String dName = makeDName(email);

            set.add(localName + "@" + dName);
        }
        return set.size();
    }

    public String makeLocalName(String email){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < email.length(); i++){ //반복 하면서 딱 필요한 부분만 남김(+이후는 버림)
            if(email.charAt(i) == '.'){
                continue;
            }
            if(email.charAt(i) == '+' || email.charAt(i) == '@'){
                //+, @가 있는 경우에는 아예 탈출(더 필요 없음)
                //+가 없고 바로 @가 들어가있는 경우가 있을 수 있음
                break;
            }
            sb.append(email.charAt(i));
        }
        return sb.toString();
    }

    public String makeDName(String email){
        return email.substring(email.indexOf("@")+1); //@이후
    }

}

