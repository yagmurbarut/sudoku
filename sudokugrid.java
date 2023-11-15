public class sudokugrid {
    private static final int SIZE = 9; // ızgara ölçü sabiti

    private static final int DIGIT_RANGE = 9; // rakam aralık sabiti

    public static void grid_yazdir(int[][] grid) { //yazdırır
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static boolean uygunmu(int[][] grid, int satir, int sutun, int rakam) {
        for (int a = 0; a < SIZE; a++) {
            if (grid[satir][a] == rakam || grid[a][sutun] == rakam) {
                return false;
            }
        }
        return true;
    }

    public static boolean sudokucoz(int[][] grid, int n) { //çözüm
        int satir = -1;
        int sutun = -1;
        boolean bosluk = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    satir = i;
                    sutun = j;
                    bosluk = false;
                    break;
                }
            }
            if (!bosluk) {
                break; // boşluk değilse çıkar
            }
        }
        if (bosluk) {
            return true;
        }

        for (int rakam = 1; rakam <= n; rakam++) {
            if (uygunmu(grid, satir, sutun, rakam)) {
                grid[satir][sutun] = rakam;

                if (sudokucoz(grid, n)) {
                    return true;
                } else {
                    grid[satir][sutun] = 0;
                }
            }
        }
        return false;
    }
}
