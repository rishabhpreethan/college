from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
print("Launching Chrome")

driver.get("http://demo.guru99.com/test/newtours/")
driver.implicitly_wait(10)
print("Waited for 10 sec")

obj_text_box = driver.find_element(By.NAME, "userName")
obj_text_box.send_keys("userName")

driver.find_element(By.NAME, "password").send_keys("password")

print("Waiting")
obj_text_box.submit()

wait = WebDriverWait(driver, 10)
print("Waiting over")

wait.until(EC.title_contains("Welcome: Mercury Tours"))
print("Check")
print(driver.title)
print("All test cases pass")
assert "Welcome: Mercury Tours" in driver.title

driver.quit()
print("Closed Chrome")
