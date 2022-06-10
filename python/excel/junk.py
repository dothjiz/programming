
import requests

response = requests.get('https://randomuser.me/api/?results=10')
data = response.json()

for sheet in sheets:
    df = pd.read_excel(file, header = None, sheet_name = sheet, na_values="n/a")
    df.info()

for user in data['results']:
    print(user['name']['first'])