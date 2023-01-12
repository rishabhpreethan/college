import pandas as pd
df = pd.DataFrame({"Name":["Tejas", "Nas", "Pat"], "Age":[20, 21, 22], "Sub1":[90, 80, 70], "Sub2":[80, 70, 60], "Team": ['A', 'B', 'A']}) 
print(df.head())
print(df.loc[0:1])
c = df.groupby("Team") 
c.get_group("A")
print(df.aggregate({"Sub1":["sum"]}))
df["Total"] = df["Sub1"]+df["Sub2"] 
df["Total"]
df.drop("Total", axis = 1, inplace=True) 
df.head()
df.isnull() 
df.fillna(0)
df1 = pd.DataFrame({"Name":['A', 'B', 'C'], "ID":[1, 2, 3]})
df2 = pd.DataFrame({"ID":[2, 3, 4], "Sub":["Math", "Phy", "Chem"]})
df1.head()
df2.head()
df1.merge(df2, on="ID", how="inner")