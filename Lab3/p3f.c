#include <stdio.h>
#include <fcntl.h>
main()
{
	char file[30];	
	
	printf("Please enter the name of a file\n");
	
	scanf("%s", file);
	char buffer[10];
	int fd, n;
	fd=open(file, O_RDONLY);
	do 
	{
		n=read(fd, buffer, 10); /*Read 10 chars from file*/
		write(1, buffer, n); /*Write chars to text terminal*/
	} while (n==10); /* keep reading until n < 10 */

	close(fd);
	printf("\n");
}
