class Node:
	def __init__(self, val):
		self.val = val
		self.children = []
		self.parents = []
def addToTree(currNode):
	#print("currNode is " + str(currNode.val))
	if currNode.val == -1:
		size = len(currNode.parents)
		if size not in paths:
			paths[size] = []
			paths[size].append(currNode)
		else:
			paths[size].append(currNode)
		return
	#for n in currNode.parents:
		#print("parents: " + str(n.val) + ", ")
	for log in logs:
		x, y = log
		if x == currNode.val:
			newNode = Node(y)
			if y not in [n.val for n in currNode.parents]:
				#print("newNode is " + str(newNode.val))
				newNode.parents = currNode.parents + [currNode]
				currNode.children.append(newNode)
				addToTree(newNode)
		elif y == currNode.val:
			newNode = Node(x)
			if x not in [n.val for n in currNode.parents]:
				#print("newNode is " + str(newNode.val))
				newNode.parents = currNode.parents + [currNode]
				currNode.children.append(newNode)
				addToTree(newNode)

if __name__ == "__main__":
	inputs = input().split(" ")
	numPeople = int(inputs[0])
	numBoulders = int(inputs[1])
	numLogs = int(inputs[2])
	totalTime = 0
	logs = []
	for i in range(numLogs):
		logInput = input().split(" ")
		x = int(logInput[0])
		y = int(logInput[1])
		logs.append((x, y))
	numSuccessfulPaths = 0
	root = Node(-2)
	paths = dict()
	addToTree(root)
	depths = []
	for key in paths.keys():
		depths.append(key)
	depths.sort()
	for depth in depths:
		endNodes = paths[depth]
		for endNode in endNodes:
			currPath = endNode.parents
			pathSafe = True
			for i in range(len(currPath)):
				x = currPath[i].val
				y = -1
				if i < len(currPath)-1:
					y = currPath[i+1].val
				if (x, y) not in logs and (y, x) not in logs:
					pathSafe = False
			if pathSafe:
				for i in range(len(currPath)):
					x = currPath[i].val
					y = -1
					if i < len(currPath)-1:
						y = currPath[i+1].val
					if (x, y) in logs:
						logs.remove((x, y))
					elif (y, x) in logs:
						logs.remove((y, x))
				
				numSuccessfulPaths+=1
				if numSuccessfulPaths >= numPeople:
					break
				else:
					totalTime+=depth
	if numSuccessfulPaths < numPeople:
		print(str(numPeople-numSuccessfulPaths) + " people left behind")
	else:
		print(str(totalTime))
				
	
