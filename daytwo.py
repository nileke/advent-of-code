sheet = []
checksum = 0
with open('two_input.txt', 'r') as infile:
	line = infile.readline()
	arr = [int(x) for x in line.split("\t") if len(x) > 0]
	max_val = max(arr)
	min_val = min(arr)
	print(max_val)
	print(min_val)
	checksum += int(max_val) - int(min_val)

print(checksum)