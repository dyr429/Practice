package DataStructure;

public class ArrayTest {

    public static void main(String args[])
    {
        int intArray[][] = {{1,2,3},{4,5}};

        int cloneArray[][] = intArray.clone();


        int[] src = {1,2,3,4,5};
        int[] dest = new int[5];
        System.arraycopy(src,0,dest,0,src.length);

        // will print false
        System.out.println(intArray == cloneArray);

        // will print true as shallow copy is created
        // i.e. sub-arrays are shared
        System.out.println(intArray[0] == cloneArray[0]);
        System.out.println(intArray[1] == cloneArray[1]);

        intArray[0][0] = 0;
        System.out.println(intArray[0][0] == cloneArray[0][0]);

        String s = "abcde";
        System.out.println(s.substring(2,5));

    }
}
