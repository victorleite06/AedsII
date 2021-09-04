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
    
    public void ler(String Arqu){
        String nomeArq = "/tmp/series/" + Arqu; // Verde
        //String nomeArq = Arqu; // Teste

        String in;
        String resp = "";

        Arq.openRead(nomeArq);
        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("firstHeading")){
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<' && in.charAt(i+1) == 'i' && in.charAt(i+2) == '>'){
                        int k = i+3;
                        for(;k < in.length() && in.charAt(k) != '<';k++){
                            resp += in.charAt(k);
                        }
                    }
                }
                setNome(resp);
            }
        }
        Arq.close();
        
        Arq.openRead(nomeArq);
        resp = "";
        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("Formato<")){
                in = Arq.readLine();
                boolean aberto = false;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = true;
                    }else if(in.charAt(i) == '>'){
                        aberto = false;
                    }
                    if(!aberto){
                        resp += in.charAt(i);
                    }
                }
                String aux = "";
                for(int j = 2;j < resp.length()-2;j++){
                    if(resp.charAt(j) != '<' && resp.charAt(j) != '>'){
                        aux += resp.charAt(j);
                    }
                }
                setFormato(aux);
            }
        }
        Arq.close();

        Arq.openRead(nomeArq);
        resp = "";
        while(Arq.hasNext()){
            in = Arq.readLine();
            //String cond = ">Dura"+(char)(135)+(char)(198)+"o<";
            //if(in.contains(">Duração<")){
            //if(in.contains(">Dura"+(char)(135)+(char)(198)+"o<")){
            if(in.contains(">Dura")){
                in = Arq.readLine();
                boolean aberto = false;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = true;
                    }else if(in.charAt(i) == '>'){
                        aberto = false;
                    }
                    if(!aberto){
                        resp += in.charAt(i);
                    }
                }
                String aux = "";
                for(int j = 1;j < resp.length()-1;j++){
                    if(resp.charAt(j) != '<' && resp.charAt(j) != '>'){
                        aux += resp.charAt(j);
                    }
                }
                setDuracao(aux);
            }
        }
        Arq.close();

        Arq.openRead(nomeArq);
        resp = "";
        while(Arq.hasNext()){
            in = Arq.readLine();
            //if(in.contains("País de origem<")){
            if(in.contains("s de origem<")){
                in = Arq.readLine();
                boolean aberto = false;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = true;
                    }else if(in.charAt(i) == '>'){
                        aberto = false;
                    }
                    if(!aberto){
                        resp += in.charAt(i);
                    }
                }
                String aux = "";
                boolean pontoVirg = false;
                for(int j = 2;j < resp.length()-1;j++){
                    if(resp.charAt(j) == ';'){
                        pontoVirg = true;
                        j += 2;
                    }
                    if(pontoVirg){
                        if(resp.charAt(j) != '<' && resp.charAt(j) != '>'){
                            aux += resp.charAt(j);
                        }
                    }
                }
                setPaisOrigem(aux);
            }
        }
        Arq.close();

        Arq.openRead(nomeArq);
        resp = "";
        while(Arq.hasNext()){
            in = Arq.readLine();
            if(in.contains("Idioma original<")){
                in = Arq.readLine();
                boolean aberto = false;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = true;
                    }else if(in.charAt(i) == '>'){
                        aberto = false;
                    }
                    if(!aberto){
                        resp += in.charAt(i);
                    }
                }
                String aux = "";
                for(int j = 2;j < resp.length()-2;j++){
                    if(resp.charAt(j) != '<' && resp.charAt(j) != '>'){
                        aux += resp.charAt(j);
                    }
                }
                setIdiomaOrigem(aux);
            }
        }
        Arq.close();

        Arq.openRead(nomeArq);
        resp = "";
        while(Arq.hasNext()){
            in = Arq.readLine();
            //if(in.contains("Emissora de televisão original<")){
            if(in.contains("Emissora de televis") && in.contains("original<")){
                in = Arq.readLine();
                boolean aberto = false;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = true;
                    }else if(in.charAt(i) == '>'){
                        aberto = false;
                    }
                    if(!aberto){
                        resp += in.charAt(i);
                    }
                }
                String aux = "";
                for(int j = 2;j < resp.length()-2;j++){
                    if(resp.charAt(j) != '<' && resp.charAt(j) != '>'){
                        aux += resp.charAt(j);
                    }
                }
                setEmissoraTV(aux);
            }
        }
        Arq.close();

        Arq.openRead(nomeArq);
        resp = "";
        while(Arq.hasNext()){
            in = Arq.readLine();
            //if(in.contains("Transmissão original<")){
            if(in.contains("Transmiss") && in.contains("original<")){
                in = Arq.readLine();
                boolean aberto = false;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = true;
                    }else if(in.charAt(i) == '>'){
                        aberto = false;
                    }
                    if(!aberto){
                        resp += in.charAt(i);
                    }
                }
                String aux = "";
                String aux1[] = resp.split("&#160;");
                String aux2 = "";
                for(int l = 0;l < aux1.length;l++){
                    if(l == 1){
                        for(int k = 10;k < aux1[l].length();k++){
                            aux += aux1[l].charAt(k);
                        }
                    }else{
                    aux += aux1[l];
                    }
                }
                for(int j = 0;j < aux.length()-1;j++){
                    if(aux.charAt(j) != '<' && aux.charAt(j) != '>' && aux.charAt(j) != '(' && aux.charAt(j) != ')'){
                        aux2 += resp.charAt(j);
                    }
                }
                setTransmissaoOrigem(aux2);
            }
        }
        Arq.close();

        /*Arq.openRead(nomeArq);
        resp = "";
        while(Arq.hasNext()){
            in = Arq.readLine();
            //if(in.contains("N.º de temporadas<")){
            if(in.contains(" de temporadas<")){
                in = Arq.readLine();
                boolean aberto = false;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = true;
                    }else if(in.charAt(i) == '>'){
                        aberto = false;
                    }
                    if(!aberto){
                        resp += in.charAt(i);
                    }
                }
                String aux = "";
                if(resp != ""){
                    for(int j = 1;j < resp.length()-1;j++){
                        if(resp.charAt(j) != '<' && resp.charAt(j) != '>'){
                            aux += resp.charAt(j);
                        }
                    }
                }else{
                    aux = "0";
                }
                setNumTemp(Integer.parseInt(aux));
            }
        }
        Arq.close();

        Arq.openRead(nomeArq);
        resp = "";
        while(Arq.hasNext()){
            in = Arq.readLine();
            //if(in.contains("N.º de episódios<")){
            if(in.contains(" de episódios<")){
                in = Arq.readLine();
                boolean aberto = false;
                for(int i = 0;i < in.length();i++){
                    if(in.charAt(i) == '<'){
                        aberto = true;
                    }else if(in.charAt(i) == '>'){
                        aberto = false;
                    }
                    if(!aberto){
                        resp += in.charAt(i);
                    }
                }
                String aux = "";
                if(resp != ""){
                    for(int j = 1;j < resp.length()-1;j++){
                        if(resp.charAt(j) != '<' && resp.charAt(j) != '>'){
                            aux += resp.charAt(j);
                        }
                    }
                }else{
                    aux = "0";
                }
                setNumEp(Integer.parseInt(aux));
            }
        }
        Arq.close();*/
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