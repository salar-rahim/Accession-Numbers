## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### About the project

You are given a list of comma separated accession numbers as input.

An accession number has the following format: L...LN...N (e.g. AB1234)

where L...L denotes one or more ASCII7 letters and N denotes one or more digits (0,1,2,3,4,5,6,7,8 or 9).

Please return an ordered list of accession numbers where any consecutive digits N...N that share the same prefix L...L are collapsed into an accession number range.

An accession number range has the following format : L...LN...N-L...LN...N (e.g. A00001-A00005).

Please note that the N...N digits are left padded using 0s (e.g. 00001) and that the length of the N...N digits must be the same for accession numbers to be part of the same accession number range.


### How the project is developed

This project is developed in two phases
* Phase 1
  * Reading the input data from command line using Java 8 Stream API
  `Arrays.stream(args).sorted().forEach(AccessionNumbers::add);`
  * Analyze the data by extracting alphabetical letters from numerical digits
  ```
  static String extractDigits(String accNumber){
        return accNumber.replaceAll("\\D+","");
    }
   
    static String extractLetters(String accNumber){
        return accNumber.replaceAll("[^A-Za-z]+","");
    }
    ```
  * Store the analyzed data in a HashMap as key,value pairs
  * Alphabetical letters extracted from each accession number is stored in the HashMap as keys with corresponding numerical digits as values
  * All the accession numbers that share the same alphabetical letters are stored in one row of the HashMap with one key and a series of corresponding values

* Phase 2
  * This phase has two further stages
  * Stage_1
    * For each entry of the HashMap it checks two adjacent values if they have different length which means they're not in a possible range
    * first value will be stored in the final list of numbers and the second value will goes through the same process
  * Stage_2
    * in this phase two adjacent values have the same length
    * checks if the second value is incrementing of the first value by only one
    * repeats the same process until last value from the possible range is found
    * the start and end of the range is concatenated two form one number range and stored in the final list of numbers



## Tests

The project is tested using JUnit

## How to run the project
Go to the working directly of the project and use the following commands to run the project
First build the project using maven
 ```
 mvn clean package
 ```
Then Run the main class of the project
```
mvn exec:java -Dexec.mainClass="com.ebi.accessionNumber.App"
```
Finally, go to the target directory and run the following command
```
java -jar accession-number-1.0-SNAPSHOT.jar **Sample input goes here **
```
Example:
```
java -jar accession-number-1.0-SNAPSHOT.jar A00000, A0001, ERR000111, ERR000112, ERR000113, ERR000115, ERR000116, ERR100114, ERR200000001, ERR200000002, ERR200000003, DRR2110012, SRR211001, ABCDEFG1
```

## Author
Salar Rahim
salar.rahim@gmail.com

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management



