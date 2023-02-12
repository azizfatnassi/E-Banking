package tn.esprit.jmlessous.gestionuser.Service.Interface;


import tn.esprit.jmlessous.gestionuser.DAO.Entities.InsurenceContract;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.Utilisateur;


import java.util.List;

public interface IInsurenceContractService {

  List<InsurenceContract> retrieveAllContracts();
  InsurenceContract addContract(InsurenceContract contract, int propertyId, String clientId);
  void deleteContract(String id);
  InsurenceContract updateContract(InsurenceContract ip);
  InsurenceContract retrieveContract(String id);
  void affecterPropertyAContract(int propertyId, int contractId);
  void discountPremiumByStat(int contractId);
  float PremiumManagementByClientSalary(String clientCIN);
  Double PremiumManagementByInsuredPropertyValue(InsurenceContract contract,double premium);
  Double PremiumManagementByInsuredPropertyStats(InsurenceContract contract, int propertyId);
  Double PremiumManagementByZoning(InsurenceContract contract, Utilisateur client);
  InsurenceContract renewContract(int contractId);
  List<InsurenceContract> retrieveAllContractsByClient(int clientCin);
  void terminateContract(int contractId);
  Double PremiumManagementByContractRank(InsurenceContract contract);

}//
