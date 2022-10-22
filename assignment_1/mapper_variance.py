import sys
import csv


chunk_size = 0 
chunk_sum = 0.0
chunk_sum_2 = 0.0 
for line in sys.stdin:
    data = next(csv.reader([line], delimiter=','))
    try:
        chunk_sum += float(data[9])
        chunk_sum_2 += float(data[9]) ** 2
        chunk_size += 1 
    except:
        continue

variance = (chunk_sum_2 / chunk_size - (chunk_sum / chunk_size) ** 2) * chunk_size / (chunk_size - 1)
mean = chunk_sum / chunk_size
print(chunk_size, mean, variance)
