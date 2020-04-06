    public class Main {
        public static void main(String[] args) {
            int[][] board = {
                    { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                    { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                    { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                    { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                    { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                    { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                    { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                    { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
            };
            Sudoku su = new Sudoku(board);

            for(Case i : su.listeC){
                System.out.println(i.getNumber());
                System.out.println(i.getColone());
                System.out.println(i.getLigne());
            }
            /*for (Ligne i : su.ligne){
                System.out.print(i);
            }
            for (Colone i : su.colone){
                System.out.print(i);
            }*/




        }
    }

