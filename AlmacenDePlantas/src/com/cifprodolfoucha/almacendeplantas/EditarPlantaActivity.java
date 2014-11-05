package com.cifprodolfoucha.almacendeplantas;

import com.jch.almacendeplantas.R;
import com.jch.almacendeplantas.R.id;
import com.jch.almacendeplantas.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class EditarPlantaActivity extends Activity implements OnClickListener{
	
	static final int CODIGO_RESPUESTA = 1;
	
	private Button btn_hacerFoto = null;
	private ImageView img_foto = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_planta);
		// 
		inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		btn_hacerFoto = (Button) findViewById(R.id.btn_hacer_foto);
		btn_hacerFoto.setOnClickListener(this);
		img_foto = (ImageView) findViewById(R.id.img_tomada);
	}

	@Override
	public void onClick(View v) {
		Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if(camara.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(camara, CODIGO_RESPUESTA);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == CODIGO_RESPUESTA && resultCode == RESULT_OK) {
			Bundle extra = data.getExtras();
			Bitmap foto = (Bitmap) extra.get("data");
			img_foto.setImageBitmap(foto);
		}
	}
	
}
