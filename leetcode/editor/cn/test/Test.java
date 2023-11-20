package leetcode.editor.cn.test;

/**
 * 测试
 *
 * @author why
 * @time 2023/11/20
 */
public class Test {
    int a;
    int b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Test1 {
    public static void main(String[] args) {
        Test test = new Test(1, 2);
        Test test1 = new Test(1, 2);
        System.out.println(test1.equals(test));
    }
}
