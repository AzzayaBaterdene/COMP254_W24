import time
import random
import matplotlib
import matplotlib.pyplot as plt


def prefixAverage1(x):
    n = len(x)
    a = [0] * n
    for j in range(n):
        total = 0
        for i in range(j + 1):
            total += x[i]
        a[j] = total / (j + 1)
    return a

def prefixAverage2(x):
    n = len(x)
    a = [0] * n
    total = 0
    for j in range(n):
        total += x[j]
        a[j] = total / (j + 1)
    return a

def generate_random_array(size):
    return [random.random() for _ in range(size)]

def experimental_analysis():
    input_sizes = [10, 50, 100, 500, 1000] 
    results1 = []
    results2 = []

    for n in input_sizes:
        input_array = generate_random_array(n)

        start_time = time.time()
        prefixAverage1(input_array)
        end_time = time.time()
        elapsed_time1 = (end_time - start_time) * 1e9

        start_time = time.time()
        prefixAverage2(input_array)
        end_time = time.time()
        elapsed_time2 = (end_time - start_time) * 1e9

        results1.append(elapsed_time1)
        results2.append(elapsed_time2)

    return results1, results2

def plot_running_times(series1, series2, input_sizes):
    plt.figure(figsize=(10, 6))
    plt.plot(input_sizes, series1, label='prefixAverage1')
    plt.plot(input_sizes, series2, label='prefixAverage2')
    plt.xscale('log')
    plt.yscale('log')
    plt.xlabel('Input Size')
    plt.ylabel('Running Time (ns)')
    plt.title('Running Times of prefixAverage Algorithms')
    plt.legend()
    plt.savefig('plot.png')  # Save the plot to a file

if __name__ == "__main__":
    results1, results2 = experimental_analysis()
    input_sizes = [10, 50, 100, 500, 1000]  # Use the same input sizes as in the analysis
    plot_running_times(results1, results2, input_sizes)
    plt.show()
