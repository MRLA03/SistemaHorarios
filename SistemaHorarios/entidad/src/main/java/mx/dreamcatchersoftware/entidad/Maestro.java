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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "maestro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maestro.findAll", query = "SELECT m FROM Maestro m")
    , @NamedQuery(name = "Maestro.findByIdMaestro", query = "SELECT m FROM Maestro m WHERE m.idMaestro = :idMaestro")
    , @NamedQuery(name = "Maestro.findByNEmpleado", query = "SELECT m FROM Maestro m WHERE m.nEmpleado = :nEmpleado")
    , @NamedQuery(name = "Maestro.findByNombreMaestro", query = "SELECT m FROM Maestro m WHERE m.nombreMaestro = :nombreMaestro")
    , @NamedQuery(name = "Maestro.findByTipo", query = "SELECT m FROM Maestro m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Maestro.findByHrsIE", query = "SELECT m FROM Maestro m WHERE m.hrsIE = :hrsIE")
    , @NamedQuery(name = "Maestro.findByHrsad", query = "SELECT m FROM Maestro m WHERE m.hrsad = :hrsad")
    , @NamedQuery(name = "Maestro.findByHmax", query = "SELECT m FROM Maestro m WHERE m.hmax = :hmax")})
public class Maestro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaestro")
    private Integer idMaestro;
    @Column(name = "nEmpleado")
    private String nEmpleado;
    @Column(name = "nombreMaestro")
    private String nombreMaestro;
    @Column(name = "tipo")
    private Integer tipo;
    @Column(name = "hrsIE")
    private Integer hrsIE;
    @Column(name = "hrsad")
    private Integer hrsad;
    @Column(name = "hmax")
    private Integer hmax;

    public Maestro() {
    }

    public Maestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public Integer getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public String getNEmpleado() {
        return nEmpleado;
    }

    public void setNEmpleado(String nEmpleado) {
        this.nEmpleado = nEmpleado;
    }

    public String getNombreMaestro() {
        return nombreMaestro;
    }

    public void setNombreMaestro(String nombreMaestro) {
        this.nombreMaestro = nombreMaestro;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getHrsIE() {
        return hrsIE;
    }

    public void setHrsIE(Integer hrsIE) {
        this.hrsIE = hrsIE;
    }

    public Integer getHrsad() {
        return hrsad;
    }

    public void setHrsad(Integer hrsad) {
        this.hrsad = hrsad;
    }

    public Integer getHmax() {
        return hmax;
    }

    public void setHmax(Integer hmax) {
        this.hmax = hmax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaestro != null ? idMaestro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maestro)) {
            return false;
        }
        Maestro other = (Maestro) object;
        if ((this.idMaestro == null && other.idMaestro != null) || (this.idMaestro != null && !this.idMaestro.equals(other.idMaestro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Maestro[ idMaestro=" + idMaestro + " ]";
    }
    
}
