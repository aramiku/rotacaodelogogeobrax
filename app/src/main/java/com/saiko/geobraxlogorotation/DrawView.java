package com.saiko.geobraxlogorotation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();
    Face[] fcs = new Face[6000];
    Ponto3D[] pointsins = new Ponto3D[8000];
    Double xini = 1.0;
    Double yini = 1.0;
    Double xfin = 1.0;
    Double yfin = 1.0;
    int f = 300;
    int auxparacolocarmeshcentralizadonaorigem = 700;
    Double xaux = 1053.0;
    Double yaux = 320.29;
    Double zaux = 566.1396;
    

    public DrawView(Context context,Face[] fcspass,Ponto3D[] ptspass) {
        super(context);
        this.fcs = fcspass;
        this.pointsins = ptspass;
        paint.setColor(Color.BLACK);
        Log.d("DrawView","terminou o construtor");
    }

    @Override
    public void onDraw(Canvas canvas) {
    	Log.d("DrawView","dentro de onDraw");
    	double[] olho = {420, 340, 900};
    	double[] P = {600, 200, 1000};
    	double[] S;
    	
    		// depois de transformado os pontos 3D em 2D , abaixo desenha as linhas do cubo
    	for(int i=1; i<1903; i++){
    		if(fcs[i].verticesNumber == 4){
    			Log.d("DrawView","dentro de for , if z= "+Double.toString(pointsins[fcs[i].pto1].z)+" x = " + Double.toString(pointsins[fcs[i].pto1].x) + " y =" + Double.toString(pointsins[fcs[i].pto1].y));
    			/*xini = (f/pointsins[fcs[i].pto1].zt)*pointsins[fcs[i].pto1].xt;
    			yini = (f/pointsins[fcs[i].pto1].zt)*pointsins[fcs[i].pto1].yt;
    			xfin = (f/pointsins[fcs[i].pto2].zt)*pointsins[fcs[i].pto2].xt;
    			yfin = (f/pointsins[fcs[i].pto2].zt)*pointsins[fcs[i].pto2].yt;*/
    			xini = (olho[2] * (pointsins[fcs[i].pto1].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto1].zt) + olho[0];
    			yini = (olho[2] * (pointsins[fcs[i].pto1].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto1].zt) + olho[1];
    			xfin = (olho[2] * (pointsins[fcs[i].pto2].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto2].zt) + olho[0];
    			yfin = (olho[2] * (pointsins[fcs[i].pto2].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto2].zt) + olho[1];
    			if(xini > 0 && yini > 0 && xfin > 0 && yfin > 0){
    				canvas.drawLine(Math.round(xini),Math.round(yini), Math.round(xfin),  Math.round(yfin), paint);
    			}
    			/*xini = (f/pointsins[fcs[i].pto2].zt)*pointsins[fcs[i].pto2].xt;
    			yini = (f/pointsins[fcs[i].pto2].zt)*pointsins[fcs[i].pto2].yt;
    			xfin = (f/pointsins[fcs[i].pto3].zt)*pointsins[fcs[i].pto3].xt;
    			yfin = (f/pointsins[fcs[i].pto3].zt)*pointsins[fcs[i].pto3].yt;*/
    			xini = (olho[2] * (pointsins[fcs[i].pto2].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto2].zt) + olho[0];
    			yini = (olho[2] * (pointsins[fcs[i].pto2].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto2].zt) + olho[1];
    			xfin = (olho[2] * (pointsins[fcs[i].pto3].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto3].zt) + olho[0];
    			yfin = (olho[2] * (pointsins[fcs[i].pto3].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto3].zt) + olho[1];
    			if(xini > 0 && yini > 0 && xfin > 0 && yfin > 0){
    				canvas.drawLine(Math.round(xini),Math.round(yini), Math.round(xfin),  Math.round(yfin), paint);
    			}
    			/*xini = (f/pointsins[fcs[i].pto3].zt)*pointsins[fcs[i].pto3].xt;
    			yini = (f/pointsins[fcs[i].pto3].zt)*pointsins[fcs[i].pto3].yt;
    			xfin = (f/pointsins[fcs[i].pto4].zt)*pointsins[fcs[i].pto4].xt;
    			yfin = (f/pointsins[fcs[i].pto4].zt)*pointsins[fcs[i].pto4].yt;*/
    			xini = (olho[2] * (pointsins[fcs[i].pto3].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto3].zt) + olho[0];
    			yini = (olho[2] * (pointsins[fcs[i].pto3].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto3].zt) + olho[1];
    			xfin = (olho[2] * (pointsins[fcs[i].pto4].xt-olho[0])) / (olho[2] + pointsins[fcs[i].pto4].zt) + olho[0];
    			yfin = (olho[2] * (pointsins[fcs[i].pto4].yt-olho[1])) / (olho[2] + pointsins[fcs[i].pto4].zt) + olho[1];
    			if(xini > 0 && yini > 0 && xfin > 0 && yfin > 0){
    				canvas.drawLine(Math.round(xini),Math.round(yini), Math.round(xfin),  Math.round(yfin), paint);
    			}
    			// nao precisa desenhar esta linha, como esta desenhando
    			// quadrado, entao se desenhar um parte do quadrado
    			// o pr�ximo quadrado ir� terminar o quadrado anterior.
    			/*xini = (f/pointsins[fcs[i].pto4].zt)*pointsins[fcs[i].pto4].xt;
    			yini = (f/pointsins[fcs[i].pto4].zt)*pointsins[fcs[i].pto4].yt;
    			xfin = (f/pointsins[fcs[i].pto1].zt)*pointsins[fcs[i].pto1].xt;
    			yfin = (f/pointsins[fcs[i].pto1].zt)*pointsins[fcs[i].pto1].yt;
    			if(xini > 0 && yini > 0 && xfin > 0 && yfin > 0){
    				canvas.drawLine(Math.round(xini),Math.round(yini), Math.round(xfin),  Math.round(yfin), paint);
    			}*/
    		}
    		//canvas.drawLine(Math.round(linhas[i].xini),Math.round(linhas[i].yini), Math.round(linhas[i].xfim),  Math.round(linhas[i].yfim), paint);
    	}
 
        //    canvas.drawLine(Math.round(AB.xini),Math.round(AB.yini), Math.round(AB.xfim),  Math.round(AB.yfim), paint);
        //    canvas.drawLine(Math.round(BD.xini),Math.round(BD.yini), Math.round(BD.xfim),  Math.round(BD.yfim), paint);            
            
    }
	public void giraCuboXGraus(Double g){
		
		// pega cada face com 4 vertices , e faz a transla��o / rota��o
    	for(int i=1; i<1903; i++){
    		if(fcs[i].verticesNumber == 4){
    			Log.d("giraCuboXGraus g= "+ Double.toString(g)," , if z= "+Double.toString(pointsins[fcs[i].pto1].z)+" x = " + Double.toString(pointsins[fcs[i].pto1].x) + " y =" + Double.toString(pointsins[fcs[i].pto1].y));
    			
    			// move ponto para origem dos quatro vertices da face
    			
    			
    			pointsins[fcs[i].pto1].x = pointsins[fcs[i].pto1].x - xaux;
    			pointsins[fcs[i].pto1].y = pointsins[fcs[i].pto1].y - yaux;
    			pointsins[fcs[i].pto1].z = pointsins[fcs[i].pto1].z - zaux;
    			
    			pointsins[fcs[i].pto2].x = pointsins[fcs[i].pto2].x - xaux;
    			pointsins[fcs[i].pto2].y = pointsins[fcs[i].pto2].y - yaux;
    			pointsins[fcs[i].pto2].z = pointsins[fcs[i].pto2].z - zaux;
    			
    			pointsins[fcs[i].pto3].x = pointsins[fcs[i].pto3].x - xaux;
    			pointsins[fcs[i].pto3].y = pointsins[fcs[i].pto3].y - yaux;
    			pointsins[fcs[i].pto3].z = pointsins[fcs[i].pto3].z - zaux;
    			
    			pointsins[fcs[i].pto4].x = pointsins[fcs[i].pto4].x - xaux;
    			pointsins[fcs[i].pto4].y = pointsins[fcs[i].pto4].y - yaux;
    			pointsins[fcs[i].pto4].z = pointsins[fcs[i].pto4].z - zaux;
    			
    			// faz rota��o
    			pointsins[fcs[i].pto1].xt = (pointsins[fcs[i].pto1].x * 1) + (pointsins[fcs[i].pto1].y * 0) + (pointsins[fcs[i].pto1].z * 0);
    			pointsins[fcs[i].pto2].xt = (pointsins[fcs[i].pto2].x * 1) + (pointsins[fcs[i].pto2].y * 0) + (pointsins[fcs[i].pto2].z * 0);
    			pointsins[fcs[i].pto3].xt = (pointsins[fcs[i].pto3].x * 1) + (pointsins[fcs[i].pto3].y * 0) + (pointsins[fcs[i].pto3].z * 0);
    			pointsins[fcs[i].pto4].xt = (pointsins[fcs[i].pto4].x * 1) + (pointsins[fcs[i].pto4].y * 0) + (pointsins[fcs[i].pto4].z * 0);
    			
    			
    			pointsins[fcs[i].pto1].yt = (pointsins[fcs[i].pto1].x * 0) + (pointsins[fcs[i].pto1].y * Math.cos(g)) + (pointsins[fcs[i].pto1].z * (-Math.sin(g)));
    			pointsins[fcs[i].pto2].yt = (pointsins[fcs[i].pto2].x * 0) + (pointsins[fcs[i].pto2].y * Math.cos(g)) + (pointsins[fcs[i].pto2].z * (-Math.sin(g)));
    			pointsins[fcs[i].pto3].yt = (pointsins[fcs[i].pto3].x * 0) + (pointsins[fcs[i].pto3].y * Math.cos(g)) + (pointsins[fcs[i].pto3].z * (-Math.sin(g)));
    			pointsins[fcs[i].pto4].yt = (pointsins[fcs[i].pto4].x * 0) + (pointsins[fcs[i].pto4].y * Math.cos(g)) + (pointsins[fcs[i].pto4].z * (-Math.sin(g)));
    			
    			
    			pointsins[fcs[i].pto1].zt = (pointsins[fcs[i].pto1].x * 0) + (pointsins[fcs[i].pto1].y * Math.sin(g)) + (pointsins[fcs[i].pto1].z * Math.cos(g));
    			pointsins[fcs[i].pto2].zt = (pointsins[fcs[i].pto2].x * 0) + (pointsins[fcs[i].pto2].y * Math.sin(g)) + (pointsins[fcs[i].pto2].z * Math.cos(g));
    			pointsins[fcs[i].pto3].zt = (pointsins[fcs[i].pto3].x * 0) + (pointsins[fcs[i].pto3].y * Math.sin(g)) + (pointsins[fcs[i].pto3].z * Math.cos(g));
    			pointsins[fcs[i].pto4].zt = (pointsins[fcs[i].pto4].x * 0) + (pointsins[fcs[i].pto4].y * Math.sin(g)) + (pointsins[fcs[i].pto4].z * Math.cos(g));
    			
    			// retorna ponto do objeto para lugar original
    			pointsins[fcs[i].pto1].x = pointsins[fcs[i].pto1].x + xaux;
    			pointsins[fcs[i].pto1].y = pointsins[fcs[i].pto1].y + yaux;
    			pointsins[fcs[i].pto1].z = pointsins[fcs[i].pto1].z + zaux;
    			
    			pointsins[fcs[i].pto2].x = pointsins[fcs[i].pto2].x + xaux;
    			pointsins[fcs[i].pto2].y = pointsins[fcs[i].pto2].y + yaux;
    			pointsins[fcs[i].pto2].z = pointsins[fcs[i].pto2].z + zaux;
    			
    			pointsins[fcs[i].pto3].x = pointsins[fcs[i].pto3].x + xaux;
    			pointsins[fcs[i].pto3].y = pointsins[fcs[i].pto3].y + yaux;
    			pointsins[fcs[i].pto3].z = pointsins[fcs[i].pto3].z + zaux;
    			
    			pointsins[fcs[i].pto4].x = pointsins[fcs[i].pto4].x + xaux;
    			pointsins[fcs[i].pto4].y = pointsins[fcs[i].pto4].y + yaux;
    			pointsins[fcs[i].pto4].z = pointsins[fcs[i].pto4].z + zaux;
    			
    			// retorna tamb�m os xts para origem
    			pointsins[fcs[i].pto1].xt = pointsins[fcs[i].pto1].xt + xaux;
    			pointsins[fcs[i].pto1].yt = pointsins[fcs[i].pto1].yt + yaux;
    			pointsins[fcs[i].pto1].zt = pointsins[fcs[i].pto1].zt + zaux;
    			
    			pointsins[fcs[i].pto2].xt = pointsins[fcs[i].pto2].xt + xaux;
    			pointsins[fcs[i].pto2].yt = pointsins[fcs[i].pto2].yt + yaux;
    			pointsins[fcs[i].pto2].zt = pointsins[fcs[i].pto2].zt + zaux;
    			
    			pointsins[fcs[i].pto3].xt = pointsins[fcs[i].pto3].xt + xaux;
    			pointsins[fcs[i].pto3].yt = pointsins[fcs[i].pto3].yt + yaux;
    			pointsins[fcs[i].pto3].zt = pointsins[fcs[i].pto3].zt + zaux;
    			
    			pointsins[fcs[i].pto4].xt = pointsins[fcs[i].pto4].xt + xaux;
    			pointsins[fcs[i].pto4].yt = pointsins[fcs[i].pto4].yt + yaux;
    			pointsins[fcs[i].pto4].zt = pointsins[fcs[i].pto4].zt + zaux;
    		}
    		//canvas.drawLine(Math.round(linhas[i].xini),Math.round(linhas[i].yini), Math.round(linhas[i].xfim),  Math.round(linhas[i].yfim), paint);
    	}
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
	public void giraCuboXGraus2(Double g){
		
		// pega cada face com 4 vertices , e faz a transla��o / rota��o
    	for(int i=1; i<1903; i++){
    		if(fcs[i].verticesNumber == 4){
    			Log.d("giraCuboXGraus g= "+ Double.toString(g)," , if z= "+Double.toString(pointsins[fcs[i].pto1].z)+" x = " + Double.toString(pointsins[fcs[i].pto1].x) + " y =" + Double.toString(pointsins[fcs[i].pto1].y));
    			
    			// move ponto para origem dos quatro vertices da face
    			
    			
    			pointsins[fcs[i].pto1].x = pointsins[fcs[i].pto1].x - xaux;
    			pointsins[fcs[i].pto1].y = pointsins[fcs[i].pto1].y - yaux;
    			pointsins[fcs[i].pto1].z = pointsins[fcs[i].pto1].z - zaux;
    			
    			pointsins[fcs[i].pto2].x = pointsins[fcs[i].pto2].x - xaux;
    			pointsins[fcs[i].pto2].y = pointsins[fcs[i].pto2].y - yaux;
    			pointsins[fcs[i].pto2].z = pointsins[fcs[i].pto2].z - zaux;
    			
    			pointsins[fcs[i].pto3].x = pointsins[fcs[i].pto3].x - xaux;
    			pointsins[fcs[i].pto3].y = pointsins[fcs[i].pto3].y - yaux;
    			pointsins[fcs[i].pto3].z = pointsins[fcs[i].pto3].z - zaux;
    			
    			pointsins[fcs[i].pto4].x = pointsins[fcs[i].pto4].x - xaux;
    			pointsins[fcs[i].pto4].y = pointsins[fcs[i].pto4].y - yaux;
    			pointsins[fcs[i].pto4].z = pointsins[fcs[i].pto4].z - zaux;
    			
    			// faz rota��o
    			
 
    			pointsins[fcs[i].pto1].xt = (pointsins[fcs[i].pto1].x * Math.cos(g)) +  (pointsins[fcs[i].pto1].z * Math.sin(g));
    			pointsins[fcs[i].pto2].xt = (pointsins[fcs[i].pto2].x * Math.cos(g)) +  (pointsins[fcs[i].pto2].z * Math.sin(g));
    			pointsins[fcs[i].pto3].xt = (pointsins[fcs[i].pto3].x * Math.cos(g)) +  (pointsins[fcs[i].pto3].z * Math.sin(g));
    			pointsins[fcs[i].pto4].xt = (pointsins[fcs[i].pto4].x * Math.cos(g)) +  (pointsins[fcs[i].pto4].z * Math.sin(g));
    			
    			
    			pointsins[fcs[i].pto1].yt =  pointsins[fcs[i].pto1].y  ;
    			pointsins[fcs[i].pto2].yt =  pointsins[fcs[i].pto2].y  ;
    			pointsins[fcs[i].pto3].yt =  pointsins[fcs[i].pto3].y  ;
    			pointsins[fcs[i].pto4].yt =  pointsins[fcs[i].pto4].y  ;
    			
    			
    			pointsins[fcs[i].pto1].zt = (pointsins[fcs[i].pto1].z * Math.cos(g)) - (pointsins[fcs[i].pto1].x * Math.sin(g)) ;
    			pointsins[fcs[i].pto2].zt = (pointsins[fcs[i].pto2].z * Math.cos(g)) - (pointsins[fcs[i].pto2].x * Math.sin(g)) ;
    			pointsins[fcs[i].pto3].zt = (pointsins[fcs[i].pto3].z * Math.cos(g)) - (pointsins[fcs[i].pto3].x * Math.sin(g)) ;
    			pointsins[fcs[i].pto4].zt = (pointsins[fcs[i].pto4].z * Math.cos(g)) - (pointsins[fcs[i].pto4].x * Math.sin(g)) ;
    			
    			// retorna ponto do objeto para lugar original
    			pointsins[fcs[i].pto1].x = pointsins[fcs[i].pto1].x + xaux;
    			pointsins[fcs[i].pto1].y = pointsins[fcs[i].pto1].y + yaux;
    			pointsins[fcs[i].pto1].z = pointsins[fcs[i].pto1].z + zaux;
    			
    			pointsins[fcs[i].pto2].x = pointsins[fcs[i].pto2].x + xaux;
    			pointsins[fcs[i].pto2].y = pointsins[fcs[i].pto2].y + yaux;
    			pointsins[fcs[i].pto2].z = pointsins[fcs[i].pto2].z + zaux;
    			
    			pointsins[fcs[i].pto3].x = pointsins[fcs[i].pto3].x + xaux;
    			pointsins[fcs[i].pto3].y = pointsins[fcs[i].pto3].y + yaux;
    			pointsins[fcs[i].pto3].z = pointsins[fcs[i].pto3].z + zaux;
    			
    			pointsins[fcs[i].pto4].x = pointsins[fcs[i].pto4].x + xaux;
    			pointsins[fcs[i].pto4].y = pointsins[fcs[i].pto4].y + yaux;
    			pointsins[fcs[i].pto4].z = pointsins[fcs[i].pto4].z + zaux;
    			
    			// retorna tamb�m os xts para origem
    			pointsins[fcs[i].pto1].xt = pointsins[fcs[i].pto1].xt + xaux;
    			pointsins[fcs[i].pto1].yt = pointsins[fcs[i].pto1].yt + yaux;
    			pointsins[fcs[i].pto1].zt = pointsins[fcs[i].pto1].zt + zaux;
    			
    			pointsins[fcs[i].pto2].xt = pointsins[fcs[i].pto2].xt + xaux;
    			pointsins[fcs[i].pto2].yt = pointsins[fcs[i].pto2].yt + yaux;
    			pointsins[fcs[i].pto2].zt = pointsins[fcs[i].pto2].zt + zaux;
    			
    			pointsins[fcs[i].pto3].xt = pointsins[fcs[i].pto3].xt + xaux;
    			pointsins[fcs[i].pto3].yt = pointsins[fcs[i].pto3].yt + yaux;
    			pointsins[fcs[i].pto3].zt = pointsins[fcs[i].pto3].zt + zaux;
    			
    			pointsins[fcs[i].pto4].xt = pointsins[fcs[i].pto4].xt + xaux;
    			pointsins[fcs[i].pto4].yt = pointsins[fcs[i].pto4].yt + yaux;
    			pointsins[fcs[i].pto4].zt = pointsins[fcs[i].pto4].zt + zaux;
    		}
    		//canvas.drawLine(Math.round(linhas[i].xini),Math.round(linhas[i].yini), Math.round(linhas[i].xfim),  Math.round(linhas[i].yfim), paint);
    	}
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
    public void setFaces(Face[] fcspass){
    	this.fcs = fcspass;
    }
    public void setPoints(Ponto3D[] ptspass){
    	this.pointsins = ptspass;
    }
    


}