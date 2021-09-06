import java.util.Comparator;

public class AnonymousTest {

    public static void main(String[] args) {
        // 익명 객체 구현방법 1
        // 람다 표현식
        Comparator<Student2> comp1 = (o1, o2) -> o1.classNumber - o2.classNumber;
    }

    // 익명 객체 구현 2
    public static Comparator<Student2> comp2 = new Comparator<Student2>() {
        @Override
        public int compare(Student2 o1, Student2 o2) {
            return o1.classNumber - o2.classNumber;
        }
    };
}

// 외부에서 익명 객체로 Comparator가 생성되기 때문에 클래스에서 Comparator을 구현 할 필요가 없어진다.
class Student2 {

    int age;			// 나이
    int classNumber;	// 학급

    Student2(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

}

