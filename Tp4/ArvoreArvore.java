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
    private int tamanho;
    private ArvoreExt arvore;

    //------------------------------------------------------------------------------
    //Construtor
    //------------------------------------------------------------------------------
    public Array()throws Exception{
        this(100);
    }
    public Array(int tamanho)throws Exception{
        series = new Serie[tamanho];
        arvore = new ArvoreExt();
        this.tamanho = 0;
    }
    //------------------------------------------------------------------------------
    //Preencher
    //------------------------------------------------------------------------------
    public ArvoreExt preencher()throws Exception{
        int cont = 0;
        String nomeArq = MyIO.readLine();
        while(!(nomeArq.contains("FIM"))){
            series[cont] = new Serie();
            series[cont].ler(nomeArq);
            arvore.inserir(series[cont]);
            cont++;
            tamanho++;
            nomeArq = MyIO.readLine();
        }
        return arvore;
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

class NoExt{
    public char letra;
    public ArvoreInt arvore;
    public NoExt esq, dir;

    //------------------------------------------------------------------------------
    //Construtores
    //------------------------------------------------------------------------------
    public NoExt(char letra){
        this(letra, null, null);
    }
    public NoExt(char letra, NoExt esq, NoExt dir){
        arvore = new ArvoreInt();
        this.letra = letra;
        this.esq = esq;
        this.dir = dir;
    }
    //------------------------------------------------------------------------------
}

class ArvoreExt{
    private NoExt raiz;
    private int comp;

    //------------------------------------------------------------------------------
    //Construtores
    //------------------------------------------------------------------------------
    public ArvoreExt()throws Exception{
        raiz = null;
        comp = 0;
        montarArvore();
    }
    //------------------------------------------------------------------------------
    //Get
    //------------------------------------------------------------------------------
    public int getComp(){
        int compGeral = comp;
        caminhar(raiz, compGeral);
        return compGeral;
    }
    private void caminhar(NoExt i, int comp){
        if(i != null){
            caminhar(i.esq, comp);
            comp += i.arvore.getComp();
            caminhar(i.dir, comp);
        }
    }
    //------------------------------------------------------------------------------
    //MontarArvore
    //------------------------------------------------------------------------------
    private void montarArvore()throws Exception{
        raiz = montarArvore('D', raiz);
        raiz = montarArvore('R', raiz);
        raiz = montarArvore('Z', raiz);
        raiz = montarArvore('X', raiz);
        raiz = montarArvore('V', raiz);
        raiz = montarArvore('B', raiz);
        raiz = montarArvore('F', raiz);
        raiz = montarArvore('P', raiz);
        raiz = montarArvore('U', raiz);
        raiz = montarArvore('I', raiz);
        raiz = montarArvore('G', raiz);
        raiz = montarArvore('E', raiz);
        raiz = montarArvore('J', raiz);
        raiz = montarArvore('L', raiz);
        raiz = montarArvore('H', raiz);
        raiz = montarArvore('T', raiz);
        raiz = montarArvore('A', raiz);
        raiz = montarArvore('W', raiz);
        raiz = montarArvore('S', raiz);
        raiz = montarArvore('O', raiz);
        raiz = montarArvore('M', raiz);
        raiz = montarArvore('N', raiz);
        raiz = montarArvore('K', raiz);
        raiz = montarArvore('C', raiz);
        raiz = montarArvore('Y', raiz);
        raiz = montarArvore('q', raiz);
    }
    private NoExt montarArvore(char c, NoExt i)throws Exception{
        if(i == null){
            i = new NoExt(c);
        }else if(c < i.letra){
            comp++;
            i.esq = montarArvore(c, i.esq);
        }else if(c > i.letra){
            comp++;
            i.dir = montarArvore(c, i.dir);
        }else{
            throw new Exception("Erro!");
        }
        return i;
    }
    //------------------------------------------------------------------------------
    //Inserir
    //------------------------------------------------------------------------------
    public void inserir(Serie serie)throws Exception{
        char letra = serie.getNome().charAt(0);
        NoExt pos = acharChave(letra);
        pos.arvore.inserir(serie);
    }
    //------------------------------------------------------------------------------
    //Remover
    //------------------------------------------------------------------------------
    public void remover(String serie)throws Exception{
        char letra = serie.charAt(0);
        NoExt pos = acharChave(letra);
        pos.arvore.remover(serie);
    }
    //------------------------------------------------------------------------------
    //Pesquisar
    //------------------------------------------------------------------------------
    public void pesquisar(String nome){
        MyIO.print("raiz ");
        char letra = nome.charAt(0);
        NoExt pos = acharChavePesq(letra);
        pos.arvore.pesquisar(nome);
    }
    //------------------------------------------------------------------------------
    //acharChave, acharChavePesq
    //------------------------------------------------------------------------------
    private NoExt acharChave(char c){
        NoExt pos = acharChave(c, raiz);
        return pos;
    }
    private NoExt acharChave(char c, NoExt i){
        if(c == i.letra){

        }else if(c < i.letra){
            acharChave(c, i.esq);
        }else if(c > i.letra){
            acharChave(c, i.dir);
        }
        return i;
    }
    private NoExt acharChavePesq(char c){
        NoExt pos = acharChavePesq(c, raiz);
        return pos;
    }
    private NoExt acharChavePesq(char c, NoExt i){
        if(c == i.letra){

        }else if(c < i.letra){
            MyIO.print("ESQ ");
            acharChavePesq(c, i.esq);
        }else if(c > i.letra){
            MyIO.print("DIR ");
            acharChavePesq(c, i.dir);
        }
        return i;
    }
    //------------------------------------------------------------------------------
}

class NoInt{
    public Serie serie;
    public NoInt esq, dir;

    //------------------------------------------------------------------------------
    //Construtores
    //------------------------------------------------------------------------------
    public NoInt(Serie serie){
        this(serie, null, null);
    }
    public NoInt(Serie serie, NoInt esq, NoInt dir){
        this.serie = serie;
        this.esq = esq;
        this.dir = dir;
    }
    //------------------------------------------------------------------------------
}

class ArvoreInt{
    private NoInt raiz;
    private int comp;

    //------------------------------------------------------------------------------
    //Construtores
    //------------------------------------------------------------------------------
    public ArvoreInt(){
        raiz = null;
        comp = 0;
    }
    //------------------------------------------------------------------------------
    //GetComp
    //------------------------------------------------------------------------------
    public int getComp(){ return comp; }
    //------------------------------------------------------------------------------
    //Inserir
    //------------------------------------------------------------------------------
    public void inserir(Serie serie)throws Exception{
        raiz = inserir(serie, raiz);
    }
    private NoInt inserir(Serie serie, NoInt i)throws Exception{
        if(i == null){
            i = new NoInt(serie);
        }else if(serie.getNome().compareTo(i.serie.getNome()) < 0){
            comp++;
            i.esq = inserir(serie, i.esq);
        }else if(serie.getNome().compareTo(i.serie.getNome()) > 0){
            comp++;
            i.dir = inserir(serie, i.dir);
        }else{
            throw new Exception("Erro!");
        }
        return i;
    }
    //------------------------------------------------------------------------------
    //Remover
    //------------------------------------------------------------------------------
    public void remover(String serie)throws Exception{
        raiz = remover(serie, raiz);
    }
    private NoInt remover(String serie, NoInt i)throws Exception{
        if(i == null){
            throw new Exception("Erro!");
        }else if(serie.compareTo(i.serie.getNome()) < 0){
            comp++;
            i.esq = remover(serie, i.esq);
        }else if(serie.compareTo(i.serie.getNome()) > 0){
            comp++;
            i.dir = remover(serie, i.dir);
        }else if(i.dir == null){
            i = i.esq;
        }else if(i.esq == null){
            i = i.dir;
        }else{
            i.esq = maiorEsq(i, i.esq);
        }
        return i;
    }
    //------------------------------------------------------------------------------
    //Pesquisar
    //------------------------------------------------------------------------------
    public void pesquisar(String nome){
        MyIO.print("raiz ");
        if(pesquisar(nome, raiz)){
            MyIO.print("SIM\n");
        }else{
            MyIO.print("NAO\n");
        }
    }
    private boolean pesquisar(String nome, NoInt i){
        boolean resp;
        if(i == null){
            resp = false;
        }else if(nome.equals(i.serie.getNome())){
            comp++;
            resp = true;
        }else if(nome.compareTo(i.serie.getNome()) < 0){
            comp++;
            MyIO.print("esq ");
            resp = pesquisar(nome, i.esq);
        }else{
            MyIO.print("dir ");
            resp = pesquisar(nome, i.dir);
        }
        return resp;
    }
    //------------------------------------------------------------------------------
    //maiorEsq
    //------------------------------------------------------------------------------
    private NoInt maiorEsq(NoInt i, NoInt j){
        if(j.dir == null){
            i.serie = j.serie;
            j = j.esq;
        }else{
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }
    //------------------------------------------------------------------------------
}

class ArvoreArvore{
    public static void main(String[] args)throws Exception{
        MyIO.setCharset("UTF-8");
        long inicio = System.currentTimeMillis();
        Array array = new Array();
        ArvoreExt arvore = new ArvoreExt();
        arvore = array.preencher();
        String pesq = MyIO.readLine();
        while(!(pesq.equals("FIM"))){
            arvore.pesquisar(pesq);
            pesq = MyIO.readLine();
        }
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        int comp = arvore.getComp();
        Arq arquivo = new Arq();
        arquivo.openWriteClose("656016_arvoreArvore.txt", "656016\t" + tempo + "\t" + comp );
    }
}