import sys


if __name__ == "__main__":
	firstLine = input().split(" ")
	a = int(firstLine[0])
	b = int(firstLine[1])
	
	ballot = []
	info = []

	for i in range(b):
		line = input().split(" ")
		c = line[0]
		d = line[1]
		ballot.append(c)
		infodict = {}
		count = a
		for k in d:
			infodict.add(k, count)
			count = count - 1
			info.append(infodict)
	print ballot
	print info
