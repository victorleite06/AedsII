import java.io.*;
import java.net.*;

class LeituraDePaginaHTML{

	public static String getHTML(String endereco){
		URL url;
		InputStream is = null;
		BufferedReader br;
		String resp = "", line;

		try{
			url = new URL(endereco);
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is));

			while((line = br.readLine()) != null){
				resp += line.toLowerCase() + "\n";
			}
		} catch(MalformedURLException mue){
			mue.printStackTrace();
		} catch(IOException ioe){
			ioe.printStackTrace();
		}

		try{
			is.close();
		} catch(IOException ioe){}
		
		return resp;
	}
	
	public static void main(String[] args){
		MyIO.setCharset("UTF-8");
		String nome,endereco, html;
		nome = MyIO.readLine();
		int cons = 0, a = 0, e = 0, i = 0, o = 0, u = 0, a1 = 0, e1 = 0, i1 = 0, o1 = 0, u1 = 0;
		int a2 = 0, e2 = 0, i2 = 0, o2 = 0, u2 = 0, a3 = 0, o3 = 0, a4 = 0, e3 = 0, i3 = 0, o4 = 0, u3 = 0;
		int br = 0, table = 0;
		while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
			endereco = MyIO.readLine();
			html = getHTML(endereco);
			for(int j = 0;j < html.length();j++){
				if(html.charAt(j) == 'a')
					a++;
				if(html.charAt(j) == 'e')
					e++;
				if(html.charAt(j) == 'i')
					i++;
				if(html.charAt(j) == 'o')
					o++;
				if(html.charAt(j) == 'u')
					u++;
				if(html.charAt(j) == 'á')
					a1++;
				if(html.charAt(j) == 'é')
					e1++;
				if(html.charAt(j) == 'í')
					i1++;
				if(html.charAt(j) == 'ó')
					o1++;
				if(html.charAt(j) == 'ú')
					u1++;
				if(html.charAt(j) == 'à')
					a2++;
				if(html.charAt(j) == 'è')
					e2++;
				if(html.charAt(j) == 'ì')
					i2++;
				if(html.charAt(j) == 'ò')
					o2++;
				if(html.charAt(j) == 'ù')
					u2++;
				if(html.charAt(j) == 'ã')
					a3++;
				if(html.charAt(j) == 'õ')
					o3++;
				if(html.charAt(j) == 'â')
					a4++;
				if(html.charAt(j) == 'ê')
					e3++;
				if(html.charAt(j) == 'î')
					i3++;
				if(html.charAt(j) == 'ô')
					o4++;
				if(html.charAt(j) == 'û')
					u3++;
				if(!(html.charAt(i) >= 'a' && html.charAt(i) <= 'z'))
					cons++;	
				if(html.charAt(j) == '<' && html.charAt(j+1) == 'b' && html.charAt(j+2) == 'r' && html.charAt(j+3) == '>'){
					br++;
					j = j + 3;
				}
				if(html.charAt(j) == '<' && html.charAt(j+1) == 't' && html.charAt(j+2) == 'a' && html.charAt(j+3) == 'b' && html.charAt(j+4) == 'l' && html.charAt(j+5) == 'e' && html.charAt(j+6) == '>'){
					table++;
					j = j + 6;
				}
			}
			MyIO.println("a(" + a + ") e(" + e + ") i(" + i + ") o(" + o + ") u(" + u + ") á(" + a1 + ") é(" + e1 + ") í(" +
					i1 + ") ó(" + o1 + ") ú(" + u1 + ") à(" + a2 + ") è(" + e2 + ") ì(" + i2 + ") ò(" + o2 + ") ù(" + u2 +
					") ã(" + a3 + ") õ(" + o3 + ") â(" + a4 + ") ê(" + e3 + ") î(" + i3 + ") ô(" + o4 + ") û(" + u3 + 
					") consoante(" + cons + ") <br>(" + br + ") <table>(" + table + ") " + nome);
			nome = MyIO.readLine();
		}
	}
}
