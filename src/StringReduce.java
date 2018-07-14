public class StringReduce {

    public static void reduce(String str){


        StringBuilder strRec = new StringBuilder();

        int count = 1;
        int i = 0;
        char cur = str.charAt(i++);

        while (i < str.length()) {
            if (str.charAt(i) == cur) {
                count++;
            } else {
                strRec.append(String.valueOf(count) + String.valueOf(cur));
                count = 1;
                cur = str.charAt(i);
            }
            i++;
        }

        strRec.append(String.valueOf(count) + String.valueOf(cur));


        System.out.print(strRec.toString());

    }


    public static void main(String[] args) {
        String test = "aaaggghhhca";
        reduce(test);
    }


}
