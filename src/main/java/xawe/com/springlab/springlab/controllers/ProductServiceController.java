package xawe.com.springlab.springlab.controllers;

import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xawe.com.springlab.springlab.ProductNotfoundException;
import xawe.com.springlab.springlab.model.*;

@RestController
public class ProductServiceController{
    private static Map<String, Product> productRepo = new HashMap<>();

    static{
        Product honey = new Product();
        honey.setid("1");
        honey.setname("Mel de abelha");
        productRepo.put(honey.getid(), honey);

        Product almond = new Product();
        almond.setid("2");
        almond.setname("Almond");
        productRepo.put(almond.getid(), almond);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        productRepo.remove(id);
        return new ResponseEntity<>("Produto removido com sucesso", HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        if(!productRepo.containsKey(id)) throw new ProductNotfoundException();
        productRepo.remove(id);
        product.setid(product.getid());
        productRepo.put(product.getid(), product);
        return new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getid(), product);
        return new ResponseEntity<>("Produto criado com sucesso", HttpStatus.OK);
    }

    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
}
