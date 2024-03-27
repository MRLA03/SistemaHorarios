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
@Table(name = "carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")
    , @NamedQuery(name = "Carrera.findByIdCarrera", query = "SELECT c FROM Carrera c WHERE c.idCarrera = :idCarrera")
    , @NamedQuery(name = "Carrera.findByClaveCarrera", query = "SELECT c FROM Carrera c WHERE c.claveCarrera = :claveCarrera")
    , @NamedQuery(name = "Carrera.findByNombreCarrera", query = "SELECT c FROM Carrera c WHERE c.nombreCarrera = :nombreCarrera")
    , @NamedQuery(name = "Carrera.findByPlan", query = "SELECT c FROM Carrera c WHERE c.plan = :plan")
    , @NamedQuery(name = "Carrera.findByBancoHoras", query = "SELECT c FROM Carrera c WHERE c.bancoHoras = :bancoHoras")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarrera")
    private Integer idCarrera;
    @Column(name = "claveCarrera")
    private String claveCarrera;
    @Column(name = "nombreCarrera")
    private String nombreCarrera;
    @Column(name = "plan")
    private String plan;
    @Column(name = "bancoHoras")
    private Integer bancoHoras;
    @OneToMany(mappedBy = "idCarrera")
    private List<Rela4> rela4List;
    @OneToMany(mappedBy = "idCarrera")
    private List<Rela3> rela3List;
    @OneToMany(mappedBy = "idCarrera")
    private List<Rela1> rela1List;

    public Carrera() {
    }

    public Carrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getClaveCarrera() {
        return claveCarrera;
    }

    public void setClaveCarrera(String claveCarrera) {
        this.claveCarrera = claveCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Integer getBancoHoras() {
        return bancoHoras;
    }

    public void setBancoHoras(Integer bancoHoras) {
        this.bancoHoras = bancoHoras;
    }

    @XmlTransient
    public List<Rela4> getRela4List() {
        return rela4List;
    }

    public void setRela4List(List<Rela4> rela4List) {
        this.rela4List = rela4List;
    }

    @XmlTransient
    public List<Rela3> getRela3List() {
        return rela3List;
    }

    public void setRela3List(List<Rela3> rela3List) {
        this.rela3List = rela3List;
    }

    @XmlTransient
    public List<Rela1> getRela1List() {
        return rela1List;
    }

    public void setRela1List(List<Rela1> rela1List) {
        this.rela1List = rela1List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrera != null ? idCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.idCarrera == null && other.idCarrera != null) || (this.idCarrera != null && !this.idCarrera.equals(other.idCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Carrera[ idCarrera=" + idCarrera + " ]";
    }
    
}
