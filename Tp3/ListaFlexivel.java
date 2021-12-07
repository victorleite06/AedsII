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

class Celula{
    public Serie serie;
    public Celula prox;
    //------------------------------------------------------------------------------
    //Construtor
    //------------------------------------------------------------------------------
    public Celula(){
        this(new Serie());
    }
    public Celula(Serie s){
        this.serie = s.clone();
        this.prox = null;
    }
    //------------------------------------------------------------------------------
}

class Lista{
    private Celula primeiro, ultimo;
    //------------------------------------------------------------------------------
    //Construtores
    //------------------------------------------------------------------------------
    public Lista(){
        primeiro = new Celula();
        ultimo = primeiro;
    }
    //------------------------------------------------------------------------------
    //Inserir
    //------------------------------------------------------------------------------
    public void inserirInicio(Serie s){
        Celula tmp = new Celula(s);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if(primeiro == ultimo){
            ultimo = tmp;
        }
        tmp = null;
    }
    public void inserirFim(Serie s){
        ultimo.prox = new Celula(s);
        ultimo = ultimo.prox;
    }
    public void inserir(Serie s, int pos)throws Exception{
        int tamanho = 0;
        for(Celula i = primeiro;i != ultimo;i = i.prox, tamanho++);

        if(pos < 0 || pos > tamanho){
            throw new Exception("Erro!");
        }else if(posEqual0(pos)){
            inserirInicio(s);
        }else if(pos == tamanho){
            inserirFim(s);
        }else{
            Celula i = primeiro;
            for(int j = 0;j < pos;j++, i = i.prox);

            Celula tmp = new Celula(s);
            tmp.prox = i.prox;
            i.prox = tmp;
            tmp = i = null;
        }
    }
    //------------------------------------------------------------------------------
    //Remover
    //------------------------------------------------------------------------------
    public void removerInicio()throws Exception{
        if(isVazio()){
            throw new Exception("Erro!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        Serie s = primeiro.serie;
        tmp.prox = null;
        tmp = null;

        MyIO.println("(R) " + s.getNome());
    }
    public void removerFim()throws Exception{
        if(isVazio()){
            throw new Exception("Erro!");
        }

        Celula i = primeiro;
        for(;i.prox != ultimo;i = i.prox);

        Serie s = ultimo.serie;
        ultimo = i;
        i = ultimo.prox = null;

        MyIO.println("(R) " + s.getNome());
    }
    public void remover(int pos)throws Exception{
        int tamanho = 0;
        for(Celula i = primeiro;i != ultimo;i = i.prox, tamanho++);

        if(isVazio()){
            throw new Exception("Erro!");
        }else if(posEqual0(pos)){
            removerInicio();
        }else if(pos == tamanho - 1){
            removerFim();
        }else{
            Celula i = primeiro;
            for(int j = 0;j < pos;j++, i = i.prox);

            Celula tmp = i.prox;
            Serie s = tmp.serie;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;

            MyIO.println("(R) " + s.getNome());
        }
    }
    //------------------------------------------------------------------------------
    //isVazio e posEqual10
    //------------------------------------------------------------------------------
    private boolean isVazio(){ return primeiro == ultimo; }
    private boolean posEqual0(int pos){ return pos == 0; }
    //------------------------------------------------------------------------------
    //Mostrar
    //------------------------------------------------------------------------------
    public void mostrar(){
        for(Celula i = primeiro.prox;i != ultimo;i = i.prox){
            i.serie.imprimir();
        }
    }
    //------------------------------------------------------------------------------
}

class ListaFlexivel{
    public static void main(String args[])throws Exception{
        Serie series[] = new Serie[61];
        int cont = 0;
        String nomeArq = MyIO.readLine();
        Lista lista = new Lista();
        while(!(nomeArq.contains("FIM"))){
            series[cont] = new Serie();
            series[cont].ler(nomeArq);
            lista.inserirFim(series[cont]);
            cont++;
            nomeArq = MyIO.readLine();
        }

        int n = MyIO.readInt();

        for(int i = 0;i < n;i++){
            String in = MyIO.readLine();
            if(in.charAt(0) == 'I'){
                String aux[] = in.split(" ");
                if(in.charAt(1) == 'I'){
                    Serie s = new Serie();
                    s.ler(aux[1]);
                    lista.inserirInicio(s);
                }
                if(in.charAt(1) == 'F'){
                    Serie s = new Serie();
                    s.ler(aux[1]);
                    lista.inserirFim(s);
                }
                if(in.charAt(1) == '*'){
                    Serie s = new Serie();
                    s.ler(aux[2]);
                    int pos = Integer.parseInt(aux[1]);
                    lista.inserir(s, pos);
                }
            }
            if(in.charAt(0) == 'R'){
                if(in.charAt(1) == 'I'){
                    lista.removerInicio();
                }
                if(in.charAt(1) == 'F'){
                    lista.removerFim();
                }
                if(in.charAt(1) == '*'){
                    String aux[] = in.split(" ");
                    int pos = Integer.parseInt(aux[1]);
                    lista.remover(pos);
                }
            }
        }
        lista.mostrar();
    }
}