package com.ductran.dochoioto.service;

public class GenericService{
	public String setID(String id) {
		int id_number = Integer.parseInt(id.substring(1))+1;
		String id_firstChar = id.substring(0, 1);	
		String zeroText = "000000";
		int id_temp = id_number;
		for(int i = 0 ; i < zeroText.length(); i++) {
			if(id_temp >= 10) {
				zeroText = zeroText.substring(1);
				id_temp /=10;
			}
		}
		String result = id_firstChar+zeroText+id_number;
		return result;
	}
	
}
