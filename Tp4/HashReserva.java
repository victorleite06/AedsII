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
    private Hash hash;

    //------------------------------------------------------------------------------
    //Construtor
    //------------------------------------------------------------------------------
    public Array(){
        this(100);
    }
    public Array(int tamanho){
        series = new Serie[tamanho];
        hash = new Hash(21, 9);
        this.tamanho = 0;
    }
    //------------------------------------------------------------------------------
    //Preencher
    //------------------------------------------------------------------------------
    public Hash preencher()throws Exception{
        int cont = 0;
        String nomeArq = MyIO.readLine();
        while(!(nomeArq.contains("FIM"))){
            series[cont] = new Serie();
            series[cont].ler(nomeArq);
            hash.inserir(series[cont]);
            cont++;
            tamanho++;
            nomeArq = MyIO.readLine();
        }
        return hash;
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

class Hash{
    private int comp;
    private int tamanho;
    private int reserva;
    private int contReserva;
    private Serie series[];
    //------------------------------------------------------------------------------
    //Construtor
    //------------------------------------------------------------------------------
    public Hash(int tamanho, int reserva){
        comp = contReserva = 0;
        this.tamanho = tamanho;
        this.reserva = reserva;
        series = new Serie[tamanho + reserva];
    }
    //------------------------------------------------------------------------------
    //Get e hash
    //------------------------------------------------------------------------------
    public int getComp(){ return comp; }
    private int hash(String s){ return s.charAt(0) % tamanho; }
    //------------------------------------------------------------------------------
    //Inserir
    //------------------------------------------------------------------------------
    public void inserir(Serie s)throws Exception{
        int i = hash(s.getNome());
        if(s.getNome() == null){
            throw new Exception("Erro!");
        }else if(series[i] == null){
            series[i] = s;
        }else if(contReserva < reserva){
            series[tamanho + contReserva] = s;
            contReserva++;
        }else{
            throw new Exception("Erro!");
        }
    }
    //------------------------------------------------------------------------------
    //Pesquisar
    //------------------------------------------------------------------------------
    public boolean pesquisar(String nome){
        boolean resp = false;
        int i = hash(nome);
        if(series[i].getNome().equals(nome)){
            comp++;
            resp = true;
        }else if(series[i] != null){
            for(int j = 0;j < reserva;j++){
                if(series[tamanho + i].getNome().equals(nome)){
                    resp = true;
                    comp++;
                    j = reserva;
                }
            }
        }
        return resp;
    }
    //------------------------------------------------------------------------------
}

class HashReserva{
    public static void main(String[] args)throws Exception{
        MyIO.setCharset("UTF-8");
        long inicio = System.currentTimeMillis();
        Array array = new Array();
        Hash hash = new Hash(21, 9);
        hash = array.preencher();
        String pesq = MyIO.readLine();
        while(!(pesq.equals("FIM"))){
            if(hash.pesquisar(pesq)){
                MyIO.println(" SIM");
            }else{
                MyIO.println(" NAO");
            }
            pesq = MyIO.readLine();
        }
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        int comp = hash.getComp();
        Arq arquivo = new Arq();
        arquivo.openWriteClose("656016_hashReserva.txt", "656016\t" + tempo + "\t" + comp );
    }
}