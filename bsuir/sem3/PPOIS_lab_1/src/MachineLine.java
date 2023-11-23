import java.util.Objects;

public class MachineLine {
    String label = "[V]";
    int num2;
    int LinePosition;
    public MachineLine(int num2) {
        this.label = label;
        this.num2 = num2;
        this.LinePosition = LinePosition;

    }
    public String[] create_srcLine() {
        if(num2 <= 0){
            String[] error = {"Лента отсутствует"};
            System.out.println(error);
            return error;
        }
        String[] srcLine = new String[num2];
        for (int i=0; i < srcLine.length; i++) {
            srcLine[i] = "[ ]";
            System.out.print(srcLine[i]);
        }
        return srcLine;
    }
    public String[] create_destLine(String[] srcLine) {
        String[] destLine = new String[srcLine.length+1];
        return destLine;
    }

    public String[] moveLeftLine(String[] srcLine, String[] srcArr){
        if (srcArr.length != srcLine.length) {LinePosition = 0;}
        if(LinePosition==0) {
            String[] destLine = create_destLine(srcLine);
            for (int i = 1, k = 0; i <= srcLine.length; i++, k++) {
                destLine[i] = srcLine[k];
            }
            destLine[LinePosition] = "[ ]";
            srcLine = destLine;
        }
        for(int i = 0; i < srcLine.length; i++){
            System.out.print(srcLine[i]);
        }
        return srcLine;

    }
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
        for (int i = 0; i < srcLine.length; i++) {
            System.out.print(srcLine[i]);
        }
        return srcLine;
    }
    public String[] makeLabel(String[] srcArr, String[] srcLine){
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i] == "._.") {
                LinePosition = i;
            }
        }
        srcLine[LinePosition] = label;
        for (int i = 0; i < srcLine.length; i++) {
            System.out.print(srcLine[i]);
        }
        return srcLine;
    }
    public String[] removeLabel(String[] srcArr, String[] srcLine){
        for (int i = 0; i < srcArr.length; i++) {
            if (srcArr[i] == "._.") {
                LinePosition = i;
            }
        }
        srcLine[LinePosition] = "[ ]";
        for (int i = 0; i < srcLine.length; i++) {
            System.out.print(srcLine[i]);
        }
        return srcLine;
    }
}