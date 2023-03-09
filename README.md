# Graph_Simulation
This is a Project i wrote during algorithms cource and originally implemented in c++.
I decided to change the implementation to Java.
This project is a Java implementation of a simulation of three properties of graphs: connectivity, isolation, and diameter. The simulation generates random graphs with a given probability of connection between vertices and measures the occurrence of certain properties in those graphs. The results are then written to an Excel file for further analysis.

The implementation includes the following classes:

Vertex: a class representing a vertex in a graph, containing an ID, a list of neighboring vertices (edges), and methods for adding edges, getting neighbors, and calculating degree.
GraphUtils: a class containing methods for calculating the diameter of a graph using BFS, determining if a graph has any isolated vertices, and checking if a graph is connected using BFS.
Graph: a class representing a graph, containing a list of vertices and a probability of connection between vertices.
ExcelWriter: a class for writing results to an Excel file.
Simulate: a class for running the simulation and writing the results to an Excel file.

The simulation works as follows:

The Simulate class generates random probabilities for the three properties (connectivity, isolation, and diameter).
For each property, the Simulate class generates a list of graphs with varying probabilities for that property.
For each graph, the Simulate class calculates the occurrence of the property and stores the result.
The results are then written to an Excel file using the ExcelWriter class.
The simulation provides a useful tool for analyzing the properties of random graphs and how they relate to certain probabilities. The implementation is modular and can be easily extended to include other graph properties and analysis methods.
