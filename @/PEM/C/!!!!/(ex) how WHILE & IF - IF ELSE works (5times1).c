#include <stdbool.h>
#include <stdio.h>


void main()
{
    int num;
    bool cincUns = false;
    int count = 0;

    scanf("%d", &num);

    while (num == 1 || num == 0)
    {
       if (num == 0)
       {
            count = 0;
       }
            else if (num == 1)
            {
                count++;
                if (count >= 5)
                {
                    cincUns = true;
                }
            }
                    scanf("%d", &num);
    }


    if (cincUns)
    {
        printf("S'ha trobat");
    }
        else
        {
            printf("No s'ha trobat");
        }
    getch();
}



