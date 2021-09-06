package array;

import java.util.*;

/**
 * 그룹 아나그램
 *
 * Map을 만들고 Map의 값을 빼고
 */
public class GroupAnagrams {

    public static void main(String[] args) {

        String[] list = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("re " + solve(list));
//		System.out.println(groupAnagrams_ascii(list));
    }

    /**
     * sort, Map
     * @param strs
     * @return
     */
    public static List<List<String>> solve(String[] strs){
        //1. data structure
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0)
            return result;
        Map<String, List<String>> map = new HashMap<>();

        //2. for
        for(String str : strs){
            char[] charArr = str.toCharArray(); //eat, tea, ate, ...
            Arrays.sort(charArr); //['a','e','t'] character로 받은 문자들을 다 쪼개서 정렬

            String key = String.valueOf(charArr); //char array -> string
            System.out.println("key = " + key);

            /*if(map.containsKey(key)){ //있으면 가져와서 더함
                map.get(key).add(str);
            }else{ //없으면 초기값 설정
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }*/
            List<String> list = map.getOrDefault(key, new ArrayList<>());//있으면 key로 가져오고 없으면 new ArrayList<>()로 새로 가져옴
            list.add(str);
            map.put(key, list);
        }
        /*result.addAll(map.values());
        return result;*/
        return new ArrayList<>(map.values());
    }

    /**
     * sort X
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams_ascii(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (int k = 0; k < str.length(); k++){
                count[str.charAt(k) - 'a']++;
            }

            String key = Arrays.toString(count);
            System.out.println("hash " + key);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
