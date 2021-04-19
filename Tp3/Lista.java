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

class ListaSimples{

	private Musica musicas[];
	private int n;

	//-------------------------------------------------------------
	//Construtores
	//-------------------------------------------------------------
	public ListaSimples(){
		this(6);
	}
	public ListaSimples(int tamanho){
		musicas = new Musica[tamanho];
		n = 0;
	}
	//-------------------------------------------------------------
	//Inserir Inicio, Fim e em uma posição
	//-------------------------------------------------------------
	public void inserirInicio(Musica m)throws Exception{
		if(n >= musicas.length)
			throw new Exception("Erro!");

		for(int i = n;i > 0;i--)
			musicas[i] = musicas[i-1];

		musicas[0] = m.clone();
		n++;
	}
	public void inserirFim(Musica m)throws Exception{
		if(n >= musicas.length)
			throw new Exception("Erro!");

		musicas[n] = m.clone();
		n++;
	}
	public void inserir(Musica m,int pos)throws Exception{
		if(n >= musicas.length || pos < 0 || pos > n)
			throw new Exception("Erro!");

		for(int i = n;i > pos;i--)
			musicas[i] = musicas[i-1];

		musicas[pos] = m.clone();
		n++;
	}
	//-------------------------------------------------------------
	//Remover Inicio, Fim e em uma posição
	//-------------------------------------------------------------
	public void removerInicio()throws Exception{
		if(n == 0)
			throw new Exception("Erro!");

		Musica m = musicas[0];
		n--;

		for(int i = 0;i < n;i++)
			musicas[i] = musicas[i+1];

		MyIO.println("(R) " + m.getNome());
	}
	public void removerFim()throws Exception{
		if(n == 0)
			throw new Exception("Erro!");

		MyIO.println("(R) " + musicas[n-1].getNome());
		n--;
	}
	public void remover(int pos)throws Exception{
		if(n == 0 || pos < 0 || pos > n)
			throw new Exception("Erro!");
		
		Musica m = musicas[pos];
		n--;

		for(int i = pos;i < n;i++)
			musicas[i] = musicas[i+1];

		MyIO.println("(R) " + m.getNome());
	}
	//-------------------------------------------------------------
	//Mostrar
	//-------------------------------------------------------------
	public void mostrar(){
		for(int i = 0;i < n;i++){
			MyIO.print("[" + i + "] ");
			musicas[i].imprimir();
			MyIO.print("\n");
		}
	}
	//-------------------------------------------------------------
}

class Lista{
	
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
		FileReader arquivo = new FileReader("data.csv");
		//FileReader arquivo = new FileReader("/tmp/data.csv");
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

	public static void main(String args[]) throws Exception {

		String ids[] = new String[500];
		int playlistTam = entradaPadrao(ids);

		String totalMusicList[] = ler();
		Musica musicas[] = montarClasse(playlistTam, ids, totalMusicList);

		ListaSimples lista = new ListaSimples(200);

		for(int i = 0;i < musicas.length;i++){
			lista.inserirFim(musicas[i]);
		}

		String x = nt.readLine();
		int n = Integer.parseInt(x);

		for(int i = 0;i < n;i++){
			String in = nt.readLine();
			int pos = 0;
			if(in.charAt(0) == 'I'){
				String aux[] = in.split(" ");
				if(in.charAt(1) == 'I'){
					for(int j = 0;j < totalMusicList.length;j++){
						if(totalMusicList[j].contains(aux[1])){
							pos = j;
							j = totalMusicList.length;
						}
					}
					Musica m = cadastra(totalMusicList[pos]);
					lista.inserirInicio(m);
				}
				if(in.charAt(1) == 'F'){
					for(int j = 0;j < totalMusicList.length;j++){
						if(totalMusicList[j].contains(aux[1])){
							pos = j;
							j = totalMusicList.length;
						}
					}
					Musica m = cadastra(totalMusicList[pos]);
					lista.inserirFim(m);
				}
				if(in.charAt(1) == '*'){
					for(int j = 0;j < totalMusicList.length;j++){
						if(totalMusicList[j].contains(aux[2])){
							pos = j;
							j = totalMusicList.length;
						}
					}
					Musica m = cadastra(totalMusicList[pos]);
					lista.inserir(m,Integer.parseInt(aux[1]));
				}
			}
			if(in.charAt(0) == 'R'){
				if(in.charAt(1) == 'I')
					lista.removerInicio();
				if(in.charAt(1) == 'F')
					lista.removerFim();
				if(in.charAt(1) == '*'){
					String aux[] = in.split(" ");
					lista.remover(Integer.parseInt(aux[1]));
				}
			}
		}
		lista.mostrar();
	}
}