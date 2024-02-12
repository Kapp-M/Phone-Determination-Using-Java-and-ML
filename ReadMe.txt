# Phone Orientation Machine Learning Classifier

This project implements a simple machine learning classifier to predict the orientation of a phone based on its coordinates. The classifier utilizes a neural network approach and allows users to input coordinates to predict the orientation of the phone.

Table of Contents
- Introduction
- Usage
- Dependencies
- contributing

## Introduction

The project consists of several Java classes:
- `Main.java`: Contains the main method to execute the classifier. It prompts the user for input coordinates and displays the predicted 6 orientations of the phone.
- `NNClassifier.java`: Implements the neural network classifier. It trains on known data and predicts orientations for unknown data.
- `AnotherClassifier.java`: A basic classifier with print function names instead of implementation.
- `BaseClassifier.java`: An abstract class defining methods for training and predicting, extended by concrete classifier implementations.
- `Point.java`: Represents a 3D point with coordinates and orientation.

## Usage

To use the classifier:
1. Compile the Java files using a Java compiler.
2. Run the `Main` class.
3. Follow the prompts to input coordinates.
4. Enter "q" to exit the program.

## Dependencies
The project has no external dependencies beyond the standard Java libraries.

## Contributing
This was a group project implemented by Members - Kalp , Rudra , Jiya , Girish.