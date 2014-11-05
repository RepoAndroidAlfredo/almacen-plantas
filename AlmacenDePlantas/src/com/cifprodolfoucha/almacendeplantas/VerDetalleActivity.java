package com.cifprodolfoucha.almacendeplantas;

import com.jch.almacendeplantas.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VerDetalleActivity extends Activity {
	
	private ImageView img_planta;
	private TextView txt_nombre;
	private TextView txt_nombrecientifico;
	private TextView txt_tipo;
	private TextView txt_descripcion;
	private TextView txt_familia;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ver_detalle);
		// Inializa los componentes graficas
		inicializarComponentes();
		// Muesta la planta recibida
		Planta planta = getIntent().getParcelableExtra("planta");
		mostrarDetallePlanta(planta);
	}
	
	private void mostrarDetallePlanta(Planta planta) {
		img_planta.setImageResource(planta.getIdImagen());
		txt_nombre.setText(planta.getNombre());
		txt_nombrecientifico.setText(planta.getNombreCientifico());
		txt_descripcion.setText(planta.getDescripion());
		txt_familia.setText(planta.getFamilia());
		txt_tipo.setText(planta.getTipo());
	}
	
	private void inicializarComponentes() {
		img_planta = (ImageView) findViewById(R.id.img_planta_detalle);
		txt_nombre = (TextView) findViewById(R.id.lbl_nombre_planta);
		txt_nombrecientifico = (TextView) findViewById(R.id.txt_nombre_cientifico_planta);
		txt_tipo = (TextView) findViewById(R.id.txt_tipo_planta);
		txt_familia = (TextView) findViewById(R.id.txt_familia_planta);
		txt_descripcion = (TextView) findViewById(R.id.txt_descripcion_planta);
	}
}
