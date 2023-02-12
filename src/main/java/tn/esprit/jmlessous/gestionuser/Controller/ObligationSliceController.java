package tn.esprit.jmlessous.gestionuser.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import tn.esprit.jmlessous.gestionuser.DAO.Entities.ObligationSlice;
import tn.esprit.jmlessous.gestionuser.Service.Implementation.ObligationSliceService;



@RestController
@RequestMapping("/sliceObligation")
@CrossOrigin(origins="http://localhost:4200")
public class ObligationSliceController {
	@Autowired
	 ObligationSliceService Sliceservice;
	  
		// http://localhost:8081/CyberFin/association/retrieve-all-association
		@GetMapping("/retrieve-all-obligation")
		@ResponseBody
		public List<ObligationSlice> getAllObligationS() {
			List<ObligationSlice> list = Sliceservice.findall();
			return list;
			}
		
		@GetMapping("/retrieve-obligation/{id}")
		@ResponseBody
		public ObligationSlice getObligationS(@PathVariable("id") Long id) {
			ObligationSlice o = Sliceservice.findObligation(id);
			return o;
			}

		
		
		
				@PostMapping("/add-obligation")
				@ResponseBody
				public ObligationSlice acheterObligation(@RequestParam("id") Long id)
				
				{
					return Sliceservice.achatObligationCoupon( id);
					
				
				}
	  
				// http://localhost:8081/CyberFin/association/remove-association/{association-id}
				@DeleteMapping("/remove-obligation")
				@ResponseBody
				public void supprimerOB(@RequestParam("id") Long id) {
					Sliceservice.deleteObligation(id);
				}
				
				//http://localhost:8081/CyberFin/association/modify-association
				@PutMapping("/modifier")
				@ResponseBody
				public ObligationSlice modifierOb(@RequestBody ObligationSlice o) {
				return Sliceservice.updatObligation(o);
				}

				
				@GetMapping("/prix/{id}")
				@ResponseBody
				public double  Prix(@PathVariable("id") Long id) {
					
					return Sliceservice.PrixObligation(id);
					}

				@GetMapping("/duration")
				@ResponseBody
				public double  DurationO(@RequestParam("id") Long id) {
					
					return Sliceservice.Duration(id);
					}
				
				@GetMapping("/sensibilite")
				@ResponseBody
				public double  Sensibilité(@RequestParam Long id) {
					
					return Sliceservice.Sensibilité(id);
					}
				
				
}
