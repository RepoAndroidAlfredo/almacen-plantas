package com.cifprodolfoucha.almacendeplantas;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class Planta implements Parcelable {

	private int idImagen;
	private String nombre;
	private String nombreCientifico;
	private String descripion;
	private String familia;
	private String origen;
	private String tipo;
	
	private List<Planta> plantas = null;
	
	public Planta(String nombre, int idImagen, String nombreCientifico, 
			String descripion, String familia, String tipo) {
		super();
		this.nombre = nombre;
		this.idImagen = idImagen;
		this.nombreCientifico = nombreCientifico;
		this.descripion = descripion;
		this.familia = familia;
		this.tipo = tipo;
		plantas = new ArrayList<Planta>();
	}
	
	public Planta(Parcel source) {
		plantas = new ArrayList<Planta>();
		leerParcel(source);
	}

	public Planta(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
	
	public int getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripion() {
		return descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		if (nombreCientifico == null) {
			if (other.nombreCientifico != null)
				return false;
		} else if (!nombreCientifico.equals(other.nombreCientifico))
			return false;
		return true;
	}

	public static final Parcelable.Creator<Planta> CREATOR = 
			new Creator<Planta>() {
				
				@Override
				public Planta[] newArray(int size) {
					return new Planta[size];
				}
				
				@Override
				public Planta createFromParcel(Parcel source) {
					return new Planta(source);
				}
			};
			
	public void leerParcel(Parcel parcel) {
		this.idImagen = parcel.readInt();
		this.nombre = parcel.readString();
		this.nombreCientifico = parcel.readString();
		this.descripion = parcel.readString();
		this.familia = parcel.readString();
		this.origen = parcel.readString();
		this.tipo = parcel.readString();
		parcel.readTypedList(plantas, CREATOR);
	}
			
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.idImagen);
		dest.writeString(this.nombre);
		dest.writeString(this.nombreCientifico);
		dest.writeString(this.descripion);
		dest.writeString(this.familia);
		dest.writeString(this.origen);
		dest.writeString(this.tipo);
		dest.writeTypedList(plantas);
	}
	
}
