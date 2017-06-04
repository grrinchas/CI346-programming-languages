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
    
2. Explain the differences between **ad hoc** and **parametric** polymorphism. What kind of polymorphism is happening
   when a language provides **overloading**? How are these concepts made available in Haskell and Java?
   
   The main difference between parametric and ad-hoc polymorphism is that parametric polymorphic functions uses
   one algorithm to operate on arguments of many different types, whereas ad-hoc polymorphic functions may use
   a different algorithm for each type of argument. 
   
   Overloaded functions are ad-hoc polymorphic.
   
   In Java parametric polymorphism is achieved using generics, which enable _types_ (classes and interfaces) and methods
   to be parameterized over types. **Type parameters**, usually denoted by single capital letters _T_, _K_... and
   enclosed in angle brackets _\<A>_ stands for any type. A generic class or interface can use type parameters
   instead of actual types for instance variables, method signatures and so on. When **parameterized type**
   (instantiated generic class) supplies concrete type argument for type parameter, 
   then all instances of type parameter in generic class are are substituted with concrete type. Generics enables 
   same classes and interfaces to operate on different types.
   
   In java ad-hoc polymorphism achieved by method overloading. Only methods with different number of parameters or, 
   different types of parameters can be overloaded. Method overloading enables different algorithm for different type.
   
   In haskell parametric polymorphism is achieved by type variables. A function with type variable can operate
   on any type. Ad-hoc polymorphism is achieved with type classes. For each type we create an instance of it, where
   type would correspond to overloaded method parameter in Java and implement functions provided by the type class.
   
3. What is multiple inheritance, why is it useful and what are the problems it can cause? Does Java support 
   multiple inheritance, and to what degree? Does Haskell have any similar mechanisms? Explain your answers with
   examples.
    
    **Multiple inheritance** is a feature of programming language in which a class or object can inherit characteristics 
    and features from more than one parent object or class. This enables to create complex objects or classes 
    without boilerplate code. Unfortunately, multiple inheritance can cause diamond problem. For example, a base
    class `A` has to subclasses `B` and `C` which both of them overrides class `A` method `method_a()`, then 
    new class `D` extends both `B` and `C` and now we have a  question: 
    "Which method implementation class `D` should use `B` or `C`?". 
    
    Prior Java 8, Java did not support multiple inheritance a class could extend only one class. In fact, each class
    extends `Object` directly or indirectly. Interfaces provided some capabilities for the class extend their 
    features. But each class had to provide their own implementation for each method defined in the interface. 
    Therefore it was not considered as multiple inheritance. On the other hand, in Java 8 interface methods may have 
    default implementation, thus enabling multiple inheritance. In preceding example, diamond problem would be solved 
    by class `D` explicitly overriding `method_a()`, otherwise compile time error would be thrown.
    
    Haskell does provide something similar to Java's interface inheritance. In Java if interface `A` declares method 
    `method_a` and interface `B` extends interface `A` then it inherits `method_a`. Thus any class implementing 
    interface `B` has to provide implementation for `method_a`. This is similar to haskell's type classes. For example, 
    `class Ord` has constraint of `class Eq` thus any Type instance of `class Ord` may provide function 
    implementation from `class Eq`. 
  
4.  What are the differences and similarities between Java interfaces and Haskell type classes?   
    
    Conceptually what is similar between interfaces and type classes is that they name and describe a set of related operations.
    Implementations of those operations may differ based on type. Both type classes and interfaces may have default 
    implementation of some operations. In that case an instance in Haskell or a class in Java does not need to provide 
    implementation for that operation, or in both cases can override. If this is not the case, then in both languages 
    type has to provide implementation. In addition, both type classes and interfaces can be extended. For example, 
    in java interface `A` can be extended by interface `B`, then any default operation defined in interface `A` is 
    available in `B`, and a class implementing `B` has to provide implementations for interface `A` and `B` methods. 
    Similarly in haskell type class `T` can be restricted by other type class `C`, meaning that only an instance of 
    type class `C` can be made instance of type class `T`. 
    
    First difference between type classes and interfaces is the type of polymorphism being achieved. In Haskell, 
    type classes achieves ad-hoc polymorphism, while in java interfaces - inclusion (subtype) polymorphism. The main 
    difference between these two types of polymorphism is the time when resolution which operation to use takes place. 
    In ad-hoc case - at compile time, while inclusion - runtime. 
    
    Another difference is that declaration of instance of type class is separate from type declaration which gives 
    ability to create instances anytime. While in Java a class which corresponds to type in Haskell has to implement
    all the needed interfaces on its declaration. Java language does not provide construct to implement extra 
    interfaces on the class. Although it can be achieved at some degree using patterns an `adapter` pattern.

    In Java interfaces can only be defined for a class (type), while in Haskell it can be defined for 
    a type or **type constructor**. Type constructors are not types they only produce types when 
    type parameter are passed. For example, `Functor` type class expects type constructor with one type parameter, 
    let's say `Maybe a`. If we create `instance Function Maybe` then all the types which `Maybe a` can make will
    be instance of the functor as well. This is very powerful mechanism and it can't be achieved with Java interfaces.
    
5.  What is an abstract data type (ADT) and how can they be used in Haskell and Java? 
    
    