package model.pojo;
// Generated Nov 11, 2014 5:50:29 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cinema generated by hbm2java
 */
@Entity
@Table(name="Cinema"
    ,schema="dbo"
    ,catalog="Alpha"
)
public class Cinema  implements java.io.Serializable {


     private int cinema;
     private int seatmax;
     private int seatcount;

    public Cinema() {
    }

    public Cinema(int cinema, int seatmax, int seatcount) {
       this.cinema = cinema;
       this.seatmax = seatmax;
       this.seatcount = seatcount;
    }
   
     @Id 

    
    @Column(name="cinema", nullable=false)
    public int getCinema() {
        return this.cinema;
    }
    
    public void setCinema(int cinema) {
        this.cinema = cinema;
    }

    
    @Column(name="seatmax", nullable=false)
    public int getSeatmax() {
        return this.seatmax;
    }
    
    public void setSeatmax(int seatmax) {
        this.seatmax = seatmax;
    }

    
    @Column(name="seatcount", nullable=false)
    public int getSeatcount() {
        return this.seatcount;
    }
    
    public void setSeatcount(int seatcount) {
        this.seatcount = seatcount;
    }




}


