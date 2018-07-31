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
	Ponto3D[] pts = new Ponto3D[8000] ;
	int quantidadeDePontos = 0;
	Face[] fcs = new Face[6000];
	int quantidadeDeFaces = 0;
	Linha2D[] linhaspass;
	LogoGeobrax logo ;
	DrawView drawView ;
	Random rand = new Random();
	// distancia do olho at� a tela
	int f = 200; // Distancia 
	int tReDraw = 10;// padrao = 60
	// intervalo de rotacao em graus
	Double graus = 0.0;
	Double grausIncrement = -0.05;
	Double graus2 = 0.0;
	
	private int X = 0;
	private int Y = 0;
	private final Handler mHandler = new Handler();
    private final Runnable mDrawCube = new Runnable() {
        public void run() {
        	//giraCubo();
            
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
	File file = new File(sdcard,"verticesandedges.txt");
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
		
		/*pts[2] = new Ponto3D(331.0019, 067.0297, 139.7767);*/

		
		//logo = new LogoGeobrax(pts);
		
		
        drawView = new DrawView(this,this.fcs,this.pts);
        //drawView.setFaces(this.fcs);
        //drawView.setPoints(this.pts);
        
        //Face[] fcs;
        
        
        
        //drawView.linhas = linhaspass;
        //drawView.move(0, 0, 20, 20, 20, 0, 0, 20);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);
        giraCubo();
        
        
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
	public void plotaCubo(){
		// apos fazer o logo girar x graus por meio de
		// trasforma��o de rotacao 
		// trasforma os pontos de 3D para 2D para exibir
		
		// AB � uma linha no plano 2D formada por Ponto A(xini,yini) e B(xfim,yfim) 
		
		/*Double xiniaux;Double xfimaux;Double yiniaux;Double yfimaux;
		xiniaux = (f/logo.A.z)*logo.A.x;
		yiniaux = (f/logo.A.z)*logo.A.y;
		xfimaux = (f/logo.B.z)*logo.B.x;     newx1 / (4 - newz1 / 400);
		yfimaux = (f/logo.B.z)*logo.B.y;
		*/
		
		// este bloco era o que estava sendo usado
		/*
		drawView.AB.xini = (f/logo.A.ztt)*logo.A.xtt; // REF PONTO A
		drawView.AB.yini = (f/logo.A.ztt)*logo.A.ytt; // REF PONTO A
		drawView.AB.xfim = (f/logo.B.ztt)*logo.B.xtt; // REF PONTO B
		drawView.AB.yfim = (f/logo.B.ztt)*logo.B.ytt; // REF PONTO B
		
		drawView.BD.xini = (f/logo.B.ztt)*logo.B.xtt; // REF PONTO B
		drawView.BD.yini = (f/logo.B.ztt)*logo.B.ytt; // REF PONTO B
		drawView.BD.xfim = (f/logo.D.ztt)*logo.D.xtt; // REF PONTO D
		drawView.BD.yfim = (f/logo.D.ztt)*logo.D.ytt; // REF PONTO D
		
		drawView.DC.xini = (f/logo.D.ztt)*logo.D.xtt;
		drawView.DC.yini = (f/logo.D.ztt)*logo.D.ytt;
		drawView.DC.xfim = (f/logo.C.ztt)*logo.C.xtt;
		drawView.DC.yfim = (f/logo.C.ztt)*logo.C.ytt;
		
		drawView.CA.xini = (f/logo.C.ztt)*logo.C.xtt;
		drawView.CA.yini = (f/logo.C.ztt)*logo.C.ytt;
		drawView.CA.xfim = (f/logo.A.ztt)*logo.A.xtt;
		drawView.CA.yfim = (f/logo.A.ztt)*logo.A.ytt;
		
		drawView.EF.xini = (f/logo.E.ztt)*logo.E.xtt;
		drawView.EF.yini = (f/logo.E.ztt)*logo.E.ytt;
		drawView.EF.xfim = (f/logo.F.ztt)*logo.F.xtt;
		drawView.EF.yfim = (f/logo.F.ztt)*logo.F.ytt;
		
		drawView.FH.xini = (f/logo.F.ztt)*logo.F.xtt;
		drawView.FH.yini = (f/logo.F.ztt)*logo.F.ytt;
		drawView.FH.xfim = (f/logo.H.ztt)*logo.H.xtt;
		drawView.FH.yfim = (f/logo.H.ztt)*logo.H.ytt;
		
		drawView.HG.xini = (f/logo.H.ztt)*logo.H.xtt;
		drawView.HG.yini = (f/logo.H.ztt)*logo.H.ytt;
		drawView.HG.xfim = (f/logo.G.ztt)*logo.G.xtt;
		drawView.HG.yfim = (f/logo.G.ztt)*logo.G.ytt;
		
		drawView.GE.xini = (f/logo.G.ztt)*logo.G.xtt;
		drawView.GE.yini = (f/logo.G.ztt)*logo.G.ytt;
		drawView.GE.xfim = (f/logo.E.ztt)*logo.E.xtt;
		drawView.GE.yfim = (f/logo.E.ztt)*logo.E.ytt;
		
		drawView.AE.xini = (f/logo.A.ztt)*logo.A.xtt;
		drawView.AE.yini = (f/logo.A.ztt)*logo.A.ytt;
		drawView.AE.xfim = (f/logo.E.ztt)*logo.E.xtt;
		drawView.AE.yfim = (f/logo.E.ztt)*logo.E.ytt;
		
		drawView.BF.xini = (f/logo.B.ztt)*logo.B.xtt;
		drawView.BF.yini = (f/logo.B.ztt)*logo.B.ytt;
		drawView.BF.xfim = (f/logo.F.ztt)*logo.F.xtt;
		drawView.BF.yfim = (f/logo.F.ztt)*logo.F.ytt;
		
		drawView.DH.xini = (f/logo.D.ztt)*logo.D.xtt;
		drawView.DH.yini = (f/logo.D.ztt)*logo.D.ytt;
		drawView.DH.xfim = (f/logo.H.ztt)*logo.H.xtt;
		drawView.DH.yfim = (f/logo.H.ztt)*logo.H.ytt;
		
		drawView.CG.xini = (f/logo.C.ztt)*logo.C.xtt;
		drawView.CG.yini = (f/logo.C.ztt)*logo.C.ytt;
		drawView.CG.xfim = (f/logo.G.ztt)*logo.G.xtt;
		drawView.CG.yfim = (f/logo.G.ztt)*logo.G.ytt;*/
		
		//y' = y * (eye_dist / eye_dist + z)
		
		/*drawView.AB.xini = logo.A.xtt * (10/10 + 50); // REF PONTO A
		drawView.AB.yini = logo.A.ytt * (10/10 + 50); // REF PONTO A
		drawView.AB.xfim = logo.B.xtt * (10/10 + 50); // REF PONTO B
		drawView.AB.yfim = logo.B.ytt * (10/10 + 50); // REF PONTO B
		
		drawView.BD.xini = logo.B.xtt * (10/10 + 50); // REF PONTO B
		drawView.BD.yini = logo.B.ytt * (10/10 + 50); // REF PONTO B
		drawView.BD.xfim = logo.D.xtt * (10/10 + 50); // REF PONTO D
		drawView.BD.yfim = logo.D.ytt * (10/10 + 50); // REF PONTO D
		
		drawView.DC.xini = logo.D.xtt * (10/10 + 50);
		drawView.DC.yini = logo.D.ytt * (10/10 + 50);
		drawView.DC.xfim = logo.C.xtt * (10/10 + 50);
		drawView.DC.yfim = logo.C.ytt * (10/10 + 50);
		
		drawView.CA.xini = logo.C.xtt * (10/10 + 50);
		drawView.CA.yini = logo.C.ytt * (10/10 + 50);
		drawView.CA.xfim = logo.A.xtt * (10/10 + 50);
		drawView.CA.yfim = logo.A.ytt * (10/10 + 50);
		
		drawView.EF.xini = logo.E.xtt * (10/10 + 50);
		drawView.EF.yini = logo.E.ytt * (10/10 + 50);
		drawView.EF.xfim = logo.F.xtt * (10/10 + 50);
		drawView.EF.yfim = logo.F.ytt * (10/10 + 50);
		
		drawView.FH.xini = logo.F.xtt * (10/10 + 50);
		drawView.FH.yini = logo.F.ytt * (10/10 + 50);
		drawView.FH.xfim = logo.H.xtt * (10/10 + 50);
		drawView.FH.yfim = logo.H.ytt * (10/10 + 50);
		
		drawView.HG.xini = logo.H.xtt * (10/10 + 50);
		drawView.HG.yini = logo.H.ytt * (10/10 + 50);
		drawView.HG.xfim = logo.G.xtt * (10/10 + 50);
		drawView.HG.yfim = logo.G.ytt * (10/10 + 50);
		
		drawView.GE.xini = logo.G.xtt * (10/10 + 50);
		drawView.GE.yini = logo.G.ytt * (10/10 + 50);
		drawView.GE.xfim = logo.E.xtt * (10/10 + 50);
		drawView.GE.yfim = logo.E.ytt * (10/10 + 50);
		
		drawView.AE.xini = logo.A.xtt * (10/10 + 50);
		drawView.AE.yini = logo.A.ytt * (10/10 + 50);
		drawView.AE.xfim = logo.E.xtt * (10/10 + 50);
		drawView.AE.yfim = logo.E.ytt * (10/10 + 50);
		
		drawView.BF.xini = logo.B.xtt * (10/10 + 50);
		drawView.BF.yini = logo.B.ytt * (10/10 + 50);
		drawView.BF.xfim = logo.F.xtt * (10/10 + 50);
		drawView.BF.yfim = logo.F.ytt * (10/10 + 50);
		
		drawView.DH.xini = logo.D.xtt * (10/10 + 50);
		drawView.DH.yini = logo.D.ytt * (10/10 + 50);
		drawView.DH.xfim = logo.H.xtt * (10/10 + 50);
		drawView.DH.yfim = logo.H.ytt * (10/10 + 50);
		
		drawView.CG.xini = logo.C.xtt * (10/10 + 50);
		drawView.CG.yini = logo.C.ytt * (10/10 + 50);
		drawView.CG.xfim = cubo.G.xtt * (10/10 + 50);
		drawView.CG.yfim = logo.G.ytt * (10/10 + 50);*/
        
	}
	class LogoGeobrax{
		/*
		 *	Rotacionar Cubo Sem o Uso De Bibliotecas Open GL ou Outra Qualquer.
		 *  
		 *  2013 Saiko Software
		 *
		 * Desenvolvido por Maro Aur�lio Bueno
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
		 */
		public Ponto3D[] ptsins ;
		public Linha2D[] linhasins ;
		
		LogoGeobrax(Ponto3D[] ptspass){
			for(int i=1; i<ptspass.length; i++){
				ptsins[i] = ptspass[i];
			}
		}
		public void giraCuboXGraus(Double g){
			
			// aplica a formula de rotacao nas arestas do logo 3D
			
			// Antes de fazer a rotacao , deve-se trasladar o logo at� a ogigem 
			// do eixo de coordenadas
			/*A.x = (A.x - 450);
			A.y = A.y - 450;
			A.z = A.z - 450;
			
			B.x = B.x - 450;
			B.y = B.y - 450;
			B.z = B.z - 450;
			
			C.x = C.x - 450;
			C.y = C.y - 450;
			C.z = C.z - 450;
			
			D.x = D.x - 450;
			D.y = D.y - 450;
			D.z = D.z - 450;
			
			E.x = E.x - 450;
			E.y = E.y - 450;
			E.z = E.z - 450;
			
			F.x = F.x - 450;
			F.y = F.y - 450;
			F.z = F.z - 450;
			
			G.x = G.x - 450;
			G.y = G.y - 450;
			G.z = G.z - 450;
			
			H.x = H.x - 450;
			H.y = H.y - 450;
			H.z = H.z - 450;
			
			
			// Faz a rotacao do logo, fazendo o girar pelo eixo x
			A.xt = (A.x * 1) + (A.y * 0) + (A.z * 0);
			A.yt = (A.x * 0) + (A.y * Math.cos(g)) + (A.z * (-Math.sin(g)));
			A.zt = (A.x * 0) + (A.y * Math.sin(g)) + (A.z * Math.cos(g));
			
			B.xt = (B.x * 1) + (B.y * 0) + (B.z * 0);
			B.yt = (B.x * 0) + (B.y * Math.cos(g)) + (B.z * (-Math.sin(g)));
			B.zt = (B.x * 0) + (B.y * Math.sin(g)) + (B.z * Math.cos(g));
			
			C.xt = (C.x * 1) + (C.y * 0) + (C.z * 0);
			C.yt = (C.x * 0) + (C.y * Math.cos(g)) + (C.z * (-Math.sin(g)));
			C.zt = (C.x * 0) + (C.y * Math.sin(g)) + (C.z * Math.cos(g));
			
			D.xt = (D.x * 1) + (D.y * 0) + (D.z * 0);
			D.yt = (D.x * 0) + (D.y * Math.cos(g)) + (D.z * (-Math.sin(g)));
			D.zt = (D.x * 0) + (D.y * Math.sin(g)) + (D.z * Math.cos(g));
			
			E.xt = (E.x * 1) + (E.y * 0) + (E.z * 0);
			E.yt = (E.x * 0) + (E.y * Math.cos(g)) + (E.z * (-Math.sin(g)));
			E.zt = (E.x * 0) + (E.y * Math.sin(g)) + (E.z * Math.cos(g));
			
			F.xt = (F.x * 1) + (F.y * 0) + (F.z * 0);
			F.yt = (F.x * 0) + (F.y * Math.cos(g)) + (F.z * (-Math.sin(g)));
			F.zt = (F.x * 0) + (F.y * Math.sin(g)) + (F.z * Math.cos(g));
			
			G.xt = (G.x * 1) + (G.y * 0) + (G.z * 0);
			G.yt = (G.x * 0) + (G.y * Math.cos(g)) + (G.z * (-Math.sin(g)));
			G.zt = (G.x * 0) + (G.y * Math.sin(g)) + (G.z * Math.cos(g));
			
			H.xt = (H.x * 1) + (H.y * 0) + (H.z * 0);
			H.yt = (H.x * 0) + (H.y * Math.cos(g)) + (H.z * (-Math.sin(g)));
			H.zt = (H.x * 0) + (H.y * Math.sin(g)) + (H.z * Math.cos(g));

			
			
			
			A.xtt = (A.zt * Math.sin(g)) + (A.xt * Math.cos(g));
			A.ytt = A.yt ;
			A.ztt = (A.zt * Math.cos(g)) - (A.xt * Math.sin(g)) ;
			
			B.xtt = (B.zt * Math.sin(g)) + (B.xt* Math.cos(g));
			B.ytt = B.yt;
			B.ztt =(B.zt * Math.cos(g)) - (B.xt * Math.sin(g)) ;
			
			C.xtt = (C.zt * Math.sin(g)) + (C.xt * Math.cos(g));
			C.ytt = C.yt;
			C.ztt = (C.zt * Math.cos(g)) - (C.xt * Math.sin(g)) ;
			
			D.xtt = (D.zt * Math.sin(g)) + (D.xt * Math.cos(g));
			D.ytt = D.yt ;
			D.ztt = (D.zt * Math.cos(g)) - (D.xt * Math.sin(g)) ;
			
			E.xtt = (E.zt * Math.sin(g)) + (E.xt * Math.cos(g));
			E.ytt = E.yt ;
			E.ztt = (E.zt * Math.cos(g)) - (E.xt * Math.sin(g)) ;
			
			F.xtt = (F.zt * Math.sin(g)) + (F.xt * Math.cos(g));
			F.ytt = F.yt ;
			F.ztt = (F.zt * Math.cos(g)) - (F.xt * Math.sin(g)) ;
			
			G.xtt = (G.zt * Math.sin(g)) + (G.xt * Math.cos(g));
			G.ytt = G.yt;
			G.ztt = (G.zt * Math.cos(g)) - (G.xt * Math.sin(g)) ;
			
			H.xtt = (H.zt * Math.sin(g)) + (H.xt * Math.cos(g));
			H.ytt = H.yt;
			H.ztt =(H.zt * Math.cos(g)) - (H.xt * Math.sin(g)) ;
			
			
			
			
			// volta o logo para a posi��o original, fazendo transla��o
			A.x = (A.x + 450);
			A.y = A.y + 450;
			A.z = A.z + 450;
			
			B.x = B.x + 450;
			B.y = B.y + 450;
			B.z = B.z + 450;
			
			C.x = C.x + 450;
			C.y = C.y + 450;
			C.z = C.z + 450;
			
			D.x = D.x + 450;
			D.y = D.y + 450;
			D.z = D.z + 450;
			
			E.x = E.x + 450;
			E.y = E.y + 450;
			E.z = E.z + 450;
			
			F.x = F.x + 450;
			F.y = F.y + 450;
			F.z = F.z + 450;
			
			G.x = G.x + 450;
			G.y = G.y + 450;
			G.z = G.z + 450;
			
			H.x = H.x + 450;
			H.y = H.y + 450;
			H.z = H.z + 450;
			
			A.xtt = (A.xtt + 450);
			A.ytt = A.ytt + 450;
			A.ztt = A.ztt + 450;
			
			B.xtt = B.xtt + 450;
			B.ytt = B.ytt + 450;
			B.ztt = B.ztt + 450;
			
			C.xtt = C.xtt + 450;
			C.ytt = C.ytt + 450;
			C.ztt = C.ztt + 450;
			
			D.xtt = D.xtt + 450;
			D.ytt = D.ytt + 450;
			D.ztt = D.ztt + 450;
			
			E.xtt = E.xtt + 450;
			E.ytt = E.ytt + 450;
			E.ztt = E.ztt + 450;
			
			F.xtt = F.xtt + 450;
			F.ytt = F.ytt + 450;
			F.ztt = F.ztt + 450;
			
			G.xtt = G.xtt + 450;
			G.ytt = G.ytt + 450;
			G.ztt = G.ztt + 450;
			
			H.xtt = H.xtt + 450;
			H.ytt = H.ytt + 450;
			H.ztt = H.ztt + 450;*/

		}
		
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
				
				Log.d("readLine",line);
				String[] separated = line.split("\\ ");
				Log.d("tipo = ", separated[0]);
				
				Log.d("antes if", "equ");
				if(separated[0].equals("v")){
					Log.d("vertice {"," x= "+ separated[1] + " y= " + separated[2] + " z= " + separated[3]+" }");
					
					pts[contpts] = new Ponto3D(Double.parseDouble(separated[1])*600,(Double.parseDouble(separated[2])*600)+400,Double.parseDouble(separated[3])*600);
					Log.d("Depois criar ponto","ufa");
					contpts++;
				}else{
					if(separated[0].equals("f")){
						Log.d("dentro de","if de faces");
						if(separated.length == 5){
							fcs[contfcs] = new Face(Integer.parseInt(separated[1]),Integer.parseInt(separated[2]),Integer.parseInt(separated[3]),Integer.parseInt(separated[4]),4);
						}else{
							fcs[contfcs] = new Face(Integer.parseInt(separated[1]),Integer.parseInt(separated[2]),Integer.parseInt(separated[3]),3);
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
