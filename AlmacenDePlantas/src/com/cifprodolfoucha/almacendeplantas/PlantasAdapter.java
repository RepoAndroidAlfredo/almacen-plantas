package com.cifprodolfoucha.almacendeplantas;

import java.util.ArrayList;
import java.util.List;

import com.jch.almacendeplantas.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlantasAdapter extends BaseAdapter {
	
	public static List<Planta> plantasBBDD = null;
	
	private LayoutInflater layoutPersonal = null;
	private ImageView imagenPlanta = null;
	private TextView txtTitulo = null;
	private TextView txtSubtitulo = null;
	
	public PlantasAdapter(Activity activity) {
		// Se usa LayoutInflater para instanciar un nuevo fichero XML
		// a su correspondiente objeto View
		this.layoutPersonal = (LayoutInflater) 
				activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// Se cargan las plantas disponibles en una lista
		plantasBBDD = cargarPlantas();
	}

	@Override
	public int getCount() {
		return plantasBBDD.size();
	}

	@Override
	public Object getItem(int position) {
		return plantasBBDD.get(position);
	}

	@Override
	public long getItemId(int position) {
		return plantasBBDD.get(position).getIdImagen();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vistaPersonalizada = convertView;
		if(convertView == null) {
			vistaPersonalizada = layoutPersonal.inflate(R.layout.item_planta, null);
		}
		Planta planta = plantasBBDD.get(position);
		imagenPlanta = (ImageView) vistaPersonalizada.findViewById(R.id.img_planta);
		imagenPlanta.setImageResource(planta.getIdImagen());
		txtTitulo = (TextView) vistaPersonalizada.findViewById(R.id.txt_titulo_planta);
		txtTitulo.setText(planta.getNombreCientifico());
		txtSubtitulo = (TextView) vistaPersonalizada.findViewById(R.id.txt_subtitulo_planta);
		txtSubtitulo.setText(planta.getDescripion());
		// Devuelve la vista personalizada con los datos
		return vistaPersonalizada;
	}
	
	private List<Planta> cargarPlantas() {
		List<Planta> listadoPlantas = new ArrayList<Planta>();
		for(int i = 0; i < imagenesDePrueba.length; i++) {
			listadoPlantas.add(new Planta("Castaño de Galicia", imagenesDePrueba[i], 
					"Titulo de prueba", "Subtitulo con descripcion de pruebas Subtitulo con descripcion de pruebas"
							+ "Subtitulo con descripcion de pruebas Subtitulo con descripcion de pruebas"
							+ "Subtitulo con descripcion de pruebas", "Familia 1", "Tipo 1"));
		}
		return listadoPlantas;
	}

	private static int [] imagenesDePrueba = {
				R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4,
	            R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7,
	            R.drawable.sample_7, R.drawable.sample_0, R.drawable.sample_1,
	            R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4,
	            R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7
	};
}
