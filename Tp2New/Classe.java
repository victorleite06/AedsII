import java.io.*;
import java.net.*;

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
    
    public void ler(String nomeArq){
        Arq.openRead(nomeArq);
        String in;
        String resp = "";

        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("<title>")){
                boolean aberto = true;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = false;
                    }else if(in.charAt(i-1) == '>'){
                        aberto = true;
                    }
                    if(aberto){
                        resp += in.charAt(i);
                    }
                }
                String aux[] = resp.split(" – ");
                setFormato(aux[0]);
            }
        }

        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("Formato")){
                in = Arq.readLine();
                boolean aberto = true;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = false;
                    }else if(in.charAt(i-1) == '>'){
                        aberto = true;
                    }
                    if(aberto){
                        resp += in.charAt(i);
                    }
                }
                setFormato(resp);
            }
        }

        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("Duração")){
                in = Arq.readLine();
                boolean aberto = true;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = false;
                    }else if(in.charAt(i-1) == '>'){
                        aberto = true;
                    }
                    if(aberto){
                        resp += in.charAt(i);
                    }
                }
                setDuracao(resp);
            }
        }

        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("País de origem")){
                in = Arq.readLine();
                boolean aberto = true;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = false;
                    }else if(in.charAt(i-1) == '>'){
                        aberto = true;
                    }
                    if(aberto){
                        resp += in.charAt(i);
                    }
                }
                setPaisOrigem(resp);
            }
        }

        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("Idioma original")){
                in = Arq.readLine();
                boolean aberto = true;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = false;
                    }else if(in.charAt(i-1) == '>'){
                        aberto = true;
                    }
                    if(aberto){
                        resp += in.charAt(i);
                    }
                }
                setIdiomaOrigem(resp);
            }
        }

        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("Emissora de televisão original")){
                in = Arq.readLine();
                boolean aberto = true;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = false;
                    }else if(in.charAt(i-1) == '>'){
                        aberto = true;
                    }
                    if(aberto){
                        resp += in.charAt(i);
                    }
                }
                setEmissoraTV(resp);
            }
        }

        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("Transmissão original")){
                in = Arq.readLine();
                boolean aberto = true;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = false;
                    }else if(in.charAt(i-1) == '>'){
                        aberto = true;
                    }
                    if(aberto){
                        resp += in.charAt(i);
                    }
                }
                setTransmissaoOrigem(resp);
            }
        }

        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("N.º de temporadas")){
                in = Arq.readLine();
                boolean aberto = true;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = false;
                    }else if(in.charAt(i-1) == '>'){
                        aberto = true;
                    }
                    if(aberto){
                        resp += in.charAt(i);
                    }
                }
                setNumTemp(Integer.parseInt(resp));
            }
        }

        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("N.º de episódios")){
                in = Arq.readLine();
                boolean aberto = true;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = false;
                    }else if(in.charAt(i-1) == '>'){
                        aberto = true;
                    }
                    if(aberto){
                        resp += in.charAt(i);
                    }
                }
                setNumEp(Integer.parseInt(resp));
            }
        }
        
        Arq.close();
    }

    //------------------------------------------------------------------------------
    //Imprimir
    public void imprimir(){
        MyIO.print(nome + " " + formato + " " + duracao + " " + paisOrigem + " " + idiomaOrigem + " " + emissoraTV + " " + trasmissaoOriginal + " " + numTemp + " " + numEp + "\n");
    }
    //------------------------------------------------------------------------------
}

class Classe{
    public static void main(String args[]){
        Serie series[] = new Serie[61];
        int cont = 0;
        String nomeArq = MyIO.readLine();
        while(!(nomeArq.contains("FIM"))){
            series[cont] = new Serie();
            series[cont].ler(nomeArq);
            cont++;
            nomeArq = MyIO.readLine();
        }

        for(int i = 0;i < series.length;i++){
            series[i].imprimir();
        }
    }
}