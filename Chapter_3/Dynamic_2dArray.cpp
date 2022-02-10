#include <cstdio>
#include <cstdlib>

// 2차원 배열 동적 할당 함수
int** alloc2DInt(int rows, int cols){
    if (rows <= 0 || cols <= 0) return NULL;

    int** mat = new int* [rows];
    for (int i = 0; i < rows; i++)
        mat[i] = new int [cols];
    return mat;
}

// 2차원 배열 동적 해제 함수
void free2DInt(int** mat, int rows, int cols=0){
    if (mat != NULL){
        for (int i = 0; i < rows; i++)
            delete [] mat[i];
        delete [] mat;
    }
}

// 동적 생성된 2차원 배열을 랜덤으로 초기화하는 함수
void set2DRandom(int** mat, int rows, int cols){
    for (int i = 0; i < rows; i++)
    for (int j = 0; j < cols; j++)
        mat[i][j] = rand()%100;
}

// 2차원 배열을 화면으로 보기 좋게 출력하는 함수
void print2DInt(int** mat, int rows, int cols){
    printf("number of rows = %d, number of cols = %d\n", rows, cols);
    for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++)
            printf("%4d", mat[i][j]);
        printf("\n");
    }
}

// main function
int main(){
    int** mat;
    int rows, cols;

    printf("input number of row and col: ");
    scanf("%d%d", &rows, &cols);

    mat = alloc2DInt(rows, cols);
    set2DRandom(mat, rows, cols);
    print2DInt(mat, rows, cols);
    free2DInt(mat, rows, cols);

    return 0;
}