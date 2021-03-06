import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

class Musica{
//Declaração de variáveis 
//-------------------------------------------------------------
    private String id;
    private String nome;
    private String key;
    private String artista[];
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
    public Musica(String id,String nome,String key,double acousticness,double danceability,double energy, int duration_ms,double instrumentalness,double valence,int popularity,float tempo,double liveness,double loudness,double speechiness,int year,String date,String artista[]){
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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.realease_date = formato.parse(date);
        for(int i = 0;i < artista.length;i++)
            this.artista[i] = artista[i];
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
    public void setArtista(String artista[]){
        for(int i = 0;i < artista.length;i++)
            this.artista[i] = artista[i];
    }
    public void setArtista(String artista){
        this.artista[0] = artista;
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
        String artista = "[";
        String aux[] = getArtista();
        artista += aux[0];
        for(int i = 1;i < aux.length;i++){
            artista += ", " + aus[i];
        }
        artista += "]";
        MyIO.println(this.id + " ## " + artista + " ## " + this.nome + " ## " + this.realease_date +
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
        String aspas = (char)(34);
        //-------------------------------------------
        //Adicionando na classe os artistas
        if(aux[3].charAt(0) == aspas){
            String auxArt[] = in.split(aspas);
            String artista[] = auxArt[1].split(",");
            m[cont].setArtista(artista);
        }else{
            m[cont].setArtista(aux[3]);
        }
        //-------------------------------------------
        //Reescrever "in" retirando os artistas
        in = reescritaIn(in);
        //-------------------------------------------
        //Adicionando na classe o nome
        String aux1 = in.split(",");
        if(aux1[13].charAt(0) == aspas){
            String aux2[] = in.split(aspas);
            m[cont].setNome(aux2[1]);
        }else{
            m[cont].setNome(aux1[13]);
        }
        //-------------------------------------------
        //Reescrever "in" retirando o nome
        in = reescritaIn(in);
        //-------------------------------------------

    }

    public static String reescritaIn(String in){
        String aux = "";
        String newIn = "";
        String aspas = (char)(34);
        String array[] = in.split(aspas);
        for(int i = 0;i < array.length;i++){
            if(i != 1){
                aux += array[i] + ", ";
            }
        }
        for(int i = 0;i < aux.length()-1;i++){
            newIn = aux.charAt(i);
        }
        return newIn;
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