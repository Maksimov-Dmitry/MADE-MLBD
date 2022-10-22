import sys


result_mean = 0.0
result_size = 0
for line in sys.stdin:
    chunk_size, chunk_mean = list(map(float, line.split()))
    result_mean = (result_size * result_mean + chunk_size * chunk_mean) / (result_size + chunk_size)
    result_size += chunk_size

print(result_mean)
