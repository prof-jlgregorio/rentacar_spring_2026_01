package br.com.jlgregorio.rentacar.repository;

import br.com.jlgregorio.rentacar.model.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandModel, Long> {

}
