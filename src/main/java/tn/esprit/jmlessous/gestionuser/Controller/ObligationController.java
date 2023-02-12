package tn.esprit.jmlessous.gestionuser.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.jmlessous.gestionuser.DAO.Entities.Obligation;
import tn.esprit.jmlessous.gestionuser.Service.Implementation.ObligationService;





@RestController
@CrossOrigin(origins="*")
@RequestMapping("/obligation")

public class ObligationController {

	@Autowired
	 ObligationService Observice;
	  
		// http://localhost:8081/CyberFin/association/retrieve-all-association
		@GetMapping("/retrieve-all-obligation")
		@ResponseBody
		public List<Obligation> getAllObligation() {
			List<Obligation> list = Observice.findall();
			return list;
			}

		@GetMapping("/retrieve-obligation")
		@ResponseBody
		public Obligation getObligationS(@RequestParam("id") Long id) {
Obligation o = Observice.retrieveObligation(id);
			return o;
			}
		
		
		// http://localhost:8081/CyberFin/association/add-association
				@PostMapping("/add-obligation")
				@ResponseBody
				public Obligation ajouterObligation(@RequestBody Obligation o)
				
				{
					return Observice.addObligation(o);
					
				
				}
	  
				// http://localhost:8081/CyberFin/association/remove-association/{association-id}
				@DeleteMapping("/remove-obligation")
				@ResponseBody
				public void supprimerOB(@RequestParam("id") Long id) {
					Observice.deleteObligation(id);
				}
				
				//http://localhost:8081/CyberFin/association/modify-association
				@PutMapping("/modifier")
				@ResponseBody
				public Obligation modifierOb(@RequestBody Obligation c) {
				return Observice.updatObligation(c);
				}
				
				@GetMapping("/duration")
				@ResponseBody
				public double  DurationO(@RequestParam("id") Long id) {
					
					return Observice.Duration(id);
					}
				@GetMapping("/sensibilite")
				@ResponseBody
				public double  Sensibilité(@RequestParam Long id) {
					
					return Observice.Sensibilité(id);
					}
	
				

				@GetMapping("/simulation")
				@ResponseBody
				public String  Simulation(@RequestParam("id") Long id) {
					
					return Observice.simulateur(id);
					}
				
				
				
				@GetMapping("/generate-csv")
			    public void generateCSV(HttpServletResponse response) throws IOException {
			        response.setContentType("text/csv");
			        response.setHeader("Content-Disposition", "attachment; file=data.csv");

			        List<Obligation> List = Observice.findall();
			        try (PrintWriter writer = response.getWriter();
			             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
			                     .withHeader("  nom  ", "  valrurNom  ", "  Taux Coupon  ", "  Coupon  ", "  Taux d interet  ", "  Date debut  ", "  Echéance  ", "  duration  ", "  sensibilité  "))) {
			            for (Obligation ob : List) {
			                csvPrinter.printRecord(
			                        ob.getNomEmetteur(),
			                        ob.getValeurNom(),
			                        ob.getTauxCoupon(),
			                        ob.getCoupons(),
			                        ob.getTaux(),
			                        ob.getDateEmission(),
			                        ob.getEcheance(),
			                        Observice.Duration(ob.getIdObligation()),
			                        Observice.Sensibilité(ob.getIdObligation())
			                        
			                        
			                        
			                );
			            }
			            csvPrinter.flush();
			        }
				
				
				
}
}
