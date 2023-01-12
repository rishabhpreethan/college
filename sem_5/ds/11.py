import pandas as pd
import statsmodels.api as sm
import matplotlib.pyplot as plt
import seaborn as sns
sns.set()
from sklearn.cluster import KMeans
data = pd.read_csv('Countryclusters.csv')

x = data.iloc[:,1:3]

kmeans = KMeans(3)
kmeans.fit(x)
KMeans(n_clusters=3)
identified_clusters = kmeans.fit_predict(x)
data_with_clusters = data.copy()data_with_clusters['Clusters'] = identified_clusters plt.scatter(data_with_clusters['Longitude'],data_with_clusters['Latitude'],c=data_with_clusters['Clusters'],cmap='rainbow')
