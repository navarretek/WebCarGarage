package Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="garage")
public class Garage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GARAGE_ID")
	private int id;
	@Column(name="GARAGE_NAME")
	private String garageName;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name="cars_in_garage",
			//               CARS_IN_GARAGE.GARAGE_ID                  GARAGE.GARAGE_ID               
			joinColumns= {@JoinColumn(name="GARAGE_ID", referencedColumnName="GARAGE_ID")}
			,
			//                      CARS_IN_GARAGE.CAR_ID                     CAR.ID               
			inverseJoinColumns= {@JoinColumn(name="CAR_ID", referencedColumnName="ID", unique=true)})
	private List<Car> listOfCars;
	/**
	 * 
	 */
	public Garage() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param garageName
	 */
	public Garage(String garageName) {
		super();
		this.garageName = garageName;
	}
	/**
	 * @param id
	 * @param garageName
	 */
	public Garage(int id, String garageName) {
		super();
		this.id = id;
		this.garageName = garageName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the garageName
	 */
	public String getGarageName() {
		return garageName;
	}
	/**
	 * @param garageName the garageName to set
	 */
	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}	
	/**
	 * @return the listOfCars
	 */
	public List<Car> getListOfCars() {
		return listOfCars;
	}
	/**
	 * @param listOfCars the listOfCars to set
	 */
	public void setListOfCars(List<Car> listOfCars) {
		this.listOfCars = listOfCars;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Garage [id=" + id + ", garageName=" + garageName + "]";
	}
	
	
}
