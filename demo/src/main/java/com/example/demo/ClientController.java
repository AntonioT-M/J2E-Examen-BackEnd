/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import com.example.demo.repositories.ClientRepository;

/**
 *
 * @author atmim
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
   @Autowired
   private ClientRepository repository;
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public List<Client> getAllClient(){
       return repository.findAll();
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Client getClientById(@PathVariable("id") ObjectId id){
       return repository.findBy_ID(id);
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public void modifyClientById(@PathVariable("id") ObjectId id, @Valid 
   @RequestBody Client client){
       client.set_ID(id);
       repository.save(client);
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.POST)
   public Client createClient(@Valid @RequestBody Client client){
       client.set_ID(ObjectId.get());
       repository.save(client);
       return client;
   }
   
   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleteClient(@PathVariable ObjectId id){
       repository.delete(repository.findBy_ID(id));
   }
}
