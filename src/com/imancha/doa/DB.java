package com.imancha.doa;

public class DB {
	public static final String[] doa = new String[] {
		"Doa Bangun Tidur",
		"Doa Keluar Masjid",
		"Doa Keluar Rumah",
		"Doa Masuk Masjid",
		"Doa Sebelum Makan",
		"Doa Sebelum Tidur",
		"Doa Sesudah Makan", 			 									 			 
	};
	
	public static final String[] arab = new String[] {			
		"اَلْحَمْدُ لِلّهِ الَّذِيْ اَحْيَانَا بَعْدَ مَا اَمَاتَنَا وَاِلَيْهِ النُّشُوْرِ",
		"اَللّهُمَّ افْتَحْلِيْ اَبْوَابَ فَضْلِكَ",
		"بِسْمِ اللّهِ تَوَكَّلْتُ عَلَى اللّهِ ﻻَ حَوْلَ وَﻻَ قُوَّةَ اِﻻَّ بِاللّهِ",
		"اَللّهُمَّ افْتَحْلِيْ اَبْوَابَ رَحْمَتِكَ", 
		"اللّهُمَّ بَارِكْ لَنَا فِيْمَا رَزَقْتَنَا وَقِنَا عَذَابَ النَّارِ",
		"بِسْمِكَ اللّهُمَّ اَحْيَا وَبِسْمِكَ اَمُوْتُ",
		"اَلْحَمْدُ لِلّهِ الَّذِيْ اَطْعَمَنَا وَسَقَانَا وَجَعَلَنَا مِنَ الْمُسْلِمِيْنَ",									
	};
	
	public static final String[] arti = new String[] {
		"Segala puji bagi Allah yang telah menghidupkan kami setelah mematikan kami dan kepada-Nya lah kami kembali",			
		"Ya Allah bukalah bagiku pintu-pintu keutamaan-Mu",
		"Dengan menyebut nama Allah saya berserah diri kepada Allah tidak ada daya dan upaya kecuali karena Allah",
		"Ya Allah bukalah bagiku pintu-pintu rahmat-Mu",
		"Ya Allah berkahilah kami terhadap apa yang telah Engkau rizkikan kepada kami dan jagalah kami dari siksa api neraka",
		"Dengan menyebut Nama-Mu Ya Allah aku hidup dan dengan menyebut Nama-Mu aku mati",
		"Segala puji bagi Allah yang telah memberikan kami makan dan minum dan menjadikan kami dari orang-orang muslim",																	
	};
	
	public static final int index(String title){
		int p = 0;
		for(int i=0; i<doa.length; i++){
			if(doa[i].equals(title)){
				p = i;
				break;
			}
		}
		
		return p;		
	}
}
