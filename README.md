# Algorithms in Java (SIDE PROJECT)

The intention of this repository is to have fun and improve my skills on Algorithm Analysis and Design, 
by implementing algorithms and solving proposed problems from the [books](https://github.com/julianomacielferreira/Algorithms-Java#references).

I choose Java&trade; as the implementation language because I purchase a copy of the book ["Algorithms, 4th Edition" by Robert Sedgewick and Kevin Wayne](https://algs4.cs.princeton.edu/home/)
and its [book site](https://algs4.cs.princeton.edu/home/) is full of resources for learning and practicing.

# Table of contents

- [Technologies](#technologies)
- [Data Sets](#data-sets)
- [Compile and Test](#compile-and-test)
- [Book Standard Library](#book-standard-library)
- [Algorithms](https://github.com/julianomacielferreira/Algorithms/blob/master/src/algorithms#README)
    - [Fundamentals Problem Set](https://github.com/julianomacielferreira/Algorithms/blob/master/src/algorithms/fundamentals/#README)
    - [Data Abstraction Problem Set](https://github.com/julianomacielferreira/Algorithms/blob/master/src/algorithms/data/abstraction/#README)
- [License](#license)
- [References](#references)


## Technologies

I opted to use [Java&trade; Platform, Standard Edition 8 API Specification](https://docs.oracle.com/javase/8/docs/api/) and [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/?section=linux).

## Data Sets

Data files used to test the algorithms have not been versioned in this repository, but this can be done with [Git Large File Storage (LFS)](https://git-lfs.github.com/). 

Click on the section [Data](https://introcs.cs.princeton.edu/java/data/) in the booksite to get one by one or download them all as one zipped big file (1GB approx.): [introcs-data.zip](https://introcs.cs.princeton.edu/java/code/introcs-data.zip).

After downloading the file, unzip it in a folder called **data** in the project root folder:

```bash
$ unzip introcs-data.zip -d project-root-folder/data
```  

**Obs.:**  In my case **project-root-folder** is _~/Projects/Java/Algorithms_.

Follow this steps in the project root folder to versioning the files (the same as [git lfs](https://git-lfs.github.com/) site):

- [Download](https://github.com/git-lfs/git-lfs/releases/download/v2.8.0/git-lfs-linux-amd64-v2.8.0.tar.gz) and install the Git command line extension. 

- Once downloaded and installed, set up Git LFS and its respective hooks by running:

```bash
$ git lfs install
```

- Select the file types you'd like Git LFS to manage (or directly edit your .gitattributes). You can configure additional file extensions at anytime.

```bash
$ git lfs track "*.txt"
```

- Make sure .gitattributes is tracked

```bash
$ git add .gitattributes
```

Finally, commit and push to GitHub as you normally would.

**Obs.:** See [Git Large File Storage (LFS)](https://git-lfs.github.com/) to know more.

## Compile and Test

To compile and run the algorithms, just run in console:

```bash
$ ./compile.sh
```

To compile the tests, just run in console:

```bash
$ ./run-tests.sh
```

## Book Standard Library

A great portion of the code uses the books standard library [algs4.jar](https://algs4.cs.princeton.edu/code/algs4.jar) that is versioned in the repository under [lib](https://github.com/julianomacielferreira/Algorithms/tree/master/lib/) folder.

To get more details about it, access the section [Code](https://algs4.cs.princeton.edu/code/) of the booksite or the complete [javadoc](https://algs4.cs.princeton.edu/code/javadoc/) documentation.

# Disclaimer

**This repository DOES NOT CONTAIN any copy / reproduction of the content available in the books ["Algorithms, 4th Edition" by Robert Sedgewick and Kevin Wayne](https://algs4.cs.princeton.edu/home/), 
[Algorithms Illuminated: Part 1: The Basics](https://www.amazon.com/dp/0999282905), [Algorithms Illuminated (Part 2): Graph Algorithms and Data Structures (Volume 2)](https://www.amazon.com/gp/product/0999282921/ref=dbs_a_def_rwt_bibl_vppi_i2),
[Introduction to Algorithms 3rd Edition (The MIT Press)](https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844), [Algorithm Complexity 3th Edition (Brazilian portuguese)](https://www.grupoa.com.br/complexidade-de-algoritmos-vol13-p990429), [Discrete Mathematics for Computing and Informatics (Brazilian portuguese)](https://www.grupoa.com.br/matematica-discreta-para-computacao-e-informatica-vol16-p990393),
[Learning Discrete Math with Exercise (Brazilian portuguese)](https://www.grupoa.com.br/aprendendo-matematica-discreta-com-exercicios-vol19-ebook-p987217?tsid=34) and [Refactoring - Improving the Design of Existing Code](https://martinfowler.com/books/refactoring.html)
for commercial purposes.** 

**It has only <ins>my own solutions for the proposed problems in the books chapters</ins> with the intention of learning and enhancing my skill set.**

# References

- ["Algorithms, 4th Edition" by Robert Sedgewick and Kevin Wayne](https://algs4.cs.princeton.edu/home/)
- [Algorithms Illuminated: Part 1: The Basics](https://www.amazon.com/dp/0999282905)
- [Algorithms Illuminated (Part 2): Graph Algorithms and Data Structures (Volume 2)](https://www.amazon.com/gp/product/0999282921/ref=dbs_a_def_rwt_bibl_vppi_i2)
- [Introduction to Algorithms 3rd Edition (The MIT Press)](https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844)
- [Algorithm Complexity 3th Edition (Brazilian portuguese)](https://www.grupoa.com.br/complexidade-de-algoritmos-vol13-p990429)
- [Refactoring - Improving the Design of Existing Code](https://martinfowler.com/books/refactoring.html)
- [Discrete Mathematics for Computing and Informatics (Brazilian portuguese)](https://www.grupoa.com.br/matematica-discreta-para-computacao-e-informatica-vol16-p990393)
- [Learning Discrete Math with Exercise (Brazilian portuguese)](https://www.grupoa.com.br/aprendendo-matematica-discreta-com-exercicios-vol19-ebook-p987217?tsid=34)
- ["Mathematics for Computer Science" by Lehman and Leighton](https://courses.csail.mit.edu/6.042/spring17/mcs.pdf)
- [Wikipedia](https://en.wikipedia.org/)
    - [Algorithm](https://en.wikipedia.org/wiki/Algorithm)
    - [Computer science](https://en.wikipedia.org/wiki/Computer_science)
    - [Computational complexity theory](https://en.wikipedia.org/wiki/Computational_complexity_theory)
    - [Discrete Mathematics](https://en.wikipedia.org/wiki/Discrete_mathematics)
    - [Graph (discrete mathematics)](https://en.wikipedia.org/wiki/Graph_\(discrete_mathematics\))
    - [Number Theory](https://en.wikipedia.org/wiki/Number_theory)
- [MIT OCW](https://ocw.mit.edu/index.htm)
    - [Introduction to Algorithms](https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/index.htm)
    - [Design and Analysis of Algorithms](https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-design-and-analysis-of-algorithms-spring-2015/index.htm)
- [Java&trade; Platform, Standard Edition 8 API Specification](https://docs.oracle.com/javase/8/docs/api/)
- [IntelliJ IDEA – the Leading Java and Kotlin IDE](https://www.jetbrains.com/idea/)

# License

Please see the [license agreement](https://github.com/julianomacielferreira/Algorithms/blob/master/LICENSE).

