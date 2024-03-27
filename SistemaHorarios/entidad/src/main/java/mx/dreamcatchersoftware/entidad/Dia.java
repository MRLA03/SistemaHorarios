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
@Table(name = "dia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dia.findAll", query = "SELECT d FROM Dia d")
    , @NamedQuery(name = "Dia.findByIdDia", query = "SELECT d FROM Dia d WHERE d.idDia = :idDia")
    , @NamedQuery(name = "Dia.findByHoraEntrada", query = "SELECT d FROM Dia d WHERE d.horaEntrada = :horaEntrada")
    , @NamedQuery(name = "Dia.findByHoraSalida", query = "SELECT d FROM Dia d WHERE d.horaSalida = :horaSalida")
    , @NamedQuery(name = "Dia.findByNd", query = "SELECT d FROM Dia d WHERE d.nd = :nd")
    , @NamedQuery(name = "Dia.findByTipo", query = "SELECT d FROM Dia d WHERE d.tipo = :tipo")})
public class Dia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDia")
    private Integer idDia;
    @Column(name = "horaEntrada")
    private Integer horaEntrada;
    @Column(name = "horaSalida")
    private Integer horaSalida;
    @Column(name = "nd")
    private Integer nd;
    @Column(name = "tipo")
    private Integer tipo;
    @JoinColumn(name = "idSala", referencedColumnName = "idSala")
    @ManyToOne
    private Sala idSala;
    @JoinColumn(name = "idSubgrupo", referencedColumnName = "idSubgrupo")
    @ManyToOne
    private Subgrupo idSubgrupo;

    public Dia() {
    }

    public Dia(Integer idDia) {
        this.idDia = idDia;
    }

    public Integer getIdDia() {
        return idDia;
    }

    public void setIdDia(Integer idDia) {
        this.idDia = idDia;
    }

    public Integer getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Integer horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Integer getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Integer horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Integer getNd() {
        return nd;
    }

    public void setNd(Integer nd) {
        this.nd = nd;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public Subgrupo getIdSubgrupo() {
        return idSubgrupo;
    }

    public void setIdSubgrupo(Subgrupo idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDia != null ? idDia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dia)) {
            return false;
        }
        Dia other = (Dia) object;
        if ((this.idDia == null && other.idDia != null) || (this.idDia != null && !this.idDia.equals(other.idDia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.dreamcatchersoftware.entidad.Dia[ idDia=" + idDia + " ]";
    }
    
}
