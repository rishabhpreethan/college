import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split 
from sklearn.tree import DecisionTreeClassifier 
from sklearn import metrics
import seaborn as sns
pima=pd.read_csv("diabetes.csv")
X = pima.iloc[:, [0,7]].values 
y= pima.iloc[:, 8].values
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=0)
clf = DecisionTreeClassifier()
y_pred = clf.predict(X_test)
print("Accuracy:",metrics.accuracy_score(y_test, y_pred)) 
print("\nConfusion Matrix is:", metrics.confusion_matrix(y_test, y_pred))
cnf_matrix=pd.crosstab(y_test, y_pred, rownames=['actual'], colnames=['Predic ted'])
sns.heatmap(cnf_matrix, annot=True)