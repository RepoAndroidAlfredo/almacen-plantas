package com.jch.almacendeplantas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
		// Inializa los componentes graficos
		inicializarComponentes();
		// Muesta la planta recibida
		Planta planta = getIntent().getParcelableExtra("planta");
		mostrarDetallePlanta(planta);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_editar, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.guardar:
			Toast.makeText(this, "Guardar YES/NO", Toast.LENGTH_LONG).show();
			return true;
		case R.id.editar:
			Toast.makeText(this, "Pincha en el campi para editarlo",
					Toast.LENGTH_LONG).show();
			return true;
		case R.id.eliminar:
			Toast.makeText(this, "Reloading borrar...", Toast.LENGTH_LONG)
					.show();
			return true;

		default:
			return super.onContextItemSelected(item);

		}
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
