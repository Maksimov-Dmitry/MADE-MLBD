import sys


result_mean = 0.0
result_variance = 0.0
result_size = 0

for line in sys.stdin:
    chunk_size, chunk_mean, chunk_variance = list(map(float, line.split()))
    result_variance = ((result_size * result_variance + chunk_size * chunk_variance) / (result_size + chunk_size) +
                       result_size * chunk_size * ((result_mean - chunk_mean) / (result_size + chunk_size) ** 2))
    result_mean = (result_size * result_mean + chunk_size * chunk_mean) / (result_size + chunk_size)
    result_size += chunk_size

print(result_variance)
