/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.models.Client;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author atmim
 */
public interface ClientRepository extends MongoRepository<Client, String>{
    Client findBy_ID(ObjectId Client_ID);
}
