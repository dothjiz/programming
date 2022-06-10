import pandas as pd
import os
import re

file = "superstore.xlsx"

xl = pd.ExcelFile(
     file)
    
sheets = xl.sheet_names
for sheet in sheets:
    df = pd.read_excel(file, sheet_name = sheet, na_values="n/a")
dfs = pd.read_excel(file, sheet_name = sheets, na_values="n/a")
dfs.describe()
