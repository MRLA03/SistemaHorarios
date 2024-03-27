/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.dreamcatchersoftware.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "rela3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rela3.findAll", query = "SELECT r FROM Rela3 r")
    , @NamedQuery(name = "Rela3.findByIdrela3", query = "SELECT r FROM Rela3 r WHERE r.idrela3 = :idrela3")})
public class Rela3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrela3")
    private Integer idrela3;
    @JoinColumn(name = "idCarrera", referencedColumnName = "idCarrera")
    @ManyToOne
    private Carrera idCarrera;
    @JoinColumn(name = "idEdificio", referencedColumnName = "idEdificio")
    @ManyToOne
    private Edificio idEdificio;

    public Rela3() {
    }

    public Rela3(Integer idrela3) {
        this.idrela3 = idrela3;
    }

    public Integer getIdrela3() {
        return idrela3;
    }

    public void setIdrela3(Integer idrela3) {
        this.idrela3 = idrela3;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Edificio getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(Edificio idEdificio) {
        this.idEdificio = idEdificio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrela3 != null ? idrela3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rela3)) {
            return false;
        }
        Rela3 other = (Rela3) object;
        if ((this.idrela3 == null && other.idrela3 != null) || (this.idrela3 != null && !this.idrela3.equals(other.idrela3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Rela3[ idrela3=" + idrela3 + " ]";
    }
    
}
