package net.kmuniz.cashtrack.repository;

import io.vavr.control.Option;
import net.kmuniz.cashtrack.entities.Company;
import org.springframework.data.repository.CrudRepository;

import io.vavr.collection.List;

public interface ICompanyRepository extends CrudRepository<Company, String> {

    List<Company> findByUserIdAndType (String userId, String type);
    Option<Company> findByCompanyId (String companyId);
}

