class CamisetasOlimpiadas{
    public static void main(String[] args){
        int numPremi = MyIO.readInt();

        int pedidos[] = new int[numPremi];
        int contP = 0;
        int contM = 0;
        for(int i = 0; i < numPremi; i++){
            pedidos[i] = MyIO.readInt();
            if(pedidos[i] == 1){
                contP++;
            }else if(pedidos[i] == 2){
                contM++;
            }
        }

        int P = MyIO.readInt();
        int M = MyIO.readInt();        

        boolean temSuficiente = false;

        if(contP == P && contM == M){
            temSuficiente = true;
        }

        if(temSuficiente){
            MyIO.println("S");
        }else{
            MyIO.println("N");
        }
    }   
}