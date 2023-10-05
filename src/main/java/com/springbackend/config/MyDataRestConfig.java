package com.springbackend.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.springbackend.entity.Country;
import com.springbackend.entity.Product;
import com.springbackend.entity.ProductCategory;
import com.springbackend.entity.Province;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    // Autowiring JPA entity Maanager
    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager; // effectively injecting the jpa entity manager using constructor injection
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH };

        // disable HTTP methods for given entity classsed: PUT, POST, DELETE and PATCH
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);
        disableHttpMethods(Product.class, config, theUnsupportedActions);
        disableHttpMethods(Province.class, config, theUnsupportedActions);
        disableHttpMethods(Country.class, config, theUnsupportedActions);

        // call an internal helper method to help expose the id's
        exposeIds(config);

    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config,
            HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids
        //

        // get a collection of all entity classes from entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an arraylist of thos entity types

        List<Class> entityClasses = new ArrayList<>();

        // get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // finally expose the entity id's for the entites / domain types

        Class[] domainTypes = entityClasses.toArray(new Class[0]); // take that emntity class and convert ot to an array
        config.exposeIdsFor(domainTypes); // gave it the array of classes to expose the id's for those given domain
                                          // types / id
    }
}