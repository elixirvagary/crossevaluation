package com.crossover.techtrial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * HourlyElectricity is responsible for electricity generated by a Panel in an hour.
 * 
 * @author Crossover
 *
 */

@Entity
@Table(name = "hourly_electricity")
public class HourlyElectricity implements Serializable {

  private static final long serialVersionUID = -575347909928592140L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "panel_id", referencedColumnName = "id")
  private Panel panel;
  
  @Column(name = "generated_electricity")
  private Long generatedElectricity;
  
  @Column(name = "reading_at")
  private LocalDateTime readingAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Panel getPanel() {
    return panel;
  }

  public void setPanel(Panel panel) {
    this.panel = panel;
  }

  public Long getGeneratedElectricity() {
    return generatedElectricity;
  }

  public void setGeneratedElectricity(Long generatedElectricity) {
    this.generatedElectricity = generatedElectricity;
  }

  public LocalDateTime getReadingAt() {
    return readingAt;
  }

  public void setReadingAt(LocalDateTime readingAt) {
    this.readingAt = readingAt;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((readingAt == null) ? 0 : readingAt.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    HourlyElectricity other = (HourlyElectricity) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (readingAt == null) {
      if (other.readingAt != null) {
        return false;
      }
    } else if (!readingAt.equals(other.readingAt)) {
      return false;
    }
    return true;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "HourlyElectricity [id=" + id + ", panel=" + panel + ", generatedElectricity="
        + generatedElectricity + ", readingAt=" + readingAt + "]";
  }
  
  
  
}
