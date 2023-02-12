package tn.esprit.jmlessous.gestionuser.Service.Implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.Obligation;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.ObligationSlice;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.ObligationRepository;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.ObligationSliceRepository;
import tn.esprit.jmlessous.gestionuser.Service.Interface.IobligationSlice;


@Service
public class ObligationSliceService implements IobligationSlice{
@Autowired
ObligationSliceRepository obligsliceRepo;
@Autowired
ObligationRepository obligationrepo;
	@Override
	public ObligationSlice achatObligationCoupon(Long id) {
		Obligation obligation =obligationrepo.findById(id).get();
		ObligationSlice o=new ObligationSlice();
		 o.setObligation(obligation);
		 o.setDateachat(LocalDate.now());
		 o.setNomObligation(obligation.getNomEmetteur());
		 o.setTaux(obligation.getTaux());
		 o.setValeurNom(obligation.getValeurNom());
		 o.setCoupons(obligation.getCoupons());
		 o.setDatePayment(o.getDateachat().plusMonths(1));
		 o.setEcheance(obligation.getEcheance());
		 double p= PrixObligation2(o);
		 o.setPrix(p);
		 
		 //set Compte acheteur - prix ob 
		 //set compte beniff + prix ob
		 
		return obligsliceRepo.save(o);
	}

	@Override
	public ObligationSlice updatObligation(ObligationSlice o) {
		
		return null;
	}

	@Override
	public void deleteObligation(Long id) {
		obligsliceRepo.deleteById(id);		
	}

	@Override
	public List<ObligationSlice> findall() {
		// TODO Auto-generated method stub
		return obligsliceRepo.findAll();
	}
//@Schedueled
	@Override
	public void PaymentSliceCoupon(ObligationSlice o) {
		LocalDate now= LocalDate.now();
		if(o.getDatePayment()==now)
		{
			o.setStatus(true);
			//Compte.setBalance (Compte.getBalance()+o.getcoupon());
			//save(compte);
			//save(o);
		}
		
		
		
	}

	@Override
	public double PrixObligation(Long id) {
		ObligationSlice o=obligsliceRepo.findById(id).get();
		double prix=0;
		long years = java.time.temporal.ChronoUnit.YEARS.between( o.getDateachat() , o.getEcheance() );
		int i=0;
		for(i=0;i<years;i++)
		{
			prix+=o.getCoupons()*Math.pow(1+o.getTaux(),-i);
		
		}
		
		return prix+(o.getValeurNom()+o.getCoupons())*Math.pow(1+o.getTaux(),years);
	}

	@Override
	public double Duration(Long id) {
		ObligationSlice o=obligsliceRepo.findById(id).get();
		long years = java.time.temporal.ChronoUnit.YEARS.between( o.getDateachat() , o.getEcheance() );
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
		ObligationSlice o=obligsliceRepo.findById(id).get();
		return -d/(o.getTaux()+1);
	}

	@Override
	public ObligationSlice findObligation(Long id) {
		// TODO Auto-generated method stub
		return obligsliceRepo.findById(id).get();
	}

	@Override
	public double PrixObligation2(ObligationSlice o) {
		
		double prix=0;
		long years = java.time.temporal.ChronoUnit.YEARS.between( o.getDateachat() , o.getEcheance() );
		int i=0;
		for(i=0;i<years;i++)
		{
			prix+=o.getCoupons()*Math.pow(1+o.getTaux(),-i);
		
		}
		
		return prix+(o.getValeurNom()+o.getCoupons())*Math.pow(1+o.getTaux(),years);
	}

	@Override
	public double CoursObligation(ObligationSlice o, float r) {
		double prix=0;
		long years = java.time.temporal.ChronoUnit.YEARS.between( o.getDateachat() , o.getEcheance() );
		int i=0;
		for(i=0;i<years;i++)
		{
			prix+=o.getCoupons()*Math.pow(1+r,-i);
		
		}
		
		return o.getValeurNom()/(prix+(o.getValeurNom()+o.getCoupons())*Math.pow(1+r,years));
	}

	@Override
	public double PrixObligationCouponCouru(ObligationSlice o, float r) {
		
		return o.getValeurNom()*CoursObligation(o, r)+CouponCouru(o);
	}

	@Override
	public double CouponCouru(ObligationSlice o) {
		
		return 0;
	}


	
	
	

}
