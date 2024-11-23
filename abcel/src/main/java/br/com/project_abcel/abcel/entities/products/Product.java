package br.com.project_abcel.abcel.entities.products;

import static br.com.project_abcel.abcel.entities.products.CultivationType.CONVENCIONAL;
import static br.com.project_abcel.abcel.entities.products.CultivationType.NAO_CONVENCIONAL;
import static br.com.project_abcel.abcel.entities.products.CultivationType.ORGANICO;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.project_abcel.abcel.access.utils.SetGenericInheritance;
import br.com.project_abcel.abcel.entities.persons.Farmer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Product")
public class Product implements Serializable, SetGenericInheritance<Farmer> {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "farmer_id")
	@JsonBackReference
	private Farmer farmer;

	@Column(length = 30, nullable = false)
	private String name;
	@Column(length = 30, nullable = false)
	private String variety;
	@Column
	@Enumerated(STRING)
	private CultivationType type;

	@Transient
	private final Map<Integer, CultivationType> typeMap;

	public Product() {
		typeMap = new HashMap<>();
		typeMap.put(0, ORGANICO);
		typeMap.put(1, CONVENCIONAL);
		typeMap.put(2, NAO_CONVENCIONAL);
	}

	@Override
	public void setInheritance(Farmer farmer) {
		setFarmer(farmer);
	}

	public String getName() {
		return name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String getType() {
		return type.toString();
	}

	public void setType(int type) {
		this.type = typeMap.get(type);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
}
