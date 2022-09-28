public class AutoboxingAndUnboxing {
    public static void main(String[] args) {
        int i = 5;

        Integer iObj = i;
        System.out.println("iObj: " + iObj);

        iObj = new Integer(50);
        /*
        The above line can be replaced with:
        iObj = 50;

        Note: this will give a NullPointerException if Iobj is 'null'
         */

        i = iObj;

        System.out.println("i: " + i);
    }
}
