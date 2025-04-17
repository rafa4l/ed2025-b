public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][];
    protected int jogador;
    protected int dimensao;
   

    public JogoDaVelha() {
        limpaTabuleiro();
        vencedor();
        
        tabuleiro = new int[dimensao][dimensao];
        
    }

    public void limpaTabuleiro() {
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i < 0 || i >= dimensao || j < 0 || j >= dimensao) {
            throw new IllegalArgumentException("Posição Inválida");
        }
        if (tabuleiro[i][j] != VAZIO)
            throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j] = jogador;
        jogador = -jogador;
    }

    public boolean descVencedor(int marca) {
        for (int i = 0; i < dimensao; i++) {
            int somaLinha = 0;
            for (int j = 0; j < dimensao; j++) {
                somaLinha += tabuleiro[i][j];
            }
            if (somaLinha == marca * dimensao) {
                return true;
            }
        }
        for (int j = 0; j < dimensao; j++) {
            int somaColuna = 0;
            for (int i = 0; i < dimensao; i++) {
                somaColuna += tabuleiro[i][j];
            }
            if (somaColuna == marca * dimensao) {
                return true;
            }
        }
        int somaDiagonal1 = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
        if (somaDiagonal1 == marca * dimensao -1 ) {
            return true;
        }
        int somaDiagonal2 = tabuleiro[2][0] + tabuleiro[1][1] + tabuleiro[0][2];
        if (somaDiagonal2 == marca * dimensao -1) {
            return true;
        }
        return false;
    }

    public int vencedor() {
        if (descVencedor(1)) {
            return (1);
        } else if (descVencedor(2)) {
            return (-1);
        } else if(descVencedor(O)){
            return (0);
        }else 
        return(2);
    }

    public String toString() {
        String s = "";
        for (int i = 0; i <= dimensao; i++) {
            for (int j = 0; j <=dimensao; j++) {
                switch (tabuleiro[i][j]) {
                    case X:
                        s += "X";
                        break;
                    case O:
                        s += "O";
                        break;
                    case VAZIO:
                        s += " ";
                        break;
                }
                if (j < dimensao)
                    s += ("|");
                if (i < dimensao)
                    s +=("\n");
                return s;
            }
        }

        String retorno = "";

        for (int i = 0; i <= dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                if (tabuleiro[i][j] == X) {
                    retorno += ("X");
                } else if (tabuleiro[i][j] == O) {
                    retorno += ("O");
                } else {
                    retorno += (" ");
                }
                if (j < dimensao) {
                    retorno += ("|");
                }
            }
            // System.out.println();
            if (i < 2) {
                retorno += ("\n-----\n");
            }

        }
        return retorno;
    }
}