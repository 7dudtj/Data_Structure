#include <cstdio>
#include <cstdlib>
#include <ctime>

int main(){
    clock_t start, finish;
    double duration;
    start = clock();
    
    // time duration
    for (int i = 0; i < 1000000000; i++){
        // do nothing
    };

    finish = clock();
    duration = (double)(finish - start) / CLOCKS_PER_SEC;
    printf("%f 초입니다.", duration);

    return 0;
}