import sys
import csv


chunk_size = 0 
chunk_sum = 0.0 
for line in sys.stdin:
    data = next(csv.reader([line], delimiter=','))
    try:
        chunk_sum += float(data[9])
        chunk_size += 1 
    except:
        continue

mean = chunk_sum / chunk_size
print(chunk_size, mean)
