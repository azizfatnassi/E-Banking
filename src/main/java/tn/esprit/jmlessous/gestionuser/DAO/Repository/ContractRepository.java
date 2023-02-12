package tn.esprit.jmlessous.gestionuser.DAO.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.InsurenceContract;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.PropertyType;


public interface ContractRepository extends CrudRepository<InsurenceContract,Integer >{
    @Query("SELECT DISTINCT ip.propertyType from CONTRACT cont "
            + "join cont.fkInsuredProperty ip "
            + "where cont.idContract =:idContract ")
    public PropertyType getPropertyTypeByContractId(@Param("idContract")int idContract);

    @Query("SELECT count(cont) from CONTRACT cont "
            + "join cont.fkClient cl "
            + "Where cl.cin = :cin")
    public int countContractNumberByClientCIN(@Param("cin")String cin);

    @Query("SELECT cont from CONTRACT cont "
            + "join cont.fkClient cl "
            + "Where cl.cin = :cin "
            + "AND cont.visibility = true")
    public List<InsurenceContract> findContractsByClientCIN(@Param("cin")int cin);

    @Query("SELECT cont from CONTRACT cont "
            + "Where cont.visibility = true")
    public List<InsurenceContract> findVisibleContracts();

}
