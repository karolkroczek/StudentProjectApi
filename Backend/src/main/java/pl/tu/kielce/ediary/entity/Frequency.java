package pl.tu.kielce.ediary.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "frequency")
public class Frequency {

    @Id
    @Column(name = "idFrequency")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFrequency;

   @Column(name = "listaObecnych")
   @OneToMany(mappedBy = "idStudent")
   private List<Students> listaObecnych;

    public int getIdFrequency() {
        return idFrequency;
    }

    public void setIdFrequency(int idFrequency) {
        this.idFrequency = idFrequency;
    }

    public List<Students> getListaObecnych() {
        return listaObecnych;
    }

    public void setListaObecnych(List<Students> listaObecnych) {
        this.listaObecnych = listaObecnych;
    }
}
