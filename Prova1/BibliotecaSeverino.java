class BibliotecaSeverino{
    
    public static void trocar(int i, int j, int array[]){
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    
    public static void main(String[] args){
        String g;
        while((g = MyIO.readLine()) != null){ // Não consegui fazer o código parar por sozinho
            int n = Integer.parseInt(g);
            int array[] = new int[n];
            for(int i = 0;i < n;i++){
                array[i] = MyIO.readInt();
            }
            //----------------------------------------------------------------
            //Oredenação
            for(int j = 0;j < (n - 1);j++){
                int menor = j;
                for(int h = (j + 1);h < n;h++){
                    if(array[menor] > array[h]){
                        menor = h;
                    }
                }
                trocar(menor, j, array);                
            }
            //----------------------------------------------------------------
            //Print + colocar 0's antes do número 
            for(int l = 0;l < n;l++){
                String aux = Integer.toString(array[l]);
                if(aux.length() == 1){
                    MyIO.println("000" + aux);
                }else if(aux.length() == 2){
                    MyIO.println("00" + aux);
                }else if(aux.length() == 3){
                    MyIO.println("0" + aux);
                }else{
                    MyIO.println(aux);
                }
            }
            //----------------------------------------------------------------
        }
    }
}