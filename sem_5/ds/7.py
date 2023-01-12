import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer 
from sklearn.naive_bayes import MultinomialNB
from sklearn import metrics
import seaborn as sns

data=pd.read_excel("Navietext.xlsx",names=['Message','Label']) 
print("Dataset:\n", data)
print('The dimensions of the dataset',data.shape)

data['Labelnum']=data.Label.map({'pos':1,'neg':0}) 
x=data.Message
y=data.Labelnum
print(x)
print(y)

vectorizer=TfidfVectorizer() 
data=vectorizer.fit_transform(x)
print("\n Train Test Split:\n") 

xtrain,xtest,ytrain,ytest=train_test_split(data,y,test_size=0.3,random_state=2) 

print('\n The total number of Training Data:',ytrain.shape)
print('\n The total number of Test Data:',ytest.shape)

clf= MultinomialNB().fit(xtrain, ytrain) 
predicted = clf.predict(xtest)
print("\n Accuracy of the classifier is:", metrics.accuracy_score(ytest,predicted)) 
print("\nConfusion Matrix is:", metrics.confusion_matrix(ytest,predicted))

cnf_matrix=pd.crosstab(ytest,predicted, rownames=['actual'], colnames=['Predicted']) 
sns.heatmap(cnf_matrix, annot=True)