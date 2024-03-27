/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "edificio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edificio.findAll", query = "SELECT e FROM Edificio e")
    , @NamedQuery(name = "Edificio.findByIdEdificio", query = "SELECT e FROM Edificio e WHERE e.idEdificio = :idEdificio")
    , @NamedQuery(name = "Edificio.findByClaveEdificio", query = "SELECT e FROM Edificio e WHERE e.claveEdificio = :claveEdificio")
    , @NamedQuery(name = "Edificio.findByNombreEdificio", query = "SELECT e FROM Edificio e WHERE e.nombreEdificio = :nombreEdificio")})
public class Edificio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEdificio")
    private Integer idEdificio;
    @Column(name = "claveEdificio")
    private String claveEdificio;
    @Column(name = "nombreEdificio")
    private String nombreEdificio;
    @OneToMany(mappedBy = "idEdificio")
    private List<Sala> salaList;
    @OneToMany(mappedBy = "idEdificio")
    private List<Rela3> rela3List;

    public Edificio() {
    }

    public Edificio(Integer idEdificio) {
        this.idEdificio = idEdificio;
    }

    public Integer getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(Integer idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getClaveEdificio() {
        return claveEdificio;
    }

    public void setClaveEdificio(String claveEdificio) {
        this.claveEdificio = claveEdificio;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    @XmlTransient
    public List<Sala> getSalaList() {
        return salaList;
    }

    public void setSalaList(List<Sala> salaList) {
        this.salaList = salaList;
    }

    @XmlTransient
    public List<Rela3> getRela3List() {
        return rela3List;
    }

    public void setRela3List(List<Rela3> rela3List) {
        this.rela3List = rela3List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEdificio != null ? idEdificio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edificio)) {
            return false;
        }
        Edificio other = (Edificio) object;
        if ((this.idEdificio == null && other.idEdificio != null) || (this.idEdificio != null && !this.idEdificio.equals(other.idEdificio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Edificio[ idEdificio=" + idEdificio + " ]";
    }
    
}
