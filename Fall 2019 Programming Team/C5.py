import fractions
import sys

if __name__ == '__main__':
	line = input().split(" ")
	num = line[0]
	repeatNum = int(line[1])
	
	numList = num.split(".")
	afterDecimal = numList[1]
	numSpots = len(afterDecimal) - repeatNum
	repeating = afterDecimal[numSpots: len(afterDecimal)]
	number = numList[0] + afterDecimal[0:numSpots+repeatNum+1]
	number2 = number + repeating
	print(number + " " + number2)
	num1 = int(number)
	num2 = int(number2)
	a = num2 - num1

	b = (10**(repeatNum + numSpots + 1)) / (10**(numSpots + 1))
	print (str(a) + " " + str(b))
	gcd = fractions.gcd(a, b)
	a /= gcd
	b /= gcd
	print(str(int(a)) + "/" + str(int(b)))
	
