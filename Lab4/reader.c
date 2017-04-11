#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

main(int argc, char *argv[]) {
	int namedpipe;
	int max_size = 30;
	char buffer[max_size+1];
	namedpipe = open("fifo",O_RDONLY);
        int n = read(namedpipe, buffer, max_size);
        buffer[n]=0;
        printf("%s",buffer);

}
