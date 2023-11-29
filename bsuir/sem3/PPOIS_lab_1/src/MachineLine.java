public class MachineLine {
    String label = "[V]";
    int num2;
    int LinePosition;
    public MachineLine(int num2) {
        this.num2 = num2;

    }

    /**
     * create srcLine
     * @return srcline
     */
    public String[] create_srcLine() {
        String[] srcLine = new String[num2];
        for (int i=0; i < srcLine.length; i++) {
            srcLine[i] = "[ ]";
            System.out.print(srcLine[i]);
        }
        return srcLine;
    }

    /**
     *
     * @param srcLine принимает srcLine для создания массива на +1 больше
     * @return destLine - массив на 1 больше srcLine
     */
    public String[] create_destLine(String[] srcLine) {
        return new String[srcLine.length+1];
    }

    /**
     *
     * @param srcLine принимаем ленту
     * @param srcArr Сравниваем длину Указателя с длинной ленты
     *               если мы выходим за рамки ленты то делаем ленту на 1 больше
     * @return srcArr - та же лента с передвинотой кареткой в левую сторону
     */
    public String[] moveLeftLine(String[] srcLine, String[] srcArr){
        if (srcArr.length != srcLine.length) {
            LinePosition = 0;
                String[] destLine = create_destLine(srcLine);
                for (int i = 1, k = 0; i <= srcLine.length; i++, k++) {
                    destLine[i] = srcLine[k];
                }
                destLine[LinePosition] = "[ ]";
                srcLine = destLine;
        }
        for (String s : srcLine) {
            System.out.print(s);
        }
        return srcLine;

    }

    /**
     *
     * @param srcLine принимаем ленту
     * @param srcArr Сравниваем длину указателя с длинной ленты
     *               если мы выходим за рамки ленты то делаем ленту на 1 больше
     * @return srcArr - та же лента c передвинотой кареткой в правую сторону
     */
    public String[] moveRightLine(String[] srcLine ,String[] srcArr) {
        if (srcArr.length != srcLine.length) {LinePosition = srcLine.length-1;}
        if (LinePosition == srcLine.length-1) {
            String[] destLine = create_destLine(srcLine);
            for (int i = 0; i < srcLine.length; i++) {
                destLine[i] = srcLine[i];
            }
            destLine[LinePosition+1] = "[ ]";
            srcLine = destLine;
        }
        for (String s : srcLine) {
            System.out.print(s);
        }
        return srcLine;
    }

    /**
     *
     * @param srcArr находим положение указателя
     * @param srcLine
     * ставит метку на ту ячейку ленты, над которой находится указатель
     * @return srcLine - лента с меткой
     */
    public String[] makeLabel(String[] srcArr, String[] srcLine){
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i].equals("._.")) {
                LinePosition = i;
            }
        }
        srcLine[LinePosition] = label;
        for (String s : srcLine) {
            System.out.print(s);
        }
        return srcLine;
    }

    /**
     *
     * @param srcArr находим положение Указателя
     * @param srcLine
     * убирает метку с той ячейки над которой находится указатель
     * @return srcLine - лента без метки
     */
    public String[] removeLabel(String[] srcArr, String[] srcLine){
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i].equals("._.")) {
                LinePosition = i;
            }
        }
        srcLine[LinePosition] = "[ ]";
        for (String s : srcLine) {
            System.out.print(s);
        }
        return srcLine;
    }
}