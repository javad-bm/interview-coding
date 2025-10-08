# Java Interview Coding Guide

A comprehensive collection of Java solutions to common coding interview questions, organized by topic and difficulty level. This repository serves as a practical guide for preparing for technical interviews and understanding fundamental programming concepts.

## 📁 Project Structure

The project is organized into logical categories to help you navigate different types of interview questions:

```
src/io/github/jbm/questions/
├── array/           # Array manipulation problems
├── backtrack/       # Backtracking algorithms
├── basics/          # Fundamental programming problems
├── game/            # Game theory and dynamic programming
├── hash/            # Hash table implementations and problems
├── heap/            # Heap data structure problems
├── matrix/          # 2D array and matrix problems
├── queue/           # Queue and priority queue problems
├── streams/         # Java 8+ Stream API examples
├── string/          # String manipulation problems
├── tree/            # Binary tree and tree traversal problems
└── two/pointers/    # Two-pointer technique problems
```

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line compiler

### Running the Code
1. Clone or download this repository
2. Navigate to the project directory
3. Compile and run individual Java files:

```bash
# Compile a specific file
javac src/io/github/jbm/questions/basics/TwoSum.java

# Run the compiled class
java -cp src io.github.jbm.questions.basics.TwoSum
```

## 📚 Problem Categories

### 🔢 Array Problems
- **AddThreeNumbers**: Find three numbers that sum to a target
- **Chunk**: Split array into chunks of specified size
- **MergeSortedArrays**: Merge two sorted arrays efficiently
- **MinimumArea**: Find minimum area rectangle
- **PositionSortedArray**: Search in rotated sorted array
- **ReverseInt**: Reverse integer digits
- **RotateArray**: Rotate array by k positions
- **SubArrayMaxSum**: Kadane's algorithm for maximum subarray sum

### 🌳 Tree Problems
- **BinaryTree**: Basic binary tree implementation
- **BinaryTreeTraverses**: In-order, pre-order, post-order traversals
- **MaxPathTree**: Find maximum path sum in binary tree
- **TreeTraverse**: Various tree traversal methods
- **TreeWidthPerLevel**: Calculate width at each tree level

### 📝 String Problems
- **Anagram**: Check if two strings are anagrams
- **Palindrome**: Check if string is palindrome
- **LongestCommonPrefix**: Find common prefix among strings
- **LongestPalindromicSubstring**: Find longest palindromic substring
- **ReverseString**: Reverse string characters
- **StringToInteger**: Convert string to integer (atoi)
- **Vowels**: Count vowels in string

### 🎯 Basic Problems
- **TwoSum**: Find two numbers that sum to target
- **Fizzbuzz**: Classic FizzBuzz problem with multiple solutions
- **ContainsDuplicate**: Check for duplicate elements
- **MoveZeros**: Move all zeros to end of array
- **ReverseInteger**: Reverse integer digits
- **Step**: Count ways to reach top of stairs

### 🎮 Game Problems
- **JumpGameI**: Can reach the last index?
- **JumpGameII**: Minimum jumps to reach the end
- **JumpGameIII**: Jump game with different rules

### 🔍 Hash Table Problems
- **HashTable**: Custom hash table implementation
- **TestHashTable**: Hash table testing and validation

### 📊 Heap Problems
- **MinHeapInt**: Minimum heap implementation
- **Median**: Find median from data stream
- **MergeSortedLinkedList**: Merge k sorted linked lists

### 🔄 Matrix Problems
- **RotateMatrix**: Rotate 2D matrix 90 degrees
- **SpiralMatrix**: Print matrix in spiral order

### 🌊 Stream Problems
- **StreamBasics**: Java 8 Stream API fundamentals
- **MostCommonEndpoint**: Find most common API endpoint
- **Stream2**: Advanced stream operations

## 💡 Key Features

- **Multiple Solutions**: Many problems include multiple approaches (brute force, optimized, etc.)
- **Clean Code**: Well-commented, readable code following Java best practices
- **Test Cases**: Each solution includes example test cases in main methods
- **Time/Space Complexity**: Solutions demonstrate understanding of algorithmic complexity
- **Real Interview Questions**: Problems commonly asked in technical interviews

## 🎯 How to Use This Repository

1. **Study by Category**: Start with basics and work your way up to more complex problems
2. **Practice Regularly**: Try to solve problems before looking at solutions
3. **Understand Patterns**: Many problems follow similar patterns (two pointers, sliding window, etc.)
4. **Test Your Solutions**: Run the code and verify outputs with different test cases
5. **Optimize**: After getting a working solution, think about time and space optimization

## 🔧 Common Patterns Covered

- **Two Pointers**: Efficient array/string processing
- **Sliding Window**: Subarray/substring problems
- **Hash Maps**: Fast lookups and counting
- **Tree Traversal**: DFS and BFS approaches
- **Dynamic Programming**: Optimization problems
- **Backtracking**: Generate all possible solutions
- **Greedy Algorithms**: Make locally optimal choices

## 📈 Difficulty Levels

- **Easy**: Basic problems (TwoSum, FizzBuzz, Palindrome)
- **Medium**: Array manipulation, tree traversal, string processing
- **Hard**: Dynamic programming, complex algorithms, optimization

## 🤝 Contributing

Feel free to contribute by:
- Adding new problems
- Improving existing solutions
- Adding more test cases
- Fixing bugs or improving code quality
- Adding complexity analysis

## 📝 Notes

- All solutions are implemented in Java
- Code follows standard Java naming conventions
- Each class includes a main method for testing
- Solutions are optimized for readability and learning
- Some problems may have multiple implementations showing different approaches

## 🎓 Interview Tips

1. **Start Simple**: Always start with a brute force solution, then optimize
2. **Think Out Loud**: Explain your thought process during interviews
3. **Consider Edge Cases**: Handle null inputs, empty arrays, single elements
4. **Test Your Code**: Walk through examples to verify correctness
5. **Discuss Complexity**: Always mention time and space complexity

---

Happy coding and good luck with your interviews! 🚀