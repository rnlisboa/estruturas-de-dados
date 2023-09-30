import time

# Função para calcular o n-ésimo número de Fibonacci usando programação dinâmica
def fibonacci_dinamico(n):
    fib = [0] * (n + 1)
    fib[1] = 1

    for i in range(2, n + 1):
        fib[i] = fib[i - 1] + fib[i - 2]

    return fib[n]

n = 1000  # Vamos calcular o 1000-ésimo número de Fibonacci

# Medir o tempo para calcular usando programação dinâmica
start_time = time.time()
resultado_dinamico = fibonacci_dinamico(n)
end_time = time.time()
tempo_dinamico = end_time - start_time

print(f'O {n}-ésimo número de Fibonacci (dinâmico) é {resultado_dinamico}')
print(f'Tempo para calcular (dinâmico): {tempo_dinamico} segundos')
