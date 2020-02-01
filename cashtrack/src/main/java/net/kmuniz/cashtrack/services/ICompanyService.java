package net.kmuniz.cashtrack.services;

import io.vavr.collection.List;
import io.vavr.control.Option;
import net.kmuniz.cashtrack.entities.Company;

public interface ICompanyService {

    Company createCompany (Company company);

    void removeCompany (String id);

    void updateCompany (Company company);

    Option<Company> findCompanyById (String id);

    List<Company> findVendors (String userId);

    List<Company> findCustomers (String userId);
}
