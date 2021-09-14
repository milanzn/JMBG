package domaci;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		String jmbg;
		Scanner s = new Scanner(System.in);
		int danRodjenja;
		int mesecRodjenja;
		int godinaRodjenja;
		int regionRodjenja;
		int kontrolnaCifra;
		int a , b , v , g , d , dj , e , z1 , z , i , j , k ; 
		int proveraKontrolneC;
		String poruka = "Poruka o validaciji: \n";
		System.out.println("Unesite Vas jedinstveni maticni broj gradjana: ");
		jmbg = s.next();
	
		
		if (jmbg.length() > 13) {
			
			System.out.println(poruka + "Uneli ste vise od 13 cifara za Vas JMBG! Pokrenite ponovo program i unesite pravilno Vas JMBG.");
		
		}
		
		else if (jmbg.length() < 13) {
				
				System.out.println(poruka + "Uneli ste manje od 13 cifara za Vas JMBG! Pokrenite ponovo program i unesite pravilno Vas JMBG");
		
		}
		
		else {
			
			
			danRodjenja = Integer.parseInt(jmbg.substring(0, 2));
			mesecRodjenja = Integer.parseInt(jmbg.substring(2, 4));
			godinaRodjenja = Integer.parseInt(jmbg.substring(4, 7));
			regionRodjenja = Integer.parseInt(jmbg.substring(7, 9));
			kontrolnaCifra = Integer.parseInt(jmbg.substring(12, 13));

			a = Integer.parseInt(jmbg.substring(0, 1)); 
			b = Integer.parseInt(jmbg.substring(1, 2));
			v = Integer.parseInt(jmbg.substring(2, 3));
			g = Integer.parseInt(jmbg.substring(3, 4));
			d = Integer.parseInt(jmbg.substring(4, 5));
			dj = Integer.parseInt(jmbg.substring(5, 6));
			e = Integer.parseInt(jmbg.substring(6, 7));
			z1 = Integer.parseInt(jmbg.substring(7, 8));
			z = Integer.parseInt(jmbg.substring(8, 9));
			i = Integer.parseInt(jmbg.substring(9, 10));
			j = Integer.parseInt(jmbg.substring(10, 11));
			k = Integer.parseInt(jmbg.substring(11, 12));
			
			
			proveraKontrolneC = 11 - ((7*(a + e) + 6 * (b + z1) + 5 * (v + z) + 4 * (g + i) + 3 * (d + j) + 2 * (dj + k)) % 11);
			// Stampam KC radi lakse provere:	
			System.out.println(proveraKontrolneC);	
			
			if (danRodjenja == 0) {
				
				poruka = poruka + "Za dan rodenja ste uneli broj 00!\n";
			}
				
			if (mesecRodjenja == 0) {
				
				poruka = poruka + "Za mesec rodenja ste uneli broj 00!\n";
			}
				
				
			if((mesecRodjenja == 4 | mesecRodjenja == 6 | mesecRodjenja == 9 | mesecRodjenja == 11) & danRodjenja >30) {
				
			poruka = poruka + ("Za dan rodjenja ste uneli broj: " + danRodjenja + ", najveci moguci broj dana za uneti mesec je 30!\n");
					
			}
			
			else if (mesecRodjenja == 2 & danRodjenja > 29) {
				
					
				poruka = poruka + ("Za dan rodjenja ste uneli broj " + danRodjenja + ", a za mesec febraur najveci moguci broj dana je 28, odnosno 29 za prestupne godine!\n");
			}
			
			else if (mesecRodjenja == 2 & danRodjenja > 28 & ((godinaRodjenja % 4 != 0) | (godinaRodjenja == 900) | (godinaRodjenja == 100)) ) {
					 
				/* 1900. i 2100. god su stolecne godine koje nisu prestupne.
				Eventulna greska se moze javiti sledece stolecne godine koja nije prestupna,
				a to je 2200. god, sto se moze otkloniti dodavanjem jos jednog ili uslova */
				// Takodje, samo proverom deljivosti (trocifrenog broja dobijenog iz JMBG) sa 400, prve greske se javljaju 3000 i 3200 godine 
				
				
				poruka = poruka + ("Za dan rodjenja ste uneli broj " + danRodjenja + ", dok godina koju ste uneli nije prestupna!\n");
									 
				 }
			else if (danRodjenja > 31 & mesecRodjenja < 13) {
				
				poruka = poruka + "Za dan rodjenja ste uneli broj: " + danRodjenja + ", najveci moguci broj dana za uneti mesec je 31!\n";
			}
			
			else if (danRodjenja > 31 & mesecRodjenja > 12) {
				
				poruka = poruka + "Za dan rodjenja ste uneli broj: " + danRodjenja + ", najveci moguci broj dana je izmedju 28 i 31, u zavisnosti od meseca rodjenja!\n";
			}
			if (mesecRodjenja > 12) {
					
				poruka = poruka + "Za mesec rodjenja ste uneli broj: " + mesecRodjenja + ", najveci moguci broj za mesec rodjena je 12!\n";
					}
			
			if (regionRodjenja == 40 | (regionRodjenja < 70 & regionRodjenja > 50)) {
				
				// gore navedeni opseg nije koriscen za broj regiona za JMBG u SFRJ.
				
				poruka = poruka + ("Uneli ste pogresan region rodjenja!\n");
			}
			
			if ((proveraKontrolneC >9 & kontrolnaCifra !=0) | (proveraKontrolneC >0 & proveraKontrolneC < 10 & proveraKontrolneC != kontrolnaCifra)){
				
				poruka = poruka + ("Niste uneli tacnu kontrolnu cifru!\n");		
			}
				
			else if (poruka != "Poruka o validaciji: \n"){
					
					poruka = poruka + "Proverite kontrolnu cifru, ista je tacna za prethodno nepravilno uneseni JMBG, " +
							"ali mozda nece biti odgovarajuca za pravilan JMBG. \n";
				
					/* Gornji else if je uradjen zbog primera: 3315985710122, ovaj JMBG ima pogresan dan i mesec rodjenja, ali tacnu kontrolnu cifru za taj JMBG,
					koja mozda nece biti tacna u ako se samo unesu tacni dan i mesec rodjenja. */
			}
			
			if (poruka.equalsIgnoreCase("Poruka o validaciji: \n")) {
						
			System.out.println("Validacija Vaseg JMBG je pravilna.");
			
			} else System.out.println(poruka);
		
		}
			s.close();
		}

}
