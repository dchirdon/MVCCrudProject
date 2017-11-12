package data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Item {
private int id;
	
@Size(min=2, max=100, message="Pick a name between 1 and 100 characters.")
 private String type;

@Min(value=0, message="Minimum value is $0.")
@Max(value=99, message="Max value is the bank max of $1,000,000.")
 private double value;

 private String imageURL;
 
 public String getImageURL() {
	return imageURL;
}

public void setImageURL(String imageURL) {
	this.imageURL = imageURL;
}

public Item(){
 }
 
public Item(String name, int id, double neckLength, String imageURL) {
	super();
	this.type = type;
	this.id = id;
	this.value = value;
	this.imageURL = imageURL;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double value() {
	return value;
}
public void setNeckLength(double value) {
	this.value = value;
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
