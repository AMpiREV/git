import java.lang.String;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Количество ячеек в значальной ленте =: ");
        int num1 = scan.nextInt();
        int num2 = num1;
        String[] srcArr, srcLine;
        Pointer pointer = new Pointer(num1);
        srcArr = pointer.create_srcArr();
        if(srcArr[0] == "Лента отсутствует"){return;}
        System.out.println();
        MachineLine line = new MachineLine(num2);
        srcLine = line.create_srcLine();
        System.out.println();
        while(true){
            System.out.println("1) Сдвиг влево");
            System.out.println("2) Сдвиг вправо");
            System.out.println("3) Поставить метку");
            System.out.println("4) Убрать метку");
            System.out.println("5) Узнать результат");
            int k = scan.nextInt();
            switch (k){
                case 1:
                    srcArr = pointer.moveLeft(srcArr);
                    System.out.println();
                    srcLine = line.moveLeftLine(srcLine, srcArr);
                    break;
                case 2:
                    srcArr = pointer.moveRight(srcArr);
                    System.out.println();
                    srcLine = line.moveRightLine(srcLine, srcArr);
                    break;
                case 3:
                    pointer.viewArr(srcArr);
                    System.out.println();
                    srcLine=line.makeLabel(srcArr, srcLine);
                    break;
                case 4:
                    pointer.viewArr(srcArr);
                    System.out.println();
                    srcLine=line.removeLabel(srcArr, srcLine);
                    break;
                case 5:
                    Solution solution = new Solution();
                    System.out.println("сумма = " + solution.makeSolution(srcLine));
                    return;
                default:
                    return;

            }
            System.out.println();
        }
    }
}
