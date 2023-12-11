from selenium import webdriver
from selenium.webdriver.common.by import By

# Use the path to your ChromeDriver executable
driver = webdriver.Chrome()
print("Launching Chrome")

driver.get("http://demo.guru99.com/test/newtours/")

driver.find_element(By.NAME, "userName").send_keys("userName")  # enter username
driver.find_element(By.NAME, "password").send_keys("password")  # enter password

# Simulate a button click using JavaScript since there is no direct 'submit' button in the HTML
driver.execute_script("document.getElementsByName('submit')[0].click();")

title = driver.title
print(driver.title)

if title == "Login: Mercury Tours":
    print("LOGIN SUCCESSFUL...")
    print("All test cases pass")
else:
    print("LOGIN FAILED")

# Close the browser window
driver.quit()
print("Closed Chrome")
