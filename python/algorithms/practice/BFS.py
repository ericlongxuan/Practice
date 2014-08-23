graph = {
	1:[2,3,4],
	2:[5,6],
	5:[9,10],
	4:[7,8],
	7:[11,12]
}

def bfs(graph, start, end):
	#maintain a queue of paths
	queue = []

	#push the first path into to queue
	queue.append([start])

	while queue:
		#get the first path from queue
		path = queue.pop(0)
		#get the last node from the path
		node = path[-1]

		#path found
		if node==end:
			return path

		#不使用graph[node]的原因是，当节点无子女的时候会报错，如不存在graph[3]的字典，
		#但是使用get就没问题，如果不存在，会返回default(这里是[])
		for adjacent in graph.get(node, []):
			new_path = list(path);
			new_path.append(adjacent);
			queue.append(new_path)

print bfs(graph,1,11);
