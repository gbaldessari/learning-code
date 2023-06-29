package recursion;

public class Factorial {
	int facR (int n){
        int resultado;
        if (n==1) return 1;
        resultado=facR(n-1)*n;
        return resultado;
    }

    int facI (int n){
        int t, resultado;
        resultado=1;
        for (t=1; t<=n; t++) resultado *=t;
        return resultado;
    }
}
