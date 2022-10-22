import sys
import csv


chunk_size = 0 
chunk_sum = 0.0
chunk_sum_2 = 0.0
bad_line = None
for line in sys.stdin:
    if bad_line:
        line = ''.join([bad_line, line])
        bad_line = None
    data = next(csv.reader([line], delimiter=','))
    if len(data) < 3:
        bad_line = line
        continue
    try:
        chunk_sum += float(data[9])
        chunk_sum_2 += float(data[9]) ** 2
        chunk_size += 1 
    except:
        continue

variance = chunk_sum_2 / chunk_size - (chunk_sum / chunk_size) ** 2
mean = chunk_sum / chunk_size
print(chunk_size, mean, variance)
