import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

class Musica{
//Declaração de variáveis 
//-------------------------------------------------------------
    private String id;
    private String nome;
    private String key;
    private String artista;
    private Date realease_date;
    private double acousticness;
    private double danceability;
    private double energy;
    private int duration_ms;
    private double instrumentalness;
    private double valence;
    private int popularity;
    private float tempo;
    private double liveness;
    private double loudness;
    private double speechiness;
    private int year;
//-------------------------------------------------------------
//Construtores da Classe
//-------------------------------------------------------------
    public Musica(String id,String nome,String key,double acousticness,double danceability,double energy, int duration_ms,double instrumentalness,double valence,int popularity,float tempo,double liveness,double loudness,double speechiness,int year,String date,String artista){
        this.id = id;
        this.nome = nome;
        this.key = key;
        this.acousticness = acousticness;
        this.danceability = danceability;
        this.energy = energy;
        this.duration_ms = duration_ms;
        this.instrumentalness = instrumentalness;
        this.valence = valence;
        this.popularity = popularity;
        this.tempo = tempo;
        this.liveness = liveness;
        this.loudness = loudness;
        this.speechiness = speechiness;
        this.year = year;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        this.realease_date = formato.parse(date);
        this.artista = artista;
    }

    public Musica(){
        Musica("","","",0,0,0,0,0,0,0,0,0,0,0,0,"1","");
    }
//-------------------------------------------------------------
//Sets e Gets
//-------------------------------------------------------------
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setKey(String key){
        this.key = key;
    }
    public String getKey(){
        return this.key;
    }
    public void setAcousticness(double acousticness){
        this.acousticness = acousticness;
    }
    public double getAcousticness(){
        return this.acousticness;
    }
    public void setDanceability(double danceability){
        this.danceability = danceability;
    }
    public double getDanceability(){
        return this.danceability;
    }
    public void setEnergy(double energy){
        this.energy = energy;
    }
    public double getEnergy(){
        return this.energy;
    }
    public void setDuration_ms(int duration_ms){
        this.duration_ms = duration_ms;
    }
    public int getDuration_ms(){
        return this.duration_ms;
    }
    public void setInstrumentalness(double instrumentalness){
        this.instrumentalness = instrumentalness;
    }
    public double getInstrumentalness(){
        return this.instrumentalness;
    }
    public void setValence(double valence){
        this.valence = valence;
    }
    public double getValence(){
        return this.valence;
    }
    public void setPopularity(int popularity){
        this.popularity = popularity;
    }
    public int getPopularity(){
        return this.popularity;
    }
    public void setTempo(float tempo){
        this.tempo = tempo;
    }
    public float getTempo(){
        return this.tempo;
    }
    public void setLiveness(double liveness){
        this.liveness = liveness;
    }
    public double getLiveness(){
        return this.liveness;
    }
    public void setLoudness(double loudness){
        this.loudness = loudness;
    }
    public double getLoudness(){
        return this.loudness;
    }
    public void setSpeechiness(double speechiness){
        this.speechiness = speechiness;
    }
    public double getSpeechiness(){
        return this.speechiness;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return this.year;
    }
    public void setRealease_date(String date){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.realease_date = formato.parse(date);
    }
    public Date getRealease_date(){
        return this.realease_date;
    }
    public void setArtista(String artista){
        this.artista = artista;
    }
    public String getArtista(){
        return this.artista;
    }
//-------------------------------------------------------------
//Clone
//-------------------------------------------------------------
    public Musica clone(){
        Musica mA = new Musica();
        mA.setAcousticness(this.acousticness);//3
        mA.setArtista(this.artista);//4
        mA.setDanceability(this.danceability);//5
        mA.setDuration_ms(this.duration_ms);//6
        mA.setEnergy(this.energy);//7
        mA.setId(this.id);//9
        mA.setInstrumentalness(this.instrumentalness);//10
        mA.setKey(this.key);//11
        mA.setLiveness(this.liveness);//12
        mA.setLoudness(this.loudness);//13
        mA.setNome(this.nome);//15
        mA.setPopularity(this.popularity);//16
        mA.setRealease_date(this.date);//17
        mA.setSpeechiness(this.speechiness);//18
        mA.setTempo(this.tempo);//19
        mA.setValence(this.valence);//1
        mA.setYear(this.year);//2
        return mA;
    }
//-------------------------------------------------------------
//Imprimir
//-------------------------------------------------------------
    public void imprimir(){
        MyIO.println(this.id + " ## " + this.artista + " ## " + this.nome + " ## " + this.realease_date +
        " ## " + this.acousticness + " ## " + this.danceability + " ## " + this.instrumentalness +
        " ## " + this.liveness + " ## " + this.loudness + " ## " + this.speechiness + " ## " + this.energy +
        " ## " + this.duration_ms);
    }
//-------------------------------------------------------------
}

class Classe{

    public static void lerArquivo(String arquivo,Musica m[]){
        try{
            Arq.openRead(arquivo);
            String in;
            int cont = -1;
            while(Arq.hasNext()){
                cont++;
                in = MyIO.readLine();
                montarClasse(in,m,cont);
            }
            Arq.close();
        }catch(Exception e){}
    }

    public static void montarClasse(String in,Musica m[],int cont){
            String aux[] = in.split(",");
            String aux1 = "",artista = "",nome = "";
            int x = 0,w;
            m[cont].setValence(Double.parseDouble(aux[x]));
            x++;
            m[cont].setYear(Integer.parseInt(aux[x]));
            x++;
            m[cont].setAcousticness(Double.parseDouble(aux[x]));
            x++;
            
            if(aux[x].charAt(0) == '['){
                w = x;
                while(aux[w].charAt(aux[w].length()-1) != ']'){ w++; }
                for(int i = x;i <= (w-x)+1;i++){
                    for(int j = 0;j < aux[i].length();j++){
                        aux1 += aux[i].charAt(j) + ',';
                    }
                }
                for(int i = 0;i < aux1.length()-1;i++){
                    artista += aux1.charAt(i);
                }
                m[cont].setArtista(artista);
                x = w+2;
            }else{
                m[cont].setArtista(aux[x]);
                x++;
            }

            m[cont].setDanceability(Double.parseDouble(aux[x]));
            x++;
            m[cont].setDuration_ms(Integer.parseInt(aux[x]));
            x++;
            m[cont].setEnergy(Double.parseDouble(aux[x]));
            x += 2;
            m[cont].setId(aux[x]);
            x++;
            m[cont].setInstrumentalness(Double.parseDouble(aux[x]));
            x++;
            m[cont].setKey(aux[x]);
            x++;
            m[cont].setLiveness(Double.parseDouble(aux[x]));
            x++;
            m[cont].setLoudness(Double.parseDouble(aux[x]));
            x++;
            
            aux1 = "";

            if(aux[x].charAt(0) == '"'){
                w = x;
                while(aux[w].charAt(aux[w].length()-1) != '"'){ w++; }
                for(int i = x;i <= (w-x)+1;i++){
                    for(int j = 0;j < aux[i].length();j++){
                        aux1 += aux[i].charAt(j) + ',';
                    }
                }
                for(int i = 0;i < aux1.length()-1;i++){
                    nome += aux1.charAt(i);
                }
                m[cont].setNome(nome);
                x = w+2;
            }else{
                m[cont].setNome(aux[x]);
                x++;
            }

            m[cont].setPopularity(Integer.parseInt(aux[x]));
            x++;
            m[cont].setRealease_date(aux[x]);
            x++;
            m[cont].setSpeechiness(Double.parseDouble(aux[x]));
            x++;
            m[cont].setTempo(Float.parseFloat(aux[x]));
    }

    public static void main(String[] args){
        String arquivo = "/temp/data.csv";
        Musica m[] = new Musica();
        lerArquivo(arquivo,m);
        for(int i = 0;i < m.length;i++){
            m[i].imprimir();
        }
    }
}