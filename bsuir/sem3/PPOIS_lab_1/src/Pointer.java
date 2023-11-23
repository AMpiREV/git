public class Pointer {
    int num1;
    int position;
    public Pointer(int num1){
       this.num1 = num1;
    }
    public String[] create_srcArr() {
        String[] srcArr = new String[num1];
        srcArr[0] = "._.";
        System.out.print(srcArr[0]);
        for (int i=1; i < srcArr.length; i++) {
            srcArr[i] = "...";
            System.out.print(srcArr[i]);
        }
        return srcArr;
    }
    public String[] create_destArr(String[] srcArr) {
        String[] destArr = new String[srcArr.length+1];
        return destArr;
    }

    public String[] moveLeft(String[] srcArr){
        for (int i = 0; i < srcArr.length; i++){
            if (srcArr[i] == "._."){ position = i; }
        }
        if(position == 0){
            String[] destArr = create_destArr(srcArr);
            for(int i = 1; i<=srcArr.length; i++){
                destArr[i] = "...";
            }
            destArr[position] = "._.";
            srcArr = destArr;
        }
        else{
            srcArr[position] = "...";
            srcArr[position-1] = "._.";
        }
        for(int i = 0; i < srcArr.length; i++){
            System.out.print(srcArr[i]);
        }
        return srcArr;

    }
    public String[] moveRight(String[] srcArr) {
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i] == "._.") {
                position = i;
            }
        }
        if (position == srcArr.length-1) {
            String[] destArr = create_destArr(srcArr);
            for (int i = 0; i <= srcArr.length; i++) {
                destArr[i] = "...";
            }
            destArr[position+1] = "._.";
            srcArr = destArr;
        } else {
            srcArr[position] = "...";
            srcArr[position+1] = "._.";
        }
        for (int i = 0; i < srcArr.length; i++) {
            System.out.print(srcArr[i]);
        }
        return srcArr;
    }
    public String[] viewArr(String[] srcArr){
        for(int i = 0; i < srcArr.length; i++){
            System.out.print(srcArr[i]);
        }
        return srcArr;
    }
}