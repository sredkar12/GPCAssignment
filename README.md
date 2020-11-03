# GPC Coding Assignment - PROBLEM TWO: SALES TAXES

I have created a main application SaletaxApplication. which reads an input file called SHOPPINGCARTS.csv and stores each line into 
a Shoppingcart object which in tutn has the logic to calculate the sales tax and the resulting total cost . The last 2 columns of the csv has the sales tax and 
the import sales tax respectively .

I created the function below to return the nearest rounded up to the nearest 0.05 amount of sales tax.
public double round05(double num) {
        return Math.round(num * 20) / 20.0;
    }
    
    
The application is fully working and I have attached a snippet of the results below . Note that I have created the first column in the SHOPPINGSCART.csv 
file as the shopping basket . So 1 , 2 and 3 are the shopping baskets with their respective items . You can run this application almost as it is with 
a little tweak in where you place your inout file and how you read it . 

The results are almost 99% identical with the outputs given in the assignment sheet by GPC except for output 3 sales tax and total cost which may be attributed
because of a different rounding up methiod used by GPC .


Actual run results:
work dir is /Users/f3lnroq/Downloads/student-services
Output 1
1 book 12.49
1 musicCD 16.49
1 chocolatebar 0.85
Sales taxes: 1.50
Total: 29.83

Output 2
1 imported box of chocolates 10.50
1 imported bottle of perfume 54.65
Sales taxes: 7.65
Total: 65.15

Output 3
1 imported bottle of perfume 32.19
1 bottle of perfume 20.89
1 packet of headache pills 9.75
1 imported box of chocolates  11.80
Sales taxes: 6.65
Total: 74.63


