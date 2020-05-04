#include <stdio.h>
#include "Base00HelloWorld.h"

//因为c语言 只有一个main方法  所以其他的方法都定义在头文件当中
// 通过引用文件 实现方法的调用和测试
int main() {
    printf("Hello, World!\n");
    main00();
    return 0;
}
