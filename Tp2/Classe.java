class Musica{
    private int id;
    private String nome;
    private String key;
    //artist(List)
    //realease_date(Date)
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
    
    public Musica(int id,String nome,String key,double acousticness,double danceability,double energy, int duration_ms,double instrumentalness,double valence,int popularity,float tempo,double liveness,double loudness,double speechiness,int year){
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
    }

}

class Classe{
    public static void main(String[] args){

    }
}