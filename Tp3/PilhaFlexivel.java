import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Musica{

	private String nome;
	private String id; // 8
	private String key; // 10
	private String artists; // 3
	private Date realease_date; // 16
	private double acousticness; // 2
	private double danceability; // 4
	private double energy; // 6
	private int duration_ms; // 5
	private double instrumentalness; // 9
	private double valence; // 0
	private int popularity; // 15
	private float tempo; // 18
	private double liveness; // 11
	private double loudness; // 12
	private double speechiness; // 17
	private int year; // 1
    //-------------------------------------------------------------
	//Construtores
	//-------------------------------------------------------------
	public Musica(){
		this.id = ""; // 8
        this.nome = ""; // 14
		this.key = ""; // 10
	}
	public Musica(String[] values)throws ParseException{
		this.id = values[8]; // 8
		this.nome = values[14]; // 14
		this.key = values[10]; // 10
		this.acousticness = Double.parseDouble(values[2]); // 2
		this.danceability = Double.parseDouble(values[4]); // 4
		this.energy = Double.parseDouble(values[6]); // 6
		this.duration_ms = Integer.parseInt(values[5]); // 5
		this.instrumentalness = Double.parseDouble(values[9]); // 9
		this.valence = Double.parseDouble(values[0]); // 0
		this.popularity = Integer.parseInt(values[15]); // 15
		this.tempo = Float.parseFloat(values[18]); // 18
		this.liveness = Double.parseDouble(values[11]); // 11
		this.loudness = Double.parseDouble(values[12]); // 12
		this.speechiness = Double.parseDouble(values[17]); // 17
		this.year = Integer.parseInt(values[1]); // 1

		String artistsString = "";
		int i = 0;
		while (i < values[3].length()) {
			if (!(values[3].charAt(i) == 39 && (values[3].charAt(i - 1) == 91 || 
					values[3].charAt(i + 1) == 93 || values[3].charAt(i + 1) == 44 || 
					values[3].charAt(i - 2) == 44))) {
				artistsString += values[3].charAt(i);
			}
			i++;
		}
		artists = artistsString; // 3 ;
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		if (values[16].length() == 4) {
			realease_date = formato.parse(values[16] + "-01-01");
		} else if (values[16].length() == 7) {
			realease_date = formato.parse(values[16] + "-01");
		} else {
			realease_date = formato.parse(values[16]);
		}
	}
    //-------------------------------------------------------------
	//Sets, Gets
	//-------------------------------------------------------------
	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getNome(){
		return nome;
	}

	public void setName(String nome){
		this.nome = nome;
	}

	public String getKey(){
		return key;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getArtists(){
		return artists;
	}

	public void setArtists(String artists){
		this.artists = artists;
	}

	public Date getRealease(){
		return realease_date;
	}

	public void setRealease(Date realease_date){
		this.realease_date = realease_date;
	}

	public double getAcousticness(){
		return acousticness;
	}

	public void setAcousticness(double acousticness){
		this.acousticness = acousticness;
	}

	public double getDanceability(){
		return danceability;
	}

	public void setDanceability(double danceability){
		this.danceability = danceability;
	}

	public double getEnergy(){
		return energy;
	}

	public void setEnergy(double energy){
		this.energy = energy;
	}

	public int getDuration(){
		return duration_ms;
	}

	public void setDuration(int duration_ms){
		this.duration_ms = duration_ms;
	}

	public double getInstrumentalness(){
		return instrumentalness;
	}

	public void setInstrumentalness(double instrumentalness){
		this.instrumentalness = instrumentalness;
	}

	public double getValence(){
		return valence;
	}

	public void setValence(double valence){
		this.valence = valence;
	}

	public int getPopularity(){
		return popularity;
	}

	public void setPopularity(int popularity){
		this.popularity = popularity;
	}

	public float getTempo(){
		return tempo;
	}

	public void setTempo(float tempo){
		this.tempo = tempo;
	}

	public double getLiveness(){
		return liveness;
	}

	public void setLiveness(double liveness){
		this.liveness = liveness;
	}

	public double getLoudness(){
		return loudness;
	}

	public void setLoudness(double loudness){
		this.loudness = loudness;
	}

	public double getSpeechiness(){
		return speechiness;
	}

	public void setSpeechiness(double speechiness){
		this.speechiness = speechiness;
	}

	public int getYear(){
		return year;
	}

	public void setYear(int year){
		this.year = year;
	}
    //-------------------------------------------------------------
	//Clone
	//-------------------------------------------------------------
	public Musica clone(){
		Musica novo = new Musica();
		novo.nome = this.nome;
		novo.id = this.id;
		novo.key = this.key;
		novo.artists = this.artists;
		novo.realease_date = this.realease_date;
		novo.acousticness = this.acousticness;
		novo.danceability = this.danceability;
		novo.energy = this.energy;
		novo.duration_ms = this.duration_ms;
		novo.instrumentalness = this.instrumentalness;
		novo.valence = this.valence;
		novo.popularity = this.popularity;
		novo.tempo = this.tempo;
		novo.liveness = this.liveness;
		novo.loudness = this.loudness;
		novo.speechiness = this.speechiness;
		novo.year = this.year;
		return novo;
	}
    //-------------------------------------------------------------
	//Imprimir
	//-------------------------------------------------------------
		public void imprimir(){
		System.out.print(this.toString());
	}
    //-------------------------------------------------------------
	//toString()
	//-------------------------------------------------------------	
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return id + " ## " + artists.toString() + " ## " + nome + " ## " + sdf.format(realease_date) + " ## " + acousticness
				+ " ## " + danceability + " ## " + instrumentalness + " ## " + liveness + " ## " + loudness + " ## "
				+ speechiness + " ## " + energy + " ## " + duration_ms;
	}
    //-------------------------------------------------------------	
}

class Celula{

    public Musica musica;
    public Celula prox;
    //-------------------------------------------------------------
	//Construtores
	//-------------------------------------------------------------
    public Celula(){
        this(new Musica());
    }
    public Celula(Musica m){
        this.musica = m.clone();
        this.prox = null;
    }
}

class PilhaFlexivelSimples{

	private Celula topo;
    private Celula fundo;
    //-------------------------------------------------------------
	//Construtor
	//-------------------------------------------------------------
    public PilhaFlexivelSimples(){
        topo = new Celula();
        fundo = topo;
    }
    //-------------------------------------------------------------
	//Inserir
	//-------------------------------------------------------------
    public void inserir(Musica m){
        fundo.prox = new Celula(m);
        fundo = fundo.prox;
    }
    //-------------------------------------------------------------
	//Remover
	//-------------------------------------------------------------
    public void remover()throws Exception{
        if(isVazio())
            throw new Exception("Erro!");
        
        Celula i = topo;
        for(;i.prox != fundo;i = i.prox);

        Musica m = fundo.musica;
        fundo = i;
        i = fundo.prox = null;

        MyIO.println("(R) " + m.getNome());
    }
    //-------------------------------------------------------------
    //isVazio()
    //-------------------------------------------------------------
    private boolean isVazio(){ return topo == fundo; }
    //-------------------------------------------------------------
	//Mostrar
	//-------------------------------------------------------------
    public void mostrar(){
        int cont = 0;
        for(Celula i = topo.prox;i != fundo;i = i.prox, cont++){
            MyIO.print("[" + cont + "] ");
            i.musica.imprimir();
            MyIO.print("\n");
        }
    }
    //-------------------------------------------------------------
}   

class PilhaFlexivel{

	final static BufferedReader nt = new BufferedReader(new InputStreamReader(System.in));

    public static Musica cadastra(String dadosMusica) throws ParseException {
		int tamanhoString = 19;
        String campos[] = new String[tamanhoString];
		int j = 0;
		String temp = "";
		for (int i = 0; i < tamanhoString; i++) {
			temp = "";
			while (j < dadosMusica.length() && ((dadosMusica.charAt(j) != ',') || !(dadosMusica.charAt(j) == ',' && dadosMusica.charAt(j + 1) != ' '))) {
				if (dadosMusica.charAt(j) != '"')
					temp += dadosMusica.charAt(j);
				j++;
			}
			j++;
			campos[i] = temp;
		}
		Musica musica = new Musica(campos);
		
		return musica;
	}

	public static Musica[] montarClasse(int quantidade, String ids[], String totalMusicList[]) throws ParseException {
		Musica m[] = new Musica[quantidade];
		for (int i = 0; i < quantidade; i++) {
			for (int j = 0; j < totalMusicList.length; j++) {
				if (totalMusicList[j].contains(ids[i])) {
					String dadosMusic = totalMusicList[j];
					m[i] = cadastra(dadosMusic);
					j = totalMusicList.length;
				}
			}

		}
		return m;
	}

	public static int entradaPadrao(String ids[]) throws IOException {
		int i = 0;

		String linha = nt.readLine();
		while (!(linha.contains("FIM"))) {
			ids[i] = linha;
			i++;
			linha = nt.readLine();
		}
		return i;
	}

	public static String[] ler() throws Exception {
		final int TOTAL_MUSIC_NUMBER = 170625;
		String totalMusicList[] = new String[TOTAL_MUSIC_NUMBER];
		FileReader arquivo = new FileReader("data.csv"); // Teste interno
		//FileReader arquivo = new FileReader("/tmp/data.csv"); // Mandar para o VERDE
		BufferedReader ler = new BufferedReader(arquivo);
		String linha = ler.readLine();
		linha = ler.readLine();
		int i = 0;
		while (linha != null) {
			totalMusicList[i] = linha;
			linha = ler.readLine();
			i++;
		}
		arquivo.close();
		return totalMusicList;
	}

    public static boolean isInserir(char c){    return c == 'I';    }
    public static boolean isRemover(char c){    return c == 'R';    }

	public static void main(String args[]) throws Exception {

		String ids[] = new String[500];
		int playlistTam = entradaPadrao(ids);

		String totalMusicList[] = ler();
		Musica musicas[] = montarClasse(playlistTam, ids, totalMusicList);

		PilhaFlexivelSimples pilha = new PilhaFlexivelSimples();

		for(int i = 0;i < musicas.length;i++){
			pilha.inserir(musicas[i]);
		}

		String x = nt.readLine();
		int n = Integer.parseInt(x);

		for(int i = 0;i < n;i++){
			String in = nt.readLine();
			int pos = 0;
			if(isInserir(in.charAt(0))){
				//---------------------------------------
                //Separar Id do Inserir
                //---------------------------------------
                String id = "";
                for(int h = 2;h < in.length();h++){
                    id += in.charAt(h);
                }
                //---------------------------------------
                
                for(int j = 0;j < totalMusicList.length;j++){
                    if(totalMusicList[j].contains(id)){
                        pos = j;
                        j = totalMusicList.length;
                    }
                }
                
                Musica m = cadastra(totalMusicList[pos]);
                pilha.inserir(m);
			}
			if(isRemover(in.charAt(0))){
				pilha.remover();
			}
		}
		pilha.mostrar();
	}
}