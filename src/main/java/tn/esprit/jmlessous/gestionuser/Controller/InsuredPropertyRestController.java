package tn.esprit.jmlessous.gestionuser.Controller;

import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;

import org.springframework.web.bind.annotation.*;
import tn.esprit.jmlessous.gestionuser.DAO.Entities.InsuredProperty;
import tn.esprit.jmlessous.gestionuser.Service.Interface.IPropertyService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class InsuredPropertyRestController {
    @Autowired
    IPropertyService propertyService;


    @GetMapping("/retrieve-all-visible-properties")
    @ResponseBody
    public List<InsuredProperty> getVisibleProperties() {
        List<InsuredProperty> list = propertyService.retrieveAllVisibleInsuredProperties();
        return list;
    }


    @GetMapping("/retrieve-not-visible-properties")
    @ResponseBody
    public List<InsuredProperty> getNotVisibleProperties() {
        List<InsuredProperty> list = propertyService.retrieveNotVisibleInsuredProperties();
        return list;
    }


    @PutMapping("/archive/{id}")
    @ResponseBody
    public void archive(@PathVariable("id") String id) {
        propertyService.archiveInsuredProperty(propertyService.retrieveInsuredProperty(id));
    }


    @PutMapping("/affecter/{contractId}/{propertyId}")
    @ResponseBody
    public void affecter(@PathVariable("contractId") int contractId, @PathVariable("propertyId") int propertyId) {
        propertyService.affecterPropertyAContract(propertyId, contractId);
    }


    @PostMapping("/add-ip")
    @ResponseBody
    public InsuredProperty addInsuredProperty(@RequestBody InsuredProperty ip) {
        InsuredProperty inp = propertyService.addInsuredProperty(ip);
        return inp;
    }


    @GetMapping("/retrieveProperty/{propertyId}")
    @ResponseBody
    public InsuredProperty retrieveContract(@PathVariable("propertyId") String propertyId) {
        return propertyService.retrieveInsuredProperty(propertyId);
    }


    @PutMapping("/modify-property")
    @ResponseBody
    public InsuredProperty modifyProperty(@RequestBody InsuredProperty inp) {
        return propertyService.updateInsuredProperty(inp);
    }
}