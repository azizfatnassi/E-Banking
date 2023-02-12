package tn.esprit.jmlessous.gestionuser.Service.Interface;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.InsuredProperty;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.PropertyType;
import tn.esprit.jmlessous.gestionuser.DAO.Repository.InsuredPropertyRepository;


import java.util.List;

public interface IPropertyService {
    InsuredPropertyRepository getInsuredProperty();

   void setInsuredProperty(InsuredPropertyRepository InsuredProperty);

   List<InsuredProperty> retrieveAllVisibleInsuredProperties();

   List<InsuredProperty> retrieveNotVisibleInsuredProperties();

   InsuredProperty addInsuredProperty(InsuredProperty ip);

   void deleteInsuredProperty(String id);

   InsuredProperty updateInsuredProperty(InsuredProperty ip);

    InsuredProperty retrieveInsuredProperty(String id);

   void archiveInsuredProperty(InsuredProperty ip);

   void affecterPropertyAContract(int propertyId, int contractId);

  Double TauxInsuredProperty(PropertyType type);
}
//