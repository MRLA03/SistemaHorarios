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
@Table(name = "rela4")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rela4.findAll", query = "SELECT r FROM Rela4 r")
    , @NamedQuery(name = "Rela4.findByIdrela4", query = "SELECT r FROM Rela4 r WHERE r.idrela4 = :idrela4")})
public class Rela4 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrela4")
    private Integer idrela4;
    @JoinColumn(name = "idCarrera", referencedColumnName = "idCarrera")
    @ManyToOne
    private Carrera idCarrera;
    @JoinColumn(name = "idGrupo", referencedColumnName = "idGrupo")
    @ManyToOne
    private Grupo idGrupo;

    public Rela4() {
    }

    public Rela4(Integer idrela4) {
        this.idrela4 = idrela4;
    }

    public Integer getIdrela4() {
        return idrela4;
    }

    public void setIdrela4(Integer idrela4) {
        this.idrela4 = idrela4;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrela4 != null ? idrela4.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rela4)) {
            return false;
        }
        Rela4 other = (Rela4) object;
        if ((this.idrela4 == null && other.idrela4 != null) || (this.idrela4 != null && !this.idrela4.equals(other.idrela4))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Rela4[ idrela4=" + idrela4 + " ]";
    }
    
}
