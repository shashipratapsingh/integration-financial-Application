//Basic Questions
//
//Convert List to Uppercase: Given a list of strings, convert all elements to uppercase using streams.
//Find Even Numbers: Given a list of integers, filter out even numbers.
//Find Odd Numbers: Given a list of integers, filter out odd numbers.
//Sum of Numbers: Compute the sum of all elements in a list.
//Average of Numbers: Compute the average of all elements in a list.
//Find Maximum Number: Find the maximum number in a list.
//Find Minimum Number: Find the minimum number in a list.
//Sort a List: Sort a list of integers in ascending order.
//Sort in Descending Order: Sort a list of integers in descending order.
//Remove Duplicates: Remove duplicate elements from a list.
//
//Intermediate Questions
//
//Find First Element: Get the first element of a list (if present).
//Find All Names Starting with "A": Given a list of names, find those starting with 'A'.
//        ->  Find Strings with Length Greater Than 5: Filter a list of strings where length > 5.
//        ->  Concatenate Strings: Join a list of strings into a single string, separated by commas.
//Group By Length: Group a list of strings by their length.
//Partition Even and Odd Numbers: Partition a list of integers into even and odd numbers.
//Count Elements Greater Than 10: Count how many numbers in a list are greater than 10.
//        ->  Find Second-Highest Number: Find the second-highest number in a list.
//->  Find Duplicate Elements: Find all duplicate elements in a list.
//        Check if Any Number is Greater Than 100: Check if any number in a list is greater than 100.
//
//Advanced Questions
//
//Find the Most Frequent Element: Find the most frequently occurring element in a list.
//->  Find Employees Older Than 30: Given a list of employees (name, age), filter those older than 30.
//        ->  Find the Highest Paid Employee: Given a list of employees (name, salary), find the one with the highest salary.
//Sort Employees by Salary in Descending Order: Sort a list of employees by salary in descending order.
//Find Employees by Department: Group employees by department.
//Find the Average Salary of Each Department: Compute the average salary per department.
//Check If All Numbers Are Positive: Check if all numbers in a list are positive.
//Find the Longest String: Find the longest string in a list.
//Convert List of Integers to a Single String: Convert a list of integers to a comma-separated string.
//Flatten a List of Lists: Given a list of lists, flatten it into a single list.
//
//        5 years experienced
//
//Parallel Stream Processing:
//Question: How can you leverage parallel streams to improve performance in data processing tasks? What are the potential pitfalls?
//Explanation: Discuss the use of parallelStream() to perform parallel processing, ensuring thread safety, understanding the underlying
//ForkJoinPool, and being aware of scenarios where parallelism might not lead to performance gains.
//
//Custom Collectors:
//Question: Can you create a custom collector? Provide an example where a built-in collector is insufficient.
//Explanation: Demonstrate how to implement the Collector interface to create a custom collector, explaining scenarios such as collecting
//        elements into a specific data structure or performing complex aggregations.
//
//Handling Infinite Streams:
//Question: How do you work with infinite streams in Java? Provide an example of generating an infinite stream and processing its elements.
//Explanation: Use Stream.iterate() or Stream.generate() to create infinite streams and apply short-circuiting operations like limit() to
//process a finite subset.
//
//Exception Handling in Streams:
//Question: How can you handle checked exceptions within stream operations?
//Explanation: Discuss strategies such as wrapping checked exceptions in unchecked exceptions, using helper methods to handle exceptions,
//or creating custom functional interfaces that allow for exception handling.
//
//Performance Considerations:
//Question: What are the performance implications of using streams? When might streams be less efficient than traditional loops?
//Explanation: Analyze scenarios where streams might introduce overhead due to object creation, lack of short-circuiting, or unsuitable
//use of parallel streams, and compare them to traditional iterative approaches.
//
//Stateful vs. Stateless Operations:
//Question: Differentiate between stateful and stateless intermediate operations in streams. Provide examples of each.
//Explanation: Explain that stateless operations (e.g., map, filter) process elements independently, while stateful operations (e.g.,
//                                                                                                                              distinct, sorted) require knowledge of the entire stream's state.
//Stream Pipeline Optimization:
//
//Question: How does the order of operations in a stream pipeline affect performance?
//Explanation: Discuss the importance of placing operations like filter() early in the pipeline to reduce the number of elements processed
//downstream, leading to more efficient execution.
//
//Lazy Evaluation:
//Question: What is lazy evaluation in the context of streams, and how does it impact performance?
//Explanation: Describe how streams delay processing until a terminal operation is invoked, allowing for optimization and potentially
//reducing computation by skipping unnecessary operations.
//
//Combining Streams:
//Question: How can you concatenate two streams? Are there any considerations to be aware of?
//Explanation: Use Stream.concat() to merge two streams and discuss considerations such as handling ordered vs. unordered streams and the
//impact on performance.
//
//Debugging Stream Pipelines:
//Question: What techniques can you use to debug complex stream pipelines?
//Explanation: Suggest methods like inserting peek() operations to log intermediate results, breaking down the pipeline into smaller parts,
//or using traditional debugging tools to inspect the behavior of the stream operations.