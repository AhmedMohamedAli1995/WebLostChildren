/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.pojo;

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

/**
 *
 * @author eslam java
 */
@Entity
@Table(name = "lost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lost.findAll", query = "SELECT l FROM Lost l"),
    @NamedQuery(name = "Lost.findById", query = "SELECT l FROM Lost l WHERE l.id = :id"),
    @NamedQuery(name = "Lost.findByFirstName", query = "SELECT l FROM Lost l WHERE l.firstName = :firstName"),
    @NamedQuery(name = "Lost.findByImageUrl", query = "SELECT l FROM Lost l WHERE l.imageUrl = :imageUrl"),
    @NamedQuery(name = "Lost.findByAge", query = "SELECT l FROM Lost l WHERE l.age = :age"),
    @NamedQuery(name = "Lost.findByOrginalAddress", query = "SELECT l FROM Lost l WHERE l.orginalAddress = :orginalAddress"),
    @NamedQuery(name = "Lost.findByPhone", query = "SELECT l FROM Lost l WHERE l.phone = :phone"),
    @NamedQuery(name = "Lost.findByGender", query = "SELECT l FROM Lost l WHERE l.gender = :gender"),
    @NamedQuery(name = "Lost.findByLostDate", query = "SELECT l FROM Lost l WHERE l.lostDate = :lostDate"),
    @NamedQuery(name = "Lost.findByReturned", query = "SELECT l FROM Lost l WHERE l.returned = :returned"),
    @NamedQuery(name = "Lost.findByLostLocation", query = "SELECT l FROM Lost l WHERE l.lostLocation = :lostLocation"),
    @NamedQuery(name = "Lost.findByLastName", query = "SELECT l FROM Lost l WHERE l.lastName = :lastName"),
    @NamedQuery(name = "Lost.findByMotherName", query = "SELECT l FROM Lost l WHERE l.motherName = :motherName"),
    @NamedQuery(name = "Lost.updateLostReturned", query = "UPDATE Lost l  set l.returned =:returned where l.id =:id"),
    @NamedQuery(name = "Lost.findByGenderFnameLname", query = "SELECT l FROM Lost l WHERE l.firstName = :firstName AND l.lastName=:lastName AND l.gender=:gender"),
    @NamedQuery(name = "Lost.findByGenderFname", query = "SELECT l FROM Lost l WHERE l.firstName = :firstName AND l.gender=:gender"),
    @NamedQuery(name = "Lost.findByGenderLname", query = "SELECT l FROM Lost l WHERE l.lastName=:lastName AND l.gender=:gender")})
public class Lost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Size(min = 1, max = 2000)
    @Column(name = "image_url")
    private String imageUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Size(max = 100)
    @Column(name = "orginal_address")
    private String orginalAddress;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "gender")
    private String gender;
    @Size(max = 45)
    @Column(name = "lost_date")
    private String lostDate;
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
    @Column(name = "lost_location")
    private String lostLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 20)
    @Column(name = "mother_name")
    private String motherName;
    @JoinColumn(name = "lost_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users lostUserId;

    public Lost() {
    }

    public Lost(Integer id) {
        this.id = id;
    }

    public Lost(Integer id, String firstName, String imageUrl, int age, String phone, String gender, String returned, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.imageUrl = imageUrl;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.returned = returned;
        this.lastName = lastName;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrginalAddress() {
        return orginalAddress;
    }

    public void setOrginalAddress(String orginalAddress) {
        this.orginalAddress = orginalAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLostDate() {
        return lostDate;
    }

    public void setLostDate(String lostDate) {
        this.lostDate = lostDate;
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

    public String getLostLocation() {
        return lostLocation;
    }

    public void setLostLocation(String lostLocation) {
        this.lostLocation = lostLocation;
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

    public Users getLostUserId() {
        return lostUserId;
    }

    public void setLostUserId(Users lostUserId) {
        this.lostUserId = lostUserId;
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
        if (!(object instanceof Lost)) {
            return false;
        }
        Lost other = (Lost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.dto.Lost[ id=" + id + " ]";
    }

}
