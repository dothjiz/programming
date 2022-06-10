from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import time
import bs4 
import sys

chrome_options = Options()

chrome_options.add_argument("--headless")

DRIVER_PATH1 = 'C:/Users/BH/.wdm/drivers/chromedriver/win32/84.0.4147.30/chromedriver.exe'
DRIVER_PATH = 'chromedriver.exe'

driver = webdriver.Chrome(executable_path=DRIVER_PATH, options=chrome_options)



Base_URL = 'https://leandomainsearch.com/search/?q='

if (not str(sys.argv[1])):
    keyword = 'orange'
else:
    keyword = str(sys.argv[1])


Searchable_URL = Base_URL + keyword

driver.get(Searchable_URL)

time.sleep(3)

html = driver.page_source

driver.quit()

soup = bs4.BeautifulSoup(html)

container = soup.find_all('button' , attrs = {'class' , '_3g0ASZWKTTIU44lmZNgQ72 _1dGJuSqXH1lo50WG42tFR'})

for d_name in container:
    print(d_name.text)