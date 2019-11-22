package com.example.juegodepalabras;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.RandomAccess;

public class VistaJuego extends View {

    public Marcador marcador;
    public AssetManager asm;
    public String [] palabras;

    public VistaJuego(Context context) {
        super(context);
        asm = getContext().getAssets();
        palabras = context.getResources().getStringArray(R.array.palabras);
        init_juego();
    }

    public void init_juego() {
        marcador = new Marcador();
        nuevaPalabra(palabras);
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dibujarMonigote(canvas);
        marcador.draw(canvas);
    }

    public void comporbar(Character c) {
        marcador.comprobar(c.charValue());
        this.invalidate();
    }

    private void dibujarMonigote(Canvas canvas) {
        try {
            //  Imagen de la horca
            InputStream is = asm.open("patibulo.png");
            Bitmap bmp = BitmapFactory.decodeStream(is);
            //  canvas.drawBitmap(bmp, 50, 10, new Paint());

            //  primer rect es la selecion del trozo de la imagen
            //  Segundo rect es para especificar donde se va a mostrar
            canvas.drawBitmap(bmp, new Rect(0, 0, 600, 800), new Rect(420, 0, 1080, 1000), null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nuevaPalabra(String [] pls) {
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
        int pos = r.nextInt(pls.length);
        marcador.setSolucion(pls[pos]);
    }
}
