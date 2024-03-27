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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "subgrupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subgrupo.findAll", query = "SELECT s FROM Subgrupo s")
    , @NamedQuery(name = "Subgrupo.findByIdSubgrupo", query = "SELECT s FROM Subgrupo s WHERE s.idSubgrupo = :idSubgrupo")
    , @NamedQuery(name = "Subgrupo.findByTipo", query = "SELECT s FROM Subgrupo s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Subgrupo.findByCapacidad", query = "SELECT s FROM Subgrupo s WHERE s.capacidad = :capacidad")
    , @NamedQuery(name = "Subgrupo.findByEstatus", query = "SELECT s FROM Subgrupo s WHERE s.estatus = :estatus")
    , @NamedQuery(name = "Subgrupo.findBySgpo", query = "SELECT s FROM Subgrupo s WHERE s.sgpo = :sgpo")
    , @NamedQuery(name = "Subgrupo.findByCon", query = "SELECT s FROM Subgrupo s WHERE s.con = :con")})
public class Subgrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSubgrupo")
    private Integer idSubgrupo;
    @Column(name = "tipo")
    private Integer tipo;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Column(name = "estatus")
    private Integer estatus;
    @Column(name = "sgpo")
    private Integer sgpo;
    @Column(name = "con")
    private Integer con;
    @JoinColumn(name = "idAsignatura", referencedColumnName = "idAsignatura")
    @ManyToOne
    private Asignatura idAsignatura;
    @JoinColumn(name = "idGrupo", referencedColumnName = "idGrupo")
    @ManyToOne
    private Grupo idGrupo;
    @JoinColumn(name = "idMaestro", referencedColumnName = "idMaestro")
    @ManyToOne
    private Maestro idMaestro;
    @OneToMany(mappedBy = "idSubgrupo")
    private List<Dia> diaList;

    public Subgrupo() {
    }

    public Subgrupo(Integer idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public Integer getIdSubgrupo() {
        return idSubgrupo;
    }

    public void setIdSubgrupo(Integer idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Integer getSgpo() {
        return sgpo;
    }

    public void setSgpo(Integer sgpo) {
        this.sgpo = sgpo;
    }

    public Integer getCon() {
        return con;
    }

    public void setCon(Integer con) {
        this.con = con;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Maestro getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(Maestro idMaestro) {
        this.idMaestro = idMaestro;
    }

    @XmlTransient
    public List<Dia> getDiaList() {
        return diaList;
    }

    public void setDiaList(List<Dia> diaList) {
        this.diaList = diaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubgrupo != null ? idSubgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subgrupo)) {
            return false;
        }
        Subgrupo other = (Subgrupo) object;
        if ((this.idSubgrupo == null && other.idSubgrupo != null) || (this.idSubgrupo != null && !this.idSubgrupo.equals(other.idSubgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Subgrupo[ idSubgrupo=" + idSubgrupo + " ]";
    }
    
}
