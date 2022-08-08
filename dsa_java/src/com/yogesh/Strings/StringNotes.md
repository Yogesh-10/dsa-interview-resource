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

## **Important** **String Methods in Java**

1. **int length():** Returns the number of characters in the String.
    
    ```
    "codingisgreat".length();  // returns 13
    ```
    
2. **Char charAt(int i):** Returns the character at ith index.
    
    ```
    "codingisgreat".charAt(3); // returns  ‘i’
    ```
    
3. **String substring (int i):** Return the substring from the i index character to end.
    
    th
    
    ```
    "codingisgreat".substring(3); // returns “ingisgreat”
    ```
    
4. **String substring (int i, int j):** Returns the substring from i to j-1 index.
    
    ```
     "codingisgreat".substring(2, 5); // returns “din”
    ```
    
5. **String concat( String str):** Concatenates specified string to the end of this string.
    
    ```
     String s1 = ”coding”;
    
     String s2 = ”isgreat”;
    
     String output = s1.concat(s2); // returns “codingisgreat”
    
    ```
    
6. **int indexOf (String s):** Returns the index within the string of the first occurrence of the specified string.
    
    ```
     String s = ”coding is great”;
    
     int output = s.indexOf(“is”); // returns 7
    
    ```
    
7. **int indexOf (String s, int i):** Returns the index within the string of the first occurrence of the specified string, starting at the specified index.
    
    ```
     String s = ”Learn Share Learn”;
     indexOf(ch, fromIndex)
     int output = s.indexOf(‘a’,3);// returns 8
    
    ```
    
8. **Int lastIndexOf( String s):** Returns the index within the string of the last occurrence of the specified string.
    
    ```
     String s = ”Learn Share Learn”;
    
     int output = s.lastIndexOf(‘a’); // returns 14
    
    ```
    
9. **boolean equals( Object otherObj):** Compares this string to the specified object.
    
    ```
     Boolean out = “coding”.equals(“coding”); // returns true
    
     Boolean out = “Coding”.equals(“coding”); // returns false
    
    ```
    
10. **boolean equalsIgnoreCase (String anotherString):**
    
    ```
     Boolean out= “Coding”.equalsIgnoreCase(“Coding”); // returns true
    
     Boolean out = “coding”.equalsIgnoreCase(“coding”); // returns true
    ```
    
11. **int compareTo( String anotherString):** Compares two string lexicographically.
    
    ```
     int out = s1.compareTo(s2);  // where s1 ans s2 are strings to be compared
    
     This returns difference s1-s2. If :
    
     out < 0  // s1 comes before s2
    
     out = 0  // s1 and s2 are equal.
    
     out > 0   // s1 comes after s2.
    
    ```
    
12. **int compareToIgnoreCase( String anotherString):** Compares two string lexicographically, ignoring case considerations.*Note- In this case, it will not consider case of a letter (it will ignore whether it is uppercase or lowercase).*
    
    ```
     int out = s1.compareToIgnoreCase(s2);
    
    // where s1 ans s2 are
    
    // strings to be compared
    
     This returns difference s1-s2. If :
    
     out < 0  // s1 comes before s2
    
     out = 0   // s1 and s2 are equal.
    
     out > 0   // s1 comes after s2.
    
    ```
    
13. **String toLowerCase():** Converts all the characters in the String to lower case.
    
    ```
    String word1 = “HeLLo”;
    
    String word3 = word1.toLowerCase(); // returns “hello"
    
    ```
    
14. **String toUpperCase():** Converts all the characters in the String to upper case.
    
    ```
    String word1 = “HeLLo”;
    
    String word2 = word1.toUpperCase(); // returns “HELLO”
    
    ```
    
15. **String trim():** Returns the copy of the String, by removing whitespaces at both ends. It does not affect whitespaces in the middle.
    
    ```
    String word1 = “ Learn Share Learn “;
    
    String word2 = word1.trim(); // returns “Learn Share Learn”
    
    ```
    
16. **String replace (char oldChar, char newChar):** Returns new string by replacing all occurrences of *oldChar* with *newChar. Note:- s1 is still fodingisgreat and s2 is codingisgreat*
    
    ```
    String s1 = “fodingisgreat“;
    
    String s2 = “fodingisgreat”.replace(‘f’ ,’g’); // returns “codingisgreat”
    
    ```
    
## Time complexity
A strings is an array of characters, so the time complexities of basic string operations will closely resemble that of array operations.

| Operation | Big-O |
| --- | --- |
| Access | O(1) |
| Search | O(n) |
| Insert | O(n) |
| Remove | O(n) |
