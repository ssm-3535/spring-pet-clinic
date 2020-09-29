package ssm.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import ssm.springframework.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{

}
