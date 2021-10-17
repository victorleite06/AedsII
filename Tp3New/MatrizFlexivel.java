class Celula{

    public int x;
    public Celula dir, esq, sup, inf;
    //-------------------------------------------------------------
	//Construtores
	//-------------------------------------------------------------
    public Celula(){
        this(0);
    }
    public Celula(int x){
        this.x = x;
        this.dir = this.esq = this.inf = this.sup = null;
    }
    //-------------------------------------------------------------
}

class MatrizFlexivelSimples{

    private Celula primeiro;
    private Celula fim;
    //-------------------------------------------------------------
	//Construtore
	//-------------------------------------------------------------
    public MatrizFlexivelSimples(){
        primeiro = new Celula();
        fim = primeiro;
    }
    //-------------------------------------------------------------
	//montarMatriz, inserir
	//-------------------------------------------------------------
    private void montarMatriz(int tamanho){        
        Celula tmp = fim = primeiro;
        
        for(int i = 0; i < tamanho; i++){            
            for(int j = 1; j < tamanho; j++){
                fim.dir = new Celula();
                fim.dir.esq = fim;
                fim = fim.dir;
            }
            
            if(i != (tamanho - 1)){
                tmp.inf = new Celula();
                tmp.inf.sup = tmp;
                tmp = fim = tmp.inf;
            }
        }
 
        Celula linha = tmp = primeiro;
        
        for(int i = 1; i < tamanho; i++){            
            fim = linha;
            linha = tmp = linha.dir;
            fim = fim.inf.dir;            
            for(int j = 1; j < tamanho; j++){
                tmp.inf = fim;
                fim.sup = tmp;
                tmp = fim;                
                if(j != (tamanho - 1))
                    fim = fim.esq.inf.dir;
            }
        }
        fim = primeiro;
    }
    public void inserir(int tamanho){
        montarMatriz(tamanho);

        Celula tmp = fim = primeiro;
        for(int i = 0; i < tamanho; i++){           
            for(int j = 0; j < tamanho; j++){
                tmp.x = MyIO.readInt();
                tmp = tmp.dir;
            }            
            fim = tmp = fim.inf;
        }
        fim = primeiro;
    }
    //-------------------------------------------------------------
	//mostrar
	//-------------------------------------------------------------
    public void mostrar(){
        Celula tmp = primeiro;
 
        for(Celula i = primeiro; i != null; i = i.inf){            
            for(Celula j = tmp; j != null; j = j.dir)
                MyIO.print("| " + j.x + " ");      
            MyIO.print("|\n");
            tmp = i.inf;
        } 
    }
    //-------------------------------------------------------------
    //diagonalPrincipal, diagonalSecundaria, soma, multiplicacao
    //-------------------------------------------------------------
    public void diagonalPrincipal(int tamanho){
        fim = primeiro;
        for (int i = 0; i < tamanho; i++){
            MyIO.print(fim.x + " ");            
            if (i != tamanho - 1)
                fim = fim.inf.dir;
        }
        MyIO.println("");
        fim = primeiro;
    }
    public void diagonalSecundaria(int tamanho){
        fim = primeiro;
        for(int i = 1; i < tamanho; i++)
            fim = fim.dir;
        for(int i = 0; i < tamanho; i++){
            MyIO.print(fim.x + " ");
            if(i != tamanho - 1)
                fim = fim.inf.esq;
        }
        MyIO.println("");
        fim = primeiro;
    }
    public void soma(MatrizFlexivelSimples m){
        Celula tmp = primeiro;
        Celula tmp2 = m.primeiro;
 
        for(Celula i = primeiro, i1 = m.primeiro; i != null; i = i.inf, i1 = i1.inf){
            for(Celula j = tmp, j1 = tmp2; j != null; j = j.dir, j1 = j1.dir)
                MyIO.print((j.x + j1.x) + " ");
            MyIO.print("\n");
            tmp = i.inf;
            tmp2 = i1.inf;
        }
    }
    public void multiplicacao(MatrizFlexivelSimples m, int tamanho){
        Celula tmp = fim = primeiro;
        Celula tmp2 = m.primeiro;
        int total = 0;
        for(int i = 0; i != tamanho; i++){
            for(Celula j =  m.primeiro; j != null; j = j.dir){
                for (Celula h = tmp, h1 = tmp2; h != null; h = h.dir, h1 = h1.inf)
                    total += h1.x * h.x;
                MyIO.print(total + " ");
                tmp2 = j.dir;
                total = 0;
            }
            MyIO.println("");
            tmp2 = m.primeiro;
            tmp = fim = fim.inf;
        }
        fim = primeiro;
        m.fim = m.primeiro;
    }
	//-------------------------------------------------------------
}
 
class MatrizFlexivel{
     public static void main(String[] args){
        
        MatrizFlexivelSimples matriz1 = new MatrizFlexivelSimples();
        MatrizFlexivelSimples matriz2 = new MatrizFlexivelSimples();
        int casos = MyIO.readInt();

        for(; casos != 0; casos--){
            //-------------------------------------------------------------
            //Leitura e criação das Matrizes
            //-------------------------------------------------------------
            MyIO.readInt();
            int tamanho = MyIO.readInt();   // Matriz1
            matriz1.inserir(tamanho);
            //-------------------------------------------------------------
            MyIO.readInt();
            MyIO.readInt();             // Matriz2
            matriz2.inserir(tamanho);
            //-------------------------------------------------------------
            //Operações
            //-------------------------------------------------------------
            matriz1.diagonalPrincipal(tamanho);
            matriz1.diagonalSecundaria(tamanho);
            matriz1.soma(matriz2);
            matriz1.multiplicacao(matriz2,tamanho);
            //-------------------------------------------------------------
        }
    }  
}