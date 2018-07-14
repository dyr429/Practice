import java.util.LinkedList;
import java.util.List;

class RestoreIP93 {
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new LinkedList<String>();
        addDot(0,result,s,0);

        return result;


    }

    private void addDot(int position, List<String> result, String currentStr,int dotCount){
        for(int i=position+1;i<position+4;i++){
            if(i<currentStr.length()){
                String sec1 = currentStr.substring(position,i);
                if(check(sec1)){
                    String promise = currentStr.substring(0,i) + "." + currentStr.substring(i,currentStr.length());
                    if(dotCount ==2){
                        String last =  promise.substring(i+1,promise.length());
                        if(last.length()<4&&check(last))
                            result.add(promise);
                    }else{
                        addDot(i+1,result,promise,dotCount+1);
                    }
                }else{
                    continue;
                }
            }

        }

    }


    //length 1 - 3
    private boolean check(String sec){
        if(sec.charAt(0) != '0'){
            int value = Integer.valueOf(sec);
            if(0<=value && value<=255){
                return true;
            }else{
                return false;
            }
        }else if(sec.length() == 1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String [ ] args)
    {
        RestoreIP93 obj = new RestoreIP93();
        obj.restoreIpAddresses("0279245587303");
    }
}