package com.springbackend.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;



@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="street")
    private String street;


     @Column(name="city")
    private String city;

    @Column(name="province")
    private String province;


     @Column(name="country")
    private String country;

     
     
     @Column(name="postcode")
    private String postcode;

    @OneToOne
    @PrimaryKeyJoinColumn //join primary keys by default keys have same name(join based on id of order and address. all hibernate)
    private Order order;


    public Long getId() {
        return id;
      }
      
      public void setId(Long id) {
        this.id = id;
      }
      
      public String getCity() {
        return city;
      }
      
      public void setCity(String city) {
        this.city = city;
      }
      
      public String getCountry() {
        return country;
      }
      
      public void setCountry(String country) {
        this.country = country;
      }
      
      public String getProvince() {
        return province;
      }
      
      public void setProvince(String province) {
        this.province = province;
      }
      
      public String getStreet() {
        return street;
      }
      
      public void setStreet(String street) {
        this.street = street;
      }
      
      public String getPostcode() {
        return postcode;
      }
      
      public void setPostcode(String postcode) {
        this.postcode = postcode;
      }
      
    
}
