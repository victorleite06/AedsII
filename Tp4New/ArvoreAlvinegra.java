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
        //String nomeArq = "/tmp/series/" + Arqu; // Verde
        String nomeArq = Arqu; // Teste

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
    private Arvore arvore;

    //------------------------------------------------------------------------------
    //Construtor
    //------------------------------------------------------------------------------
    public Array(){
        this(100);
    }
    public Array(int tamanho){
        series = new Serie[tamanho];
        arvore = new Arvore();
        this.tamanho = 0;
    }
    //------------------------------------------------------------------------------
    //Preencher
    //------------------------------------------------------------------------------
    public Arvore preencher()throws Exception{
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

class No{
    public Serie serie;
    public No esq, dir;
    public boolean cor;

    //------------------------------------------------------------------------------
    //Construtores
    //------------------------------------------------------------------------------
    public No(Serie serie){
        this(serie, null, null, false);
    }
    public No(Serie serie, boolean cor){
        this(serie, null, null, cor);
    }
    public No(Serie serie, No esq, No dir, boolean cor){
        this.serie = serie;
        this.esq = esq;
        this.dir = dir;
        this.cor = cor;
    }
}

class Arvore{
    private No raiz;
    private int comp;

    //------------------------------------------------------------------------------
    //Construtores
    //------------------------------------------------------------------------------
    public Arvore(){
        raiz = null;
        comp = 0;
    }
    //------------------------------------------------------------------------------
    //GetComp
    //------------------------------------------------------------------------------
    public int getComp(){
        return comp;
    }
    //------------------------------------------------------------------------------
    //Inserir
    //------------------------------------------------------------------------------
    public void inserir(Serie serie)throws Exception{
        if(raiz == null){
            raiz = new No(serie);
        }else if(raiz.esq == null && raiz.dir == null){
            if(serie.getNome().compareTo(raiz.serie.getNome()) < 0){
                comp++;
                raiz.esq = new No(serie);
            }else{
                raiz.dir = new No(serie);
            }
        }else if(raiz.esq == null){
            if(serie.getNome().compareTo(raiz.serie.getNome()) < 0){
                comp++;
                raiz.esq = new No(serie);
            }else if(serie.getNome().compareTo(raiz.dir.serie.getNome()) < 0){
                comp++;
                raiz.esq = new No(raiz.serie);
                raiz.serie = serie;
            }else{
                raiz.esq = new No(raiz.serie);
                raiz.serie = raiz.dir.serie;
                raiz.dir.serie = serie;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        }else if(raiz.dir == null){
            if(serie.getNome().compareTo(raiz.serie.getNome()) > 0){
                comp++;
                raiz.dir = new No(serie);
            }else if(serie.getNome().compareTo(raiz.esq.serie.getNome()) > 0){
                comp++;
                raiz.dir = new No(raiz.serie);
                raiz.serie = serie;
            }else{
                raiz.dir = new No(raiz.serie);
                raiz.serie = raiz.esq.serie;
                raiz.esq.serie = serie;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        }else{
            inserir(serie, null, null, null, raiz);
        }
        raiz.cor = false;
    }
    private void inserir(Serie serie, No bisavo, No avo, No pai, No i)throws Exception{
        if(i == null){
            if(serie.getNome().compareTo(pai.serie.getNome()) < 0){
                i = pai.esq = new No(serie, true);
            }else{
                i = pai.dir = new No(serie, true);
            }
            if(pai.cor == true){
                balancear(bisavo, avo, pai, i);
            }
        }else{
            if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true){
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if(i == raiz){
                    i.cor = false;
                }else if(pai.cor == true){
                    balancear(bisavo, avo, pai, i);
                }
            }
            if(serie.getNome().compareTo(i.serie.getNome()) < 0){
                comp++;
                inserir(serie, avo, pai, i, i.esq);
            }else if(serie.getNome().compareTo(i.serie.getNome()) > 0){
                comp++;
                inserir(serie, avo, pai, i, i.dir);
            }else{
                throw new Exception("Erro!");
            }
        }
    }
    //------------------------------------------------------------------------------
    //Pesquisar
    //------------------------------------------------------------------------------
    public void pesquisar(String nome){
        MyIO.println("raiz ");
        if(pesquisar(nome, raiz)){
            MyIO.print("SIM");
        }else{
            MyIO.print("NAO");
        }
    }
    private boolean pesquisar(String nome, No i){
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
    //Balancear, rotacionarDir, rotacionarEsq, rotacionarEsqDir, rotacionarDirEsq
    //------------------------------------------------------------------------------
    private void balancear(No bisavo, No avo, No pai, No i){
        if(pai.cor == true){
            if(pai.serie.getNome().compareTo(avo.serie.getNome()) > 0){
                comp++;
                if(i.serie.getNome().compareTo(pai.serie.getNome()) > 0){
                    comp++;
                    avo = rotacionarEsq(avo);
                }else{
                    avo = rotacionarDirEsq(avo);
                }
            }else{
                if(i.serie.getNome().compareTo(pai.serie.getNome()) > 0){
                    comp++;
                    avo = rotacionarDir(avo);
                }else{
                    avo = rotacionarEsqDir(avo);
                }
            }

            if(bisavo == null){
                raiz = avo;
            }else if(avo.serie.getNome().compareTo(bisavo.serie.getNome()) < 0){
                comp++;
                bisavo.esq = avo;
            }else{
                bisavo.dir = avo;
            }

            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }
    private No rotacionarDir(No no){
        No noEsq = no.esq;
        No noEsqDir = no.esq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;
        
        return noEsq;
    }
    private No rotacionarEsq(No no){
        No noDir = no.dir;
        No noDirEsq = no.dir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        return noDir;
    }
    private No rotacionarEsqDir(No no){
        no.esq = rotacionarEsq(no.esq);
        return rotacionarDir(no);
    }
    private No rotacionarDirEsq(No no){
        no.dir = rotacionarDir(no.dir);
        return rotacionarEsq(no);
    }
}

class ArvoreAlvinegra{
    public static void main(String[] args)throws Exception{
        MyIO.setCharset("UTF-8");
        long inicio = System.currentTimeMillis();
        Array array = new Array();
        Arvore arvore = new Arvore();
        arvore = array.preencher();
        String pesq = MyIO.readLine();
        while(pesq.equals("FIM")){
            arvore.pesquisar(pesq);
            pesq = MyIO.readLine();
        }
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        int comp = arvore.getComp();
        Arq arquivo = new Arq();
        arquivo.openWriteClose("656016_avinegra.txt", "656016\t" + tempo + "\t" + comp );
    }
}