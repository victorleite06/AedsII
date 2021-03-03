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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.realease_date = formato.parse(date);
        this.artista = artista;
    }
    public Musica(){
        Musica("","","",0,0,0,0,0,0,0,0,0,0,0,0,"","");
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
}

class Classe{
    public static void main(String[] args){

    }
}