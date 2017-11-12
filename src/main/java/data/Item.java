package data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Item {
private int id;
	
@Size(min=9, max=10 , message="Please enter type, Debit Card, Credit Card or Gift Card")
 private String type;

@Min(value=0, message="Minimum value is $0.")
@Max(value=1_000_000, message="Max value is the bank max of $1,000,000.")
 private double value;

 private String name;

public Item(){
 }
 
public Item(String type, int id, double value, String imageURL) {
	super();
	this.type = type;
	this.id = id;
	this.value = value;
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public double getValue() {
	return value;
}

public void setValue(double value) {
	this.value = value;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public String toString() {
	return "Item [name=" + type + ", id=" + id + ", value=" + value + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Item other = (Item) obj;
	if (id != other.id)
		return false;
	if (type == null) {
		if (other.type != null)
			return false;
	} else if (!type.equals(other.type))
		return false;
	if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
		return false;
	return true;
}

}
