package Others;

import java.util.ArrayList;
import java.util.List;

public class GenericTest<E> {
    List<String> val= new ArrayList<>();

    public static void main(String[] args) {
        GenericTest test=new GenericTest();
        test.val.add(1);
    }
}
