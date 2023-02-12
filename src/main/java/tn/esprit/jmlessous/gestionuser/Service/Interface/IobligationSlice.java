package tn.esprit.jmlessous.gestionuser.Service.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.ObligationSlice;





@Service
public interface IobligationSlice {
	ObligationSlice findObligation(Long id);
	ObligationSlice achatObligationCoupon( Long id);
	ObligationSlice updatObligation(ObligationSlice o);
	void deleteObligation(Long id);
	List<ObligationSlice> findall();
	void PaymentSliceCoupon(ObligationSlice o);
	double PrixObligation(Long id);
	double PrixObligation2(ObligationSlice o);
	double CoursObligation(ObligationSlice o,float r);
	double Duration(Long id);
	double Sensibilité(Long id);
	double PrixObligationCouponCouru(ObligationSlice o,float r);
	double CouponCouru(ObligationSlice o);
}
