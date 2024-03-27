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
@Table(name = "asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findByIdAsignatura", query = "SELECT a FROM Asignatura a WHERE a.idAsignatura = :idAsignatura")
    , @NamedQuery(name = "Asignatura.findByClaveAsignatura", query = "SELECT a FROM Asignatura a WHERE a.claveAsignatura = :claveAsignatura")
    , @NamedQuery(name = "Asignatura.findByNombreAsignatura", query = "SELECT a FROM Asignatura a WHERE a.nombreAsignatura = :nombreAsignatura")
    , @NamedQuery(name = "Asignatura.findByHoraClase", query = "SELECT a FROM Asignatura a WHERE a.horaClase = :horaClase")
    , @NamedQuery(name = "Asignatura.findByHoraTaller", query = "SELECT a FROM Asignatura a WHERE a.horaTaller = :horaTaller")
    , @NamedQuery(name = "Asignatura.findByHoraPractica", query = "SELECT a FROM Asignatura a WHERE a.horaPractica = :horaPractica")
    , @NamedQuery(name = "Asignatura.findByHoraLaboratorio", query = "SELECT a FROM Asignatura a WHERE a.horaLaboratorio = :horaLaboratorio")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAsignatura")
    private Integer idAsignatura;
    @Column(name = "claveAsignatura")
    private String claveAsignatura;
    @Column(name = "nombreAsignatura")
    private String nombreAsignatura;
    @Column(name = "horaClase")
    private Integer horaClase;
    @Column(name = "horaTaller")
    private Integer horaTaller;
    @Column(name = "horaPractica")
    private Integer horaPractica;
    @Column(name = "horaLaboratorio")
    private Integer horaLaboratorio;
    @OneToMany(mappedBy = "idAsignatura")
    private List<Subgrupo> subgrupoList;
    @OneToMany(mappedBy = "clave")
    private List<Rela2> rela2List;
    @OneToMany(mappedBy = "idAsignatura")
    private List<Rela1> rela1List;

    public Asignatura() {
    }

    public Asignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getClaveAsignatura() {
        return claveAsignatura;
    }

    public void setClaveAsignatura(String claveAsignatura) {
        this.claveAsignatura = claveAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Integer getHoraClase() {
        return horaClase;
    }

    public void setHoraClase(Integer horaClase) {
        this.horaClase = horaClase;
    }

    public Integer getHoraTaller() {
        return horaTaller;
    }

    public void setHoraTaller(Integer horaTaller) {
        this.horaTaller = horaTaller;
    }

    public Integer getHoraPractica() {
        return horaPractica;
    }

    public void setHoraPractica(Integer horaPractica) {
        this.horaPractica = horaPractica;
    }

    public Integer getHoraLaboratorio() {
        return horaLaboratorio;
    }

    public void setHoraLaboratorio(Integer horaLaboratorio) {
        this.horaLaboratorio = horaLaboratorio;
    }

    @XmlTransient
    public List<Subgrupo> getSubgrupoList() {
        return subgrupoList;
    }

    public void setSubgrupoList(List<Subgrupo> subgrupoList) {
        this.subgrupoList = subgrupoList;
    }

    @XmlTransient
    public List<Rela2> getRela2List() {
        return rela2List;
    }

    public void setRela2List(List<Rela2> rela2List) {
        this.rela2List = rela2List;
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
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Asignatura[ idAsignatura=" + idAsignatura + " ]";
    }
    
}
