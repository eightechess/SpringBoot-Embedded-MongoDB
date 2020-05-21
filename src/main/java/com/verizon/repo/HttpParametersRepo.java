package com.verizon.repo;

import com.verizon.model.HttpParameters;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface HttpParametersRepo extends MongoRepository<HttpParameters, String> {

}
