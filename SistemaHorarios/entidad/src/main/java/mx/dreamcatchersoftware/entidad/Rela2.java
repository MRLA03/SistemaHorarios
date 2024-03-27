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
@Table(name = "rela2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rela2.findAll", query = "SELECT r FROM Rela2 r")
    , @NamedQuery(name = "Rela2.findByIdrela2", query = "SELECT r FROM Rela2 r WHERE r.idrela2 = :idrela2")
    , @NamedQuery(name = "Rela2.findByTipo", query = "SELECT r FROM Rela2 r WHERE r.tipo = :tipo")})
public class Rela2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrela2")
    private Integer idrela2;
    @Column(name = "tipo")
    private Integer tipo;
    @JoinColumn(name = "clave", referencedColumnName = "claveAsignatura")
    @ManyToOne
    private Asignatura clave;
    @JoinColumn(name = "nEmpleado", referencedColumnName = "nEmpleado")
    @ManyToOne
    private Maestro nEmpleado;

    public Rela2() {
    }

    public Rela2(Integer idrela2) {
        this.idrela2 = idrela2;
    }

    public Integer getIdrela2() {
        return idrela2;
    }

    public void setIdrela2(Integer idrela2) {
        this.idrela2 = idrela2;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Asignatura getClave() {
        return clave;
    }

    public void setClave(Asignatura clave) {
        this.clave = clave;
    }

    public Maestro getNEmpleado() {
        return nEmpleado;
    }

    public void setNEmpleado(Maestro nEmpleado) {
        this.nEmpleado = nEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrela2 != null ? idrela2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rela2)) {
            return false;
        }
        Rela2 other = (Rela2) object;
        if ((this.idrela2 == null && other.idrela2 != null) || (this.idrela2 != null && !this.idrela2.equals(other.idrela2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Rela2[ idrela2=" + idrela2 + " ]";
    }
    
}
