package string;

/**
 * 라이센스 키 포멧 만들기 문제
 *
 * 주어진 문자열에서 '-'를 빼고 모든 문자를 대문자로 만든 후
 * 문자열의 뒤에서부터 주어진 파싱수(4) 만큼 가서 '-'를 넣어야 함
 */
public class LicenseKeyFormat {

    public static void main(String[] args) {
        //String str = "8F3Z-2e-9-w";
        String str = "8fedg-2EF-90dd-asdfkle";
        //String str = " 8-5g-3-J ";
        int k = 4;

        System.out.println(solve(str, k));
    }

    public static String solve(String str, int k){
        // 1. - 삭제
        String newStr = str.replace("-", "");
        System.out.println("newStr = " + newStr);

        // 2. 대문자로 만들기
        newStr = newStr.toUpperCase();
        System.out.println("newStr = " + newStr);

        // 3. 뒤에서 부터 문자열을 k개로 파싱, '-' 넣기 (문자열 넣으려면 StringBuilder)
        StringBuilder sb = new StringBuilder(newStr); //가변 상태로 문자열 가능
        System.out.println("newStr = " + newStr);
        int len = sb.length();

        //끝에서부터 0까지 가면서 4칸 마다 '-'를 넣어야 함
        for(int i = k; i < len; i+=k){ // 4, 8, 12, ...
            System.out.println();
            sb.insert(len - i, '-');
            System.out.println("sb = " + sb);
        }

        return sb.toString();
    }
}
