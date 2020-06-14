/*
 * W20- Java Intermediate
 * Final Assignment
 * and open the template in the editor.
 */
package alienhunt;
/*
  * Aliens Class = An abstract class with two protected and two private data 
 * members, a constructor that requires a value for each data field and a toString() method that
 * returns a String containing a complete description of the Alien. 
 * 
 * @author Kerry Nelson Milovic
 * @version 2.0
 * @since 2020-04-21
 */

public abstract class Alien {
	private int typeID;
	private String typeName;

    /**
     *Integer representing the number of eyes
     */
    protected int numberEyes;

    /**
     *String stating the planet the alien calls home
     */
    protected String homePlanet;
	
    /**
     * Alien()constructor requires arguments but as part of an abstract class it doesn't instantiate objects.
     * 
     * @param typeID String stating the name of the alien
     * @param homePlanet String stating the planet the alien calls home
     * @param typeName String stating the name of the alien
     * @param numberEyes Integer representing the number of eyes
     */
    public Alien(int typeID, String homePlanet, String typeName, int numberEyes ) {
		
	}
    /**
     *
     * overriding the toString() method 
     * @return String Complete Alien Description
     */
    @Override 
public String toString() {
	return "Complete Alien Description: Alien Type Number: " + this.getTypeID() + " a.k.a: " + this.getTypeName() + ". Home is the planet " + this.getHomePlanet() + ". Looks at you with " + this.getNumberEyes() + " eyes.";
}
/**
 * @return the typeID
 */
public int getTypeID() {
	return typeID;
}
/**
 * @param typeID the typeID to set
 */
public void setTypeID(int typeID) {
	this.typeID = typeID;
}
/**
 * @return the typeName
 */
public String getTypeName() {
	return typeName;
}
/**
 * @param typeName the typeName to set
 */
public void setTypeName(String typeName) {
	this.typeName = typeName;
}
/**
 * @return the numberEyes
 */
public int getNumberEyes() {
	return numberEyes;
}
/**
 * @param numberEyes the numberEyes to set
 */
public void setNumberEyes(int numberEyes) {
	this.numberEyes = numberEyes;
}
/**
 * @return the homePlanet
 */
public String getHomePlanet() {
	return homePlanet;
}
/**
 * @param homePlanet the homePlanet to set
 */
public void setHomePlanet(String homePlanet) {
	this.homePlanet = homePlanet;
}
}