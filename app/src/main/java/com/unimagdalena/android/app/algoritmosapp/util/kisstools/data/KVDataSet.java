package com.unimagdalena.android.app.algoritmosapp.util.kisstools.data;

public interface KVDataSet {

	public String get(String key);

	public boolean set(String key, String value);

	public boolean remove(String key);

	public boolean clear();

	public boolean delete();
}
