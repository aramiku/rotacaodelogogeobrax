package com.saiko.geobraxlogorotation;

/*
 * 2013 Saiko Software
 *
 * Desenvolvido por Maro Aur�lio Bueno
 * Cubo que rotaciona :
 * Usando da f�rmula de rota��o de pontos no espa�o 3D
 * gira-se um cubo dadas suas coordenadas .
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;

public class GeobraxRotacionar extends Activity {
	// Representacao de um cubo no espa�o 3D
	Ponto3D[] pts = new Ponto3D[80000] ;
	Face[] fcs = new Face[60000];
	DrawView drawView ;
	Random rand = new Random();
	// distancia do olho at� a tela
	int f = 200; // Distancia 
	int tReDraw = 10;// padrao = 60
	// intervalo de rotacao em graus
	Double graus = -1.0;
	Double grausIncrement = 0.0;
	Double graus2 = 0.0;
	
	private int X = 0;
	private int Y = 0;
	private final Handler mHandler = new Handler();
    private final Runnable mDrawCube = new Runnable() {
        public void run() {
        	giraCubo();
            
        }
    };
    //Find the directory for the SD Card using the API
	//*Don't* hardcode "/sdcard"
	//File sdcard = new File("/storage/emulated/0/Ringtones");//S4
	File sdcard = Environment
			.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES); // tablet Alberto 2.3
    
    //String pathu = Environment.getExternalStorageDirectory().getPath();// xperia S
    //Log.d("getExternal()",pathu);
    //File sdcard = new File(pathu);// xperia S
	//Get the text file
	//File file = new File(sdcard,"verticesandedges.txt");
	File file = new File(sdcard,"marcoandmislene3d.txt");
	//Read text from file
	StringBuilder text = new StringBuilder();
	BufferedReader br;
	String line;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_geobrax_rotacionar);
		
		// cira��o de um cubo no espa�o 3D
		pts[0] = new Ponto3D(332.1290, 067.0315, 140.4233);
		learquivo();
		Log.d("Depois de ","learquivo()");

        drawView = new DrawView(this,this.fcs,this.pts);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);
        //giraCubo();
        
        
	}
	public void giraCubo(){
		//this.logo.giraCuboXGraus(graus);
		//plotaCubo();
		
		graus = graus + grausIncrement;
		if(graus > 180){
			graus = grausIncrement;
			Log.d("graus foi para", Double.toString(graus));
		}
		drawView.giraCuboXGraus2(graus);
		//drawView.move(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
		drawView.invalidate();
        mHandler.removeCallbacks(mDrawCube);
        mHandler.postDelayed(mDrawCube, tReDraw);
        
        //Log.e("logo ponto A.xt",Double.toString(logo.A.xt));
        //Log.e("logo ponto A.yt",Double.toString(logo.A.yt));
	}
	public void giraCubo2(){
		//this.logo.giraCuboXGraus(graus);
		//plotaCubo();
		
		graus = graus + grausIncrement;
		if(graus > 180){
			graus2 = grausIncrement;
			Log.d("graus foi para", Double.toString(graus));
		}
		drawView.giraCuboXGraus2(graus);
		//drawView.move(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
		drawView.invalidate();
        //mHandler.removeCallbacks(mDrawCube);
        //mHandler.postDelayed(mDrawCube, tReDraw);
        
        //Log.e("logo ponto A.xt",Double.toString(logo.A.xt));
        //Log.e("logo ponto A.yt",Double.toString(logo.A.yt));
	}
	//@Override
	public boolean onTouchEvent(MotionEvent event) {
		int eventaction = event.getAction(); 
		if(eventaction == MotionEvent.ACTION_DOWN){
			if(event.getX() > X){
				Log.d("girou para" , "girou X");
				giraCubo();
			}
		}else{
			if(event.getY() > Y){
				Log.d("girou para " , "girou Y");
				giraCubo2();
			}
		}
		
        X = (int)event.getX(); 
        Y = (int)event.getY(); 
		
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.geobrax_rotacionar, menu);
		return true;
	}
	class LogoGeobrax{
		/*
		 *	Rotacionar Cubo Sem o Uso De Bibliotecas Open GL ou Outra Qualquer.
		 *  
		 *  2013 Saiko Software
		 *
		 * Desenvolvido por Maro Aur�lio Bueno
		 *
		 *
		 * Normal Shader
		 * 
		 *         | z
		 *         |
		 *         |E_________ F
		 *        /|        /|
		 *    A  /_|_______/B|
		 *      |  |       | |
		 *      |  |       | |
		 *      |  |G________|_H_______y__
		 *      | /        | /
		 *     C|/_________|/D
		 *      /
		 *     /
		 *    / x  
		 * 
		 *
		 * O que está na frente sobrepor aos de traz
		 * ordenar de acordo com tamanho do z e seguir a orde para plotar.
		 *
		 *
		 */
		public Ponto3D[] ptsins ;
		public Linha2D[] linhasins ;

		
	}
	private void learquivo(){
		try {
		    br = new BufferedReader(new FileReader(file));
		}
		catch (IOException e) {
		    //You'll need to add proper error handling here
			e.printStackTrace();
			
		}
		try{
			int contpts = 1;
			int contfcs = 1;
			while((line = br.readLine()) != null){
				
				//Log.d("readLine",line);
				String[] separated = line.split("\\ ");
				//Log.d("tipo = ", separated[0]);

				
				//Log.d("antes if", "equ");
				if(separated[0].equals("v")){
					//Log.d("vertice {"," x= "+ separated[1] + " y= " + separated[2] + " z= " + separated[3]+" }");
					// Multiplica por 600 para posicionar o logo mais no meio da tela, ela pode ter 1920x1080 por isto somando 600 dá o meio da tela mais ou menos.
					// fcs[] , cada um guarda os indices dos pontos que formam uma face, o objeto 3D é formado por faces que são os triânguos e retângulos .
					// sistema wavefront
					//v  x  y  z
					//v 12 21 23    //indice 1
					//v 78 39 20    //indice 2
					//v 19 02 83    //indice 3
					//v 02 03 91    //indice 4

					//f  1 2 3 4     // face formado pelos pontos acima
					/*

					Double xvai  = (Double.parseDouble(separated[1]) * Math.cos()) +  (pointsins[fcs[i].pto1].z * mathsing);

					pointsins[fcs[i].pto1].yt =  pointsins[fcs[i].pto1].y  ;

					pointsins[fcs[i].pto1].zt = (pointsins[fcs[i].pto1].z * mathcosg) - (pointsins[fcs[i].pto1].x * mathsing) ;

					 */

					// pts3D [ f[1].1 ].x = 12
					// pts3D [ f[1].1 ].y = 21

					int grausx = -90;   //   _
					int grausy = 0;   //   /
					int grausz = 0;    //    |

					// Gira no eixo x
					Double xvai  = Double.parseDouble(separated[1])  ;

					Double yvai = ((Double.parseDouble(separated[2]) * Math.cos(Math.toRadians(grausx))) -  (Double.parseDouble(separated[3]) * Math.sin( Math.toRadians(grausx) ))) ;

					Double zvai  = (Double.parseDouble(separated[2]) * Math.sin(Math.toRadians(grausx))) + (Double.parseDouble(separated[3]) * Math.cos(Math.toRadians(grausx))) ;


					// Gira no eixo y
					Double xvai2  = ((zvai * Math.sin(Math.toRadians(grausy))) +  (xvai * Math.cos( Math.toRadians(grausy) ))) ;

					Double yvai2 = (yvai)  ;

					Double zvai2  = (zvai * Math.cos(Math.toRadians(grausy))) - (xvai * Math.sin(Math.toRadians(grausy))) ;


					// Gira no eixo z
					Double xvai3  = ((xvai2 * Math.cos(Math.toRadians(grausz))) -  (yvai2 * Math.sin( Math.toRadians(grausz) ))) ;

					Double yvai3 = (xvai2 * Math.sin(Math.toRadians(grausz))) + (yvai2 * Math.cos(Math.toRadians(grausz))) ;

					Double zvai3  = zvai2;



					pts[contpts] = new Ponto3D(xvai3,yvai3,zvai3);

					//pts[contpts] = new Ponto3D(Double.parseDouble(separated[1])+1.5,(Double.parseDouble(separated[2])+1.5),(Double.parseDouble(separated[3])));

					//Log.d("Depois criar ponto","ufa");
					contpts++;
				}else{
					if(separated[0].equals("f")){
						Log.d("dentro de","if de faces");
						if(separated.length == 5){
							String pt1 = separated[1];
							String[] ptsp1 = pt1.split("//");
							String pt2 = separated[2];
							String[] ptsp2 = pt2.split("//");
							String pt3 = separated[3];
							String[] ptsp3 = pt3.split("//");
							String pt4 = separated[4];
							String[] ptsp4 = pt4.split("//");

							//Log.d("fcscheck", "line " + line + "  spl : " + ptsp1[0] + " _ " + ptsp2[0] + " _ " + ptsp3[0] + " _ " + ptsp4[0]);
							fcs[contfcs] = new Face(Integer.parseInt(ptsp1[0]),Integer.parseInt(ptsp2[0]),Integer.parseInt(ptsp3[0]),Integer.parseInt(ptsp4[0]),4);
						}else{
							String pt1 = separated[1];
							String[] ptsp1 = pt1.split("//");
							String pt2 = separated[2];
							String[] ptsp2 = pt2.split("//");
							String pt3 = separated[3];
							String[] ptsp3 = pt3.split("//");
							//String pt4 = separated[4];
							//String[] ptsp4 = pt1.split("//");

							fcs[contfcs] = new Face(Integer.parseInt(ptsp1[0]),Integer.parseInt(ptsp2[0]),Integer.parseInt(ptsp3[0]),3);
						}
						contfcs++;
					}
				}
				
			}
			Log.d("Saiu do while ","carregaVerticesEPlanos()");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
