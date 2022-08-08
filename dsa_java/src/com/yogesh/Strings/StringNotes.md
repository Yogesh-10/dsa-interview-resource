# Strings

A string is a sequence of characters. Many tips that apply to arrays also apply to strings.

Strings are defined as a stream of characters. Strings are used to represent text and are generally represented by enclosing text within quotes as: *"This is a sample string!"*

Different programming languages have different ways of declaring and using Strings. We will learn to implement strings in **Java**

In java, objects of String are immutable which means a constant and cannot be changed once created.

There are two ways to create string in Java:

- ***String literal***
    
    ```java
    String s = “GeeksforGeeks”;
    ```
    
- **Using *new* keyword**
    
    ```java
    String s = new String (“GeeksforGeeks”);
    ```

## Java Strings are Immutable

In Java, strings are **immutable**. This means, once we create a string, we cannot change that string.

To understand it more deeply, consider an example:

```
// create a string
String example = "Hello! ";
```

Here, we have created a string variable named example. The variable holds the string "Hello! ".

Now suppose we want to change the string.

```
// add another string "World"
// to the previous tring example
example = example.concat(" World");
```

Here, we are using the `concat()` method to add another string World to the previous string.

It looks like we are able to change the value of the previous string. However, this is not `true`.

Let's see what has happened here,

1. JVM takes the first string "Hello! "
    
2. creates a new string by adding  to the first string "World"
    
3. assign the new string  to the  variable "Hello! World"
    
4. the first string  remains unchanged "Hello! "
    
---

## Creating strings using the new keyword

So far we have created strings like primitive types in Java.

Since strings in Java are objects, we can create strings using the `new` keyword as well. For example,

```
// create a string using the new keyword
String name = new String("Java String");
```

In the above example, we have created a string name using the `new` keyword.

Here, when we create a string object, the `String()` constructor is invoked.

**Note**: The `String` class provides various other constructors to create strings. To learn more, visit [Java String (official Java documentation)](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html).

---

## **Example: Create Java Strings using the new keyword**

```
class Main {
  public static void main(String[] args) {

    // create a string using new
    String name = new String("Java String");

    System.out.println(name);  // print Java String
  }
}
```

---

## **Create String using literals vs new keyword**

Now that we know how strings are created using string literals and the `new` keyword, let's see what is the major difference between them.

In Java, the JVM maintains a **string pool** to store all of its strings inside the memory. The string pool helps in reusing the strings.

1. While creating strings using string literals,

```
String example = "Java";
```

Here, we are directly providing the value of the string (`Java`). Hence, the compiler first checks the string pool to see if the string already exists.

- **If the string already exists**, the new string is not created. Instead, the new reference,  points to the already existed string (`Java`).
    
    example
    
- **If the string doesn't exist**, the new string (`Java` is created.

2. While creating strings using the new keyword,

```
String example = new String("Java");
```

Here, the value of the string is not directly provided. Hence, a new `"Java"` string is created even though `"Java"` is already present inside the memory pool.
