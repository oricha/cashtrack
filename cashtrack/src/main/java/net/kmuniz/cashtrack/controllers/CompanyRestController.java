package net.kmuniz.cashtrack.controllers;

import io.vavr.collection.List;
import io.vavr.control.Option;
import net.kmuniz.cashtrack.entities.Company;
import net.kmuniz.cashtrack.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/v1/companies")
@CrossOrigin(origins="*")
public class CompanyRestController {

    @Autowired
    private ICompanyService service;

    @PostMapping("/")
    public ResponseEntity<Company> createCompany (@RequestBody Company payload){
        Company result = service.createCompany(payload);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/")
    public void updateCompany(@RequestBody Company payload){
        service.updateCompany(payload);
    }

    @DeleteMapping("/{companyId}")
    public void removeCompany(@PathVariable String companyId){
        service.removeCompany(companyId);
    }

    @GetMapping("/one/{companyId}")
    public ResponseEntity<Company> findOneCompany (@PathVariable String companyId){
        Option<Company> result = service.findCompanyById(companyId);
        if (result.isDefined()){
            Company company = result.get();
            return ResponseEntity.ok(company);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/vendors/{userId}")
    public ResponseEntity<List<Company>> findVendors (@PathVariable String userId){
        List<Company> results = service.findVendors(userId);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/customers/{userId}")
    public ResponseEntity<List<Company>> findCustomers (@PathVariable String userId){
        List<Company> results = service.findCustomers(userId);
        return ResponseEntity.ok(results);
    }
}
