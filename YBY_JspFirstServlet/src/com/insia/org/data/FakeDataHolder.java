package com.insia.org.data;

import java.lang.reflect.Field;
import java.util.*;


public class FakeDataHolder {
	private static FakeDataHolder instance = null;
	
	private Map<String, List<? extends Object>> data = new HashMap<String, List<? extends Object>>();
	
	private FakeDataHolder() {
		
	}
	
	public static FakeDataHolder getInstance() {
		if(instance == null) {
			instance = new FakeDataHolder();
		}
		return instance;
	}
	
	/**
	 * Returns the List instance representing the table <tableName>.
	 * @param tableName The name of the table to get
	 * @return The List instance corresponding to the tableName given, or NULL if that table does not exist.
	 */
	public List<? extends Object> get(String tableName) {
		if(tableName != null && data.containsKey(tableName)) {
			return data.get(tableName);
		}
		return null;
	}

	/**
	 * Create a new table and returns the List instance created. Cannot override an existing table
	 * @param tableName
	 * @return The List instance created or null if the table couldn't be created.
	 */
	public List<? extends Object> createTable(String tableName) {
		if(tableName != null && !tableName.trim().equals("") && !data.containsKey(tableName)) {
			List<Object> ft = new ArrayList<Object>();
			data.put(tableName, ft);
			return ft;
		}
		return null;
	}
	
	/**
	 * Delete the <tableName> entry, or do nothing if the table didn't exist
	 * @param tableName
	 */
	public void dropTable(String tableName) {
		if(tableName != null && data.containsKey(tableName)) {
			data.remove(tableName);
		}
	}
	
	/**
	 * Recherche dans la table sp�cifi�e un objet ayant pour valeur propertyValue � l'attribut propertyName.
	 * @param tableName Le nom de la table
	 * @param propertyName Le nom de la propri�t� de l'objet � comparer
	 * @param propertyValue La valeur de la propri�t� qui doit correspondre
	 * @return Retourne le premier objet trouv� ou NULL si la recherche n'a pas aboutie
	 */
	public Object findOne(String tableName, String propertyName, Object propertyValue) {
		List<? extends Object> table = get(tableName);
		if(table == null){
			return null;
		}
		// Recherche de l'objet contenant la valeur souhaitee dans la propriete
		for(Object row:table){
			// Parcours de tous les champs de la classe
			try{
				Field field = row.getClass().getDeclaredField(propertyName);
				field.setAccessible(true);
				Object prop = field.get(row);
				if(prop.equals(propertyValue)){
					return row;
				}
			} catch (NoSuchFieldException nsfe) {
				continue;
			} catch(IllegalAccessException iae) {
				System.err.println("Impossible d'acceder a la propriete " + propertyName + " : acces refuse.");
				iae.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Recherche dans la table sp�cifi�e un objet ayant pour valeur propertyValue � l'attribut propertyName.
	 * @param tableName Le nom de la table
	 * @param propertyName Le nom de la propri�t� de l'objet � comparer
	 * @param propertyValue La valeur de la propri�t� qui doit correspondre
	 * @return Retourne le premier objet trouv� ou NULL si la recherche n'a pas aboutie
	 */
	public Object findOne(String tableName, String[] propertyName, Object[] propertyValue) {
		List<? extends Object> table = get(tableName);
		if(table == null){
			return null;
		}
		
		// Recherche de l'objet contenant la valeur souhaitee dans la propriete
		for(Object row:table){
			// Parcours de tous les champs de la classe
			boolean found = true;
			for(int i = 0; i < propertyName.length; i++) {
				try{
					Field field = row.getClass().getDeclaredField(propertyName[i]);
					field.setAccessible(true);
					Object prop = field.get(row);
					if(!prop.equals(propertyValue[i])){
						found = false;
						break;
					}
				} catch (NoSuchFieldException nsfe) {
					found = false;
					break;
				} catch(IllegalAccessException iae) {
					System.err.println("Impossible d'acceder a la propriete " + propertyName[i] + " : acces refuse.");
					iae.printStackTrace();
				}
			}
			if(found) {
				return row;
			}
		}
		
		return null;
	}
	
	/**
	 * Recherche dans la table sp�cifi�e les objets ayant pour valeur propertyValue � l'attribut propertyName.
	 * @param tableName Le nom de la table
	 * @param propertyName Le nom de la propri�t� � comparer
	 * @param propertyValue La valeur de la propri�t� qui doit correspondre
	 * @return Retourne une liste des objets trouv�s (eventuellement vide si la recherche n'a pas aboutie)
	 */
	public List<? extends Object> findAll(String tableName, String propertyName, Object propertyValue) {
		List<? extends Object> table = get(tableName);
		List<Object> results = new ArrayList<Object>();
		if(table == null){
			return results;
		}
		
		// Recherche de l'objet contenant la valeur souhaitee dans la propriete
		for(Object row:table){
			// Parcours de tous les champs de la classe
			try{
				Field field = row.getClass().getDeclaredField(propertyName);
				field.setAccessible(true);
				Object prop = field.get(row);
				if(prop.equals(propertyValue)){
					results.add(row);
				}
			} catch (NoSuchFieldException nsfe) {
				continue;
			} catch(IllegalAccessException iae) {
				System.err.println("Impossible d'acceder a la propriete " + propertyName + " : acces refuse.");
				iae.printStackTrace();
			}
		}
				
		return results;
	}
	
	/**
	 * Recherche dans la table sp�cifi�e les objets dont la valeur de l'attribut propertyName contient au moins propertyValue.
	 * @param tableName Le nom de la table
	 * @param propertyName Le nom de la propri�t� � comparer
	 * @param propertyValue La valeur de la propri�t� qui doit correspondre
	 * @return Retourne une liste des objets trouv�s (eventuellement vide si la recherche n'a pas aboutie)
	 */
	public List<? extends Object> findAllLike(String tableName, String propertyName, String propertyValue) {
		List<? extends Object> table = get(tableName);
		List<Object> results = new ArrayList<Object>();
		if(table == null){
			return results;
		}
		
		// Recherche de l'objet contenant la valeur souhaitee dans la propriete
		for(Object row:table){
			// Parcours de tous les champs de la classe
			try{
				Field field = row.getClass().getDeclaredField(propertyName);
				field.setAccessible(true);
				Object prop = field.get(row);
			
				if(prop.toString().contains(propertyValue)){
					results.add(row);
				}					
			} catch (NoSuchFieldException nsfe) {
				continue;
			} catch(IllegalAccessException iae) {
				System.err.println("Impossible d'acceder a la propriete " + propertyName + " : acces refuse.");
				iae.printStackTrace();
			}
		}
				
		return results;
	}
}
