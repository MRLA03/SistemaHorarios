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
@Table(name = "rela1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rela1.findAll", query = "SELECT r FROM Rela1 r")
    , @NamedQuery(name = "Rela1.findByIdrela1", query = "SELECT r FROM Rela1 r WHERE r.idrela1 = :idrela1")
    , @NamedQuery(name = "Rela1.findByPos", query = "SELECT r FROM Rela1 r WHERE r.pos = :pos")})
public class Rela1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrela1")
    private Integer idrela1;
    @Column(name = "pos")
    private Integer pos;
    @JoinColumn(name = "idAsignatura", referencedColumnName = "idAsignatura")
    @ManyToOne
    private Asignatura idAsignatura;
    @JoinColumn(name = "idCarrera", referencedColumnName = "idCarrera")
    @ManyToOne
    private Carrera idCarrera;

    public Rela1() {
    }

    public Rela1(Integer idrela1) {
        this.idrela1 = idrela1;
    }

    public Integer getIdrela1() {
        return idrela1;
    }

    public void setIdrela1(Integer idrela1) {
        this.idrela1 = idrela1;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Carrera getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Carrera idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrela1 != null ? idrela1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rela1)) {
            return false;
        }
        Rela1 other = (Rela1) object;
        if ((this.idrela1 == null && other.idrela1 != null) || (this.idrela1 != null && !this.idrela1.equals(other.idrela1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Rela1[ idrela1=" + idrela1 + " ]";
    }
    
}
