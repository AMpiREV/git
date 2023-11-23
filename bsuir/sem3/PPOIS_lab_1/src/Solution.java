public class Solution {
    int sum;
    int number_of_labels;

    public int makeSolution(String[] srcLine) {
        for (int i = 0; i < srcLine.length; i++) {
            if (srcLine[i].equals("[V]")) {
                number_of_labels = 0;
                for (int j = i + 1; j < srcLine.length; j++) {
                    if (srcLine[j].equals("[V]")) {
                        number_of_labels += 1;
                    }else{
                        i+=number_of_labels;
                    }
                    break;
                }
            }
            sum += number_of_labels;
        }
        return sum;
    }
}
