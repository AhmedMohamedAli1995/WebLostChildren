/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 *
 * @author eslam java
 */
@Entity
@Table(name = "found")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Found.findAll", query = "SELECT f FROM Found f"),
    @NamedQuery(name = "Found.findById", query = "SELECT f FROM Found f WHERE f.id = :id"),
    @NamedQuery(name = "Found.findByFirstName", query = "SELECT f FROM Found f WHERE f.firstName = :firstName"),
    @NamedQuery(name = "Found.findByLastName", query = "SELECT f FROM Found f WHERE f.lastName = :lastName"),
    @NamedQuery(name = "Found.findByMotherName", query = "SELECT f FROM Found f WHERE f.motherName = :motherName"),
    @NamedQuery(name = "Found.findByImageUrl", query = "SELECT f FROM Found f WHERE f.imageUrl = :imageUrl"),
    @NamedQuery(name = "Found.findByFromAge", query = "SELECT f FROM Found f WHERE f.fromAge = :fromAge"),
    @NamedQuery(name = "Found.findByToAge", query = "SELECT f FROM Found f WHERE f.toAge = :toAge"),
    @NamedQuery(name = "Found.findByGender", query = "SELECT f FROM Found f WHERE f.gender = :gender"),
    @NamedQuery(name = "Found.findByFoundDate", query = "SELECT f FROM Found f WHERE f.foundDate = :foundDate"),
    @NamedQuery(name = "Found.findByFoundLocation", query = "SELECT f FROM Found f WHERE f.foundLocation = :foundLocation"),
    @NamedQuery(name = "Found.findByReturned", query = "SELECT f FROM Found f WHERE f.returned = :returned"),
    @NamedQuery(name = "Found.findByCurrentLocation", query = "SELECT f FROM Found f WHERE f.currentLocation = :currentLocation"),
    @NamedQuery(name = "Found.updateFoundReturned", query = "UPDATE Found f  set f.returned =:returned where f.id =:id"),
    @NamedQuery(name = "Found.findByGenderFnameLname", query = "SELECT f FROM Found f WHERE f.firstName = :firstName AND f.lastName=:lastName AND f.gender=:gender"),
    @NamedQuery(name = "Found.findByGenderFname", query = "SELECT f FROM Found f WHERE f.firstName = :firstName AND f.gender=:gender"),
    @NamedQuery(name = "Found.findByGenderLname", query = "SELECT f FROM Found f WHERE f.lastName=:lastName AND f.gender=:gender")})
public class Found implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 20)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 20)
    @Column(name = "mother_name")
    private String motherName;
    @Basic(optional = false)
    @Size(min = 1, max = 2000)
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "from_age")
    private Integer fromAge;
    @Column(name = "to_age")
    private Integer toAge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "gender")
    private String gender;
    @Size(max = 45)
    @Column(name = "found_date")
    private String foundDate;
    @Size(max = 200)
    @Column(name = "found_location")
    private String foundLocation;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "returned")
    private String returned;
    @Size(max = 200)
    @Column(name = "current_location")
    private String currentLocation;
    @JoinColumn(name = "found_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)

    private Users foundUserId;

    public Found() {
    }

    public Found(Integer id) {
        this.id = id;
    }

    public Found(Integer id, String imageUrl, String gender, String returned) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.gender = gender;
        this.returned = returned;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getFromAge() {
        return fromAge;
    }

    public void setFromAge(Integer fromAge) {
        this.fromAge = fromAge;
    }

    public Integer getToAge() {
        return toAge;
    }

    public void setToAge(Integer toAge) {
        this.toAge = toAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

    public String getFoundLocation() {
        return foundLocation;
    }

    public void setFoundLocation(String foundLocation) {
        this.foundLocation = foundLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Users getFoundUserId() {
        return foundUserId;
    }

    public void setFoundUserId(Users foundUserId) {
        this.foundUserId = foundUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Found)) {
            return false;
        }
        Found other = (Found) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.pojo.Found[ id=" + id + " ]";
    }

}
