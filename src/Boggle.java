import java.util.ArrayList;
public class Boggle {
        public String[][] array; // array to print with randomized letters
        public ArrayList<String> list; // list of letters to add to array

    public void boggle(String[][] array) {
        this.array = array;
        this.list = list;
    }

    public void printBoggle (String[][] array){ // prints the 16 letter randomized array
//        for (int r = 0; r < array.length; r++){
//            for (int c = 0; c < array[r].length; c++){
//                System.out.print(array[r][c]);
//            }
//        }
        System.out.print(array[0][0] + "  " + array[0][1] +  "  " + array[0][2] +  "  " + array[0][3] + "\n");
        System.out.print(array[1][0] +  "  " + array[1][1] +  "  " + array[1][2] +  "  " + array[1][3] + "\n");
        System.out.print(array[2][0] +  "  " + array[2][1] +  "  " + array[2][2] +  "  " + array[2][3] + "\n");
        System.out.print(array[3][0] +  "  " + array[3][1] +  "  " + array[3][2] +  "  " + array[3][3] + "\n");
    }
    public String[][] randomize (){ // randomizes (or boggles) the array
        array = new String[4][4];
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                array[r][c] = (letters((int)(Math.random() * 26)));
            }
        }
        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++) {
                if (((int) (Math.random() * 26)) <= 3) {
                    array[r][c] = "E";
                }
            }
        }
            for (int r = 0; r < array.length; r++) {
                for (int c = 0; c < array[r].length; c++) {
                    if (((int) (Math.random() * 26)) <= 2) {
                        array[r][c] = "S";
                    }
                }
        }

        return array;
    }
    public String letters (int i) {// letters to use for the random array
        list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("J");
        list.add("K");
        list.add("L");
        list.add("M");
        list.add("N");
        list.add("O");
        list.add("P");
        list.add("Q");
        list.add("R");
        list.add("S");
        list.add("T");
        list.add("U");
        list.add("V");
        list.add("W");
        list.add("X");
        list.add("Y");
        list.add("Z");
        return list.get(i);
    }
}
