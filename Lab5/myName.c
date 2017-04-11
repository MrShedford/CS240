#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

main(int argc, char *argv[]) {
	mknod("fifo", 010600, 0);
	open("fifo",O_WRONLY);
	close(1);
	dup(3);
	printf("Sean Edward Comerford");
	
}
