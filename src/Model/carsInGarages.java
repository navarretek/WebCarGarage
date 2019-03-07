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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cars_in_garage")
public class carsInGarages {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cars_in_garage_id")
	private int id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="GARAGE_ID")
	private Garage garage;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name="cars_in_garage",
			joinColumns= {@JoinColumn(name="GARAGE_ID",referencedColumnName="GARAGE_ID")}
			,
			inverseJoinColumns= {@JoinColumn(name="CAR_ID",referencedColumnName="ID", unique=true)}
			)
	private List<Car> listOfCars;
	
	/**
	 * @param id
	 * @param garage
	 */
	public carsInGarages(int id, Garage garage) {
		super();
		this.id = id;
		this.garage = garage;
	}
	/**
	 * 
	 */
	public carsInGarages() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param garage
	 * @param listOfCars
	 */
	public carsInGarages(Garage garage, List<Car> listOfCars) {
		super();
		this.garage = garage;
		this.listOfCars = listOfCars;
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
	 * @return the garage
	 */
	public Garage getGarage() {
		return garage;
	}
	/**
	 * @param garage the garage to set
	 */
	public void setGarage(Garage garage) {
		this.garage = garage;
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
}
