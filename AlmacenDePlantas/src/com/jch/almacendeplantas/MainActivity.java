package com.jch.almacendeplantas;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn_OrdenarXNombre = null;
	private Button btn_OrdenarXTipo = null;
	private GridView gridView = null;
	private PlantasAdapter adaptadorPlantas = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Inicializa los componentes graficos y sus eventos
		inicializarComponentes();
		// Se registra el menu contextual en el gridview
		registerForContextMenu(gridView);
		
		String a;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		// Asocia el elemento de busqueda con el servicio
		// que va a recibir las busquedas
		SearchManager buscador = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView elemento = (SearchView) menu.findItem(R.id.menu_buscar)
				.getActionView();
		elemento.setSearchableInfo(buscador
				.getSearchableInfo(getComponentName()));
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.salir:
			Toast.makeText(this, "Saliendo!!", Toast.LENGTH_LONG).show();
			finish();
			return true;
		default:
			return super.onContextItemSelected(item);

		}
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_contextual, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		switch (item.getItemId()) {
		case R.id.editar:
			// TODO: pasarle el intent de editar
			Toast.makeText(this, "editar menu contextual...", Toast.LENGTH_LONG)
					.show();
			return true;
		case R.id.borrar:
			// TODO: Pasarle el intent de eliminar
			Toast.makeText(this, "borrar menu contextual...", Toast.LENGTH_LONG)
					.show();
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}

	/*
	 * Este metodo captura todos los intent de busqueda que genera esta
	 * actividad, y realiza la busqueda
	 * 
	 * @see android.app.Activity#onNewIntent(android.content.Intent)
	 */
	@Override
	protected void onNewIntent(Intent intent) {
		if (intent.getAction().equals(Intent.ACTION_SEARCH)) {
			realizarBusqueda(intent.getStringExtra(SearchManager.QUERY));
		}
	}

	private void realizarBusqueda(String nombre) {
		// TODO: Implementar la busqueda de plantas
		if (PlantasAdapter.plantasBBDD.contains(new Planta(nombre))) {
			Toast.makeText(this, "Existe", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(this, "No Existe", Toast.LENGTH_LONG).show();
		}
	}

	private void inicializarComponentes() {
		btn_OrdenarXNombre = (Button) findViewById(R.id.btn_ordenar_nombre);
		btn_OrdenarXTipo = (Button) findViewById(R.id.btn_ordenar_familia);
		gridView = (GridView) findViewById(R.id.gridview);
		adaptadorPlantas = new PlantasAdapter(this);

		// /////////////////////////////////////////////
		// EVENTOS
		// /////////////////////////////////////////////

		// Evento btn_OrdenarXNombre
		btn_OrdenarXNombre.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO: Implementar evento de ordenar por nombre

			}
		});
		// Evento btn_OrdenarXTipo
		btn_OrdenarXTipo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO: Implementar evento de ordenar por tipo
			}
		});
		// Evento on_Item_Click del GridView
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Planta planta = (Planta) adaptadorPlantas.getItem(position);
				Intent detalle = new Intent(MainActivity.this,
						VerDetalleActivity.class);
				detalle.putExtra("planta", planta);
				startActivity(detalle);
			}
		});
		// Evento on_Long_Click del GridView
		gridView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// Retorna false para que se muestre el menu contextual
				return false;
			}

		});
		// Se le asigna el adaptador para que se vea
		// con nuestra vista personalizada
		gridView.setAdapter(adaptadorPlantas);
	}
}
