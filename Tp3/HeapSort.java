import java.io.*;
import java.io.FileReader;

class Serie{
    private String nome;
    private String formato;
    private String duracao;
    private String paisOrigem;
    private String idiomaOrigem;
    private String emissoraTV;
    private String trasmissaoOriginal;
    private int numTemp;
    private int numEp;
    //------------------------------------------------------------------------------
    //Construtores
    public Serie(){
        this.nome = "";
        this.formato = "";
        this.duracao = "";
        this.paisOrigem = "";
        this.idiomaOrigem = "";
        this.emissoraTV = "";
        this.trasmissaoOriginal = "";
        this.numTemp = 0;
        this.numEp = 0;
    }
    public Serie(String nome, String formato, String duracao, String paisOrigem, String idiomaOrigem, String emissoraTV, String transmissaoOriginal, int numTemp, int numEp){
        this.nome = nome;
        this.formato = formato;
        this.duracao = duracao;
        this.paisOrigem = paisOrigem;
        this.idiomaOrigem = idiomaOrigem;
        this.emissoraTV = emissoraTV;
        this.trasmissaoOriginal = transmissaoOriginal;
        this.numTemp = numTemp;
        this.numEp = numEp;
    }
    //------------------------------------------------------------------------------
    //Sets/Gets
    public void setNome(String nome){ this.nome = nome; }
    public String getNome(){ return this.nome; }

    public void setFormato(String formato){ this.formato = formato; }
    public String getFormato(){ return this.formato; }
    
    public void setDuracao(String duracao){ this.duracao = duracao; }
    public String getDuracao(){ return this.duracao; }
    
    public void setPaisOrigem(String paisOrigem){ this.paisOrigem = paisOrigem; }
    public String getPaisOrigem(){ return this.paisOrigem; }
    
    public void setIdiomaOrigem(String idiomaOrigem){ this.idiomaOrigem = idiomaOrigem; }
    public String getIdiomaOrigem(){ return this.idiomaOrigem; }
    
    public void setEmissoraTV(String emissoraTV){ this.emissoraTV = emissoraTV; }
    public String getEmissoraTV(){ return this.emissoraTV; }
    
    public void setTransmissaoOrigem(String transmissaoOriginal){ this.trasmissaoOriginal = transmissaoOriginal; }
    public String getTransmissaoOriginal(){ return this.trasmissaoOriginal; }
    
    public void setNumTemp(int numTemp){ this.numTemp = numTemp; }
    public int getNumTemp(){ return this.numTemp; }
    
    public void setNumEp(int numEp){ this.numEp = numEp; }
    public int getNumEp(){ return this.numEp; }
    //------------------------------------------------------------------------------
    //Clone/Ler
    public Serie clone(){
        Serie novo = new Serie();
        novo.nome = this.nome;
        novo.formato = this.formato;
        novo.duracao = this.duracao;
        novo.paisOrigem = this.paisOrigem;
        novo.idiomaOrigem = this.idiomaOrigem;
        novo.emissoraTV = this.emissoraTV;
        novo.trasmissaoOriginal = this.trasmissaoOriginal;
        novo.numTemp = this.numTemp;
        novo.numEp = this.numEp;
        return novo;
    }
    
    public void ler(String Arqu){
        String nomeArq = "/tmp/series/" + Arqu; // Verde
        //String nomeArq = Arqu; // Teste

        try{
            FileReader arq = new FileReader(nomeArq);
            BufferedReader ler = new BufferedReader(arq);

            this.nome = procurarNome(Arqu);

            while(!(ler.readLine().contains("Formato")));
            this.formato = removerTags(ler.readLine());

            while(!(ler.readLine().contains("Duração")));
            this.duracao = removerTags(ler.readLine());

            while(!(ler.readLine().contains("País de origem")));
            this.paisOrigem = removerTags(ler.readLine());

            while(!(ler.readLine().contains("Idioma original")));
            this.idiomaOrigem = removerTags(ler.readLine());

            while(!(ler.readLine().contains("Emissora de televisão")));
            this.emissoraTV = removerTags(ler.readLine());

            while(!(ler.readLine().contains("Transmissão original")));
            this.trasmissaoOriginal = removerTags(ler.readLine());

            while(!(ler.readLine().contains("N.º de temporadas")));
            this.numTemp = retornarInt(removerTags(ler.readLine()));

            while(!(ler.readLine().contains("N.º de episódios")));
            this.numEp = retornarInt(removerTags(ler.readLine()));

            ler.close();
        }catch(FileNotFoundException e){
            System.out.println("Erro em abrir file " + nomeArq);
        }catch(IOException e){
            System.out.println("Erro em ler file" + nomeArq);
        }
    }

    private String procurarNome(String Arqu){
        String nome = "";
        for(int i = 0;i < Arqu.length();i++){
            if(Arqu.charAt(i) == '_')
                nome += ' ';
            else
                nome += Arqu.charAt(i);
        }
        return nome.substring(0, nome.length()-5);
    }
    private String removerTags(String in){
        String resp = "";
        for(int i = 0;i < in.length();i++){
            if(in.charAt(i) == '<'){
                i++;
                while(in.charAt(i) != '>')
                    i++;
            }else if(in.charAt(i) == '&'){
                i++;
                while(in.charAt(i) != ';')
                    i++;
            }else{
                resp += in.charAt(i);
            }
        }
        return resp;
    }
    private int retornarInt(String in){
        String resp = "";
        for(int i = 0;i < in.length();i++){
            if(in.charAt(i) >= '0' && in.charAt(i) <= '9'){
                resp += in.charAt(i);
            }else{
                i = in.length();
            }
        }
        return Integer.parseInt(resp);
    }

    //------------------------------------------------------------------------------
    //Imprimir
    public void imprimir(){
        MyIO.print(nome + " " + formato + " " + duracao + " " + paisOrigem + " " + idiomaOrigem + " " + emissoraTV + " " + trasmissaoOriginal + " " + numTemp + " " + numEp + "\n");
    }
    //------------------------------------------------------------------------------
}

class Array{
    private Serie series[];
    private int comp;
    private int mov;
    private int tamanho;

    //------------------------------------------------------------------------------
    //Construtor
    //------------------------------------------------------------------------------
    public Array(){
        this(100);
    }
    public Array(int tamanho){
        series = new Serie[tamanho+1];
        comp = mov = 0;
        this.tamanho = 0;
    }
    //------------------------------------------------------------------------------
    //Gets
    //------------------------------------------------------------------------------
    public int getComp(){ return this.comp; }
    public int getMov(){ return this.mov; }
    //------------------------------------------------------------------------------
    //Preencher
    //------------------------------------------------------------------------------
    public void preencher(){
        int cont = 0;
        String nomeArq = MyIO.readLine();
        while(!(nomeArq.contains("FIM"))){
            series[cont] = new Serie();
            series[cont].ler(nomeArq);
            cont++;
            tamanho++;
            nomeArq = MyIO.readLine();
        }
    }
    //------------------------------------------------------------------------------
    //Sort
    //------------------------------------------------------------------------------
    public void sort(){
        Serie tmp[] = new Serie[(tamanho+1)];
        for(int i = 0;i < tamanho;i++){
            tmp[i+1] = series[i];
        }
        series = tmp;

        int tamHeap = 2;
        for(;tamHeap <= tamanho;tamHeap++){
            construir(tamHeap);
        }

        while(tamHeap > 1){
            swap(1, tamHeap--);
            reconstruir(tamHeap);
        }

        tmp = series;
        series = new Serie[tamanho];
        for(int i = 0;i < tamanho;i++){
            series[i] = tmp[i+1];
        }
    }
    private void construir(int tamHeap){
        for(int i = tamHeap; i > 1 && comparacao((i/2), i); i /= 2){
            swap(i, i/2);
        }
    }
    private void reconstruir(int tamHeap){
        int i = 1;
        while(i <= (tamHeap/2)){
            int filho = getMaiorFilho(i, tamHeap);
            if(comparacao(i, filho)){
                swap(i, filho);
                i = filho;
            }else{
                i = tamHeap;
            }
        }
    }
    //------------------------------------------------------------------------------
    //swap, comparacao, getMaiorFilho
    //------------------------------------------------------------------------------
    private void swap(int i, int j){
        Serie tmp = series[i];
        series[i] = series[j];
        series[j] = tmp;
        mov += 2;
    }
    private boolean comparacao(int i, int j){
        int cont = 0;
        boolean comparacao = false;
        if(series[i].getFormato() != series[j].getFormato()){
            comp++;
            String aux = series[i].getFormato();
            String aux1 = series[j].getFormato();
            if(!(aux.equals(aux1))){
                if(aux.length() == aux1.length()){
                    while((aux.charAt(cont) == aux1.charAt(cont))){ cont++; comp++; }
                    if(aux.charAt(cont) < aux1.charAt(cont)){
                        comparacao = true;
                        comp++;
                    }
                }
            }
        }
        return comparacao;
    }
    private int getMaiorFilho(int i, int tamHeap){
        int filho;
        if(2*i == tamHeap || comparacao((2*i+1), (2*i))){
            filho = 2*i;
        }else{
            filho = 2*i + 1;
        }
        return filho;
    }
    //------------------------------------------------------------------------------
    //Mostrar
    //------------------------------------------------------------------------------
    public void mostrar(){
        for(int i = 0;i < tamanho;i++){
            series[i].imprimir();
        }
    }
    //------------------------------------------------------------------------------
}


class HeapSort{   
    public static void main(String[] args){
        MyIO.setCharset("UTF-8");
        long inicio = System.currentTimeMillis();
        Array array = new Array();
        array.preencher();
        array.sort();
        array.mostrar();
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        int comp = array.getComp();
        int mov = array.getMov();
        Arq arquivo = new Arq();
        arquivo.openWriteClose("656016_heapsort.txt", "656016\t" + comp + "\t" + mov + "\t" + tempo);
    }
}