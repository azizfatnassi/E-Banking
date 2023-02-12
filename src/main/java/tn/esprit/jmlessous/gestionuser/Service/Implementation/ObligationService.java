package tn.esprit.jmlessous.gestionuser.Service.Implementation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.Obligation;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.ObligationRepository;
import tn.esprit.jmlessous.gestionuser.Service.Interface.Iobligation;


@Service
public class ObligationService implements Iobligation {
@Autowired
ObligationRepository obligationrepo;
	@Override
	public Obligation addObligation(Obligation o) {
		o.setDateEmission(LocalDate.now());
		
		o.setPeriode( ChronoUnit.MONTHS.between(o.getDateEmission(), o.getEcheance()));
		return obligationrepo.save(o);
	}

	@Override
	public Obligation updatObligation(Obligation o) {
		// TODO Auto-generated method stub
		return obligationrepo.save(o);
	}

	@Override
	public void deleteObligation(Long id) {
		// TODO Auto-generated method stub
		 obligationrepo.deleteById(id);
	}

	@Override
	public List<Obligation> findall() {
		// TODO Auto-generated method stub
		return obligationrepo.findAll();
	}
	
	@Override
	public Obligation retrieveObligation(Long id) {
		// TODO Auto-generated method stub
		return obligationrepo.findById(id).get();
	}
	
	@Override
	public double Duration(Long id) {
		Obligation o=obligationrepo.findById(id).get();
		long years = java.time.temporal.ChronoUnit.YEARS.between( o.getDateEmission() , o.getEcheance() );
		int i=0;
		double a=0;
		double b=0;
		double duration=0;
		
		for(i=0;i<years;i++)
		{
			 a+=i*o.getCoupons()*Math.pow(1+o.getTaux(),-i);
			 b+=o.getCoupons()*Math.pow(1+o.getTaux(),-i);
		
		}
		duration=(a+(o.getValeurNom()+o.getCoupons())*Math.pow(1+o.getTaux(),years))/(b+(years*(o.getValeurNom()+o.getCoupons())*Math.pow(1+o.getTaux(),years)));
		return duration;
	}
	
	


		@Override
		public double Sensibilité(Long id) {
			double d=Duration(id);
			Obligation o=obligationrepo.findById(id).get();
			return -d/(o.getTaux()+1);
		}
		@Override
		public double PrixObligation2(Obligation o) {
			
			double prix=0;
			long years = java.time.temporal.ChronoUnit.YEARS.between( o.getDateEmission() , o.getEcheance() );
			int i=0;
			for(i=0;i<years;i++)
			{
				prix+=o.getCoupons()*Math.pow(1+o.getTaux(),-i);
			
			}
			
			return prix+(o.getValeurNom()+o.getCoupons())*Math.pow(1+o.getTaux(),years);
		}

		@Override
		public Obligation comparaison() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String simulateur(Long id) {
		Obligation ob= obligationrepo.findById(id).get();
		long years = java.time.temporal.ChronoUnit.YEARS.between( ob.getDateEmission() , ob.getEcheance() );
		double interet = Capitalisation(ob);
		double interet2 = ob.getValeurNom() - interet;
		
			return "votre investissment de " +ob.getValeurNom() +" dans l'obligation de " + ob.getNomEmetteur() +" retourne\n"+
			interet+ " interet de \n" +interet2 +
			"dans une periode de " +years +" ans";
		}

		@Override
		public double Capitalisation(Obligation ob) {
			long years = java.time.temporal.ChronoUnit.YEARS.between( ob.getDateEmission() , ob.getEcheance() );
			
			return  ob.getCoupons()*years+ob.getValeurNom();
		}

		 
}
