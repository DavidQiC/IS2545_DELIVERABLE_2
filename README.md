# IS2545 - DELIVERABLE 2: Unit Testing

(JDK 1.8)

This code of Project consists of this following packages:
- edu.pitt (main class is put here, please run CitySim9002.java here to run the whole project)
- edu.pitt.bean (used to define object: Visitor and Location)
- edu.pitt.utils (used to design some necessay parameters and methods which will be used in Main java classs)
- edu.pitt.test (all the tests are here)

## Testing

When doing testing, the argument which this program accpets should be tested. what if the input is more than one arguments, a character, or is one number, these suitation should be inclued.

The random number is used in three different ways: get a random vistor, get a random location and get a random number to determine whether the given visitor shall quit. All these should be tested.

Puls, testing whether a certain location is liked or disliked by a certain visitor is necessary.


## CitySim9002 Requirements

### 1. FUN-FIVE-VISITORS. Five visitors, numbered 1 through 5, shall traverse the City, one after the other.


In /SQAHW2/src/edu/pitt/CitySim9002.java,  the following code ensure only 5 visitors shall traverse the City, one after the other.
```java
for (int i = 0; i < 5; i++) {
	//...
}
```


### 2. FUN-VISITOR. Each Visitor shall be of one of four types: a Student, a Professor, a Business Person, or a Blogger.

The following enum types makes it sure there are only four kind of vistiors can be chosen.
```java
public enum Visitor {

	Student("a Student", 1, 3, 1), Professor("a Professor", 2, 4, 0), Business("a Business Person", 3, 2,
			2), Blogger("a Blogger", 4, 0, 4);
	private String name;
	private int index;
	private int likeMax;
	private int disLikeMax;

	private Visitor(String name, int index, int likeMax, int disLikeMax) {
		this.name = name;
		this.index = index;
		this.likeMax = likeMax;
		this.disLikeMax = disLikeMax;
	}
	//...	
}
```

### 3. FUN-CITY-LOCS. The program shall simulate a City with four locations: The Cathedral of Learning, Squirrel Hill, The Point, and Downtown.
The following enum types makes it sure there are only four locations can be traveled.

```java
public enum Location {
	CathedralLearning("The Cathedral of Learning", 1), SquirrelHill("eeed", 2), ThePoint("The Point",
			3), Downtown("Downtown", 4);

	private String name;
	private int index;

	private Location(String name, int index) {
		this.name = name;
		this.index = index;
	}
 }
```

### 4. FUN-PREFERENCES. A Student shall like Squirrel Hill, Downtown, and The Point, and dislike The Cathedral of Learning.  A Business Person shall like Squirrel Hill and Downtown, and dislike all other locations. A Professor shall like all locations.  A Blogger shall dislike all locations.

In /SQAHW2/src/edu/pitt/utils/Helper.java, the code in static block is used to build LocationlikeMap and LocationDisLikeMap, making sure which place is liked or disliked by which kind of people.

### 5. FUN-ITERATIONS. For each iteration, the program shall randomly select a location for the visitor to visit.  The choices specified in FUN-CITY-LOCS as well as the option to leave the City shall all have equal weight - that is, there is an equal chance that a visitor will have a 20% chance of visiting any location specified in FUN-CITY-LOCS and a 20% chance of leaving the City (except in cases covered under FUN-FIRST-VISIT).

the RandomGenerator.java , as well as TravelService.java in /SQAHW2/src/edu/pitt/utils is used to generate random number and get a random location or a random visitor on basis of this random number.

### 6. FUN-ITER-DISPLAY. At each iteration, the program shall display where the Visitor has visited and whether or not the Visitor liked that location.  This output shall be of the format:

LocationlikeMap and LocationDisLikeMap in Helper.java, as well as two enum types make sure poeple like or dislike a certain location

### 7. FUN-FIRST-VISIT. For the first visit for a given Visitor, the Visitor cannot leave the City.  The Visitor must visit at least one Location.

In /SQAHW2/src/edu/pitt/CitySim9002.java,  the following code ensure every visitor must visit at least one Location
```java
for (int i = 0; i < 5; i++) {
	//...
	for (int j = 0;; j++) {
		if (j != 0) {
			if (service.quit(generator)) {
				System.out.println(people + " has left the city");
				break;
			}
		}
	//...
}
```

### 8. FUN-NUM-ITERATIONS. There shall be no limit on the number of iterations for a given Visitor.

The `public boolean quit(RandomGenerator generator)` defined in /SQAHW2/src/edu/pitt/utils/TravelService.java is used to decide when to quit, as long as the random number generated in /SQAHW2/src/edu/pitt/utils/RandomGenerator.java is greater than 0.2, the visitor will never finish his traverl. In other word, There shall be no limit on the number of iterations for a given Visitor.

### 9. FUN-REPEAT. A Visitor shall be able to repeatedly visit a location if the random number generator produces that as the next location.

Because we use random number to decide what kind of visitors and what kind of locations, it is possible that a visitor shall visit the location which has been visited last time.

### 10. FUN-ARGS. The program shall accept one and only one argument, which shall be an integer, which shall act as a seed for the random number generator.  If the program is passed in any number of arguments other than 1, including 0, or the passed-in argument is not a valid integer, the program shall display the message "Please enter one integer argument, seed" and immediately cease execution (exit).
In /SQAHW2/src/edu/pitt/utils/TravelService.java, the `public boolean checkArgs(String[] args)` makes sure only one integer argument will be accepted.

```java
public boolean checkArgs(String[] args){
	if(args.length != 1){
		System.out.println("The program shall accept one and only one argument");
		return false;
	}
	try{
		Integer.parseInt(args[0]);
	}catch(Exception e){
		System.out.println("The input must be a Integer");
		return false;
	}
	return true;
}
```
### 11. FUN-DISPLAY. The program shall always display the message "Welcome to CitySim! Your seed is _x_." (where _x_ is an integer argument passed in from the command line) as the first message of the simulation.
In /SQAHW2/src/edu/pitt/CitySim9002.java,  the following code make this function successful.
```java
int seed = Integer.parseInt(args[0]);
System.out.println("Welcome to CitySim!  Your seed is " + seed);
```
### 12. FUN-STOP. If the Visitor has left the City, the message "Visitor _x_ has left the city.", along with a newline and then three asterisks ("***"), shall be displayed before simulating the next Visitor.
In /SQAHW2/src/edu/pitt/CitySim9002.java,  the following code make this function successful.
```java
for (int i = 0; i < 5; i++) {
	//...
	for (int j = 0;; j++) {
		if (j != 0) {
			if (service.quit(generator)) {
				System.out.println(people + " has left the city");
				break;
			}
		}
		//...
	}
	System.out.println("***");
}
```
### 13. FUN-END. After five Visitors have been simulated, the program shall exit.
In /SQAHW2/src/edu/pitt/CitySim9002.java, after the loop ends, the program will exit automatically.
