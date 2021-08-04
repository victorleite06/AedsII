class LAB01Q01AquecimentoRecursivo{
    public static boolean isMaiuscula(char c){
        return (c >= 'A' && c <= 'Z');
    }
   
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
   
    public static int contarLetrasMaiusculas(String s, int pos){
        if(pos < s.length()){
            if(isMaiuscula(s.charAt(pos)) == true){
              return 1 + contarLetrasMaiusculas(s, pos+1);
            }else{
              return contarLetrasMaiusculas(s, pos+1);
            }
        }
        return 0;
    }

    public static void imprimir(int i, int numEntrada, String entrada[]){
        if(i < numEntrada){
            MyIO.println(contarLetrasMaiusculas(entrada[i],0));
            i++;
            imprimir(i, numEntrada, entrada);
        }
    }
   
    public static void main(String[] args){
        String[] entrada = new String[1000];
        int numEntrada = 0;
        
        do{
           entrada[numEntrada] = MyIO.readLine();
        }while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;
   
        int i = 0;
        imprimir(i, numEntrada, entrada);
    }
}