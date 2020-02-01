package net.kmuniz.cashtrack.services;

import io.vavr.collection.List;
import io.vavr.control.Option;
import net.kmuniz.cashtrack.entities.Address;
import net.kmuniz.cashtrack.entities.Company;
import net.kmuniz.cashtrack.repository.ICompanyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyServiceImplTest {

    @Mock
    private ICompanyRepository repository;
    @InjectMocks
    CompanyServiceImpl service;

    @Test
    void createCompanyTest() {
        Company data = createMockCompany("123456", "Codesity", "vendor");
        when(repository.save(data)).thenReturn(data);
        Company result = service.createCompany(data);
        assertEquals(data.getCompanyId(), result.getCompanyId());
        assertEquals(data.getName(), result.getName());
    }


    @Test
    public void findCompanySuccessTest(){
        String id = "123456";
        Company data = createMockCompany(id, "Codesity", "vendor");
        when(repository.findByCompanyId(id)).thenReturn(Option.of(data));
        Option<Company> result = repository.findByCompanyId(id);
        result.onEmpty(() -> fail("Nothing found"));
        Company company = result.get();
        Assertions.assertEquals(data.getName(), company.getName());
        assertEquals(id, company.getCompanyId());
    }

    @Test
    public void findCompanyFailedTest(){
        String id = "12345";
        when(repository.findByCompanyId(id)).thenReturn(Option.none());
        Option<Company> result = repository.findByCompanyId(id);
        if (result.isDefined()) fail();
    }
    @Test
    public void findVendorsTest() {
        List<Company> vendors = createListOfCompanies("vendor");
        when(repository.findByUserIdAndType("user", "vendor")).thenReturn(vendors);
        List<Company> results = service.findVendors("user");
        assertEquals(vendors, results);
    }

    @Test
    public void findCustomersTest(){
        List<Company> customers = createListOfCompanies("customer");
        when(repository.findByUserIdAndType("user", "customer")).thenReturn(customers);
        List<Company> results = service.findCustomers("user");
        assertEquals(customers, results);
    }

    private Company createMockCompany(String id, String name, String type){
        Address address = new Address("Tallinn", "10130", "Kiriku 6 tn");
        return new Company(id, "user", name, type, "12345", address);
    }

    private List<Company> createListOfCompanies (String type){
        List<Company> results = List
                .of(createMockCompany("12345", "Codesity", type),
                        createMockCompany("12345", "Codesity", type),
                        createMockCompany("12345", "Codesity", type),
                        createMockCompany("12345", "Codesity", type),
                        createMockCompany("12345", "Codesity", type));
        return results;
    }
}
