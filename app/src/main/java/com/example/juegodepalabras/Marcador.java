package com.example.juegodepalabras;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

public class Marcador {
    public String estado;
    public String solucion;
    public ArrayList<Character> caracteres;
    public int fallos;

    public Marcador() {
        //this.solucion = "";
        this.caracteres = new ArrayList<>();
        this.fallos = 0;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setSolucion(String s) {
        this.solucion = s;
    }

    public String getSolucion() {
        return this.solucion;
    }

    public boolean comprobar(char c) {
        if(solucion.contains(c + "")) {
            if(caracteres.contains(c)) {
                return false;
            }else {
                caracteres.add(c);
                return true;
            }

        }else {
            return false;
        }
    }

    public void contarFallo() {
        this.fallos += 1;
    }

    public void draw(Canvas canvas) {
        try {
            int pos = 20;
            for(int i = 0; i < this.solucion.length(); i++) {
                Paint p = new Paint();
                p.setStrokeWidth(3);
                canvas.drawLine(pos, 20, pos + 40, 20, p);
                if(this.caracteres.contains(this.solucion.charAt(i))) {
                    p = new Paint();
                    p.setTextSize(30);
                    canvas.drawText(this.solucion.charAt(i) + "", pos, 5, p);
                }
                pos += 50;
                //canvas.drawText(this.solucion, 100, 50, new Paint());
            }

        }catch (Exception ex) {

        }
        //  Dibujar estado     - >  dibujar la palabra
        //  Dibujar marcador   - >  dibujar el monigote
    }
}
