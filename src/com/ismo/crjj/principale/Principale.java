package com.ismo.crjj.principale;

import java.util.Scanner;

import com.entities.Appartement;
import com.entities.Etage;
import com.entities.Immeuble;
import com.entities.Rue;
import com.ismo.crjj.dao.DaoAppartement;
import com.ismo.crjj.dao.DaoEtage;
import com.ismo.crjj.dao.DaoFactory;
import com.ismo.crjj.dao.DaoImmeuble;
import com.ismo.crjj.dao.DaoRue;
import com.ismo.crjj.dao.TypeDao;

public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i= 0;
		   Scanner sc =new Scanner(System.in);
		
				DaoImmeuble doaImm= (DaoImmeuble) DaoFactory.getDAO(TypeDao.Immeuble);
				for(Immeuble Im : doaImm.getAll())
					System.out.println(Im);
				
			
				System.out.println("Donner une rue");
				int id=sc.nextInt();
				DaoRue doaRue= (DaoRue) DaoFactory.getDAO(TypeDao.Rue);
				Rue rue = doaRue.getOne(id);
				for(Immeuble Im : rue.getImmeubles())
					System.out.println(Im);
				
			
				System.out.println("Donner une appartement");
				String ids  = sc.next();
				DaoAppartement daoApp= (DaoAppartement) DaoFactory.getDAO(TypeDao.Appartement);
				Appartement app=new Appartement(ids,0);
				if(daoApp.delete(app))
					System.out.println("l'appartement est supprime");
				else
					System.out.println("l'appartement n'est pas supprime");
				
				
				System.out.println("Donner une etage");
				id  = sc.nextInt();
				DaoEtage daoEtage= (DaoEtage) DaoFactory.getDAO(TypeDao.Etage);
				
				System.out.println("Donner un nb App");
				int  nbApp = sc.nextInt();
				Etage et=new Etage(0, nbApp);
				if(daoEtage.update(et))
					System.out.println("l'etage est modifiee");
				else
					System.out.println("l'etage n'est pas modifie");
				
			}
		   
	}



