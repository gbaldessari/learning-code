#include <iostream>
#include <cstdlib>
#include <ctime>
#include <algorithm>

int main() {
    // Inicializar el generador de números aleatorios
    srand(static_cast<unsigned int>(time(0)));

    const int TAMANO = 10;
    int numeros[TAMANO];

    // Generar los números aleatorios sin repetición
    for (int i = 0; i < TAMANO; ++i) {
        int numero;
        bool repetido;
        do {
            numero = rand() % 100 + 1;
            repetido = false;
            for (int j = 0; j < i; ++j) {
                if (numeros[j] == numero) {
                    repetido = true;
                    break;
                }
            }
        } while (repetido);
        numeros[i] = numero;
    }

    // Imprimir la lista de números generados sin repetición
    std::cout << "Lista de " << TAMANO << " números sin repetición entre 1 y 100:" << std::endl;
    for (int i = 0; i < TAMANO; ++i) {
        std::cout << numeros[i] << std::endl;
    }

    const int n = 3;

    // Validar la entrada de n
    if (n <= 0 || n > TAMANO) {
        std::cout << "Error: la cantidad de números a seleccionar debe estar entre 1 y " << TAMANO << "." << std::endl;
        return 1;
    }

    // Mezclar los números generados
    std::random_shuffle(numeros, numeros + TAMANO);

    // Imprimir los n números seleccionados al azar
    std::cout << "Números seleccionados al azar (" << n << " números):" << std::endl;
    for (int i = 0; i < n; ++i) {
        std::cout << numeros[i] << std::endl;
    }

    return 0;
}
