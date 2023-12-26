from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
print("Launching Chrome")

driver.get("http://demo.guru99.com/test/newtours/")

my_list = driver.find_elements(By.XPATH, "//a")
print("Number of links =", len(my_list))

driver.quit()
print("Closed Chrome")