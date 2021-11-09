class Bingo {
    public static void main(String[] args){
        int n = MyIO.readInt();
        int k = MyIO.readInt();
        int u = MyIO.readInt();

        int[][] cartelas = new int[n][k];
        int[] contAcertos = new int[n];

        for(int i = 0;i < n;i++){
            contAcertos[i] = 0;
            for(int j = 0;j < k;j++){
                cartelas[i][j] = MyIO.readInt();
            }
        }

        int numSort;

        for(int i = 0;i < u;i++){
            numSort = MyIO.readInt();
            for(int j = 0;j < n;j++){
                for(int h = 0;h < k;h++){
                    if(cartelas[j][h] == numSort){
                        contAcertos[j]++;
                    }
                }
            }
        }

        int cartelasVencedoras = 0;

        int cont = 0;
        for(int i = 0;i < n;i++){
            if(contAcertos[i] == k){
                cartelasVencedoras = i;
                cont++;
            }
        }
        MyIO.print(cartelasVencedoras);
    }    
}
