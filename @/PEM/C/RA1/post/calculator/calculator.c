#include <stdio.h>
#include <stdlib.h>


int add1, add2, addr, sub1, sub2, subr, mult1, mult2, multr, div1, div2, divr;
void main()
{
        invoke_main_menu();
        return 0;
}

void invoke_main_menu()
{
    int op;
    system("clear");

    printf("====Main Menu====\n==============\n= 1) Add\n= 2) Substract\n= 3) Multiply\n= 4) Divide\n= 5) EXIT\n==============\n=================\n\nInput the desired mode to operate in with: ");
    scanf("%d", &op);

    while (!(op == 1 || op == 2 || op == 3 || op == 4 || op == 5))
    {
        printf("Illegal Value. Try Again: ");
        scanf("%d", &op);
    }
        switch(op)
        {
            case 1:
                system("clear");
                invoke_add_gui();
                break;
            case 2:
                system("clear");
                invoke_substract_gui();
                break;
            case 3:
                system("clear");
                invoke_multiply_gui();
                break;
            case 4:
                system("clear");
                invoke_divide_gui();
                break;
            case 5:
                system("clear");
                abort();
                break;
        }
}

void invoke_add_gui()
{
    int back;
    printf("====Add====\n========\n= Input two numbers (%, %)\n========\n=========== ");
    scanf("%d %d", &add1, &add2);

    invoke_add_skeleton(add1, add2);
    addr = invoke_add_skeleton(add1, add2);

    printf("\n\nResult: %d + %d = %d\n\nPress '0' to return to the Main Menu: ", add1, add2, addr);
    scanf("%d", &back);

    while (!(back == 0))
    {
        printf("Illegal Value. Try Again: ");
        scanf("%d", &back);
    }
        if (back == 0)
        {
            invoke_main_menu();
        }
}

int invoke_add_skeleton(int x, int y)
{
    x = add1;
    y = add2;

    addr = (x + y);
}

void invoke_substract_gui()
{
    int back;
    printf("====Substract====\n==============\n= Input two numbers (%, %)\n==============\n================= ");
    scanf("%d %d", &sub1, &sub2);

    invoke_substract_skeleton(sub1, sub2);
    subr = invoke_substract_skeleton(sub1, sub2);

    printf("\n\nResult: %d - %d = %d\n\nPress '0' to return to the Main Menu: ", sub1, sub2, subr);
    scanf("%d", &back);

    while (!(back == 0))
    {
        printf("Illegal Value. Try Again: ");
        scanf("%d", &back);
    }
        if (back == 0)
        {
            invoke_main_menu();
        }
}

int invoke_substract_skeleton(int x, int y)
{
    x = sub1;
    y = sub2;

    subr = (x - y);
}

void invoke_multiply_gui()
{
    int back;
    printf("====Multiply====\n=============\n= Input two numbers (%, %)\n=============\n================ ");
    scanf("%d %d", &mult1, &mult2);

    invoke_multiply_skeleton(mult1, mult2);
    multr = invoke_multiply_skeleton(sub1, sub2);

    printf("\n\nResult: %d * %d = %d\n\nPress '0' to return to the Main Menu: ", mult1, mult2, multr);
    scanf("%d", &back);

    while (!(back == 0))
    {
        printf("Illegal Value. Try Again: ");
        scanf("%d", &back);
    }
        if (back == 0)
        {
            invoke_main_menu();
        }
}

int invoke_multiply_skeleton(int x, int y)
{
    x = mult1;
    y = mult2;

    multr = (x * y);
}

void invoke_divide_gui()
{
    int back;
    printf("====Divide====\n========\n= Input two numbers (%, %)\n========\n=========== ");
    scanf("%d %d", &div1, &div2);

    invoke_divide_skeleton(div1, div2);
    divr = invoke_divide_skeleton(div1, div2);

    printf("\n\nResult: %d / %d = %d\n\nPress '0' to return to the Main Menu: ", div1, div2, divr);
    scanf("%d", &back);

    while (!(back == 0))
    {
        printf("Illegal Value. Try Again: ");
        scanf("%d", &back);
    }
        if (back == 0)
        {
            invoke_main_menu();
        }
}

int invoke_divide_skeleton(int x, int y)
{
    x = div1;
    y = div2;

    divr = (x / y);
}
