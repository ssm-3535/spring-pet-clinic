package ssm.springframework.springpetclinic.services;

import java.util.Set;

import ssm.springframework.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
	
}
