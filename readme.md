CSS Type Selectors for JSON

Built with Jackson

Assume the first argument to the program is the JSON File Path

Program processes Json into an in memory tree from the file. 

The program converts the users input into a SearchNode object. The SearchNode object acts as a comparator, checking to see if any arbitrary node is equal to itself. Then a recursive depth first search of the tree is done.

If we were to implement Compound or Chained selectors we would break the user input search string into an array of space delimited search terms, and each converted into a SearchNode. A SearchNode array would be passed to the search method which each recursive term that matched calling the method again passing the tail of the search term object to the next level, returning true when a SearchNode matches itself as true against the only element in the array. 
