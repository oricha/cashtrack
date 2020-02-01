package net.kmuniz.cashtrack.services;

import io.vavr.control.Option;
import net.kmuniz.cashtrack.entities.Company;
import net.kmuniz.cashtrack.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.vavr.collection.List;

@Component("ICompanyService")
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyRepository repository;

    @Override
    public Company createCompany(Company company) {
        return repository.save(company);
    }

    @Override
    public void removeCompany(String id) {
        repository.deleteById(id);
    }

    @Override
    public Option<Company> findCompanyById(String id) {
        return repository.findByCompanyId(id);
    }

    @Override
    public List<Company> findVendors(String userId) {
        return repository.findByUserIdAndType(userId, "vendor");
    }

    @Override
    public List<Company> findCustomers(String userId) {
        return repository.findByUserIdAndType(userId, "customer");
    }

    @Override
    public void updateCompany(Company company) {
        repository.findByCompanyId(company.getCompanyId())
                .peek(data -> repository.save(company));
    }
}
