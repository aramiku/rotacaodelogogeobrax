package com.saiko.geobraxlogorotation;

class Face{
	
	// Aresta de um cuto , cubo �
	// formado por 12 linhas

	public int pto1 ;
	public int pto2 ;
	public int pto3 ;
	public int pto4 ;
	public int verticesNumber = 0;

    	Face(int pt1pass, int pt2pass, int pt3pass, int pt4pass, int verticesNumberPass){
    		this.pto1 = pt1pass;
    		this.pto2 = pt2pass;
    		this.pto3 = pt3pass;
    		this.pto4 = pt4pass;
    		verticesNumber = verticesNumberPass;
    	}
    	Face(int pt1pass, int pt2pass, int pt3pass, int verticesNumberPass){
    		this.pto1 = pt1pass;
    		this.pto2 = pt2pass;
    		this.pto3 = pt3pass;
    		verticesNumber = verticesNumberPass;

    	}
		public Face() {
			// Precisa de um construtor vazio
		}
    }