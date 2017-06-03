1.  In Java, what are the differences between an abstract class and an interface? How did this situation change in 
    version 8 of the language?
    
    1. Abstract classes can have constants, members, method declarations and defined methods, whereas 
    interfaces can only have constants and method declarations.
    2. Methods and members of the class can be defined with any visibility, whereas all methods of an
    interface must be defined as public.
    3. A child class can only extend a single class (abstract or concrete), but can implement one or 
    more interfaces.
    4. A child class can define abstract methods with the same or less restrictive visibility, whereas
    a class implementing an interface must define the methods with the exact same visibility (public)
    5. Methods of the inter
    6. Abstract classes can have static methods, whereas interfaces can not.
    
    Java 8 modifications of interface:
    
    1. Interfaces can have default implementation using `default` keyword.
    2. Interfaces can have `static` methods as abstract classes.
    3. Interface with just one method can be declared as functional and be used where lambda expression
    expected, whereas abstract class can be declared functional.
    
2. 
