public int[] solution(int[] A) {
        int N = A.length;
        if(N == 1) return new int[]{0};
        
        int[] O = new int[N];
        int[] nbOfValues = new int[100_001];
        int[] nbOfDivs   = new int[100_001];
        int maxV = 0;
        for(int a: A){
            maxV = Math.max(maxV, a);
            nbOfValues[a]++;
        }
        int sqrt = (int) (Math.sqrt(maxV) + 0.5);
        int mult;
        for(int i = 1; i <= sqrt; i++){
            for(int j = i; (mult = j * i) <= maxV; j++){
                if(nbOfValues[mult] > 0){ // if there's such value in A
                    nbOfDivs[mult] += nbOfValues[i];
                    if(i != j){
                        nbOfDivs[mult] += nbOfValues[j];
                    }
                }
            }
        }
        for(int i = 0; i < N; i++){
            O[i] = N- nbOfDivs[ A[i] ];
        }
        return O;
    }
