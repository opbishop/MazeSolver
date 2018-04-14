#MazeSolver
To Run the program:
===================
Either place maze .txt files in /mazes directory, or compile to a .jar and include /mazes directory in the same path, i.e.:

MazeSolver/
| 	MazeSolver.jar
| 	mazes/
| 	| 	small_maze.txt
| 	| 	large_maze.txt

Solving a maze
==============

This program will solve simple mazes given in the format described below and output the solution.

If no solution is possible the output will be indicated by "Failed to solve <file name>" in the command line.
  
 The following rules are placed on the maze:
  - Arbitrary sized mazes should be handled
  - Valid moves are N, S, E, W (not diagonally)
  - All input will be clean, no validation is necessary
  - The maze file format is described below with an example
 
Maze file format
================

The input is a maze description file in plain text.  
 1 - denotes walls
 0 - traversable passage way

INPUT:
<WIDTH> <HEIGHT><CR>
<START_X> <START_Y><CR>		(x,y) location of the start. (0,0) is upper left and (width-1,height-1) is lower right
<END_X> <END_Y><CR>		(x,y) location of the end
<HEIGHT> rows where each row has <WIDTH> {0,1} integers space delimited

OUTPUT:
 the maze with a path from start to end
 walls marked by '#', passages marked by ' ', path marked by 'X', start/end marked by 'S'/'E'

Example file:  
10 10
1 1
8 8
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 1 0 1 1 1 1 1 1
1 0 1 0 0 0 0 0 0 1
1 0 1 1 0 1 0 1 1 1
1 0 1 0 0 1 0 1 0 1
1 0 1 0 0 0 0 0 0 1
1 0 1 1 1 0 1 1 1 1
1 0 1 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

OUTPUT:
##########
#SXX     #
# #X######
# #XX    #
# ##X# ###
# # X# # #
# # XX   #
# ###X####
# #  XXXE#
##########

