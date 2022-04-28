#include <cstdio>
#include <cstdlib>

// 2���� �迭 ���� �Ҵ� �Լ�
int** alloc2DInt(int rows, int cols){
    if (rows <= 0 || cols <= 0) return NULL;

    int** mat = new int* [rows];
    for (int i = 0; i < rows; i++)
        mat[i] = new int [cols];
    return mat;
}

// 2���� �迭 ���� ���� �Լ�
void free2DInt(int** mat, int rows, int cols=0){
    if (mat != NULL){
        for (int i = 0; i < rows; i++)
            delete [] mat[i];
        delete [] mat;
    }
}

// ���� ������ 2���� �迭�� �������� �ʱ�ȭ�ϴ� �Լ�
void set2DRandom(int** mat, int rows, int cols){
    for (int i = 0; i < rows; i++)
    for (int j = 0; j < cols; j++)
        mat[i][j] = rand()%100;
}

// 2���� �迭�� ȭ������ ���� ���� ����ϴ� �Լ�
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