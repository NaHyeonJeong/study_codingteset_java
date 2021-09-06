import java.util.Comparator;

/**
 * Comparator.compare(T, E)
 *
 * 두 매개변수 객체를 비교함
 * 자기자신과 비교할 수 없음
 */
public class ComparatorTest {

    public static void main(String[] args)  {

        Student1 a = new Student1(17, 2);	// 17살 2반
        Student1 b = new Student1(18, 1);	// 18살 1반
        Student1 c = new Student1(15, 3);	// 15살 3반

        //a객체와는 상관 없이 b와 c객체를 비교한다.
        //a객체와 비교하고 싶다면 a.compare(a, b);
        int isBig = a.compare(b, c);

        if(isBig > 0) {
            System.out.println("b객체가 c객체보다 큽니다.");
        }
        else if(isBig == 0) {
            System.out.println("두 객체의 크기가 같습니다.");
        }
        else {
            System.out.println("b객체가 c객체보다 작습니다.");
        }

    }
}

class Student1 implements Comparator<Student1> {

    int age;			// 나이
    int classNumber;	// 학급

    Student1(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    @Override
    public int compare(Student1 o1, Student1 o2) {
        return o1.classNumber - o2.classNumber;
    }
}
