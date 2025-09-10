>> loard carbig
>> tbl = table(Horsepower,Weight, Acceleration,Cylinders,MPG);
>> disp('first 5 rows of dataset:')
first 5 rows of dataset:
>> head(tbl,5)

ans =

  5×5 table

    Horsepower    Weight    Acceleration    Cylinders    MPG
    __________    ______    ____________    _________    ___

    130           3504        12            8            18 
    165           3693      11.5            8            15 
    150           3436        11            8            18 
    150           3433        12            8            16 
    140           3449      10.5            8            17 

>> disp('summary statistics;')
summary statistics;
>> summary(tbl)
Variables:

    Horsepower: 406×1 double

        Values:

            Min            46         
            Median         95         
            Max            230        
            NumMissing     6          

    Weight: 406×1 double

        Values:

            Min         1613  
            Median    2822.5  
            Max         5140  

    Acceleration: 406×1 double

        Values:

            Min          8          
            Median    15.5          
            Max       24.8          

    Cylinders: 406×1 double

        Values:

            Min       3          
            Median    4          
            Max       8          

    MPG: 406×1 double

        Values:

            Min            9    
            Median         23   
            Max            46.6 
            NumMissing     8    
----------------------------------------------------------------------------------
>> disp("Number of missing values")
Number of missing values
>> disp(sum(ismissing(tbl)))
     6     0     0     0     8
	 
---------------------------------------------------------------------------------
>> tbl_clean = rmmissing(tbl);
>> fprintf("After removing missing values: %d row remain\n", height(tbl_clean));
After removing missing values: 392 row remain
>> tbl_fill = fillmissing(tbl,'linear');
X = tbl_clean{:,{'Horsepower','Weight','Acceleration'}}

X =

   1.0e+03 *

    0.1300    3.5040    0.0120
    0.1650    3.6930    0.0115
    0.1500    3.4360    0.0110
    0.1500    3.4330    0.0120
    0.1400    3.4490    0.0105	 .....
--------------------------------------------------------------------------------
>> X_norm = normalize(X,'range');
To use 'normalize', the following product must be both licensed and installed:
  DSP System Toolbox
  ------------------------------------------------------------------------------
  >> X_std = zscore(X);
>>  subplot(1,2,1); hist(X(:,1));title('Original Horsepower');
>> subplot(1,2,2); hist(X_std(:,1));title('Standardised Horsepower');

--------------------------------------------------------------------------------
>> tbl_clean.Cylinders = categorical(tbl_clean.Cylinders);
--------------------------------------------------------------------------------
>> corrVal= corr(tbl_clean{:,{'Horsepower','Weight','Acceleration'}},tbl_clean.MPG,'Rows','Complete');
>> disp('Correlation of features with MPG:')
Correlation of features with MPG:
>> disp(array2table(corrVal,'variableNames',{'correlation'}));
    correlation
    ___________

    -0.77843   
    -0.83224   
     0.42333   
---------------------------------------------------------------------------------
