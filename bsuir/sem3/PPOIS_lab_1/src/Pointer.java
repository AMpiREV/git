public class Pointer {
    int num1;
    int position;
    public Pointer(int num1){
       this.num1 = num1;
    }

    /**
     * создание Указателя
     * @return srcArr
     */
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

    /**
     *
     * @param srcArr принимаем указатель, чтобы создать месте для его дальнейшего пути
     * @return destArr - новый указатель с новым положением указателя
     */
    public String[] create_destArr(String[] srcArr) {
        return new String[srcArr.length+1];
    }

    /**
     *
     * @param srcArr Двигаем указатель влево, если указатель дальше идти не может
     *               то создаём новое место
     * @return srcArr - Указатель передвинутый влево
     */
    public String[] moveLeft(String[] srcArr){
        for (int i = 0; i < srcArr.length; i++){
            if (srcArr[i].equals("._.")){ position = i; }
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
        for (String s : srcArr) {
            System.out.print(s);
        }
        return srcArr;

    }

    /**
     *
     * @param srcArr Двигаем указатель вправо, если указатель дальше идти не может
     *               то создаём новое место
     * @return srcArr Указатель передвинутый вправо
     */
    public String[] moveRight(String[] srcArr) {
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i].equals("._.") ) {
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
        for (String s : srcArr) {
            System.out.print(s);
        }
        return srcArr;
    }

    /**
     *
     * @param srcArr
     * выводим текущее положение указателя
     * @return srcArr
     */
    public String[] viewArr(String[] srcArr){
        for (String s : srcArr) {
            System.out.print(s);
        }
        return srcArr;
    }
}