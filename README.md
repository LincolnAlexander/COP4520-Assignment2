# COP4520-Assignment2

## Welcome Non-Technical Manager!

## How to run program

To run my program you will need to open your command prompt and download files: Locky.java & Vase.java
Navigate to the to the folder where you downloaded that file.
Compile the file by typing: javac Locky.java or javac Vase.java
Execute the file by typing: java Locky or java Vase

## Summary

// Problem 1
I decided to use Reentrant Locks for the first problem. The Lock makes sure no other threads can enter the function where you can eat the cake. This makes sure once you enter the labrynth you will be the only one inside as per the restrictions. You can eat the cake or leave it according to a random number generator, almost like a coin flip. This is the most efficent way, since all guest have a chance to eat a slice of cake and once they eat the cake they can no longer enter. All guest will eat a slice of cake before the program ends, I used a set to be sure that everyone had a slice of cake. This also makes sure that a person can have two slices of cake.

// Problem 2
I used the second stategy. I used a door variable as stated in the problem description. If someone was inside the showroom then no one else could enter, and all other threads were to try again. The second strategy is one of the better options as it makes sure there won't be a crowd of people. The first strategy is the worst as anybody can come at any time and this could potentially break the vase. The guest would also have no indicator when they can come to the showroom. The third stategy is good overall, the only downfall may be that guest will be in the queue for uncertain amounts of times. It is the fairest option out of all three.
