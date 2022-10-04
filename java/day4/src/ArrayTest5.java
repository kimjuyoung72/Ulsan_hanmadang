public class ArrayTest5 {
    public static void main(String[] args) {

        //1차원 배열에 디폴트값을 주어 초기화

        int[] x = new int[]{1, 2, 3};
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }

        int[][] y = new int[][]{{1, 2, 3},{3, 4, 5}}; //[2][3]
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < y[i].length; j++) {
                System.out.println("y[" + i + "]" + "[" + j + "] = " + y[i][j]);
            }
        }

        int[][][] z = new int[][][]{{{1},{2},{3}},{{3},{4},{5}}}; //[2][3][1]
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[i].length; j++) {
                for (int k = 0; k < z[i][j].length; k++) {
                    System.out.println("z[" + i + "]" + "[" + j + "]" + "[" + k + "] =" + z[i][j][k]);
                }
            }
        }
        System.out.println(z.length);
        System.out.println(z[0].length);
        System.out.println(z[0][0].length);
    }
}
