// FLOYD WARSHALL'S ALGORITHM

#include<stdio.h>

int min(int a,int b){ 
    if(a<b)   
        return(a);
    else   
        return(b);
}

void floyds(int p[10][10],int n){    
    int i,j,k; 
    for(k=1;k<=n;k++)
        for (i=1;i<=n;i++)     
            for (j=1;j<=n;j++)
                if(i==j)                   
                    p[i][j]=0;            
                else                
                    p[i][j]=min(p[i][j],p[i][k]+p[k][j]);
}

int main(){ 
    int p[10][10],n,i,j; 
    printf("Enter the number of vertices:\n"); 
    scanf("%d",&n); printf("Enter the Matrix\n"); 
    for(i=1;i<=n;i++){     
        for(j=1;j<=n;j++){           
            scanf("%d", &p[i][j]);     
        } 
    } 
    floyds(p,n); 
    printf("Output Matrix :\n"); 
    for(i=1;i<=n;i++){  
        for(j=1;j<=n;j++)     
            printf("%d \t",p[i][j]);  
            printf("\n"); 
    } 
    printf("\n The shortest paths are:\n"); 
    for (i=1;i<=n;i++)     
        for (j=1;j<=n;j++){      
            if(i!=j)          
                printf("\n <%d,%d>=%d",i,j,p[i][j]);     
        } 
}